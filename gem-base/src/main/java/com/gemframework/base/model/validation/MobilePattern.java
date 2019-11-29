package com.gemframework.base.model.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @Title: MobilePattern.java
 * @Package: com.gemframework.base.annotation
 * @Date: 2019/11/29 13:11
 * @Version: v1.0
 * @Description: 自定义手机号码校验注解

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidate.class})
public @interface MobilePattern {

	String regexp() default "";

	String message() default "手机格式不正确";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
