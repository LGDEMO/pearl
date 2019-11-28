package com.gemframework.base.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserVo extends BaseVo {

    private Long id;

    private String userName;

    private Integer userAge;

    private String userPhone;

}
