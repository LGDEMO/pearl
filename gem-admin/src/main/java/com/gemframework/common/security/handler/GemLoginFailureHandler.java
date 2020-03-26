/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.security.handler;

import com.gemframework.common.constant.GemConstant;
import com.gemframework.common.enums.OperateStatus;
import com.gemframework.common.enums.OperateType;
import com.gemframework.common.utils.GemIPHandler;
import com.gemframework.model.vo.SysLogVo;
import com.gemframework.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.gemframework.common.utils.GemIPHandler.getIpAddr;


@Slf4j
@Component("gemLoginFailureHandler")
public class GemLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private SysLogService sysLogService;

    public GemLoginFailureHandler(){
        this.setDefaultFailureUrl("/login?error=true");
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        super.onAuthenticationFailure(request,response,exception);
        response.setContentType(GemConstant.MediaType.JSON_UTF_8);
        log.info("登录失败:"+exception.getMessage());
        //这里写登录失败的逻辑
        // 判断是用哪一种方式进行登录的

//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setContentType(GemConstant.MediaType.JSON_UTF_8);
//        if(exception instanceof BadCredentialsException){
//            response.getWriter().write(GemJsonUtils.objectToJson(ResultData.getResultWithCode(GemErrorStatus.PASSWORD_ERROR)));
//        }else if(exception instanceof InternalAuthenticationServiceException){
//            response.getWriter().write(GemJsonUtils.objectToJson(ResultData.getResultWithCode(GemErrorStatus.NOT_USER)));
//        }else{
//            log.error("---auth error:{}","GemLoginFailureHandler");
//            response.getWriter().write(GemJsonUtils.objectToJson(ResultData.getResultWithCode(GemErrorStatus.AUTHENTICATION_FAILED)));
//        }

        //记录操作日志
        SysLogVo sysLogVo = SysLogVo.builder()
                .account(request.getParameter("username").trim())
                .username(request.getParameter("username").trim())
                .clientIp(getIpAddr(request))
                .address(GemIPHandler.ipToAddress(getIpAddr(request)))
                .operateType(OperateType.LOGIN.getCode())
                .operateStatus(OperateStatus.FAIL.getCode())
                .requestUrl(request.getRequestURL().toString())
                .requestMothod(request.getMethod())
                .build();
        sysLogService.save(sysLogVo);
    }

}
