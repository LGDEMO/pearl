 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 ***
#### AccessDecisionManager 权限校验
#### FilterInvocationSecurityMetadataSource 权限配置数据库加载
#### AbstractSecurityInterceptor  Spring security 核心抽象接口
#### AuthenticationManager  自定义用户角色数据
#### WebSecurityConfigurerAdapter Spring security核心配置

1. 从HttpServletRequest中获取SecurityContextImpl对象
    SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute(SESSION_USERKEY);
2. 从SecurityContextImpl中获取Authentication对象
    Authentication authentication = securityContextImpl.getAuthentication();
3. 初始化UsernamePasswordAuthenticationToken实例 ，这里的参数user就是我们要更新的用户信息
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials());
    auth.setDetails(authentication.getDetails());
4. 重新设置SecurityContextImpl对象的Authentication
    securityContextImpl.setAuthentication(auth);

#### 参考文献
https://blog.csdn.net/zysh888/article/details/105114874
