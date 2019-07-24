package com.zhiwei.webservice.jdkclient;

import com.zhiwei.webservice.service.WeatherForJDKServiceImpl;
import com.zhiwei.webservice.service.WeatherForJDKServiceImplService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @Description: java类作用描述
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 13:01
 * @Version: 1.0
 */
public class JDKClient {
    public static void main(String[] args) throws IOException {
        /**
         * 第一种实现方式
         */
//        //1.创建服务试图
//        WeatherForJDKServiceImplService service = new WeatherForJDKServiceImplService();
//        //2.获取服务实现类
//        WeatherForJDKServiceImpl serviceImpl = service.getPort(WeatherForJDKServiceImpl.class);
//        //3.调用方法
//        String result = serviceImpl.query("上海");
//        //4.输出结果
//        System.out.println(result);

        /**
         * 第二种实现方式
         *
         * 参照WeatherForJDKServiceImplService.class
         */
        //new URL("http://localhost:8080/weatherService?wsdl");
//        URL url = new URL("http://localhost:8080/weatherService?wsdl");
//        QName qName = new QName("http://service.webservice.zhiwei.com/", "WeatherForJDKServiceImplService");
//        Service service = Service.create(url, qName);
//        WeatherForJDKServiceImpl port = service.getPort(WeatherForJDKServiceImpl.class);
//        String result = port.query("上海");
//        System.out.println(result);

        /**
         * 自定义发送符合要求的soap协议的请求数据
         */
        //URL
        URL url = new URL("http://localhost:8080/weatherService");
        //创建一个连接对象
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","text/xml; charset=utf-8");
        //打开通信
        connection.setDoOutput(true);
        connection.setDoInput(true);
        //发送信息
        //拼接服务协议要求的数据格式
        String info = buildXML("上海");
        connection.getOutputStream().write(info.getBytes());

        //获取响应信息
        int code = connection.getResponseCode();
        if (code == 200) {
            //响应正常获取数据
            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }else {

        }
    }
    private  static  String buildXML(String cityName){
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\"?>");
        builder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"");
        builder.append("<S:Body>");
        builder.append("<ns2:query xmlns:ns2=\"http://service.webservice.zhiwei.com/\">");
        builder.append("<arg0>");
        builder.append(cityName);
        builder.append("</arg0>");
        builder.append("</ns2:query>");
        builder.append("</S:Body>");
        builder.append("</S:Envelope>");
        return builder.toString();
    }
}
