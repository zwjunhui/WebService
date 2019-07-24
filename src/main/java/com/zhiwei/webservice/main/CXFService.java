package com.zhiwei.webservice.main;

/**
 * @Description: 利用CXF框架来实现发布服务  @WebService的注解是加在接口上的不是加在实现类上的
 * @Author: wyjun
 * @UpdateDate: 2019/7/23 14:53
 * @Version: 1.0
 */
public class CXFService {

    public static void main(String[] args) {
        //首先要导入需要的jar包

    /*
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        //设置发布的地址
        factoryBean.setAddress("http://localhost:8080/weatherService");
        //设置服务的接口
        factoryBean.setServiceClass(接口名称.class);
        //设置服务的实现对象
        factoryBean.setServiceBean(new 实现类);

        //通过工厂创建服务
        factoryBean.create();

        //发布服务成功
        System.out.println("发布服务成功");

    */


        /**
         * CXF框架实现服务的客户端
         *  新建一个项目 cmd 进入到src目录下 执行
         *  wsdl2java -d . 说明书地址
         */
        //调用服务
       /* JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        //设置服务接口
        jaxWsProxyFactoryBean.setServiceClass(接口.class);
        //设置服务地址
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/weatherService");
        //获取服务接口实例
        接口 service = jaxWsProxyFactoryBean.create();

        //调用方法
        String result = service.query("参数");
        //输出结果
        System.out.println(result);*/
    }
}
