package com.gemframework.cms.common.security.scheme;

import com.gemframework.cms.model.vo.RoleVo;
import lombok.Data;
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

@Data
@Component
public class GemAuthenticationManager implements AuthenticationManager {

    List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    private String prd = "ROLE_";

    private List<RoleVo> roles;


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
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
