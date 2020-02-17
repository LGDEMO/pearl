/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : gem

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2020-02-17 19:56:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gem_dept
-- ----------------------------
DROP TABLE IF EXISTS `gem_dept`;
CREATE TABLE `gem_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `abbr` varchar(20) DEFAULT NULL COMMENT '简称',
  `boss` varchar(10) DEFAULT NULL COMMENT '负责人',
  `desp` varchar(300) DEFAULT NULL COMMENT '描述',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `id_path` varchar(20) DEFAULT NULL COMMENT 'ID路径',
  `level` tinyint(1) DEFAULT NULL COMMENT '级别',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `num` varchar(20) DEFAULT NULL COMMENT '部门编号',
  `pid` int(20) DEFAULT NULL COMMENT '父ID',
  `series` varchar(20) DEFAULT NULL COMMENT '所属系列',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_dept
-- ----------------------------
INSERT INTO `gem_dept` VALUES ('1', 'BJ', '张三', '北京分公司有限公司，位于中国缝制设备制造之都-，自1999年创建以来，经过二十年不懈的努力发展，公司在缝制行业树立起自己的形象和品牌。今天的中工缝制设备制造，已经涵盖了自动化缝制设备 特种机缝制设备。', 'fwg.bj@wanyong.com', '01', '1', '北京分公司', '010', '0', '01', '010-66889988', '二级单位', null, '2020-02-17 19:47:32');
INSERT INTO `gem_dept` VALUES ('2', '', '', '', '', '02', '1', '广东分公司', '', '0', '02', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('3', '', '', '', '', '02-03', '2', '深圳分公司', '', '2', '02', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('4', '', '', '', '', '02-04', '2', '广州分公司', '', '2', '02', '', '', null, '2020-02-17 19:47:22');
INSERT INTO `gem_dept` VALUES ('5', '海淀', '李四', '海淀办事处', 'wanyongedu@163.com', '01-05', '2', '海淀办事处', '01001', '1', '01', '010-66889988', '内部', null, null);
INSERT INTO `gem_dept` VALUES ('6', '', '', '', '', '06', '1', '上海分公司', '', '0', '06', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('7', '', '1212', '', '', '07', '1', '河北分公司', '1212', '0', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('8', '', '', '', '', '08', '1', '天津分公司', '', '0', '08', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('10', '', '', '', '', '10', '1', '重庆分公司', '', '0', '10', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('11', '', '', '', '', '06-11', '2', '浦东分公司', '', '6', '06', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('12', 'SHFGSI', '张松', '', 'shanghai@qq.com', '06-12', '2', '松江分公司', '1001', '6', '06', '022-80898213', '自营', null, null);
INSERT INTO `gem_dept` VALUES ('13', '', '', '', '', '07-13', '2', '邯郸分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('14', '', '', '', '', '07-14', '2', '石家庄分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('15', '', '', '', '', '08-15', '2', '静海分公司', '', '8', '08', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('16', '', '', '', '', '07-16', '2', '保定分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('17', '', '', '', '', '10-17', '2', '重庆', '', '10', '10', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('18', '', '', '', '', '01-18', '2', '添加子节点', '', '1', '01', '', '', '2020-02-17 19:47:42', '2020-02-17 19:47:42');

-- ----------------------------
-- Table structure for gem_menu
-- ----------------------------
DROP TABLE IF EXISTS `gem_menu`;
CREATE TABLE `gem_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL COMMENT '是否选中 0 未选中 1 选中',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  `id_path` varchar(20) DEFAULT NULL COMMENT 'ID路径',
  `level` tinyint(1) DEFAULT NULL COMMENT '级别，最大支持三级',
  `link` varchar(50) DEFAULT NULL COMMENT '菜单/按钮链接',
  `name` varchar(10) DEFAULT NULL COMMENT '菜单/按钮名称',
  `pid` bigint(20) DEFAULT '0' COMMENT '父级ID',
  `series` varchar(20) DEFAULT NULL COMMENT '所属系列',
  `sort_number` int(10) DEFAULT NULL COMMENT '排序编号',
  `tag` varchar(30) DEFAULT NULL COMMENT '菜单/按钮标签',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型 0菜单 1按钮 2其他',
  `sort_path` varchar(150) DEFAULT NULL COMMENT '排序编号路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_menu
