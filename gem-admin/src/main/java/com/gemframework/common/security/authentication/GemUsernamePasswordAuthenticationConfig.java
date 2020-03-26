/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.security.authentication;

import com.gemframework.common.security.handler.GemLoginFailureHandler;
import com.gemframework.common.security.handler.GemLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 自定义的用户名密码认证配置类
 */
@Component
public class GemUsernamePasswordAuthenticationConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private GemUsernamePasswordAuthenticationProvider gemUsernamePasswordAuthenticationProvider;

    @Autowired
    private GemLoginSuccessHandler gemLoginSuccessHandler;

    @Autowired
    private GemLoginFailureHandler gemLoginFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        GemUsernamePasswordAuthenticationFilter authenticationFilter = new GemUsernamePasswordAuthenticationFilter();

        /**
         * 自定义用户认证处理逻辑时，需要指定AuthenticationManager，否则无法认证
         */
        authenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        /**
         * 自定义用户认证处理逻辑时，需要指定RememberMeServices，否则自定义用户认证的"记住我"功能异常
         */
        authenticationFilter.setRememberMeServices(http.getSharedObject(RememberMeServices.class));

        /**
         * 指定自定义的认证成功和失败的处理器
         */
        authenticationFilter.setAuthenticationSuccessHandler(gemLoginSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(gemLoginFailureHandler);

        /**
         * 把自定义的用户名密码认证过滤器和处理器添加到UsernamePasswordAuthenticationFilter过滤器之前
         */
        http
            .authenticationProvider(gemUsernamePasswordAuthenticationProvider)
            .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

}