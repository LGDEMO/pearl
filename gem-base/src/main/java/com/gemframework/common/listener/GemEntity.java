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

import javax.persistence.EntityListeners;
import java.sql.Timestamp;


/**
 * @Title: GemEntity.java
 * @Package: com.gemframework.listener
 * @Date: 2019/11/28 17:42
 * @Version: v1.0
 * @Description: 自定义实体操作监控实现

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@EntityListeners(GemEntityListener.class)
public class GemEntity implements GemEntityOpt {

    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private Long createOn;
    private Long lastUpdateOn;

    @Override
    public Timestamp getDateCreated() {
        return createTime;
    }

    @Override
    public void setDateCreated(Timestamp dateCreated) {
        createTime = dateCreated;
    }

    @Override
    public Timestamp getLastUpdated() {
        return lastUpdateTime;
    }

    @Override
    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdateTime = lastUpdated;
    }

    @Override
    public Long getDateCreatedOn() {
        return createOn;
    }

    @Override
    public void setDateCreatedOn(Long dateCreatedOn) {
        createOn = dateCreatedOn;
    }

    @Override
    public Long getLastUpdatedOn() {
        return lastUpdateOn;
    }

    @Override
    public void setLastUpdatedOn(Long lastUpdatedOn) {
        this.lastUpdateOn = lastUpdatedOn;
    }
}
