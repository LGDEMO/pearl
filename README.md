# gem

#### 介绍
Gem项目是一款国产的，优秀的基于SpringBoot2.2集成框架。

#### 软件架构
![Gem架构图](https://images.gitee.com/uploads/images/2019/1215/223822_6d41d924_1388237.png "屏幕截图.png")

#### 代码结构

gem
 |——gem-bas 项目基础包
 |——gem-cms Web管理后台（含，权限管理，内容管理等）

#### 项目特点
- 基于最新的SpringCloud、Spring Boot生态技术，高度整合封装稳定、高效、安全的微服务解决方案
- 采用主流的BootStrap4响应式前端模版框架，上手简单、美观大气、交互体验更完美
-- [BootStrap中文网](https://www.bootcss.com)
- 多数据源驱动支持，可接入MySQL、Oracle、SQL Server等主流数据库
- Maven多项目依赖，模块及插件分项目，尽量松耦合，方便模块升级、增减模块。
- 集成Swagger模块，自定义注解使用代码侵入性极低，测试Api更简单
- 持久层实体类采用@Table注解配置，集成JAP模块正向生成表结构
- 完善的安全体系，身份认证、密码策略、安全审计、日志收集
- 代码风格优雅简洁、通俗易懂，符合《阿里巴巴JAVA开发手册》规范要求，可作为企业代码规范

#### 技术选型
##### 前端集成

- Bootstrap v4
- jQuery v2.1.4

##### 后端集成
- SpringBoot 2.2.1.RELEASE
- Redis 3.3.1
- Druid 1.1.8
- Lombok
- Swagger

#### 演示地址

- 暂无

#### 系统截图

- 开发中...

#### 内置功能

- 资源管理：系统中的菜单，按钮，列表字段，查询条件等元素统称为资源。
- 角色管理：角色进行精细化资源授权，实现菜单，按钮，列表以及数据控制。
- 账户管理：登录系统的帐号称作“账户”，账户可以选择一个或多个角色。
- 人员管理：公司人员，通常指使用账户登录系统的人，人员可以与账户绑定。
- 部门管理：部门也可以称为“组织”，是将人员进行组织划分的模块。
- 字典管理：系统字典管理，常量管理。
- 日志管理：系统业务操作日志，API调用日志，用户登录日志等。
- 监控管理：系统链路监控，服务TPS，QPS监控，SQL监控等。
- 代码生成：使用GemFrame的专属代码生成器，减少80%重复工作量。

#### 功能特点

- 强大的角色能力，菜单级，按钮级，表单级，数据级进行精细化权限控制
- 丰富的报表形式，通过快速配置，实现曲线图，柱状图，饼状图等数据报表
- 支持多种文件格式处理能力，实现上传，下载，播放加载，导入导出等功能
- 灵活的日志管理，含登录日志、操作日志、异常日志，主便审计及BUG定位

#### 安装教程

- 通过git下载源码
- 创建数据库gemframedb，数据库编码为UTF-8
- 修改application.properties/application.yml文件，更新MySQL账号和密码
- 运行gem-work-jpa即可生成数据库表结构
- 执行db/gemframe-init.sql文件，初始化表数据
- 在gemframe目录下，执行mvn clean install
- Eclipse、IDEA打开项目
- 运行gem-cms中的EurekaServerApplication.java
- gem-cms访问地址：http://localhost:xxxx/gem/login
- 账号密码：admin/123456
- swagger接口测试：http://localhost:[业务端口]/swagger-ui.html

#### 使用说明

- 暂无

#### 问题反馈

1.  开发文档：暂无
2.  项目文档：暂无
3.  官方社区：https://www.gemframework.com/bbs
4.  gitee仓库：https://gitee.com/zzimo/gem
5.  github仓库：暂无
6.  官方网站：http://www.gemframework.com
7.  官方QQ群：72940788、446017307
8.  如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持 技术讨论、二次开发等咨询、问题和建议，请移步到官方社区，我会在第一时间进行解答和回复！