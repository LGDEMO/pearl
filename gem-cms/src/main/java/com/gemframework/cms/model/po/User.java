package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Title: User.java
 * @Package: com.gemframework.cms.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 用户信息

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_user")
@NoArgsConstructor
public class User extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '用户名'",nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(150) not null comment '密码'",nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(10) not null comment '用户名'",nullable = false)
    private String realname;

    @Column(columnDefinition = "int(1) comment '性别'")
    private Integer sex;

    @Column(columnDefinition = "int(2) comment '年龄'")
    private Integer age;

    @Column(columnDefinition = "varchar(11) not null comment '手机号'",nullable = false, unique = true)
    private String phone;

    @Column(columnDefinition = "varchar(11) comment '邮箱'",nullable = true, unique = true)
    private String email;

    @Column(columnDefinition = "varchar(80) comment '地址'",nullable = true, unique = true)
    private String address;

    @Column(columnDefinition = "bigint(20) comment '部门ID'")
    private Integer deptId;

    @Transient
    private List<Role> roles;

    @Transient
    private Dept dept;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", deptId=" + deptId +
                ", roles=" + roles +
                ", dept=" + dept +
                '}';
    }
}
