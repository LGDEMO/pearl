package com.gemframework.admin.model.vo;

import com.gemframework.base.model.po.BasePo;
import com.gemframework.base.model.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Title: RoleVo.java
 * @Package: com.gemframework.admin.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@NoArgsConstructor
public class RoleVo extends BaseVo {

    private Long id;

    @NotBlank(message = "角色名不能为空！")
    @Size(max = 2,min = 10,message = "角色名长度限制2~10个数字之间")
    private String rolename;

    @NotBlank(message = "角色标识不能为空！")
    @Size(max = 2,min = 10,message = "角色标识长度限制2~10个数字之间")
    private String flag;



}