package com.gemframework.cms.common.security.scheme;

import com.alibaba.fastjson.JSON;
import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.cms.model.po.User;
import com.gemframework.cms.service.UserRolesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class GemFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Resource
    private UserRolesService userRolesService;

    @Resource
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    //针对某些接口放白名单
    private String[] ignoreStartUris = new String[]{
            "/swagger",
            "/webjars/",
            "/v2/",
            "/api/claims/",
            "/metrics"
    };

    //设置自定义校验
    @Autowired
    public void setMyAccessDecisionManager(GemAccessDecisionManager gemAccessDecisionManager) {
        super.setAccessDecisionManager(gemAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }


    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        //通过cookie获取用户信息
        HttpServletRequest request = fi.getHttpRequest();
        String url = request.getServletPath();
        if (StringUtils.startsWithAny(url, ignoreStartUris)) {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            return;
        }
//        SecurityContextHolder.clearContext();
        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        log.info("[权限拦截] 当前登录用户 user:{}", principal);
        log.info("[权限拦截] 当前用户角色：{}", JSON.toJSON(SecurityContextHolder.getContext().getAuthentication().getAuthorities()));
        if ("anonymousUser".equals(principal)) {
            log.info("[权限拦截] 给用户授权开始========url:{}", url);
            Cookie[] cookies = request.getCookies();
            String sessionId = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(GemConstant.Auth.CAS_SESSION_ID)) {
                        sessionId = cookie.getValue();
                        break;
                    }
                }
            }

            //TODO:
            User sessionUser = new User();
//            SessionUser sessionUser = UserUtils.getUserBySessionId(sessionId);
            if (sessionUser != null) {
                Authentication authReq = new UsernamePasswordAuthenticationToken
                        (sessionUser.getUsername(), sessionUser.getPassword());
                GemAuthenticationManager am = new GemAuthenticationManager();
                //TODO:
                List<String> roles = null;
                am.setRoles(roles);
                Authentication result = am.authenticate(authReq);
                SecurityContextHolder.getContext().setAuthentication(result);
            } else {
                log.info("[权限校验] 当前用户未登录");
            }
            log.info("[权限拦截] 当前用户角色：{}", JSON.toJSON(SecurityContextHolder.getContext().getAuthentication().getAuthorities()));
            log.info("[权限拦截] 给用户授权结束========");
        }
        //fi里面有一个被拦截的url
        //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
        //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
        InterceptorStatusToken token = super.beforeInvocation(fi);
        if (token == null) {
            return;
        }
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }

    }

    @Override
    public void destroy() {

    }

    //设置自定义数据库配置
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }
}
