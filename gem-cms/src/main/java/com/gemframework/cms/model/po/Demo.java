package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gem_demo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Demo extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '名称'",nullable = false)
    private String name;
}
