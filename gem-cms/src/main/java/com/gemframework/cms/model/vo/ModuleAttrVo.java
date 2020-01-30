package com.gemframework.cms.model.vo;

import com.gemframework.bas.model.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Title: ModuleAttrVo.java
 * @Package: com.gemframework.cms.model.vo
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
public class ModuleAttrVo extends BaseVo {

    private Long id;
    private Long moduleId;
    private String attrNameEn;
    private String attrNameCn;
    private String attrType;
    private String options;
    private Integer minLength;
    private Integer maxLength;
    private String filedName;
    private String editType;//列表支持编辑类型
    private Integer isNull;//是否允许为空
    private Integer isTableVisit;//列表显示
    private Integer isTableSort;//支持排序显示
    private Integer isQurey;//支持查询
}
