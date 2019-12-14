package com.gemframework.cms.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("gem.auth")
public class GemAuthPageProperties {

	private String indexPage;

	private String loginPage;

	private String errorPage;

	private String deniedPage;

	private String nofoundPage;
}
