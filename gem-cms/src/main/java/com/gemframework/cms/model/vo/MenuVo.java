package com.gemframework.cms.model.vo;

import com.gemframework.bas.model.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Title: RoleVo.java
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
public class MenuVo extends BaseVo {

    private Long id;
    private String name;
    private String tag;
    private String link;
    private String type;
    private String level;
    private String pid;
    private String img;

}
