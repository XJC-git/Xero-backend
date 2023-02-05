package com.xerotech.funcx.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> includePathLists= new ArrayList<>();
        includePathLists.add("/**");//  拦截
        List<String> excludePathLists= new ArrayList<>();
        excludePathLists.add("/login");//  不拦截
        excludePathLists.add("/error");
        registry.addInterceptor(dataBaseInterceptor())
                .excludePathPatterns(excludePathLists)
                .addPathPatterns(includePathLists);
    }

    @Bean
    public DataBaseInterceptor dataBaseInterceptor() {
        return new DataBaseInterceptor();
    }
}