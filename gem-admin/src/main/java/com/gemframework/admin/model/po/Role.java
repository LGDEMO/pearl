package com.gemframework.admin.model.po;

import com.gemframework.base.model.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
@Table(name = "gem_role")
public class Role extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '角色名称'",nullable = false, unique = true)
    private String rolename;

    @Column(columnDefinition = "varchar(10) not null comment '标识'",nullable = false, unique = true)
    private String flag;



}
