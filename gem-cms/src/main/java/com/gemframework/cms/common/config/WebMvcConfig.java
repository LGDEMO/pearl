package com.gemframework.cms.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

@Configuration   //表示配置
public class WebMvcConfig implements WebMvcConfigurer  {

    @Autowired
    LoginInterceptor loginInterceptor;

    /**
     * 不需要登录拦截的url
     */
//    final String[] notLoginInterceptPaths = {"/static/**","/admin/login","/error/**","/login"};
    final String[] notLoginInterceptPaths = {"/static/**","/login"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这里添加多个拦截器
        // 登录拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(notLoginInterceptPaths);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置不需要经过controller就跳转到登录页面
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");

    }

    /***
     * addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //排除静态资源拦截
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
