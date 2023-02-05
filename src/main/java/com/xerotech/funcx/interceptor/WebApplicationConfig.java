package com.xerotech.funcx.interceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JCccc
 * @Date: 2022-6-23 10:52
 * @Description:
 */
@Configuration
public class WebApplicationConfig {

    @Bean
    BodyWrapperFilter getBodyWrapperFilter(){
        return new BodyWrapperFilter();
    }
    @Bean("bodyWrapperFilter")
    public FilterRegistrationBean<BodyWrapperFilter> checkUserFilter(BodyWrapperFilter bodyWrapperFilter) {
        FilterRegistrationBean<BodyWrapperFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(bodyWrapperFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }

}
