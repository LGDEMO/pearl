package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import com.gemframework.cms.model.vo.MenuVo;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Title: Menu.java
 * @Package: com.gemframework.cms.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 用户信息

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_menu")
@NoArgsConstructor
public class Menu extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10) comment '菜单/按钮名称'")
    private String name;
    @Column(columnDefinition = "varchar(10) comment '菜单/按钮标签'")
    private String tag;
    @Column(columnDefinition = "varchar(20) comment '菜单/按钮链接'")
    private String link;
    @Column(columnDefinition = "tinyint(1) comment '类型 0菜单 1按钮 2其他'")
    private Integer type;
    @Column(columnDefinition = "tinyint(1) comment '级别，最大支持三级'")
    private Integer level;
    //图标
    @Column(columnDefinition = "varchar(10) comment '图标'")
    private String icon;
    //父级ID
    @Column(columnDefinition = "bigint(20) comment '父级ID'")
    private Long pid;
    //是否选中 0 未选中 1 选中
    @Column(columnDefinition = "tinyint(1) comment '是否选中 0 未选中 1 选中'")
    private Integer active;
    //排序
    @Column(columnDefinition = "int(10) comment '排序编号'")
    private Integer sortNumber;

    @Transient
    List<Menu> childs;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", link='" + link + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", active=" + active +
                ", sortNumber=" + sortNumber +
                ", childs=" + childs +
                '}';
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }
}
