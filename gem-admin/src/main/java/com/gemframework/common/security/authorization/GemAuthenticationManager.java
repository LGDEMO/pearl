/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.security.authorization;

import com.gemframework.model.vo.RoleVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 自定义角色数据
 * @Package: com.gemframework.common.security.scheme
 * @Date: 2019/12/11 15:24
 * @Version: v1.0
 * @Description: 自定义角色数据
 * @Author: zhangysh
 * @Copyright: Copyright (c) 2019 GemStudio
 * @Company: www.gemframework.com
 */
@Data
@Slf4j
@Component
public class GemAuthenticationManager implements AuthenticationManager {

    List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    private String prd = "ROLE_";

    private List<RoleVo> roles;


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        log.info("authenticate");
        if (auth.getName().equals(auth.getCredentials())) {
            for (RoleVo role : roles) {
                //增加用户角色
                AUTHORITIES.add(new SimpleGrantedAuthority(prd + role.getRolename()));
            }
            return new UsernamePasswordAuthenticationToken(auth.getName(),
                    auth.getCredentials(), AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }



}
