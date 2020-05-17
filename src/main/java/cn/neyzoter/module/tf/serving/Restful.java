package cn.neyzoter.module.tf.serving;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Restful调用Tensorflow Serving的服务
 * @author Charles Song
 * @date 2020-5-17
 */
public class Restful {
    public static String UTF_8 = "UTF-8";
    public static void main (String[] args) {
        String params = "{\"instances\":[1.0,2.0,5.0]}";
        String url = "http://114.55.104.50:8501/v1/models/half_plus_two:predict";
        System.out.println(params);
        try {
            String result = sendPost(params, url,null);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendPost (String data, String requestUrl,
                                        String authorization) throws IOException {
        byte[] requestBytes = data.getBytes();
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(requestUrl);
        if (authorization != null) {
            //设置请求头Authorization
            postMethod.setRequestHeader("Authorization", "Basic " + authorization);
        }
        // 设置请求头 Content-Type
        postMethod.setRequestHeader("Content-Type", "application/json");
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
                requestBytes.length);
        // 请求体
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                requestBytes.length, "application/json; charset=utf-8");
        postMethod.setRequestEntity(requestEntity);
        // 执行请求
        httpClient.executeMethod(postMethod);
        // 获取返回的流
        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();
        byte[] datas = null;
        try {
            // 从输入流中读取数据
            datas = readInputStream(soapResponseStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String(datas, UTF_8);
        return result;
    }
    /**
     * 从输入流中读取数据
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }
}
