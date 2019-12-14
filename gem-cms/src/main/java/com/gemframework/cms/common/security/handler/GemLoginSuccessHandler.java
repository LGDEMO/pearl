package com.gemframework.cms.common.security.handler;

import com.gemframework.cms.common.security.config.GemAuthPageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("gemLoginSuccessHandler")
public class GemLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Autowired
    private GemAuthPageProperties gemAuthPageProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        log.info("登录成功");
        //TODO:这里写登录成功后的逻辑
        //页面跳转到首页
        //api请求的话返回token

        log.info(request.getHeader("licence"));
        //如果没有登录，跳转登录
        getRedirectStrategy().sendRedirect(request, response, gemAuthPageProperties.getIndexPage());
    }


}
