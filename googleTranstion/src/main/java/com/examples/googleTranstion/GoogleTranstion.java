package com.examples.googleTranstion;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class GoogleTranstion {
    public static String transtion(boolean isUseProxy, String text) throws Exception
    {
        // 配置代理地址和端口
        String proxyHost = "127.0.0.1";
        int proxyPort = 7890;

        // 创建代理对象
        OkHttpClient client = new OkHttpClient.Builder().build();
        if (isUseProxy) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

            // 创建 OkHttp 客户端并设置代理
            client = new OkHttpClient.Builder().proxy(proxy).build();
        }


        // 创建请求对象
        Request request = new Request.Builder()
                .url("https://translate.google.com/m?sl=auto&tl=en&q=" + text + "&hl=zh-CN") // 目标 URL
                .build();

        // 发送请求并获取响应
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String html = null;
                if (response.body() != null) {
                    html = response.body().string();
                }
                // 解析HTML字符串
                Document doc = Jsoup.parse(html);

                // 根据class获取内容
                Elements contentElements = doc.getElementsByClass("result-container");

                String result = "";
                // 遍历并输出内容
                for (Element element : contentElements) {
                    System.out.println("Content: ");
                    System.out.println(element.text());
                    result = element.text();
                }
                return result;
            } else {
                System.out.println("请求失败: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
