package com.gemframework.admin.model.po;

import com.gemframework.base.model.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Title: User.java
 * @Package: com.gemframework.admin.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 用户信息

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "gem_user")
public class User extends BasePo implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '用户名'",nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(20) not null comment '密码'",nullable = false)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "gem_user_roles",
            joinColumns = {
                    @JoinColumn(name = "ur_user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ur_role_id")
            }
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = getRoles();
        for(Role role : roles)
        {
            auths.add(new SimpleGrantedAuthority(role.getFlag()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
