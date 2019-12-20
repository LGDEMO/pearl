package com.gemframework.cms.service.impl;

import com.gemframework.bas.common.utils.GemBeanUtils;
import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title: MenuServiceImplTest.java
 * @Package: com.gemframework.cms.service.impl
 * @Date: 2019/12/20 20:50
 * @Version: v1.0
 * @Description: 这里写描述
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class MenuServiceImplTest {
    @Resource
    private MenuRepository menuRepository;

    @Test
    void findListAll() {
        List<Menu> list = menuRepository.findAll();
        List<MenuVo> vos = GemBeanUtils.copyCollections(list,MenuVo.class);
        for(MenuVo vo :vos){
            if(vo.getIdPath().lastIndexOf("-")>0){
                vo.setParentIdPath(vo.getIdPath().substring(0,vo.getIdPath().lastIndexOf("-")));
            }
        }
    }
}
