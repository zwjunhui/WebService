package com.zhiwei.webservice.config;

import com.zhiwei.webservice.service.IUserService;
import com.zhiwei.webservice.service.IUserServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * @Description: java类作用描述
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 17:08
 * @Version: 1.0
 */
@Configuration
public class WebServiceConfig {

    @Bean
   // springmvc 的核心类 为DispatcherServlet
    //此处若不重命名此bean的话 原本的mvc就被覆盖了。
    public ServletRegistrationBean disServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/ws/*");
    }

   /* @Bean
    public IUserService userService(){
        return new IUserServiceImpl();
    }*/

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus springBus = new SpringBus();
        return springBus;
    }
    @Bean
    public Endpoint endpoint(IUserService userService){
        EndpointImpl endpoint =  new EndpointImpl(springBus(),new IUserServiceImpl());
        endpoint.publish("/user");
        return endpoint;
    }
}
