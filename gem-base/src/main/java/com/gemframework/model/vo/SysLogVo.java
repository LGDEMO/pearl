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
 * @Title: SysLogVo.java
 * @Package: com.gemframework.model.vo
 * @Date: ${date}
 * @Version: v1.0
 * @Description: VO

 * @Author: gemteam
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class SysLogVo extends BaseVo {

    private Long id;
    private String username;
    private String account;
    private String clientIp;
    private String address;
    private Integer operateType;
    private Integer operateStatus;
    private String requestUrl;
    private String requestMothod;
    private String requestArgs;

}
