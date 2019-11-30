package com.gemframework.admin.common.security.config;

import com.gemframework.admin.service.UserService;
import com.gemframework.admin.service.impl.UserServiceImpl;
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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @Title: WebSecurityConfg.java
 * @Package: com.gemframework.admin.common.config
 * @Date: 2019/11/30 18:56
 * @Version: v1.0
 * @Description: 集成WebSecurityConfigurerAdapter
 * 实现HttpSecurity的configure方法
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Slf4j
@Configuration
public class WebSecurityConfg extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/500").permitAll()
            .antMatchers("/404").permitAll()
            .antMatchers("/403").permitAll()
            .antMatchers("/user/login").permitAll()
            .antMatchers("/home").hasRole("ADMIN")//指定权限为ADMIN才能访问
            .antMatchers("/user").hasAnyRole("ADMIN", "USER")
            .anyRequest()//除了上面的请求
            .authenticated()//都需要认证访问
            .and()
            .formLogin()//使用表单认证方式
            .loginProcessingUrl("/home")//配置默认登录入口
            .successHandler(gemLoginSuccessHandler)//使用自定义的成功结果处理器
            .failureHandler(gemLoginFailureHandler)//使用自定义失败的结果处理器
            .and()
            .csrf().disable();
        //设置session
        http
            .sessionManagement()
            .invalidSessionUrl("/login")
            .maximumSessions(-1)
            .sessionRegistry(getSessionRegistry());
    }

    /**
     * 自定义认证策略
     *
     * @return
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder().encode("123456");
        log.info("加密后的密码:" + password);
        auth.inMemoryAuthentication().withUser("admin").password(password)
                .roles("ADMIN").and();
//        auth.inMemoryAuthentication().withUser("user").password(password)
//                .roles("USER").and();
    }

    @Autowired
    private AuthenticationSuccessHandler gemLoginSuccessHandler; //认证成功结果处理器

    @Autowired
    private AuthenticationFailureHandler gemLoginFailureHandler; //认证失败结果处理器

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry getSessionRegistry() {
        return new SessionRegistryImpl();
    }

    //完成自定义认证实体注入
    @Bean
    UserDetailsService getUserService()
    {
        return new UserServiceImpl();
    }

    @Autowired
    private UserService userService;

}
