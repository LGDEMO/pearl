package com.gemframework.admin.common.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("gemLoginFailureHandler")
public class GemLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public GemLoginFailureHandler(){
        this.setDefaultFailureUrl("/login?error=true");
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        super.onAuthenticationFailure(request,response,exception);
        response.setContentType("application/json;charset=UTF-8");
        log.info("登录失败");
        //这里写登录失败的逻辑
        // 判断是用哪一种方式进行登录的
    }
}
