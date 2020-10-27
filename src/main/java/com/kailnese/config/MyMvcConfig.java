package com.kailnese.config;

import com.kailnese.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("/**");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("I came here to exclude some site");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/log/**","/registration");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/success").setViewName("temp/success");
        registry.addViewController("/client").setViewName("mainPage/client");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/dashboard").setViewName("mainPage/dashboard");
        registry.addViewController("/about").setViewName("mainPage/about");
        registry.addViewController("/edit").setViewName("mainPage/edit");
    }
}
