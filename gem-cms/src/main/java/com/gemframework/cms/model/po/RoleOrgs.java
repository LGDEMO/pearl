package com.gemframework.cms.model.po;

import com.gemframework.bas.model.po.BasePo;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Title: RoleMenus.java
 * @Package: com.gemframework.cms.model.po
 * @Date: 2019/11/30 17:54
 * @Version: v1.0
 * @Description: 用户信息

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Entity
@Table(name = "gem_role_orgs")
@NoArgsConstructor
public class RoleOrgs extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "bigint(20) not null comment '角色ID'")
    private Long roleId;

    @Column(columnDefinition = "bigint(20) not null comment '数据组织（域）ID'")
    private Long orgId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "RoleOrgs{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                ", orgId='" + orgId + '\'' +
                '}';
    }
}
