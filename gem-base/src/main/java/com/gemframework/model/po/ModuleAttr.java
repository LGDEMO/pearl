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

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "gem_module_attr")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ModuleAttr extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long moduleId;

    @Column(columnDefinition = "varchar(30) not null comment '字段名称'",nullable = false)
    private String attrName;

    @Column(columnDefinition = "int(2) not null comment '字段顺序'",nullable = false)
    private Integer attrSort;

    @Column(columnDefinition = "varchar(30) not null comment '字段描述'",nullable = false)
    private String comment;

    @Column(columnDefinition = "varchar(30) not null comment '字段类型'",nullable = false)
    private String attrType;

    @Column(columnDefinition = "varchar(300) comment '下拉框内容'")
    private String options;

    @Column(columnDefinition = "int(10) not null comment '字段最小长度'",nullable = false)
    private Integer minLength;

    @Column(columnDefinition = "int(10) not null comment '字段最大长度'",nullable = false)
    private Integer maxLength;

    @Column(columnDefinition = "varchar(10)  DEFAULT 'text' comment '编辑类型'")
    private String editType; // "text";//列表支持编辑类型

    @Column(columnDefinition = "tinyint(1) not null DEFAULT 1 comment '是否为空 1允许为空 0不允许为空'",nullable = false)
    private Integer isNull; // true;//是否允许为空

    @Column(columnDefinition = "tinyint(1) not null DEFAULT 1 comment '是否可见 1可见 0不可见'",nullable = false)
    private Integer isVisit;//列表显示

    @Column(columnDefinition = "tinyint(1) not null DEFAULT 1 comment '是否支持排序 1支持 0不支持'",nullable = false)
    private Integer isSort;//支持排序显示

    @Column(columnDefinition = "tinyint(1) not null DEFAULT 1 comment '是否支持查询 1支持 0不支持'",nullable = false)
    private Integer isSearch; // true;//支持查询
}
