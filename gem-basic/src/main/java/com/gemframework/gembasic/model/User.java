package com.gemframework.gembasic.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Title: User.java
 * @Package: com.gemframework.gembasic.model
 * @Date: 2019/11/25 14:30
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Data
@Builder
public class User {

    private Long id;

    private Integer age;

    private String name;

}
