package com.zhiwei.webservice.service;

import javax.jws.WebService;

/**
 * @Description: java类作用描述
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 11:24
 * @Version: 1.0
 */
@WebService
public class WeatherForJDKServiceImpl implements WeatherForJDkService {
    @Override
    public String query(String cityName) {

        System.out.println("查询"+cityName+"的天气");
        return "大晴天";
    }
}
