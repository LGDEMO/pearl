package com.gemframework.base.model.vo;

import com.gemframework.base.model.validation.MobilePattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class UserVo extends BaseVo {

    private Long id;

    @NotBlank(message = "用户名不能为空！")
    private String userName;

    @NotNull(message = "年龄不能为空！")
    @Max(value = 100, message = "年龄不能超过100岁")
    private Integer userAge;

    @NotNull(message = "手机号不能为空！")
    @Size(min = 2,max = 10,message = "手机号长度限制11~15个数字之间")
    @MobilePattern
    private String userPhone;

}
