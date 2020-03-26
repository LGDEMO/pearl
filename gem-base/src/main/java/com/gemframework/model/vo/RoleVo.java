/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Title: RoleVo.java
 * @Package: com.gemframework.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends BaseVo {

    private Long id;

    @NotBlank(message = "角色名不能为空！")
    @Size(min = 2,max = 10,message = "角色名长度限制2~10个数字之间")
    private String rolename;

    @NotBlank(message = "角色标识不能为空！")
    @Size(min = 2,max = 10,message = "角色标识长度限制2~10个数字之间")
    private String flag;

    private String desp;

    private Integer datarange;

    private List<MenuVo> menus;
    private List<DeptVo> depts;

}
