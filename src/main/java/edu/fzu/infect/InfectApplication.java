package edu.fzu.infect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "edu.fzu.infect.mapper")
public class InfectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectApplication.class, args);
    }

}