-- ----------------------------
INSERT INTO `gem_menu` VALUES ('2', null, 'fab fa-angular', '02', '1', '#', '权限管理', '0', '02', '8', 'menu_sys', '0', '08-02', null, '2020-02-17 19:51:24');
INSERT INTO `gem_menu` VALUES ('3', null, 'fas fa-user-circle', '02-03', '2', 'user/list.html', '用户管理', '2', '02', '5', 'menu_user', '0', '08-02-05-02-03', null, null);
INSERT INTO `gem_menu` VALUES ('4', null, 'fas fa-sitemap', '02-04', '2', 'dept/list.html', '部门管理', '2', '02', '4', 'menu_dept', '0', '08-02-04-02-04', null, null);
INSERT INTO `gem_menu` VALUES ('5', null, 'fas fa-rocket', '02-05', '2', 'role/list.html', '角色管理', '2', '02', '2', 'menu_role', '0', '08-02-02-02-05', null, null);
INSERT INTO `gem_menu` VALUES ('6', null, 'fab fa-adn', '02-06', '2', 'menu/list.html', '菜单管理', '2', '02', '1', 'menu_menu', '0', '08-02-01-02-06', null, '2020-02-17 19:51:37');
INSERT INTO `gem_menu` VALUES ('7', null, 'fas fa-box', '07', '1', '#', '外部网站', '0', '07', '998', 'menu_website', '0', '998-07', null, null);
INSERT INTO `gem_menu` VALUES ('8', null, 'fab fa-angular', '07-08', '2', 'http://www.baidu.com', '百度一下', '7', '07', '4', 'menu_api', '0', '998-07-04-07-08', null, null);
INSERT INTO `gem_menu` VALUES ('9', null, 'fab fa-apple', '07-09', '2', 'http://www.gemframework.com/shouquan.html', '商业授权', '7', '07', '3', 'menu_app', '0', '998-07-03-07-09', null, null);
INSERT INTO `gem_menu` VALUES ('10', null, 'fab fa-amilia', '10', '1', '#', '一级菜单', '0', '10', '999', 'menu_1', '0', '999-10', null, null);
INSERT INTO `gem_menu` VALUES ('11', null, 'fab fa-amazon', '10-11', '2', '123', '二级菜单', '10', '10', '99', 'menu_2', '0', '999-10-99-10-11', null, null);
INSERT INTO `gem_menu` VALUES ('12', null, 'fas fa-angle-double-right', '10-11-12', '3', 'HTTP://JSON.CN', '三级菜单', '11', '10', '99', 'menu_json', '0', '999-10-99-10-11-99-10-11-12', null, null);
INSERT INTO `gem_menu` VALUES ('14', null, '', '02-06-14', '3', 'menu/delete', '删除按钮', '6', '02', '3', 'btn_menu_del', '1', '08-02-01-02-06-03-02-06-14', null, null);
INSERT INTO `gem_menu` VALUES ('15', null, '', '02-05-15', '3', 'role/pageByParams', '分页查询', '5', '02', '1', 'fun_role_page', '2', '08-02-02-02-05-01-02-05-15', null, null);
INSERT INTO `gem_menu` VALUES ('16', null, '', '02-04-16', '3', 'findAllDeptTree', '左侧菜单树', '4', '02', '99', 'fun_dept_tree', '2', '08-02-04-02-04-99-02-04-16', null, null);
INSERT INTO `gem_menu` VALUES ('17', null, '', '02-03-17', '3', 'user/pageByParams', '分页查询', '3', '02', '1', 'fun_user_page', '2', '08-02-05-02-03-01-02-03-17', null, null);
INSERT INTO `gem_menu` VALUES ('18', null, '', '02-05-18', '3', 'role/add', '添加/编辑', '5', '02', '99', 'fun_role_add', '2', '08-02-02-02-05-99-02-05-18', null, null);
INSERT INTO `gem_menu` VALUES ('19', null, '', '02-04-19', '3', 'dept/getOne', '查询单个部门', '4', '02', '99', 'fun_dept_get', '2', '08-02-04-02-04-99-02-04-19', null, null);
INSERT INTO `gem_menu` VALUES ('20', null, '', '02-04-20', '3', 'dept/add', '添加/编辑', '4', '02', '99', 'fun_dept_add', '2', '08-02-04-02-04-99-02-04-20', null, null);
INSERT INTO `gem_menu` VALUES ('21', null, '', '02-06-21', '3', 'menu/add', '添加/编辑', '6', '02', '1', 'fun_menu_add', '2', '08-02-01-02-06-01-02-06-21', null, null);
INSERT INTO `gem_menu` VALUES ('23', null, '', '02-05-23', '3', 'role/list', '下拉框角色列表', '5', '02', '991', 'fun_role_list', '2', '08-02-02-02-05-991-02-05-23', null, null);
INSERT INTO `gem_menu` VALUES ('24', null, '', '02-03-24', '3', 'user/add', '添加/编辑', '3', '02', '99', 'fun_user_add', '2', '08-02-05-02-03-99-02-03-24', null, null);
INSERT INTO `gem_menu` VALUES ('25', null, '', '02-06-25', '3', 'menu/add.html', '添加按钮', '6', '02', '99', 'btn_menu_add', '1', '08-02-01-02-06-99-02-06-25', null, null);
INSERT INTO `gem_menu` VALUES ('26', null, '', '02-06-26', '3', 'menu/edit.html', '编辑按钮', '6', '02', '99', 'btn_menu_edit', '1', '08-02-01-02-06-99-02-06-26', null, null);
INSERT INTO `gem_menu` VALUES ('27', null, '', '02-05-27', '3', 'role/add.html', '添加按钮', '5', '02', '99', 'btn_role_add', '1', '08-02-02-02-05-99-02-05-27', null, null);
INSERT INTO `gem_menu` VALUES ('28', null, '', '02-05-28', '3', 'role/edit.html', '编辑按钮', '5', '02', '99', 'btn_role_edit', '1', '08-02-02-02-05-99-02-05-28', null, null);
INSERT INTO `gem_menu` VALUES ('29', null, '', '02-05-29', '3', 'role/delete', '删除按钮', '5', '02', '99', 'btn_role_del', '1', '08-02-02-02-05-99-02-05-29', null, null);
INSERT INTO `gem_menu` VALUES ('30', null, '', '02-03-30', '3', 'user/add.html', '添加按钮', '3', '02', '99', 'btn_user_add', '1', '08-02-05-02-03-99-02-03-30', null, null);
INSERT INTO `gem_menu` VALUES ('31', null, '', '02-03-31', '3', 'user/edit.html', '编辑按钮', '3', '02', '99', 'btn_user_edit', '1', '08-02-05-02-03-99-02-03-31', null, null);
INSERT INTO `gem_menu` VALUES ('32', null, 'fas fa-globe', '32', '1', '#', '源码下载', '0', '32', '997', 'menu_src', '0', '997-32', null, null);
INSERT INTO `gem_menu` VALUES ('33', null, 'fab fa-github', '32-33', '2', 'https://gitee.com/gemteam/gemframe', '码云地址', '32', '32', '2', 'menu_gitee', '0', '997-32-02-32-33', null, null);
INSERT INTO `gem_menu` VALUES ('34', null, 'fab fa-windows', '32-34', '2', 'http://www.gemframework.com', 'GemFrame官网', '32', '32', '3', 'menu_gem', '0', '997-32-03-32-34', null, null);
INSERT INTO `gem_menu` VALUES ('35', null, 'fas fa-basketball-ball', '32-35', '2', 'http://www.gemframework.com/bbs', '官方社区', '32', '32', '1', 'menu_bbs', '0', '997-32-01-32-35', null, null);
INSERT INTO `gem_menu` VALUES ('36', null, 'fas fa-cog', '36', '1', '112', '系统监控', '0', '36', '99', 'menu_monitor', '0', '99-36', null, null);
INSERT INTO `gem_menu` VALUES ('37', null, 'fas fa-database', '36-37', '2', 'druid', 'MySQL监控', '36', '36', '99', 'menu_druid', '0', '99-36-99-36-37', null, null);
INSERT INTO `gem_menu` VALUES ('38', null, 'fas fa-video', '38', '1', '#', '示例演示', '0', '38', '99', 'menu_demo', '0', '99-38', null, null);
INSERT INTO `gem_menu` VALUES ('39', null, 'fab fa-first-order', '38-39', '2', 'demo/pages/redis', 'Redis示例', '38', '38', '99', 'menu_redis', '0', '99-38-99-38-39', null, null);
INSERT INTO `gem_menu` VALUES ('40', null, 'fas fa-lightbulb', '36-40', '2', 'swagger-ui.html', '接口调试', '36', '36', '99', 'menu_swagger', '0', '99-36-99-36-40', null, null);
INSERT INTO `gem_menu` VALUES ('41', null, '', '02-41', '2', 'orderInfo', '首页订单信息', '2', '02', '99', 'fun_index_order', '2', '08-02-99-02-41', null, null);
INSERT INTO `gem_menu` VALUES ('45', null, 'fas fa-code', '45', '1', 'generate/code/list.html', '代码生成', '0', '45', '99', 'menu_code', '0', '99-45', null, null);
INSERT INTO `gem_menu` VALUES ('46', null, '', '45-46', '2', 'generate/code/pageByParams', '分页查询', '45', '45', '99', 'fun_code_page', '2', '99-45-99-45-46', null, null);
INSERT INTO `gem_menu` VALUES ('47', null, '', '45-47', '2', 'generate/code/add.html', '添加按钮', '45', '45', '99', 'btn_code_add', '1', '99-45-99-45-47', null, null);
INSERT INTO `gem_menu` VALUES ('48', null, '', '45-48', '2', 'generate/code/edit.html', '编辑按钮', '45', '45', '99', 'btn_code_edit', '1', '99-45-99-45-48', null, null);
INSERT INTO `gem_menu` VALUES ('49', null, '', '45-49', '2', 'generate/code/delete', '删除按钮', '45', '45', '99', 'btn_code_del', '1', '99-45-99-45-49', null, null);
INSERT INTO `gem_menu` VALUES ('50', null, '', '45-50', '2', 'generate/code/add', '添加/编辑', '45', '45', '99', 'fun_code_add', '1', '99-45-99-45-50', null, null);
INSERT INTO `gem_menu` VALUES ('51', null, 'fab fa-modx', '45-51', '2', 'module/list.html', '模块管理', '45', '45', '99', 'menu_module', '0', '99-45-99-45-51', null, null);
INSERT INTO `gem_menu` VALUES ('52', null, '', '45-51-52', '3', 'module/pageByParams', '分页查询', '51', '45', '99', 'fun_module_page', '1', '99-45-99-45-51-99-45-51-52', null, null);
INSERT INTO `gem_menu` VALUES ('53', null, '', '45-51-53', '3', 'module/add.html', '添加按钮', '51', '45', '99', 'btn_module_add', '1', '99-45-99-45-51-99-45-51-53', null, null);
INSERT INTO `gem_menu` VALUES ('54', null, '', '45-51-54', '3', 'module/edit.html', '编辑按钮', '51', '45', '99', 'btn_module_edit', '1', '99-45-99-45-51-99-45-51-54', null, null);
INSERT INTO `gem_menu` VALUES ('55', null, '', '45-51-55', '3', 'module/delete', '删除按钮', '51', '45', '99', 'btn_module_del', '1', '99-45-99-45-51-99-45-51-55', null, null);
INSERT INTO `gem_menu` VALUES ('56', null, '', '45-51-56', '3', 'module/add', '添加/编辑', '51', '45', '99', 'fun_module_add', '1', '99-45-99-45-51-99-45-51-56', null, null);
INSERT INTO `gem_menu` VALUES ('57', null, 'fas fa-certificate', '45-57', '2', 'moduleAttr/list.html', '属性管理', '45', '45', '99', 'menu_module_attr', '0', '99-45-99-45-57', null, null);
INSERT INTO `gem_menu` VALUES ('58', null, '', '45-57-58', '3', 'moduleAttr/pageByParams', '分页查询', '57', '45', '99', 'fun_moduleAttr_page', '1', '99-45-99-45-57-99-45-57-58', null, null);
INSERT INTO `gem_menu` VALUES ('59', null, '', '45-57-59', '3', 'moduleAttr/add.html', '添加按钮', '57', '45', '99', 'btn_moduleAttr_add', '1', '99-45-99-45-57-99-45-57-59', null, null);
INSERT INTO `gem_menu` VALUES ('60', null, '', '45-57-60', '3', 'moduleAttr/edit.html', '编辑按钮', '57', '45', '99', 'btn_moduleAttr_edit', '1', '99-45-99-45-57-99-45-57-60', null, null);
INSERT INTO `gem_menu` VALUES ('61', null, '', '45-57-61', '3', 'moduleAttr/add', '添加/编辑', '57', '45', '99', 'fun_moduleAttr_add', '1', '99-45-99-45-57-99-45-57-61', null, null);
INSERT INTO `gem_menu` VALUES ('62', null, '', '45-57-62', '3', 'moduleAttr/delete', '删除按钮', '57', '45', '99', 'btn_moduleAttr_delete', '1', '99-45-99-45-57-99-45-57-62', null, null);
INSERT INTO `gem_menu` VALUES ('63', null, '', '45-57-63', '3', 'module/list', '获取模块列表', '57', '45', '99', 'fun_module_list', '1', '99-45-99-45-57-99-45-57-63', null, null);
INSERT INTO `gem_menu` VALUES ('64', null, '', '45-51-64', '3', 'module/generateCode', '生成代码按钮', '51', '45', '99', 'btn_code_generate', '1', '99-45-99-45-51-99-45-51-64', null, null);
INSERT INTO `gem_menu` VALUES ('65', null, '', '45-51-65', '3', 'module/downloadCode', '代码下载', '51', '45', '99', 'btn_module_download', '1', '99-45-99-45-51-99-45-51-65', null, null);
INSERT INTO `gem_menu` VALUES ('66', null, '', '45-51-66', '3', 'module/deleteBatch', '批量删除', '51', '45', '99', 'plsc', '1', '99-45-99-45-51-99-45-51-66', null, null);
INSERT INTO `gem_menu` VALUES ('67', null, '', '45-57-67', '3', 'moduleAttr/deleteBatch', '批量删除', '57', '45', '99', 'plsc1', '1', '99-45-99-45-57-99-45-57-67', null, null);
INSERT INTO `gem_menu` VALUES ('68', null, 'fas fa-exclamation-circle', '68', '1', 'errorpages', '错误页面', '0', '68', '99', 'errorpages', '0', '99-68', null, null);
INSERT INTO `gem_menu` VALUES ('69', null, 'far fa-flag', '68-69', '2', '404', '404', '68', '68', '99', '404', '0', '99-68-99-68-69', null, null);
INSERT INTO `gem_menu` VALUES ('70', null, 'fas fa-flag-checkered', '68-70', '2', '403', '403', '68', '68', '99', '403', '0', '99-68-99-68-70', null, null);
INSERT INTO `gem_menu` VALUES ('71', null, 'fas fa-th-large', '36-71', '2', 'sysLog/list.html', '系统日志', '36', '36', '99', 'log', '0', '99-36-99-36-71', null, null);
INSERT INTO `gem_menu` VALUES ('73', null, '', '36-71-73', '3', 'sysLog/pageByParams', '分页查询日志', '71', '36', '99', 'logpage', '1', '99-36-99-36-71-99-36-71-73', null, null);
INSERT INTO `gem_menu` VALUES ('74', null, '', '36-71-74', '3', 'sysLog/deleteBatch', '清空日志', '71', '36', '99', 'deleteBatch', '1', '99-36-99-36-71-99-36-71-74', null, null);
INSERT INTO `gem_menu` VALUES ('75', null, '', '02-06-75', '3', 'menu/addChild.html', '添加子节点', '6', '02', '99', 'addChild', '1', '08-02-01-02-06-99-02-06-75', null, null);
INSERT INTO `gem_menu` VALUES ('79', null, '', '02-03-79', '3', 'user/resetPassword', '重置密码', '3', '02', '99', 'user/resetPasswor', '1', '08-02-05-02-03-99-02-03-79', null, null);
INSERT INTO `gem_menu` VALUES ('81', null, '', '02-06-81', '3', 'common/resetSideMenus', '同步侧菜单信息', '6', '02', '99', 'resetSideMenus', '1', '08-02-01-02-06-99-02-06-81', null, null);
INSERT INTO `gem_menu` VALUES ('82', null, 'fas fa-file-alt', '38-82', '2', 'demo/pages/pageStyle', '页面风格', '38', '38', '99', 'pagestyle', '0', '99-38-99-38-82', null, null);

