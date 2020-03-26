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
@Table(name = "gem_sysLog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class SysLog extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) comment '用户名'")
    private String username;

    @Column(columnDefinition = "varchar(10) comment '操作帐号'")
    private String account;

    @Column(columnDefinition = "tinyint(1) comment '操作类型 0登录 1其他'")
    private Integer operateType;

    @Column(columnDefinition = "tinyint(1) comment '操作状态 0成功 1失败'")
    private Integer operateStatus;

    @Column(columnDefinition = "varchar(32) comment '客户端IP'")
    private String clientIp;

    @Column(columnDefinition = "varchar(32) comment '地理地址'")
    private String address;

    @Column(columnDefinition = "varchar(100) comment '请求URL'")
    private String requestUrl;

    @Column(columnDefinition = "varchar(10) comment '请求方法'")
    private String requestMothod;

    @Column(columnDefinition = "varchar(100) comment '请求参数'")
    private String requestArgs;

}
