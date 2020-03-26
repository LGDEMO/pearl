/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.vo.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: MenuSide.java
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
