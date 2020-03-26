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

import java.sql.Timestamp;

/**
 * @Title: GemEntityOpt.java
 * @Package: com.gemframework.listener
 * @Date: 2019/11/28 17:42
 * @Version: v1.0
 * @Description: 自定义监控实体操作

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
public interface GemEntityOpt {

    Timestamp getDateCreated();

    void setDateCreated(Timestamp dateCreated);

    Timestamp getLastUpdated();

    void setLastUpdated(Timestamp lastUpdated);

    Long getDateCreatedOn();

    void setDateCreatedOn(Long dateCreatedOn);

    Long getLastUpdatedOn();

    void setLastUpdatedOn(Long lastUpdatedOn);

}
