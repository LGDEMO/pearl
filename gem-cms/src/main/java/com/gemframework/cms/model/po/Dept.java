package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Title: Dept.java
 * @Package: com.gemframework.cms.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 部门（针对User）

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_dept")
@NoArgsConstructor
public class Dept extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) not null comment '部门名称'",nullable = false)
    private String name;

    @Column(columnDefinition = "int(20) comment '父ID'")
    private Long pid;

    @Column(columnDefinition = "tinyint(1) comment '级别'")
    private Integer level;

    @Column(columnDefinition = "varchar(50) comment '描述'")
    private String desp;

    //排序
    @Column(columnDefinition = "int(10) comment '排序编号'")
    private Integer sortNumber;
    //系列 用于归类 存放家族一级分类ID 一级分类存自己ID
    @Column(columnDefinition = "varchar(20) comment '所属系列'")
    private String series;

    //路径 1-2-1
    @Column(columnDefinition = "varchar(20) comment 'ID路径'")
    private String idPath;

    //父级的路径 1-2-1
    @Transient
    private String parentIdPath;
    @Transient
    List<Dept> childs;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getParentIdPath() {
        return parentIdPath;
    }

    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath;
    }

    public List<Dept> getChilds() {
        return childs;
    }

    public void setChilds(List<Dept> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", level=" + level +
                ", desp='" + desp + '\'' +
                ", sortNumber=" + sortNumber +
                ", series='" + series + '\'' +
                ", idPath='" + idPath + '\'' +
                ", parentIdPath='" + parentIdPath + '\'' +
                ", childs=" + childs +
                '}';
    }
}