-- ----------------------------
-- Table structure for gem_module
-- ----------------------------
DROP TABLE IF EXISTS `gem_module`;
CREATE TABLE `gem_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(10) DEFAULT NULL COMMENT '作者签名',
  `is_add` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否具备添加功能 1：是 0：否',
  `is_del` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否具备删除功能 1：是 0：否',
  `is_edit` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否具备编辑功能 1：是 0：否',
  `is_query` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否具备查询功能 1：是 0：否',
  `name_cn` varchar(60) NOT NULL COMMENT '模块中文名称',
  `name_en` varchar(30) NOT NULL COMMENT '模块英文名称',
  `package_name` varchar(30) NOT NULL COMMENT '包名',
  `page_height` int(10) DEFAULT '450' COMMENT '编辑页面高度',
  `page_width` int(10) DEFAULT '550' COMMENT '编辑页面宽度',
  `pk_nane` varchar(60) NOT NULL COMMENT '主键名称',
  `is_generate` tinyint(1) DEFAULT '0' COMMENT '是否生成CODE, 1：是 0：否',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_module
-- ----------------------------
INSERT INTO `gem_module` VALUES ('2', 'zhangysh', '1', '1', '1', '1', '车辆管理', 'car', 'com.gemframework.cms', '450', '550', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('3', 'zhangysh', '1', '1', '1', '1', '测试', 'test', 'com.gemframework', '0', '550', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('4', 'gems', '1', '1', '1', '1', '苹果管理', 'apple', 'com.test', '500', '400', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('39', 'gemteam', '0', '1', '0', '1', '系统日志', 'sysLog', 'com.gemframework', '450', '550', 'name', '1', null, null);

-- ----------------------------
-- Table structure for gem_module_attr
-- ----------------------------
DROP TABLE IF EXISTS `gem_module_attr`;
CREATE TABLE `gem_module_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(30) NOT NULL COMMENT '字段名称',
  `attr_type` varchar(30) NOT NULL COMMENT '字段类型',
  `comment` varchar(30) NOT NULL COMMENT '字段描述',
  `edit_type` varchar(10) DEFAULT 'text' COMMENT '编辑类型',
  `is_null` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否为空 1允许为空 0不允许为空',
  `is_search` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否支持查询 1支持 0不支持',
  `is_sort` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否支持排序 1支持 0不支持',
  `is_visit` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见 1可见 0不可见',
  `max_length` int(10) NOT NULL COMMENT '字段最大长度',
  `min_length` int(10) NOT NULL COMMENT '字段最小长度',
  `module_id` bigint(20) DEFAULT NULL,
  `options` varchar(300) DEFAULT NULL COMMENT '下拉框内容',
  `attr_sort` int(2) NOT NULL COMMENT '字段顺序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_module_attr
