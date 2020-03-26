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

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 * 根据自己需求扩展业务
 */
@Slf4j
@Component
@Order(1)
public class GemCustomFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //启动时执行
        log.debug("启动时执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.debug("访问时执行");
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        //执行下一个过滤器
        fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        return;
    }

    @Override
    public void destroy() {

        log.info("被销毁了");
    }
}