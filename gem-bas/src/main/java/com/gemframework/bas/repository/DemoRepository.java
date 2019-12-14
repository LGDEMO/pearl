package com.gemframework.bas.repository;

import com.gemframework.bas.model.po.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title: DemoRepository.java * @Package: com.gemframework.bas.repository * @Date: 2019-11-29 23:09:36 * @Version: v1.0 * @Description: 这里写描述 * @Author: zhangys * @Copyright: Copyright (c) 2019 GemStudio * @Company: www.gemframework.com
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {
}