-- ----------------------------
INSERT INTO `gem_module_attr` VALUES ('37', 'name', 'text', '描述', null, '0', '1', '0', '0', '10', '20', '2', null, '2', null, null);
INSERT INTO `gem_module_attr` VALUES ('38', 'name1', 'text', '1212', null, '1', '0', '1', '1', '12', '212', '2', null, '2', null, null);
INSERT INTO `gem_module_attr` VALUES ('39', '12121', 'text', '1212', null, '1', '1', '0', '1', '212', '121', '2', null, '3', null, null);
INSERT INTO `gem_module_attr` VALUES ('42', 'client_ip', 'text', '日志名称', null, '1', '1', '1', '1', '20', '1', '39', null, '4', null, null);
INSERT INTO `gem_module_attr` VALUES ('43', 'type', 'text', '日志类型', null, '1', '1', '1', '1', '2', '1', '39', null, '5', null, null);
INSERT INTO `gem_module_attr` VALUES ('44', 'desp', 'text', '日志内容', null, '1', '1', '1', '1', '200', '0', '39', null, '6', null, null);
INSERT INTO `gem_module_attr` VALUES ('45', 'id', 'text', '自增ID', null, '0', '0', '0', '0', '20', '1', '39', null, '1', null, null);
INSERT INTO `gem_module_attr` VALUES ('46', 'account', 'text', '系统账号', null, '1', '1', '1', '1', '20', '0', '39', null, '3', null, null);
INSERT INTO `gem_module_attr` VALUES ('47', 'user_id', 'text', '用户ID', null, '1', '1', '1', '1', '20', '0', '39', null, '2', null, null);

