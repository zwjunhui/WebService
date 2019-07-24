package com.zhiwei.webservice.main;


import com.zhiwei.webservice.service.WeatherForJDKServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @Description: 发布webservice服务
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 11:38
 * @Version: 1.0
 */
public class JDKPublish {

    public static void main(String[] args) {
        /**
         * 参数一： 服务的地址
         * 参数二： 服务的实现
         */

        //访问服务的描述文件 服务的地址+wsdl  例如：http://localhost:8080/weatherService?wsdl
        Endpoint.publish("http://localhost:8080/weatherService",new WeatherForJDKServiceImpl());

        /**
         * 客户端的生成：
         *  创建一个新得项目 cmd 进入到新建项目的src文件夹下
         *  执行  wsimport -s . http://localhost:8080/weatherService?wsdl
         *   -s 表示存放源文件的
         *   . 表示当前目录
         *   后面跟服务的说明url地址
         */


    }
}
