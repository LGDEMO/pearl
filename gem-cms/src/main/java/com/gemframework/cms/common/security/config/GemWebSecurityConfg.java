package com.gemframework.cms.common.security.config;

import com.gemframework.cms.common.security.scheme.GemFilterSecurityInterceptor;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.service.RoleService;
import com.gemframework.cms.service.UserService;
import com.gemframework.cms.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: WebSecurityConfg.java
 * @Package: com.gemframework.cms.common.config
 * @Date: 2019/11/30 18:56
 * @Version: v1.0
 * @Description: 集成WebSecurityConfigurerAdapter
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Slf4j
@Configuration
public class GemWebSecurityConfg extends WebSecurityConfigurerAdapter {


    /**
     * 实现HttpSecurity的configure方法
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<RoleVo> list = new ArrayList<RoleVo>();
        //拦截和校验请求
        http.addFilterBefore(gemFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http
                .formLogin()//定义本系统使用表单认证方式
                .loginPage("/login")//定义登录时的login页面
                .defaultSuccessUrl("/index")
                .successHandler(gemLoginSuccessHandler)//使用自定义的成功结果处理器
                .failureHandler(gemLoginFailureHandler)//使用自定义失败的结果处理器
                .and()
                .csrf().disable()//关闭跨域防护
        ;

        //开启自动注销 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        //开启免认证（记住我）
        http.rememberMe().rememberMeParameter("remember");
        //设置session
        http
            .sessionManagement()
            .invalidSessionUrl("/login")
            .maximumSessions(-1)
            .sessionRegistry(getSessionRegistry());
    }

    /**
     * 添加 UserDetailsService， 实现自定义登录校验
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        log.info("验证..");
        auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private AuthenticationSuccessHandler gemLoginSuccessHandler; //认证成功结果处理器

    @Autowired
    private AuthenticationFailureHandler gemLoginFailureHandler; //认证失败结果处理器

    @Autowired
    private GemFilterSecurityInterceptor gemFilterSecurityInterceptor; //自定义拦截


    //完成自定义认证实体注入
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public SessionRegistry getSessionRegistry() {
        return new SessionRegistryImpl();
    }

}
