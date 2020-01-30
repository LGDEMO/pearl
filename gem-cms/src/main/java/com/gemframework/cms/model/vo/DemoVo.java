package com.gemframework.cms.model.vo;

import com.gemframework.bas.model.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Title: DemoVo.java
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
public class DemoVo extends BaseVo {

    private Long id;

    @NotBlank(message = "名称不能为空！")
    private String name;
}
