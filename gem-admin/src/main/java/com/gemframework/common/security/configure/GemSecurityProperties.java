/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除gemframe官方保留所有法律责任追究！
 * 本软件受国家版权局知识产权以及国家计算机软件著作权保护（登记号：2018SR503328）
 * 不得恶意分享产品源代码、二次转售等，违者必究。
 * Copyright (c) 2020 gemframework all rights reserved.
 * http://www.gemframework.com
 * 版权所有，侵权必究！
 */
package com.gemframework.common.security.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("gem.security")
public class GemSecurityProperties {

	//开关
	private boolean open;

	//首页路径
	private String indexPage;

	//登录页路径
	private String loginPage;

	//错误页面路径
	private String errorPage;

	//拒绝访问路径
	private String deniedPage;

	//找不到路径
	private String nofoundPage;
}
