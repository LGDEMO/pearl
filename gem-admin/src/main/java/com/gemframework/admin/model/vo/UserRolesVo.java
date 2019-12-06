package com.gemframework.admin.model.vo;

import com.gemframework.base.model.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: UserRoleVo.java
 * @Package: com.gemframework.admin.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@NoArgsConstructor
public class UserRolesVo extends BaseVo {

    private Long id;

    private Long userId;

    private Long roleId;

    public UserRolesVo(Long id){
        this.id = id;
    }

}
