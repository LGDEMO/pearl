package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Title: Org.java
 * @Package: com.gemframework.cms.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 数据组织（针对数据）

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_org")
@NoArgsConstructor
public class Org extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '组织名称'",nullable = false)
    private String name;

    @Column(columnDefinition = "int(20) comment '父ID'")
    private Integer parent_id;

    @Column(columnDefinition = "varchar(10) comment '路径'")
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", path='" + path + '\'' +
                '}';
    }
}
