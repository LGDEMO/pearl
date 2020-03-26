/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.model.vo.view;

import lombok.Builder;
import lombok.Data;

@Data
public class Home {

    @Data
    @Builder
    public static class Order{
        private int waitPay;
        private int timeoutPay;
        private int payOffs;
        private int sended;
        private int timeoutSend;
        private int close;
        private int success;
        private int refund;
    }

}
