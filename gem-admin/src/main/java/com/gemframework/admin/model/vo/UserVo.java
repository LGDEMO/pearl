package com.gemframework.admin.model.vo;

import com.gemframework.base.model.validation.MobilePattern;
import com.gemframework.base.model.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
public class UserVo extends BaseVo {

    private Long id;

    @NotBlank(message = "用户名不能为空！")
    private String username;

    @NotBlank(message = "密码不能为空！")
    private String password;

    @NotBlank(message = "姓名不能为空！")
    @Size(max = 2,min = 10,message = "姓名长度限制2~10个数字之间")
    private String realname;

    private String sex;

    @NotNull(message = "年龄不能为空！")
    @Max(value = 100, message = "年龄不能超过100岁")
    private Integer age;

    @NotNull(message = "手机号不能为空！")
    @MobilePattern
    private String phone;

    @Email(message = "邮箱格式不正确！")
    private String email;

    @Size(max = 5,min = 80,message = "地址长度限制5~80个数字之间")
    private String address;

}
