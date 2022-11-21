package entity;

import lombok.Data;

import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-11-20 14:44
 */
@Data
public class Param {
    private Header header;
    private Parameter parameter;
    private Payload payload;

    public Header header(String appId, long status, String resId) {
        Header header = new Header();
        header.setApp_id(appId);
        header.setStatus(status);
        header.setRes_id(resId);
        return header;
    }

    public Parameter its(String from, String to, List<String> result) {
        Parameter parameter = new Parameter();
        parameter.setIts(parameter.its(from, to, result));
        return parameter;
    }

    public Payload inputData(String encoding, long status, String text) {
        Payload payload = new Payload();
        payload.setInput_data(payload.inputData(encoding, status, text));
        return payload;
    }
}

@Data
class Header {
    private String app_id;
    private long status;
    private String res_id;
}

@Data
class Parameter {
    private Its its;

    public Its its(String from, String to, List<String> result) {
        its=new Its();
        its.setFrom(from);
        its.setTo(to);
        its.setResult(result);
        return its;
    }

    @Data
    static class Its {
        private String from;
        private String to;
        private List<String> result;
    }
}

@Data
class Payload {
    private InputData input_data;

    public InputData inputData(String encoding, long status, String text) {
        input_data=new InputData();
        input_data.setEncoding(encoding);
        input_data.setStatus(status);
        input_data.setText(text);
        return input_data;
    }

    @Data
    static class InputData {
        private String encoding;
        private long status;
        private String text;
    }
}