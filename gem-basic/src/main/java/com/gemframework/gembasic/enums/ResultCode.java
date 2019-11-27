package com.gemframework.gembasic.enums;

import lombok.Getter;

/**
 * @Title: ResultCode.java
 * @Package: com.gemframework.gembasic.enum
 * @Date: 2019/11/27 22:28
 * @Version: v1.0
 * @Description: 错误码枚举类

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Getter
public enum ResultCode {

    SUCCESS(0,"返回成功"),

    SYSTEM_EXCEPTION(999999,"系统异常"),
    ;


    private Integer code;
    private String msg;

    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
