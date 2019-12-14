package com.gemframework.cms.common.security.scheme;

import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.cms.model.po.Menu;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Title: 权限配置数据库加载
 * @Package: com.gemframework.cms.common.security.scheme
 * @Date: 2019/12/11 15:30
 * @Version: v1.0
 * @Description: 权限配置数据库加载

 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Slf4j
@Component
public class GemMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Resource
    private RoleService roleService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * @Title: 加载权限表中所有权限
     * @Retrun: void
     * @Description:
     * @Date: 2019/12/8 22:22
     */
    public void loadResourceDefine() {
        map = new HashMap<>();
        ConfigAttribute cfg;
        List<RoleVo> roles = roleService.findListAll();
        for (RoleVo role : roles) {
            cfg = new SecurityConfig(GemConstant.Auth.ROLE_PREFIX + role.getFlag());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，
            // 例如请求方法到ConfigAttribute的集合中去。
            // 此处添加的信息将会作为GemAccessDecisionManager类的decide的第三个参数。
            //用权限的getLink() 作为map的key，用ConfigAttribute的集合作为 value，
            log.info("设置用户角色==========={}",role.toString());
            List<MenuVo> menus = role.getMenus();
            for (MenuVo menu : menus) {
                log.info("设置用户URL==========="+menu.toString()+":"+cfg);
                setMap(menu.getLink(), cfg);
            }
        }
    }

    /**
     * 增加权限队列
     * @param url
     * @param cfg
     */
    private void setMap(String url, ConfigAttribute cfg) {
        Collection<ConfigAttribute> array = map.get(url);
        if (CollectionUtils.isEmpty(array)) {
            array = new ArrayList<>(6);
        }
        array.add(cfg);
        map.put(url, array);
    }

    /**
     * @Title: 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，
     * 则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     * @Param: [object]
     * @Retrun: java.util.Collection<org.springframework.security.access.ConfigAttribute>
     * @Description:
     * @Date: 2019/12/11 15:32
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
