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
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Title: TableVo.java
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
@EqualsAndHashCode(callSuper=true)
public class ModuleVo extends BaseVo {

    private Long id;

    @NotBlank(message = "包名不能为空！")
    private String packageName;

    @NotBlank(message = "英文名称不能为空！")
    private String nameEn;

    @NotBlank(message = "中文名称不能为空！")
    private String nameCn;

    @NotBlank(message = "主键名称不能为空！")
    private String pkNane;

    @NotNull(message = "请设置是否具备添加功能！")
    private Integer isAdd;

    @NotNull(message = "请设置是否具备编辑功能！")
    private Integer isEdit;

    @NotNull(message = "请设置是否具备删除功能！")
    private Integer isDel;

    @NotNull(message = "请设置是否具备查询功能！")
    private Integer isQuery;

    private Integer pageWidth;
    private Integer pageHeight;

    //作者
    private String author;

    private List<ModuleAttrVo> moduleAttrs;

    //是否生成Code
    private Integer isGenerate;

}
