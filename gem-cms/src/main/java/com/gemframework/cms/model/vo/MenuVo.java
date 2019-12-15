package com.gemframework.cms.model.vo;

import com.gemframework.bas.model.vo.BaseVo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Title: RoleVo.java
 * @Package: com.gemframework.cms.model.vo
 * @Date: 2019/11/30 22:40
 * @Version: v1.0
 * @Description: VO

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */

@Data
@NoArgsConstructor
public class MenuVo extends BaseVo implements Comparable<MenuVo>{

    private Long id;
    //名称
    private String name;
    //标签
    private String tag;
    //链接
    private String link;
    //类型 0 菜单 1 按钮 2 其他
    private Integer type;
    //级别 菜单级别 最大支持三级
    @Max(value = 3, message = "级别最大支持三级")
    private Integer level;
    //图标
    private String icon;
    //父级ID
    private Long pid;
    //是否选中 0 未选中 1 选中
    private Integer active;
    //排序
    private Integer sortNumber;

    List<MenuVo> childs;


    @Override
    public int compareTo(MenuVo o) {
        if (this.level>o.level) {
            return -1;//-1是排在后面
        }else if (this.level<o.level) {
            return 1;//1是排在前面
        }else {
            if (this.sortNumber<o.sortNumber) {
                return -1;
            }else if (this.sortNumber>o.sortNumber) {
                return 1;
            }else {
                return 0;
            }
        }
    }
}
