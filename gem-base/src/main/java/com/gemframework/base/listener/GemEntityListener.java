package com.gemframework.base.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @Title: GemEntityListener.java
 * @Package: com.gemframework.gembasic.listener
 * @Date: 2019/11/28 17:42
 * @Version: v1.0
 * @Description: 这里写描述

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
        log.debug("save之前的操作");
    }

    @PostPersist
    public void postpersist(GemEntityOpt object) throws IllegalArgumentException, IllegalAccessException {

        log.debug("save之后的操作");
    }

    @PreUpdate
    public void preUpdate(GemEntityOpt object)
            throws IllegalArgumentException, IllegalAccessException {
        Timestamp now = Timestamp.from(Instant.now());
        object.setLastUpdated(now);
        log.debug("update之前的操作");
    }

    @PostUpdate
    public void postUpdate(GemEntityOpt object)
            throws IllegalArgumentException, IllegalAccessException {
        log.debug("update之后的操作");
    }

    @PreRemove
    public void preRemove(GemEntityOpt object) {
        log.debug("del之前的操作");

    }

    @PostRemove
    public void postRemove(GemEntityOpt object) {
        log.debug("del之后的操作");

    }
}
