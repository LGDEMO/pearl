package com.gemframework.cms.common.interceptor;

import com.gemframework.cms.common.security.config.GemAuthPageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration   //表示配置
public class WebMvcConfigurerAdapter implements WebMvcConfigurer  {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Resource
    GemAuthPageProperties gemAuthPageProperties;

    /**
     * 不需要登录拦截的url
     */
    final String[] notLoginInterceptPaths = {
            "/static/**",
            "/403",
            "/404",
            "/error",
            "/login",
            "/index",
            "initMenus",
            "/user/add",
            "/menu/add",
            "/menu/delete",
            "/menu/update",
            "/menu/list",
            "*.html",
    };

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
        registry.addViewController("/login")
                .setViewName("/login");

    }

    /***
     * addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //排除静态资源拦截
        registry.addResourceHandler("static/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


    @Resource(name="thymeleafViewResolver")
    private ThymeleafViewResolver thymeleafViewResolver;

    @Override
    /**
     * @Title: 定义thymeleaf全局变量
     * @Param: [registry]
     * @Retrun: void
     * @Description:
     * @Date: 2019/12/19 21:56
     */
    public void configureViewResolvers(ViewResolverRegistry registry) {

        if (thymeleafViewResolver != null) {
            Map<String, Object> vars = new HashMap<>(1);
            vars.put("staticPathPrefix", "static/access");
            thymeleafViewResolver.setStaticVariables(vars);
        }
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }
}
