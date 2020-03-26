/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.filter;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.common.exception.GemException;
import com.gemframework.common.utils.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 定义一个验证码的拦截器
 */
@Slf4j
@Component
@Order(2)
public class ValidateCodeFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if(request.getMethod().equalsIgnoreCase("post")){
            log.info("验证验证码~~~~~~~"+request.getRequestURI()+"=="+request.getMethod());
        }
        if (StringUtils.equals("login", request.getRequestURI()) &&
                StringUtils.endsWithIgnoreCase(request.getMethod(), "post")) {
            try {
                if(!VerifyCodeUtil.checkVerifyCode(request)){
                    throw new GemException(ResultCode.VERIFY_CODE_ERROR);
                }else{
                    log.info("验证成功~~~~~~~");
                }
            } catch (GemException e) {
                throw new GemException(ResultCode.PARAM_EXCEPTION);
            }
        }
        filterChain.doFilter(request, response);
    }
}