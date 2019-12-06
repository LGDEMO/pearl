package com.gemframework.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gemframework.base.model.validation.MobilePattern;
import com.gemframework.base.model.vo.BaseVo;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;


@NoArgsConstructor
public class UserVo extends BaseVo {

    private Long id;

    @NotBlank(message = "用户名不能为空！")
    private String username;

    @NotBlank(message = "密码不能为空！")
    @JsonIgnore
    private String password;

    @NotBlank(message = "姓名不能为空！")
    @Size(min = 2,max = 10,message = "姓名长度限制2~10个数字之间")
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

    @Size(min = 5,max = 80,message = "地址长度限制5~80个数字之间")
    private String address;

    private List<RoleVo> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", roles=" + roles +
                '}';
    }
}
