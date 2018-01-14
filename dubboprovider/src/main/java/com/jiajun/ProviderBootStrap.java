package com.jiajun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by SUMMERS on 2018/1/14.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ProviderBootStrap {

    public static void main(String[] args){
        SpringApplication.run(ProviderBootStrap.class,args);


    }
}
