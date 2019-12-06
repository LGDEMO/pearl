package com.gemframework.admin.common.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemframework.base.model.BaseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @Title: 自定义异常格式统一
 * @Package: com.gemframework.admin.common.security.handler
 * @Date: 2019/12/5 20:47
 * @Version: v1.0
 * @Description: 这里写描述

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Component("gemAccessDeniedHandler")
public class GemAccessDeineHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().print(JSONObject.toJSONString(BaseResult.ERROR(888,"没有访问权限!")));
    }

}
