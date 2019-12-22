package com.gemframework.cms.common.security.handler;

import com.gemframework.cms.common.security.config.GemAuthPageProperties;
import com.gemframework.cms.model.vo.ztree.MenuSide;
import com.gemframework.cms.model.vo.MenuVo;
import com.gemframework.cms.model.vo.RoleVo;
import com.gemframework.cms.service.MenuService;
import com.gemframework.cms.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.gemframework.bas.common.constant.GemConstant.Auth.ROLE_PREFIX;

@Slf4j
@Component("gemLoginSuccessHandler")
public class GemLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private GemAuthPageProperties gemAuthPageProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        log.info("登录成功");
        //TODO:这里写登录成功后的逻辑
        //页面跳转到首页
        //api请求的话返回token

        //页面：登录成功后加载权限菜单
        //判断用户角色
        //根据角色查询菜单信息
        List<RoleVo> roles = new ArrayList<>();
        Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
        for(GrantedAuthority grantedAuthority:collection){
            RoleVo vo = roleService.getByFlag(getRoleFlag(grantedAuthority.getAuthority()));
            if(vo != null){
                roles.add(vo);
            }
        }
        if(roles != null && roles.size() > 0){
            List<MenuVo> menus = menuService.findListByRoles(roles);
            if(menus!=null && menus.size()>0){
                List<MenuSide> menuSides = new ArrayList<>();
                for(MenuVo menuVo:menus){
                    MenuSide menuSide = MenuSide.builder()
                            .F_ModuleId(String.valueOf(menuVo.getId()))
                            .F_ParentId(String.valueOf(menuVo.getPid()))
                            .F_EnCode(menuVo.getTag())
                            .F_FullName(menuVo.getName())
                            .F_Icon(menuVo.getIcon())
                            .F_UrlAddress(menuVo.getLink()).build();
                    menuSides.add(menuSide);
                }
                request.getSession().setAttribute("session_sidebar_menus", menuSides);
            }
        }
        request.getSession().setAttribute("session_username",getCurrentUsername());
        //如果没有登录，跳转登录
        getRedirectStrategy().sendRedirect(request, response, gemAuthPageProperties.getIndexPage());
    }


    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private String getRoleFlag(String fullFalg){
        return fullFalg.replaceAll(ROLE_PREFIX,"");
    }
}
