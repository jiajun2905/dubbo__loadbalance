package com.jiajun.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import javax.annotation.PostConstruct;
import java.util.Scanner;

/**
 * Created by SUMMERS on 2018/1/14.
 */
@Service
public class HelloWorldRpcService {

    @Reference(loadbalance = "custom")
    private IHelloWorldService helloWorldService;


    @PostConstruct
    public void init(){
        System.out.println("----------" + helloWorldService.sayHello(0));
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String x = scanner.nextLine();
            int index;
            try{
                index = Integer.parseInt(x);
            }catch (Exception e){
                index = 0;
            }
            System.out.println("**************" + helloWorldService.sayHello(index));
        }
    }
}
