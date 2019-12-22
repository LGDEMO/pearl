package com.gemframework.cms.model.vo.ztree;

import com.gemframework.bas.model.vo.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Title: MenuSide.java
 * @Package: com.gemframework.cms.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@Builder
public class MenuSide {

//   "F_ModuleId": "1",
//   "F_ParentId": "0",
//   "F_EnCode": "SysManage",
//   "F_FullName": "系统管理",
//   "F_Icon": "fa fa-desktop",
//   "F_UrlAddress": "/default",

    private String F_ModuleId;
    private String F_ParentId;
    private String F_EnCode;
    private String F_FullName;
    private String F_Icon;
    private String F_UrlAddress;
}
