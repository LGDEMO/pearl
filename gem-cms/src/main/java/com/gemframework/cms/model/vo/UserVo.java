package com.gemframework.cms.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemframework.bas.common.annotation.ValidMoblie;
import com.gemframework.bas.model.vo.BaseVo;
import com.gemframework.cms.model.po.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserVo extends BaseVo {

    private Long id;

    @NotBlank(message = "用户名不能为空！")
    private String username;

    @NotBlank(message = "密码不能为空！")
    private String password;

    @NotNull(message = "工号不能为空！")
    private Integer worknum;

    @NotBlank(message = "请选择归属部门！")
    private String dept_id;
    //岗位
    private String post;

    @NotBlank(message = "姓名不能为空！")
    @Size(min = 2,max = 10,message = "姓名长度限制2~10个数字之间")
    private String realname;

    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private Integer province;
    private Integer city;
    private Integer area;
    @Size(min = 5,max = 80,message = "地址长度限制5~80个数字之间")
    private String address;

    @NotBlank(message = "手机号不能为空！")
    @ValidMoblie
    private String phone;

    private String tel;

    @Email(message = "邮箱格式不正确！")
    private String email;

    private String qq;

    private String desp;

    private List<RoleVo> roles;

    private List<String> roleNames;

    private List<DeptVo> depts;

    private List<String> deptNames;

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
