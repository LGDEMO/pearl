package com.gemframework.base.model.validation;


import org.apache.tomcat.util.buf.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidate implements ConstraintValidator<MobilePattern, String> {

    @Override
    public void initialize(MobilePattern constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(null == value){
            return false;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,1,3,6-8])|(18[0-9])|(19[8,9])|(166))[0-9]{8}$");
        Matcher m = p.matcher(value);
        return m.matches();
    }
}
