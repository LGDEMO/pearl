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

import lombok.*;

/**
 * @Title: ModuleAttrVo.java
 * @Package: com.gemframework.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ModuleAttrVo extends BaseVo {

    private Long id;
    private Long moduleId;
    private String attrName;
    private Integer attrSort;
    private String comment;
    private String attrType;
    private String options;
    private Integer minLength;
    private Integer maxLength;
    private String editType;//列表支持编辑类型
    private Integer isNull;//是否允许为空
    private Integer isVisit;//列表显示
    private Integer isSort;//支持排序显示
    private Integer isSearch;//支持查询
}
