/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.security.exception;

import com.gemframework.common.enums.ResultCode;
import com.gemframework.common.enums.ResultURL;
import lombok.*;
import org.springframework.security.access.AccessDeniedException;

@Getter
@Setter
public class GemAccessDeniedException extends AccessDeniedException {

    private ResultCode resultCode;
    private ResultURL url;

    public GemAccessDeniedException(ResultCode resultCode) {
        super(resultCode.getMsg());
    }

    public GemAccessDeniedException(ResultCode resultCode, ResultURL URL) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.url = URL;
    }
}