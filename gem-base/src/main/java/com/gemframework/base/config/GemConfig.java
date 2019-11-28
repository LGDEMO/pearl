package com.gemframework.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Title: GemConfig.java
 * @Package: com.gemframework.gembasic.config
 * @Date: 2019/11/27 23:31
 * @Version: v1.0
 * @Description: 自定义配置文件
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "gem")
public class GemConfig {

    private BigDecimal min;
    private BigDecimal max;
    private String desc;
}
