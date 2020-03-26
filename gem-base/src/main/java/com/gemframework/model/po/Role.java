/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Title: User.java
 * @Package: com.gemframework.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 用户信息

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_role")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Role extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '角色名称'",nullable = false, unique = true)
    private String rolename;

    @Column(columnDefinition = "varchar(10) not null comment '标识'",nullable = false, unique = true)
    private String flag;

    @Column(columnDefinition = "varchar(100) not null comment '描述'",nullable = false)
    private String desp;

    @Column(columnDefinition = "int(2) not null comment '数据范围'",nullable = false)
    private Integer datarange;

    @Transient
    private List<Menu> menus;

    @Transient
    private List<Dept> depts;

}
