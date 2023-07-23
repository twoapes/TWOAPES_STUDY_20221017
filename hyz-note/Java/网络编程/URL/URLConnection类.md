# URLConnection类

```java
public Object getContent( ) throws IOException
public int getContentLength( )
public String getContentType( )
public long getDate( )
public long getLastModified( )
public InputStream getInputStream( )throws IOException
public OutputSteram getOutputStream( )throws IOException
```

以下是使用`URLConnection`类进行HTTP POST请求的示例代码：

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPPostExample {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("http://www.example.com/api/post");

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为POST
            connection.setRequestMethod("POST");

            // 允许输入输出流
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // 设置请求头
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // 构建请求体
            String requestBody = "{\"username\": \"user123\", \"password\": \"pass123\"}";

            // 获取输出流并写入请求体
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // 获取响应码
            int responseCode = connection.getResponseCode();

            // 读取响应
            BufferedReader reader;
            if (responseCode >= 200 && responseCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 打印响应
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response:");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们创建了一个`URL`对象表示要访问的URL地址。然后，通过`openConnection()`方法获取`HttpURLConnection`对象，并设置请求方法为POST，允许输入输出流。接下来，设置请求头，例如设置`Content-Type`为`application/json`，`Accept`为`application/json`。然后，构建请求体，将其写入输出流。发送请求后，获取响应码，根据响应码来获取相应的输入流进行读取。最后，将响应内容打印出来。

请注意，上述示例中的URL是一个示例URL，实际应用中需要根据需要替换为正确的URL。另外，实际应用中可能还需要处理异常、设置其他请求属性、处理响应数据等。
