# InputStreamReader

- 实现将字节的输入流按指定字符集转换为字符的输入流

- 需要和InputStream“套接”

```java
public InputStreamReader(InputStream in)
public InputSreamReader(InputStream in,String charsetName)
如： Reader isr = new InputStreamReader(System.in,"gbk");
```