-- ----------------------------
-- Table structure for gem_role
-- ----------------------------
DROP TABLE IF EXISTS `gem_role`;
CREATE TABLE `gem_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datarange` int(2) NOT NULL COMMENT '数据范围',
  `desp` varchar(100) NOT NULL COMMENT '描述',
  `flag` varchar(10) NOT NULL COMMENT '标识',
  `rolename` varchar(10) NOT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qt12q8vffue7qn0fgvb42kljf` (`flag`),
  UNIQUE KEY `UK_5ojc0xjc1im8mccxp9njmjvft` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_role
-- ----------------------------
INSERT INTO `gem_role` VALUES ('1', '3', '管理员', 'admin', '管理员', null, null);
INSERT INTO `gem_role` VALUES ('18', '3', '测试演示角色', 'test', '测试角色', null, '2020-02-17 19:52:50');

-- ----------------------------
-- Table structure for gem_role_depts
-- ----------------------------
DROP TABLE IF EXISTS `gem_role_depts`;
CREATE TABLE `gem_role_depts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_role_depts
-- ----------------------------
INSERT INTO `gem_role_depts` VALUES ('188', '1', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_depts` VALUES ('189', '5', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_depts` VALUES ('190', '18', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_depts` VALUES ('207', '1', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('208', '5', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('209', '2', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('210', '3', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('211', '4', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('212', '6', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('213', '11', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('214', '12', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('215', '7', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('216', '13', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('217', '14', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('218', '16', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('219', '8', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('220', '15', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('221', '10', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_depts` VALUES ('222', '17', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');

-- ----------------------------
-- Table structure for gem_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `gem_role_menus`;
CREATE TABLE `gem_role_menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=548 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_role_menus
-- ----------------------------
INSERT INTO `gem_role_menus` VALUES ('476', '2', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('477', '3', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('478', '17', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('479', '24', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('480', '45', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('481', '46', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('482', '47', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('483', '48', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('484', '49', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('485', '50', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('486', '51', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('487', '52', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('488', '53', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('489', '54', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('490', '55', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('491', '56', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('492', '64', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('493', '65', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('494', '66', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('495', '57', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('496', '58', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('497', '59', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('498', '60', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('499', '61', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('500', '62', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('501', '63', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('502', '67', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('503', '68', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('504', '69', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('505', '70', '18', '2020-02-17 19:52:50', '2020-02-17 19:52:50');
INSERT INTO `gem_role_menus` VALUES ('527', '2', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('528', '6', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('529', '21', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('530', '14', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('531', '5', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('532', '15', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('533', '18', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('534', '23', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('535', '4', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('536', '16', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('537', '19', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('538', '20', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('539', '3', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('540', '17', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('541', '24', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('542', '7', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('543', '9', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('544', '8', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('545', '10', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('546', '11', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');
INSERT INTO `gem_role_menus` VALUES ('547', '12', '1', '2020-02-17 19:53:54', '2020-02-17 19:53:54');

-- ----------------------------
-- Table structure for gem_user
-- ----------------------------
DROP TABLE IF EXISTS `gem_user`;
CREATE TABLE `gem_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(80) DEFAULT NULL COMMENT '地址',
  `area` int(5) DEFAULT NULL COMMENT '区县code',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `city` int(5) DEFAULT NULL COMMENT '城市code',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(150) NOT NULL COMMENT '密码',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `post` varchar(5) NOT NULL COMMENT '岗位',
  `province` int(5) DEFAULT NULL COMMENT '省份code',
  `qq` varchar(11) DEFAULT NULL COMMENT 'QQ',
  `realname` varchar(10) NOT NULL COMMENT '用户名',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) DEFAULT NULL COMMENT '座机号',
  `username` varchar(10) NOT NULL COMMENT '用户名',
  `worknum` int(5) NOT NULL COMMENT '工号',
  `desp` varchar(11) DEFAULT NULL COMMENT '其他备注',
  `dept_id` int(5) NOT NULL COMMENT '归属部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ioc195vl2wbh2o986iimitfp3` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_user
-- ----------------------------
INSERT INTO `gem_user` VALUES ('1', '内蒙古自治区呼和浩特市市辖区', '150101', '2020-01-10 00:00:00', '150100', '1558882222@qq.com', '$2a$10$oxp97zlAjJ/12kNxXo6sBuTv1iR6cdooL4ffE4rijpJLsA8D9w5Ve', '18500029041', '1', '150000', '', '管理员', '0', '', 'admin', '888', '', '11', null, null);
INSERT INTO `gem_user` VALUES ('7', '北京市市辖区顺义区北京庄园', '110113', null, '110100', '769990999@qq.com', '$2a$10$rMuB65K93Ch2QQ.mcklt..rROCWThLWRsLnbL2fv4xt2FjNAYLIHa', '13338880040', '1', '110000', '', '张先生', '1', '', 'zhangysh', '1001', '123', '5', null, null);
INSERT INTO `gem_user` VALUES ('8', '河北省秦皇岛市山海关区', '130303', '2020-01-31 00:00:00', '130300', '769922@qq.com', '$2a$10$g5HO4XFXVmvvqRRC10EkwOM0cewbXLzasjV4YQSjEFI8QA1sfPvO6', '13338880041', '1', '130000', '', '刘三', '0', '', 'zhaoxy', '1002', '', '8', null, null);
INSERT INTO `gem_user` VALUES ('9', '河北省唐山市路南区', '130202', null, '130200', 'wukong@qq.com', '', '13338880022', '3', '130000', '', '孙悟空', '1', '022-1233212', 'sunwuk', '1003', '', '4', null, null);
INSERT INTO `gem_user` VALUES ('10', '123456', '140303', '2019-12-28 00:00:00', '140300', '11233344444@33', '$2a$10$C7dt6zjXEmZKipEbgLaWEu9p6oYS1AahvVi1ZOxM1fzhDGudDaeQ2', '18500029040', '4', '140000', '', 'LISI', '0', '1', 'lisi', '1005', '21212', '4', null, null);
INSERT INTO `gem_user` VALUES ('12', '河北省秦皇岛市山海关区', '130303', '2019-01-01 00:00:00', '130300', 'zhubajie@qq.com', '', '18500029043', '1', '130000', 'zhubajie521', '猪八戒', '0', '', 'zhubajie', '1004', '天蓬元帅下凡', '4', null, null);
INSERT INTO `gem_user` VALUES ('13', '山西省阳泉市矿区', '140303', '2017-01-02 00:00:00', '140300', 'q4444@33', '$2a$10$2RHRFoltZ2KuqHkrWzCRGu.F7w70WC1JG8aQOxX59Cy4u0u1PkUV2', '13381022222', '3', '140000', '2bajie521', '121212', '0', '', 'lixs', '1006', '23423WWW', '4', null, null);
INSERT INTO `gem_user` VALUES ('14', '北京市市辖区东城区', '110101', '2020-12-31 00:00:00', '110100', 'jindong@163.com', '$2a$10$DgfwOcfsNYWSCaQMLObIs.3UpdYbjwVqr5z7/5nQ2Q1rn.vd79ReS', '18500038222', '4', '110000', '2', '靳东', '0', '1', 'jindong', '1009', '当红男演员', '5', null, null);
INSERT INTO `gem_user` VALUES ('18', '北京市市辖区东城区', '110101', '2020-12-31 00:00:00', '110100', 'ww@183.com', '$2a$10$1WyEWj//I6Q0Z0DP4OBNK.VgtzwuDrQgGgdQsZNYG4SsTgY0gAQp2', '18522299999', '1', '110000', '', '王宝强', '0', '', 'wangbao', '1010', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('19', '北京市县延庆县', '110229', null, '110200', '7699122@qq.com', '$2a$10$khKKTy/UvAAu09M8.AVnQOKokwgMZd20qLZLmcNgiZfKufotUV0AK', '13338320042', '1', '110000', '', '1111', '0', '', 'sunwuk1', '111', '', '4', null, null);
INSERT INTO `gem_user` VALUES ('20', '北京市市辖区朝阳区', '110105', '2020-01-01 00:00:00', '110100', 'gem@163.com', '$2a$10$znRrt4wtQVQ4qRshq05apO7SzjX04OAr8rCu1Ar4Qu05PdOjW2r2.', '18522299991', '1', '110000', '', 'gem宝石', '0', '', 'gem', '2001', '', '15', null, null);
INSERT INTO `gem_user` VALUES ('21', '天津市县宁河县', '120221', '2020-01-02 00:00:00', '120200', 'gem1@163.com', '$2a$10$WMzYbiWtTYLnuufpZ13Oz.6poiZ.Ovk2P9XrwkLvMMw1h8lVmC31C', '13338880141', '2', '120000', '', '苏西', '1', '', 'suxi', '2002', '', '11', null, null);
INSERT INTO `gem_user` VALUES ('22', '河北省石家庄市市辖区', '130101', '2020-01-01 00:00:00', '130100', 'ajiao@qq.com', '$2a$10$Uf4cuqGrGBnUclvgSsUBeOox.vFtfBkvXKYz2zPsn/7TeTwkJH3bW', '18429340234', '1', '130000', '', '阿娇', '1', '', 'ajiao', '2003', '', '2', null, null);
INSERT INTO `gem_user` VALUES ('23', '吉林省四平市铁西区', '220302', '2020-01-08 00:00:00', '220300', 'aiqim@163.com', '$2a$10$geGwqvAzYeI70fFlBPzhSe6IntHDuficNpbEIMO6PvyrRDxmkKXn2', '13338280040', '3', '220000', '', '爱奇', '1', '', 'aiqi', '2003', '', '7', null, null);
INSERT INTO `gem_user` VALUES ('24', '河北省邢台市临城县', '130522', '2020-01-26 00:00:00', '130500', 'ls@qq.com', '$2a$10$4VCCFN2laJK8AdmTFusbr.5YHyspDOT37N8alPCLDXU5m2ZGRLJXy', '18338880022', '1', '130000', '', '刘飒', '0', '', 'liusa', '2004', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('25', '山东省烟台市莱山区', '370613', null, '370600', 'niuize@qq.com', '$2a$10$/5a5yufxiJf66faZUF9ffuYyBVmVxZxQp4saIpAs76UySGQouBLmG', '15338880042', '1', '370000', '', '妞紫', '1', '', 'niuniu', '2005', '', '10', null, null);
INSERT INTO `gem_user` VALUES ('26', '河北省秦皇岛市昌黎县', null, null, null, 'sem@163.com', '$2a$10$/GzcBUpnKfei5EwJ1nZZx.RTyaG5YiK2A2RU1MDyZxpmLX/4JNv9i', '13338880010', '3', null, '', '史小菲', '1', '', 'shixiaof', '2008', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('27', '内蒙古自治区乌海市市辖区', '150301', '2020-01-24 00:00:00', '150300', 'lem@163.com', '$2a$10$zdvFAj69Rrau6E1HoNfYmufBBRDwaPdBkew/nsZf4a7F8AYO5R22i', '13338880031', '1', '150000', '', '李库', '1', '', 'liku', '2009', '', '13', null, null);
INSERT INTO `gem_user` VALUES ('29', '北京市县延庆县山西省吉林省', null, null, null, '1358882222@qq.com', '$2a$10$H86l7PrVCMDN7AfiPvsJm.NHG3OVgCoiA0nhjkToSDUx1aAB7NTPe', '18200029040', '1', null, '', '刘松', '0', '', 'liusong', '2011', '', '13', null, null);
INSERT INTO `gem_user` VALUES ('30', '北京市县延庆县山西省吉林省', null, null, null, '1344444@33', '$2a$10$fMNbehcWTf7VexrAOpW/MeWuHcZ5CmvxHgSfT.Loeh46yjRsskQ6e', '18500029022', '1', null, '', '121212', '0', '', 'niha', '1212', '', '1', null, null);
INSERT INTO `gem_user` VALUES ('31', '北京市县延庆县山西省吉林省', null, null, null, '1338345222@qq.com', '$2a$10$U47V2f0Sx9fVye4p9AzRceXGwyLBgp/31didHIUTG35sv/a3kPPl2', '18200034040', '1', null, '', '赵本山', '0', '', 'zhaobens', '2011', '', '3', null, '2020-02-17 19:55:48');
INSERT INTO `gem_user` VALUES ('32', '天津市市辖区河西区', '120103', null, '120100', '112333424@33', '$2a$10$81Afi89ZwXqsCSviRjJl.OVPFacMXX6TjuRjTsKfn2ee2ES61qePS', '18500029020', '1', '120000', '', '121212', '0', '', 'test', '1212', '', '18', null, '2020-02-17 19:56:11');

-- ----------------------------
-- Table structure for gem_user_depts
-- ----------------------------
DROP TABLE IF EXISTS `gem_user_depts`;
CREATE TABLE `gem_user_depts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_user_depts
-- ----------------------------
INSERT INTO `gem_user_depts` VALUES ('16', '2', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('17', '3', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('18', '4', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('19', '6', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('20', '11', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('21', '2', '19', null, null);
INSERT INTO `gem_user_depts` VALUES ('22', '3', '19', null, null);
INSERT INTO `gem_user_depts` VALUES ('23', '1', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('24', '5', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('25', '2', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('26', '3', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('27', '4', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('28', '6', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('29', '11', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('30', '12', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('31', '7', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('32', '13', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('33', '14', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('34', '8', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('35', '15', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('36', '10', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('37', '2', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('38', '3', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('39', '4', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('40', '2', '22', null, null);
INSERT INTO `gem_user_depts` VALUES ('41', '4', '22', null, null);
INSERT INTO `gem_user_depts` VALUES ('42', '7', '23', null, null);
INSERT INTO `gem_user_depts` VALUES ('43', '14', '23', null, null);
INSERT INTO `gem_user_depts` VALUES ('44', '2', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('45', '3', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('46', '4', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('47', '8', '25', null, null);
INSERT INTO `gem_user_depts` VALUES ('48', '15', '25', null, null);

-- ----------------------------
-- Table structure for gem_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `gem_user_roles`;
CREATE TABLE `gem_user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_user_roles
-- ----------------------------
INSERT INTO `gem_user_roles` VALUES ('39', '1', '30', null, null);
INSERT INTO `gem_user_roles` VALUES ('40', '18', '30', null, null);
INSERT INTO `gem_user_roles` VALUES ('50', '1', '24', null, null);
INSERT INTO `gem_user_roles` VALUES ('52', '1', '1', null, null);
INSERT INTO `gem_user_roles` VALUES ('58', '18', '31', '2020-02-17 19:55:48', '2020-02-17 19:55:48');
INSERT INTO `gem_user_roles` VALUES ('59', '18', '32', '2020-02-17 19:56:11', '2020-02-17 19:56:11');

-- ----------------------------
-- Table structure for get_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `get_sys_log`;
CREATE TABLE `get_sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(10) DEFAULT NULL COMMENT '操作帐号',
  `client_ip` varchar(32) DEFAULT NULL COMMENT '客户端IP',
  `operate_status` tinyint(1) DEFAULT NULL COMMENT '操作状态 0成功 1失败',
  `operate_type` tinyint(1) DEFAULT NULL COMMENT '操作类型 0登录 1其他',
  `request_args` varchar(100) DEFAULT NULL COMMENT '请求参数',
  `request_mothod` varchar(10) DEFAULT NULL COMMENT '请求方法',
  `request_url` varchar(100) DEFAULT NULL COMMENT '请求URL',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of get_sys_log
-- ----------------------------
INSERT INTO `get_sys_log` VALUES ('1', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('6', 'admin', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('7', 'admin', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('8', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('9', 'zhangsan', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'zhangsan', null, null);
INSERT INTO `get_sys_log` VALUES ('10', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('11', 'admin', '192.168.1.8', '1', '0', null, 'POST', 'http://192.168.1.6:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('12', 'admin', '192.168.1.8', '0', '0', null, 'POST', 'http://192.168.1.6:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('13', 'admin', '192.168.1.6', '0', '0', null, 'POST', 'http://192.168.1.6:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('14', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('15', 'admin', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('16', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('17', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('18', 'liusong', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'liusong', null, null);
INSERT INTO `get_sys_log` VALUES ('19', 'liusong', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'liusong', null, null);
INSERT INTO `get_sys_log` VALUES ('20', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('21', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('22', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('23', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('24', 'admin', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('25', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('26', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('27', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('28', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('29', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/gem/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('30', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1/admin/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('31', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', null, null);
INSERT INTO `get_sys_log` VALUES ('32', 'admin', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', '2020-02-17 19:40:53', '2020-02-17 19:40:53');
INSERT INTO `get_sys_log` VALUES ('33', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', '2020-02-17 19:41:00', '2020-02-17 19:41:00');
INSERT INTO `get_sys_log` VALUES ('34', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', '2020-02-17 19:44:06', '2020-02-17 19:44:06');
INSERT INTO `get_sys_log` VALUES ('35', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', '2020-02-17 19:46:49', '2020-02-17 19:46:49');
INSERT INTO `get_sys_log` VALUES ('36', 'admin', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin', '2020-02-17 19:51:17', '2020-02-17 19:51:17');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
