package com.jiajun.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by SUMMERS on 2018/1/14.
 */

@Service
public class HelloWorldServiceImpl implements IHelloWorldService {

    @PostConstruct
    public void init(){
        System.out.println("start service" + " " + host);
    }

    @Value("${server.port}")
    private String host;

    @Override
    public String sayHello(int index) {
        System.out.println("----------" + host);
        return "--------------- serverJiajun " + host;
    }
}
