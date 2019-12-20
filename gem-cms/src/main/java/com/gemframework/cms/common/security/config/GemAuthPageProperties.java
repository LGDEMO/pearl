package com.gemframework.cms.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("gem.auth")
public class GemAuthPageProperties{

	//首页路径
	private String indexPage = "/index";;

	//登录页路径
	private String loginPage = "/login";;

	//错误页面路径
	private String errorPage = "/error";;

	//拒绝访问路径
	private String deniedPage = "/403";;

	//找不到路径
	private String nofoundPage = "/404";;
}
