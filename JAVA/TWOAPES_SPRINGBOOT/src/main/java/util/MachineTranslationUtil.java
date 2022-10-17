package util;

import com.alibaba.fastjson.JSONObject;
import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;
import statics.ComputerUtils;
import statics.DateUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
public class MachineTranslationUtil {
    /**
     * @param charset charset
     * @param id      id
     * @param secret  secret
     * @param key     key
     * @param from    from
     * @param to      to
     * @param text    text
     * @return machine
     * @author add by huyingzhao
     * 2022-09-24 10:56
     */
    public static String machine(Charset charset, String id, String secret, String key, String from, String to, String text) {
        long startTime = System.currentTimeMillis();
        String str = "";
        try {
            String resp = doRequest(charset, id, secret, key, from, to, text);
            JSONObject jsonObject = JSONObject.parseObject(resp);
            jsonObject = jsonObject.getJSONObject("payload");
            jsonObject = jsonObject.getJSONObject("result");
            text = jsonObject.getString("text");
            String textBase64Decode = new String(Base64.getDecoder().decode(text), charset);
            jsonObject = JSONObject.parseObject(textBase64Decode);
            jsonObject = jsonObject.getJSONObject("trans_result");
            str += ("machine before:=>" + jsonObject.getString("src"));
            str += ("\t");
            str += ("machine after:=>" + jsonObject.getString("dst"));
            log.debug(str);
            str = jsonObject.getString("dst");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        ComputerUtils.end(startTime,"util.MachineTranslationUtil.machine");
        return str;
    }

    /**
     * @param charset charset
     * @param id      id
     * @param secret  secret
     * @param key     key
     * @param from    from
     * @param to      to
     * @param text    text
     * @return doRequest
     * @throws Exception Exception
     * @author add by huyingzhao
     * 2022-09-24 10:56
     */
    private static String doRequest(Charset charset, String id, String secret, String key, String from, String to, String text) throws Exception {
        URL realUrl = new URL(buildRequestUrl(secret, key, charset));
        URLConnection connection = realUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-type", "application/json");
        OutputStream out = httpURLConnection.getOutputStream();
        String params = buildParam(charset,id, from, to, text);
        out.write(params.getBytes());
        out.flush();
        InputStream is;
        try {
            is = httpURLConnection.getInputStream();
        } catch (Exception e) {
            is = httpURLConnection.getErrorStream();
            log.error(e.getMessage(), e);
        }
        return readAllBytes(charset,is);
    }

    /**
     * @param secret  secret
     * @param key     key
     * @param charset charset
     * @return buildRequestUrl
     * @author add by huyingzhao
     * 2022-09-24 10:53
     */
    private static String buildRequestUrl(String secret, String key, Charset charset) {
        URL url;
        String requestUrl = "https://itrans.xf-yun.com/v1/its";
        String httpRequestUrl = requestUrl.replace("ws://", "http://").replace("wss://", "https://");
        try {
            url = new URL(httpRequestUrl);
            String date = DateUtils.format(DateUtils.nowTime(), ISO8601.EEE_DD_MMM_YYYY_HH_MM_SS_Z, Locale.US, TimeZone.getTimeZone("GMT"));
            String host = url.getHost();
            String builder = "host: " + host + "\n" + "date: " + date + "\n" + "POST " + url.getPath() + " HTTP/1.1";
            Mac mac = Mac.getInstance("hmacsha256");
            SecretKeySpec spec = new SecretKeySpec(secret.getBytes(charset), "hmacsha256");
            mac.init(spec);
            byte[] hexDigits = mac.doFinal(builder.getBytes(charset));
            String sha = Base64.getEncoder().encodeToString(hexDigits);
            String authorization = String.format("api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", key, "hmac-sha256", "host date request-line", sha);
            String authBase = Base64.getEncoder().encodeToString(authorization.getBytes(charset));
            return String.format("%s?authorization=%s&host=%s&date=%s", requestUrl, URLEncoder.encode(authBase, charset), URLEncoder.encode(host, charset), URLEncoder.encode(date, charset));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return "";
    }

    /**
     * @param charset   charset
     * @param id   id
     * @param from from
     * @param to   to
     * @param text text
     * @return buildParam
     * @author add by huyingzhao
     * 2022-09-24 10:57
     */
    private static String buildParam(Charset charset, String id, String from, String to, String text) {
        String RES_ID = "its_en_cn_word";
        return "{" + "    \"header\": {" + "        \"app_id\": \"" + id + "\"," + "        \"status\": 3," + "        \"res_id\": \"" + RES_ID + "\"" + "    }," + "    \"parameter\": {" + "        \"its\": {" + "            \"from\": \"" + from + "\"," + "            \"to\": \"" + to + "\"," + "            \"result\": {}" + "        }" + "    }," + "    \"payload\": {" + "        \"input_data\": {" + "            \"encoding\": \"utf8\"," + "            \"status\": 3," + "            \"text\": \"" + Base64.getEncoder().encodeToString(text.getBytes(charset)) + "\"" + "        }" + "    }" + "}";
    }

    /**
     * @param is is
     * @return readAllBytes
     * @throws IOException IOException
     * @author add by huyingzhao
     * 2022-09-24 10:58
     */
    private static String readAllBytes(Charset charset,InputStream is) throws IOException {
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder("\n");
        int len;
        while ((len = is.read(b)) != -1) {
            sb.append(new String(b, 0, len, charset));
        }
        return sb.toString();
    }
}