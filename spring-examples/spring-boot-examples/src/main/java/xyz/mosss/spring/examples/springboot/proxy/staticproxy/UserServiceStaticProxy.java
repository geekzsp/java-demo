package xyz.mosss.spring.examples.springboot.proxy.staticproxy;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import xyz.mosss.spring.examples.springboot.proxy.UserService;
import xyz.mosss.spring.examples.springboot.proxy.cglibproxy.UserServiceCglibProxy;

import java.io.IOException;

public class UserServiceStaticProxy implements UserService {
    private UserService userService;

    public UserServiceStaticProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getUser() {
        System.out.println("代理userService 执行前");
        userService.getUser();
        System.out.println("代理userService 执行后");
    }

    public static void main(String[] args) throws IOException {
        
        //https://pay.mobikwik.com
        //设置代理IP、端口、协议（请分别替换）
        //HttpHost proxy = new HttpHost("你的代理的IP", 8080, "http");

        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                //.setProxy(proxy)
                .build();

        //实例化CloseableHttpClient对象
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

        //访问目标地址
        HttpGet httpGet = new HttpGet("http://pay.mobikwik.com");

        //请求返回
        CloseableHttpResponse httpResp = httpclient.execute(httpGet);
        try {
            int statusCode = httpResp.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                System.out.println("成功");
            }
        } catch (Exception e) {

        } finally {
            httpResp.close();
        }
    }
}