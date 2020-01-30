package com.gemframework.bas.common.enums;

import lombok.Getter;

/**
 * @Title: ResultCode.java
 * @Package: com.gemframework.bas.enum
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

    //系统错误码 1000-9999
    PARAM_EXCEPTION(1000,"参数错误"),
    DATA_EXIST(1001,"数据已存在"),
    DATA_NOT_EXIST(1002,"数据不存在"),
    CRATE_IMAGE_ERROR(1003,"生成图形验证码失败"),
    VERIFY_CODE_ERROR(1004,"验证验证码失败"),
    MODULE_ATTR_ERROR(1005,"请完善模块属性（字段）信息"),

    //业务错误码 10000-99999
    USER_EXIST(10000,"用户已存在"),
    DEPT_EXIST(10001,"部门已存在"),
    ROLE_EXIST(10002,"角色已存在"),
    MENU_EXIST(10002,"菜单已存在"),
    SYSTEM_EXCEPTION(999999,"系统异常"),
    ;


    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
