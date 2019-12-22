package com.gemframework.cms.model.vo.ztree;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: MenuTree.java
 * @Package: com.gemframework.cms.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@Builder
public class MenuTree {

//    id:	10	,
//    name:"	父级—",
//    title:"	父级—",
//    open:true,
//    noR:false,
//    nocheck:true,
//    children:[
    private Long id;
    private Long pid;
    private String name;
    private String title;
    private boolean open;
    private boolean nocheck;
    //级别
    private Integer level;
    private List<MenuTree> children;
}
