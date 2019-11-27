package com.gemframework.gembasic.exception;

import com.gemframework.gembasic.enums.ResultCode;
import com.gemframework.gembasic.model.BasicResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @Title: GemException.java
 * @Package: com.gemframework.gembasic.exception
 * @Date: 2019/11/27 21:53
 * @Version: v1.0
 * @Description: 异常统一捕获类
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@ControllerAdvice
public class GemExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(GemExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BasicResult handleExp(HttpServletRequest request, Exception ex) {
        if (ex instanceof GemException) {
            logger.error("GemException {}" , ex.getMessage());
            GemException gemException = (GemException) ex;
            return BasicResult.ERROR(gemException.getCode(), gemException.getMessage());
        } else {
            logger.error("System Exception {}" , ex.getMessage());
            return BasicResult.ERROR(ResultCode.SYSTEM_EXCEPTION.getCode(), ResultCode.SYSTEM_EXCEPTION.getMsg());
        }
    }

    @ExceptionHandler(SQLException.class)
    public ModelAndView handSql(Exception ex) {
        logger.info("SQL Exception {}" , ex.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("sql_error");
        return mv;
    }
}
