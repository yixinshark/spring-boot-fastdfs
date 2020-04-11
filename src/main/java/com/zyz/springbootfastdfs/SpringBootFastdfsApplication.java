package com.zyz.springbootfastdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//Swaggerui注解
@EnableSwagger2
public class SpringBootFastdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFastdfsApplication.class, args);
    }

}
