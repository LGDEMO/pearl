/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @Title: GemEntityListener.java
 * @Package: com.gemframework.listener
 * @Date: 2019/11/28 17:42
 * @Version: v1.0
 * @Description: 实体操作监听类

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Slf4j
@Component
@Transactional
public class GemEntityListener {

    @PrePersist
    public void prePersist(GemEntityOpt object) throws IllegalArgumentException, IllegalAccessException {
        Timestamp now = Timestamp.from(Instant.now());
        object.setDateCreated(now);
        object.setLastUpdated(now);
        log.info("save之前的操作");
    }

    @PostPersist
    public void postpersist(GemEntityOpt object) throws IllegalArgumentException, IllegalAccessException {

        log.info("save之后的操作");
    }

    @PreUpdate
    public void preUpdate(GemEntityOpt object)
            throws IllegalArgumentException, IllegalAccessException {
        Timestamp now = Timestamp.from(Instant.now());
        object.setLastUpdated(now);
        log.info("update之前的操作");
    }

    @PostUpdate
    public void postUpdate(GemEntityOpt object)
            throws IllegalArgumentException, IllegalAccessException {
        log.info("update之后的操作");
    }

    @PreRemove
    public void preRemove(GemEntityOpt object) {
        log.info("del之前的操作");

    }

    @PostRemove
    public void postRemove(GemEntityOpt object) {
        log.info("del之后的操作");

    }
}
