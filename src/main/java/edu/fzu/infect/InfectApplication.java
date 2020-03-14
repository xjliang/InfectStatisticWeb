package edu.fzu.infect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xjliang
 */
@SpringBootApplication
@MapperScan(basePackages = "edu.fzu.infect.generator")
@EnableScheduling
public class InfectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectApplication.class, args);
    }

}
