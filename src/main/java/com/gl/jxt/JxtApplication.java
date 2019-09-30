package com.gl.jxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.gl.jxt.dao")
public class JxtApplication {

    public static void main (String[] args) {
        SpringApplication.run(JxtApplication.class, args);
    }
}
