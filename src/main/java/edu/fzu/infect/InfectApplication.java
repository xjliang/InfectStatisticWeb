package edu.fzu.infect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "edu.fzu.infect.mapper")
@EnableScheduling
public class InfectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectApplication.class, args);
    }

}
