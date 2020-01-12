package com.gemframework.cms.common.security.handler;

import com.alibaba.fastjson.JSONArray;
import com.gemframework.bas.common.constant.GemConstant;
import com.gemframework.cms.common.enums.MenuType;
import com.gemframework.cms.common.security.config.GemSecurityProperties;
import com.gemframework.cms.common.security.scheme.GemMetadataSourceService;
import com.gemframework.cms.model.vo.tree.MenuSide;
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

import javax.annotation.Resource;
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
    private GemSecurityProperties gemSecurityProperties;

    @Autowired
    GemMetadataSourceService gemMetadataSourceService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType(GemConstant.MediaType.JSON_UTF_8);
        log.info("登录成功");
        //重新设置用户权限
        gemMetadataSourceService.loadResourceDefine();

        //TODO:这里写登录成功后的逻辑
        //页面跳转到首页
        //api请求的话返回token

        //页面：登录成功后加载权限菜单
        //判断用户角色
        //根据角色查询菜单信息
        List<RoleVo> roles = new ArrayList<>();
        Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
        boolean isSuperAdmin = false;
        for(GrantedAuthority grantedAuthority:collection){
            String roleFlag = getRoleFlag(grantedAuthority.getAuthority());
            if(roleFlag.contains("admin")){
                isSuperAdmin = true;
            }
            RoleVo vo = roleService.getByFlag(roleFlag);
            if(vo != null){
                roles.add(vo);
            }
        }
        if(roles != null && roles.size() > 0){
            List<MenuVo> menus = menuService.findListByRoles(roles);
            List<MenuSide> menuSides = new ArrayList<>();
            //如果权限验证关闭 或者 是超级管理员
            if(!gemSecurityProperties.isOpen()){
                String menusData_def = "[\n" +
                        "                {\n" +
                        "                        \"f_ModuleId\": \"111\",\n" +
                        "                        \"f_ParentId\": \"0\",\n" +
                        "                        \"f_EnCode\": \"SysManage\",\n" +
                        "                        \"f_FullName\": \"系统默认\",\n" +
                        "                        \"f_Icon\": \"fa fa-desktop\",\n" +
                        "                        \"f_UrlAddress\": \"/default\",\n" +
                        "                },\n" +
                        "                {\n" +
                        "                        \"f_ModuleId\": \"21\",\n" +
                        "                        \"f_ParentId\": \"111\",\n" +
                        "                        \"f_EnCode\": \"MenuManage\",\n" +
                        "                        \"f_FullName\": \"菜单管理\",\n" +
                        "                        \"f_Icon\": \"fa fa-sitemap\",\n" +
                        "                        \"f_UrlAddress\": \"menu/list.html\",\n" +
                        "                } ]";
                List<MenuSide> defMenuSides = (List<MenuSide>) JSONArray.parseArray(menusData_def, MenuSide.class);
                menuSides.addAll(defMenuSides);
                //查询所有菜单
                menus = menuService.findListAllByType(MenuType.MENU);
            }

            if(isSuperAdmin){
                //查询所有菜单
                menus = menuService.findListAllByType(MenuType.MENU);
            }

            if(menus!=null && menus.size()>0){
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
        getRedirectStrategy().sendRedirect(request, response, gemSecurityProperties.getIndexPage());
    }


    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private String getRoleFlag(String fullFalg){
        return fullFalg.replaceAll(ROLE_PREFIX,"");
    }
}
