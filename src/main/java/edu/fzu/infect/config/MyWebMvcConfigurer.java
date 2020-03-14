package edu.fzu.infect.config;

import edu.fzu.infect.config.accesslog.AccessLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xjliang
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {


    private final String[] excludePath = {"/static"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**")
            .excludePathPatterns(excludePath);
    }
}
