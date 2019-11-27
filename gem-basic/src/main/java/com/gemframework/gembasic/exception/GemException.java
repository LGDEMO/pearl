package com.gemframework.gembasic.exception;

import com.gemframework.gembasic.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Title: GemException.java
 * @Package: com.gemframework.gembasic.exception
 * @Date: 2019/11/27 22:16
 * @Version: v1.0
 * @Description: 系统约定业务异常
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Getter
@Setter
public class GemException extends RuntimeException {

    private Integer code;

    public GemException(ResultCode resultCode){
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }
}
