/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : gem

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2020-02-22 13:29:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gem_dept
-- ----------------------------
DROP TABLE IF EXISTS `gem_dept`;
CREATE TABLE `gem_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_dept
-- ----------------------------
INSERT INTO `gem_dept` VALUES ('1', null, '2020-02-15 15:38:46', 'BJ', '张三', '北京分公司有限公司，位于中国缝制设备制造之都-，自1999年创建以来，经过二十年不懈的努力发展，公司在缝制行业树立起自己的形象和品牌。今天的中工缝制设备制造，已经涵盖了自动化缝制设备 特种机缝制设备。', 'fwg.bj@wanyong.com', '01', '1', '北京分公司', '010', '0', '01', '010-66889988', '二级单位', null, null);
INSERT INTO `gem_dept` VALUES ('2', '2019-12-28 14:31:12', '2019-12-28 14:31:12', '', '', '', '', '02', '1', '广东分公司', '', '0', '02', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('3', null, '2019-12-28 14:31:35', '', '', '', '', '02-03', '2', '深圳分公司', '', '2', '02', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('4', null, '2019-12-28 14:31:45', '', '', '', '', '02-04', '2', '广州分公司', '', '2', '02', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('5', null, '2020-02-15 15:38:59', '海淀', '李四', '海淀办事处', 'wanyongedu@163.com', '01-05', '2', '海淀办事处', '01001', '1', '01', '010-66889988', '内部', null, null);
INSERT INTO `gem_dept` VALUES ('6', null, '2020-01-26 13:31:05', '', '', '', '', '06', '1', '上海分公司', '', '0', '06', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('7', null, '2020-01-09 19:45:34', '', '1212', '', '', '07', '1', '河北分公司', '1212', '0', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('8', null, '2020-01-04 20:15:19', '', '', '', '', '08', '1', '天津分公司', '', '0', '08', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('10', null, '2020-01-10 10:19:28', '', '', '', '', '10', '1', '重庆分公司', '', '0', '10', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('11', null, '2020-01-04 20:13:40', '', '', '', '', '06-11', '2', '浦东分公司', '', '6', '06', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('12', null, '2020-01-26 13:31:10', 'SHFGSI', '张松', '', 'shanghai@qq.com', '06-12', '2', '松江分公司', '1001', '6', '06', '022-80898213', '自营', null, null);
INSERT INTO `gem_dept` VALUES ('13', null, '2020-01-04 20:15:03', '', '', '', '', '07-13', '2', '邯郸分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('14', null, '2020-01-04 20:15:10', '', '', '', '', '07-14', '2', '石家庄分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('15', null, '2020-01-04 20:15:40', '', '', '', '', '08-15', '2', '静海分公司', '', '8', '08', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('16', null, '2020-01-15 11:22:16', '', '', '', '', '07-16', '2', '保定分公司', '', '7', '07', '', '', null, null);
INSERT INTO `gem_dept` VALUES ('17', null, '2020-01-15 11:22:30', '', '', '', '', '10-17', '2', '重庆', '', '10', '10', '', '', null, null);

-- ----------------------------
-- Table structure for gem_menu
-- ----------------------------
DROP TABLE IF EXISTS `gem_menu`;
CREATE TABLE `gem_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_menu
-- ----------------------------
INSERT INTO `gem_menu` VALUES ('2', null, '2020-01-19 15:16:12', null, 'fab fa-angular', '02', '1', '#', '权限管理', '0', '02', '8', 'menu_sys', '0', '08-02', null, '2020-02-21 20:28:42');
INSERT INTO `gem_menu` VALUES ('3', null, '2020-01-27 18:46:18', null, 'fas fa-user-circle', '02-03', '2', 'user/list.html', '用户管理', '2', '02', '5', 'menu_user', '0', '08-02-05-02-03', null, null);
INSERT INTO `gem_menu` VALUES ('4', null, '2020-01-12 12:03:15', null, 'fas fa-sitemap', '02-04', '2', 'dept/list.html', '部门管理', '2', '02', '4', 'menu_dept', '0', '08-02-04-02-04', null, null);
INSERT INTO `gem_menu` VALUES ('5', null, '2020-01-12 12:01:16', null, 'fas fa-rocket', '02-05', '2', 'role/list.html', '角色管理', '2', '02', '2', 'menu_role', '0', '08-02-02-02-05', null, null);
INSERT INTO `gem_menu` VALUES ('6', null, '2020-02-15 18:59:42', null, 'fab fa-adn', '02-06', '2', 'menu/list.html', '菜单管理', '2', '02', '1', 'menu_menu', '0', '08-02-01-02-06', null, null);
INSERT INTO `gem_menu` VALUES ('7', null, '2020-01-31 17:46:05', null, 'fas fa-box', '07', '1', '#', '外部网站', '0', '07', '998', 'menu_website', '0', '998-07', null, null);
INSERT INTO `gem_menu` VALUES ('8', null, '2020-01-31 17:46:05', null, 'fab fa-angular', '07-08', '2', 'http://www.baidu.com', '百度一下', '7', '07', '4', 'menu_api', '0', '998-07-04-07-08', null, null);
INSERT INTO `gem_menu` VALUES ('9', null, '2020-02-12 22:56:16', null, 'fab fa-apple', '07-09', '2', 'http://www.gemframework.com/shouquan.html', '商业授权', '7', '07', '3', 'menu_app', '0', '998-07-03-07-09', null, null);
INSERT INTO `gem_menu` VALUES ('10', null, '2020-01-31 17:45:55', null, 'fab fa-amilia', '10', '1', '#', '一级菜单', '0', '10', '999', 'menu_1', '0', '999-10', null, null);
INSERT INTO `gem_menu` VALUES ('11', null, '2020-01-31 17:45:55', null, 'fab fa-amazon', '10-11', '2', '123', '二级菜单', '10', '10', '99', 'menu_2', '0', '999-10-99-10-11', null, null);
INSERT INTO `gem_menu` VALUES ('12', null, '2020-01-31 17:45:55', null, 'fas fa-angle-double-right', '10-11-12', '3', 'HTTP://JSON.CN', '三级菜单', '11', '10', '99', 'menu_json', '0', '999-10-99-10-11-99-10-11-12', null, null);
INSERT INTO `gem_menu` VALUES ('14', null, '2020-01-12 11:58:22', null, '', '02-06-14', '3', 'menu/delete', '删除按钮', '6', '02', '3', 'btn_menu_del', '1', '08-02-01-02-06-03-02-06-14', null, null);
INSERT INTO `gem_menu` VALUES ('15', null, '2020-01-12 12:01:47', null, '', '02-05-15', '3', 'role/pageByParams', '分页查询', '5', '02', '1', 'fun_role_page', '2', '08-02-02-02-05-01-02-05-15', null, null);
INSERT INTO `gem_menu` VALUES ('16', null, '2020-01-12 12:04:06', null, '', '02-04-16', '3', 'findAllDeptTree', '左侧菜单树', '4', '02', '99', 'fun_dept_tree', '2', '08-02-04-02-04-99-02-04-16', null, null);
INSERT INTO `gem_menu` VALUES ('17', null, '2020-01-27 18:47:33', null, '', '02-03-17', '3', 'user/pageByParams', '分页查询', '3', '02', '1', 'fun_user_page', '2', '08-02-05-02-03-01-02-03-17', null, null);
INSERT INTO `gem_menu` VALUES ('18', null, '2020-01-12 12:02:07', null, '', '02-05-18', '3', 'role/add', '添加/编辑', '5', '02', '99', 'fun_role_add', '2', '08-02-02-02-05-99-02-05-18', null, null);
INSERT INTO `gem_menu` VALUES ('19', null, '2020-01-27 18:46:11', null, '', '02-04-19', '3', 'dept/getOne', '查询单个部门', '4', '02', '99', 'fun_dept_get', '2', '08-02-04-02-04-99-02-04-19', null, null);
INSERT INTO `gem_menu` VALUES ('20', null, '2020-01-27 18:47:05', null, '', '02-04-20', '3', 'dept/add', '添加/编辑', '4', '02', '99', 'fun_dept_add', '2', '08-02-04-02-04-99-02-04-20', null, null);
INSERT INTO `gem_menu` VALUES ('21', null, '2020-01-12 11:58:49', null, '', '02-06-21', '3', 'menu/add', '添加/编辑', '6', '02', '1', 'fun_menu_add', '2', '08-02-01-02-06-01-02-06-21', null, null);
INSERT INTO `gem_menu` VALUES ('23', null, '2020-01-12 12:02:45', null, '', '02-05-23', '3', 'role/list', '下拉框角色列表', '5', '02', '991', 'fun_role_list', '2', '08-02-02-02-05-991-02-05-23', null, null);
INSERT INTO `gem_menu` VALUES ('24', null, '2020-01-27 18:47:43', null, '', '02-03-24', '3', 'user/add', '添加/编辑', '3', '02', '99', 'fun_user_add', '2', '08-02-05-02-03-99-02-03-24', null, null);
INSERT INTO `gem_menu` VALUES ('25', null, '2020-01-12 12:06:24', null, '', '02-06-25', '3', 'menu/add.html', '添加按钮', '6', '02', '99', 'btn_menu_add', '1', '08-02-01-02-06-99-02-06-25', null, null);
INSERT INTO `gem_menu` VALUES ('26', null, '2020-01-12 11:57:08', null, '', '02-06-26', '3', 'menu/edit.html', '编辑按钮', '6', '02', '99', 'btn_menu_edit', '1', '08-02-01-02-06-99-02-06-26', null, null);
INSERT INTO `gem_menu` VALUES ('27', '2020-01-12 12:04:53', '2020-01-12 12:04:53', null, '', '02-05-27', '3', 'role/add.html', '添加按钮', '5', '02', '99', 'btn_role_add', '1', '08-02-02-02-05-99-02-05-27', null, null);
INSERT INTO `gem_menu` VALUES ('28', null, '2020-01-12 12:05:45', null, '', '02-05-28', '3', 'role/edit.html', '编辑按钮', '5', '02', '99', 'btn_role_edit', '1', '08-02-02-02-05-99-02-05-28', null, null);
INSERT INTO `gem_menu` VALUES ('29', '2020-01-12 12:07:13', '2020-01-12 12:07:13', null, '', '02-05-29', '3', 'role/delete', '删除按钮', '5', '02', '99', 'btn_role_del', '1', '08-02-02-02-05-99-02-05-29', null, null);
INSERT INTO `gem_menu` VALUES ('30', '2020-01-12 13:58:27', '2020-01-12 13:58:27', null, '', '02-03-30', '3', 'user/add.html', '添加按钮', '3', '02', '99', 'btn_user_add', '1', '08-02-05-02-03-99-02-03-30', null, null);
INSERT INTO `gem_menu` VALUES ('31', '2020-01-12 13:58:52', '2020-01-12 13:58:52', null, '', '02-03-31', '3', 'user/edit.html', '编辑按钮', '3', '02', '99', 'btn_user_edit', '1', '08-02-05-02-03-99-02-03-31', null, null);
INSERT INTO `gem_menu` VALUES ('32', null, '2020-01-31 17:46:13', null, 'fas fa-globe', '32', '1', '#', '源码下载', '0', '32', '997', 'menu_src', '0', '997-32', null, null);
INSERT INTO `gem_menu` VALUES ('33', null, '2020-01-31 17:46:13', null, 'fab fa-github', '32-33', '2', 'https://gitee.com/gemteam/gemframe', '码云地址', '32', '32', '2', 'menu_gitee', '0', '997-32-02-32-33', null, null);
INSERT INTO `gem_menu` VALUES ('34', null, '2020-01-31 17:46:13', null, 'fab fa-windows', '32-34', '2', 'http://www.gemframework.com', 'GemFrame官网', '32', '32', '3', 'menu_gem', '0', '997-32-03-32-34', null, null);
INSERT INTO `gem_menu` VALUES ('35', null, '2020-01-31 17:46:13', null, 'fas fa-basketball-ball', '32-35', '2', 'http://www.gemframework.com/bbs', '官方社区', '32', '32', '1', 'menu_bbs', '0', '997-32-01-32-35', null, null);
INSERT INTO `gem_menu` VALUES ('36', null, '2020-01-27 18:44:00', null, 'fas fa-desktop', '36', '1', '112', '系统监控', '0', '36', '99', 'menu_monitor', '0', '99-36', null, '2020-02-21 20:42:24');
INSERT INTO `gem_menu` VALUES ('37', null, '2020-02-13 21:11:57', null, 'fas fa-database', '36-37', '2', 'druid', 'MySQL监控', '36', '36', '99', 'menu_druid', '0', '99-36-99-36-37', null, null);
INSERT INTO `gem_menu` VALUES ('38', null, '2020-01-27 18:43:13', null, 'fas fa-video', '38', '1', '#', '示例演示', '0', '38', '99', 'menu_demo', '0', '99-38', null, null);
INSERT INTO `gem_menu` VALUES ('39', null, '2020-02-15 19:04:46', null, 'fab fa-first-order', '38-39', '2', 'demo/pages/redis', 'Redis示例', '38', '38', '99', 'menu_redis', '0', '99-38-99-38-39', null, null);
INSERT INTO `gem_menu` VALUES ('40', null, '2020-02-15 22:08:37', null, 'fas fa-lightbulb', '36-40', '2', 'doc.html', '接口调试', '36', '36', '99', 'menu_swagger', '0', '99-36-99-36-40', null, '2020-02-21 19:56:39');
INSERT INTO `gem_menu` VALUES ('41', null, '2020-01-27 18:48:18', null, '', '02-41', '2', 'orderInfo', '首页订单信息', '2', '02', '99', 'fun_index_order', '2', '08-02-99-02-41', null, null);
INSERT INTO `gem_menu` VALUES ('45', null, '2020-01-27 18:42:31', null, 'fas fa-code', '45', '1', 'generate/code/list.html', '代码生成', '0', '45', '99', 'menu_code', '0', '99-45', null, null);
INSERT INTO `gem_menu` VALUES ('51', '2020-01-28 20:19:08', '2020-01-28 20:19:08', null, 'fab fa-modx', '45-84-51', '3', 'module/list.html', '模块管理', '84', '45', '99', 'menu_module', '0', '99-45-99-45-84-99-45-84-51', null, '2020-02-21 20:52:23');
INSERT INTO `gem_menu` VALUES ('52', null, '2020-01-28 20:50:11', null, '', '45-84-51-52', '3', 'module/pageByParams', '分页查询', '51', '45', '99', 'fun_module_page', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-52', null, '2020-02-21 20:53:15');
INSERT INTO `gem_menu` VALUES ('53', '2020-01-28 20:52:37', '2020-01-28 20:52:37', null, '', '45-84-51-53', '3', 'module/add.html', '添加按钮', '51', '45', '99', 'btn_module_add', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-53', null, '2020-02-21 20:55:11');
INSERT INTO `gem_menu` VALUES ('54', '2020-01-28 20:53:04', '2020-01-28 20:53:04', null, '', '45-84-51-54', '3', 'module/edit.html', '编辑按钮', '51', '45', '99', 'btn_module_edit', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-54', null, '2020-02-21 20:55:13');
INSERT INTO `gem_menu` VALUES ('55', '2020-01-28 20:53:44', '2020-01-28 20:53:44', null, '', '45-84-51-55', '3', 'module/delete', '删除按钮', '51', '45', '99', 'btn_module_del', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-55', null, '2020-02-21 20:55:17');
INSERT INTO `gem_menu` VALUES ('56', '2020-01-28 20:54:18', '2020-01-28 20:54:18', null, '', '45-84-51-56', '3', 'module/add', '添加/编辑', '51', '45', '99', 'fun_module_add', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-56', null, '2020-02-21 20:55:20');
INSERT INTO `gem_menu` VALUES ('57', '2020-01-29 18:26:39', '2020-01-29 18:26:39', null, 'fas fa-certificate', '45-84-57', '3', 'moduleAttr/list.html', '属性管理', '84', '45', '99', 'menu_module_attr', '0', '99-45-99-45-84-99-45-84-57', null, '2020-02-21 20:52:05');
INSERT INTO `gem_menu` VALUES ('58', '2020-01-29 18:27:51', '2020-01-29 18:27:51', null, '', '45-84-57-58', '3', 'moduleAttr/pageByParams', '分页查询', '57', '45', '99', 'fun_moduleAttr_page', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-58', null, '2020-02-21 20:53:47');
INSERT INTO `gem_menu` VALUES ('59', null, '2020-01-29 18:32:17', null, '', '45-84-57-59', '3', 'moduleAttr/add.html', '添加按钮', '57', '45', '99', 'btn_moduleAttr_add', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-59', null, '2020-02-21 20:53:41');
INSERT INTO `gem_menu` VALUES ('60', null, '2020-01-29 18:32:26', null, '', '45-84-57-60', '3', 'moduleAttr/edit.html', '编辑按钮', '57', '45', '99', 'btn_moduleAttr_edit', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-60', null, '2020-02-21 20:53:37');
INSERT INTO `gem_menu` VALUES ('61', '2020-01-29 18:32:05', '2020-01-29 18:32:05', null, '', '45-84-57-61', '3', 'moduleAttr/add', '添加/编辑', '57', '45', '99', 'fun_moduleAttr_add', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-61', null, '2020-02-21 20:53:30');
INSERT INTO `gem_menu` VALUES ('62', '2020-01-29 18:33:05', '2020-01-29 18:33:05', null, '', '45-84-57-62', '3', 'moduleAttr/delete', '删除按钮', '57', '45', '99', 'btn_moduleAttr_delete', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-62', null, '2020-02-21 20:53:28');
INSERT INTO `gem_menu` VALUES ('63', '2020-01-29 20:10:49', '2020-01-29 20:10:49', null, '', '45-84-57-63', '3', 'module/list', '获取模块列表', '57', '45', '99', 'fun_module_list', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-63', null, '2020-02-21 20:53:25');
INSERT INTO `gem_menu` VALUES ('64', '2020-01-30 14:01:13', '2020-01-30 14:01:13', null, '', '45-84-51-64', '3', 'module/generateCode', '生成代码按钮', '51', '45', '99', 'btn_code_generate', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-64', null, '2020-02-21 20:55:05');
INSERT INTO `gem_menu` VALUES ('65', null, '2020-01-30 22:08:52', null, '', '45-84-51-65', '3', 'module/downloadCode', '代码下载', '51', '45', '99', 'btn_module_download', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-65', null, '2020-02-21 20:54:52');
INSERT INTO `gem_menu` VALUES ('66', null, '2020-02-08 00:00:37', null, '', '45-84-51-66', '3', 'module/deleteBatch', '批量删除', '51', '45', '99', 'plsc', '1', '99-45-99-45-84-99-45-84-51-99-45-84-51-66', null, '2020-02-21 20:53:55');
INSERT INTO `gem_menu` VALUES ('67', null, '2020-02-08 00:00:29', null, '', '45-84-57-67', '3', 'moduleAttr/deleteBatch', '批量删除', '57', '45', '99', 'plsc1', '1', '99-45-99-45-84-99-45-84-57-99-45-84-57-67', null, '2020-02-21 20:53:21');
INSERT INTO `gem_menu` VALUES ('68', '2020-02-12 22:32:29', '2020-02-12 22:32:29', null, 'fas fa-exclamation-circle', '68', '1', 'errorpages', '错误页面', '0', '68', '99', 'errorpages', '0', '99-68', null, null);
INSERT INTO `gem_menu` VALUES ('69', '2020-02-12 22:32:51', '2020-02-12 22:32:51', null, 'far fa-flag', '68-69', '2', '404', '404', '68', '68', '99', '404', '0', '99-68-99-68-69', null, null);
INSERT INTO `gem_menu` VALUES ('70', '2020-02-12 22:33:13', '2020-02-12 22:33:13', null, 'fas fa-flag-checkered', '68-70', '2', '403', '403', '68', '68', '99', '403', '0', '99-68-99-68-70', null, null);
INSERT INTO `gem_menu` VALUES ('71', null, '2020-02-13 21:09:57', null, 'fas fa-th-large', '36-71', '2', 'sysLog/list.html', '系统日志', '36', '36', '99', 'log', '0', '99-36-99-36-71', null, null);
INSERT INTO `gem_menu` VALUES ('73', null, '2020-02-13 21:11:11', null, '', '36-71-73', '3', 'sysLog/pageByParams', '分页查询日志', '71', '36', '99', 'logpage', '1', '99-36-99-36-71-99-36-71-73', null, null);
INSERT INTO `gem_menu` VALUES ('74', '2020-02-13 22:24:12', '2020-02-13 22:24:12', null, '', '36-71-74', '3', 'sysLog/deleteBatch', '清空日志', '71', '36', '99', 'deleteBatch', '1', '99-36-99-36-71-99-36-71-74', null, null);
INSERT INTO `gem_menu` VALUES ('75', null, '2020-02-15 15:50:19', null, '', '02-06-75', '3', 'menu/addChild.html', '添加子节点', '6', '02', '99', 'addChild', '1', '08-02-01-02-06-99-02-06-75', null, null);
INSERT INTO `gem_menu` VALUES ('79', null, '2020-02-15 15:53:58', null, '', '02-03-79', '3', 'user/resetPassword', '重置密码', '3', '02', '99', 'user/resetPasswor', '1', '08-02-05-02-03-99-02-03-79', null, null);
INSERT INTO `gem_menu` VALUES ('81', null, '2020-02-15 19:01:55', null, '', '02-06-81', '3', 'common/resetSideMenus', '同步侧菜单信息', '6', '02', '99', 'resetSideMenus', '1', '08-02-01-02-06-99-02-06-81', null, null);
INSERT INTO `gem_menu` VALUES ('82', null, '2020-02-15 19:04:32', null, 'fas fa-file-alt', '38-82', '2', 'demo/pages/pageStyle', '页面风格', '38', '38', '99', 'pagestyle', '0', '99-38-99-38-82', null, null);
INSERT INTO `gem_menu` VALUES ('83', null, null, null, 'far fa-comments', '83', '1', 'doc.html', '消息管理', '0', '83', '99', 'message', '0', '99-83', null, '2020-02-21 19:47:38');
INSERT INTO `gem_menu` VALUES ('84', null, null, null, 'fas fa-angle-double-right', '45-84', '2', '123', '正向生成', '45', '45', '99', 'zxsc', '0', '99-45-99-45-84', '2020-02-21 20:51:42', '2020-02-21 20:51:43');
INSERT INTO `gem_menu` VALUES ('85', null, null, null, 'fas fa-angle-double-left', '45-85', '2', 'code/list.html', '逆向生成', '45', '45', '99', 'nxsc', '0', '99-45-99-45-85', null, '2020-02-22 13:18:02');

-- ----------------------------
-- Table structure for gem_module
-- ----------------------------
DROP TABLE IF EXISTS `gem_module`;
CREATE TABLE `gem_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
INSERT INTO `gem_module` VALUES ('2', null, '2020-02-08 20:48:23', 'zhangysh', '1', '1', '1', '1', '车辆管理', 'car', 'com.gemframework.cms', '450', '550', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('3', null, '2020-01-31 14:34:56', 'zhangysh', '1', '1', '1', '1', '测试', 'test', 'com.gemframework', '0', '550', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('4', null, '2020-01-31 14:36:50', 'gems', '1', '1', '1', '1', '苹果管理', 'apple', 'com.test', '500', '400', 'name', '0', null, null);
INSERT INTO `gem_module` VALUES ('39', null, '2020-02-13 20:34:57', 'gemteam', '0', '1', '0', '1', '系统日志', 'sysLog', 'com.gemframework', '450', '550', 'name', '1', null, null);

-- ----------------------------
-- Table structure for gem_module_attr
-- ----------------------------
DROP TABLE IF EXISTS `gem_module_attr`;
CREATE TABLE `gem_module_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
INSERT INTO `gem_module_attr` VALUES ('37', null, '2020-02-08 20:48:23', 'name', 'text', '描述', null, '0', '1', '0', '0', '10', '20', '2', null, '2', null, null);
INSERT INTO `gem_module_attr` VALUES ('38', '2020-02-08 20:48:23', '2020-02-08 20:48:23', 'name1', 'text', '1212', null, '1', '0', '1', '1', '12', '212', '2', null, '2', null, null);
INSERT INTO `gem_module_attr` VALUES ('39', '2020-02-08 20:48:23', '2020-02-08 20:48:23', '12121', 'text', '1212', null, '1', '1', '0', '1', '212', '121', '2', null, '3', null, null);
INSERT INTO `gem_module_attr` VALUES ('42', null, '2020-02-13 20:34:57', 'client_ip', 'text', '日志名称', null, '1', '1', '1', '1', '20', '1', '39', null, '4', null, null);
INSERT INTO `gem_module_attr` VALUES ('43', null, '2020-02-13 20:34:57', 'type', 'text', '日志类型', null, '1', '1', '1', '1', '2', '1', '39', null, '5', null, null);
INSERT INTO `gem_module_attr` VALUES ('44', null, '2020-02-13 20:34:57', 'desp', 'text', '日志内容', null, '1', '1', '1', '1', '200', '0', '39', null, '6', null, null);
INSERT INTO `gem_module_attr` VALUES ('45', null, '2020-02-13 20:34:57', 'id', 'text', '自增ID', null, '0', '0', '0', '0', '20', '1', '39', null, '1', null, null);
INSERT INTO `gem_module_attr` VALUES ('46', null, '2020-02-13 20:34:57', 'account', 'text', '系统账号', null, '1', '1', '1', '1', '20', '0', '39', null, '3', null, null);
INSERT INTO `gem_module_attr` VALUES ('47', null, '2020-02-13 20:34:57', 'user_id', 'text', '用户ID', null, '1', '1', '1', '1', '20', '0', '39', null, '2', null, null);

-- ----------------------------
-- Table structure for gem_role
-- ----------------------------
DROP TABLE IF EXISTS `gem_role`;
CREATE TABLE `gem_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
INSERT INTO `gem_role` VALUES ('1', '2020-01-04 11:56:08', '2020-01-04 17:53:01', '3', '管理员', 'admin', '管理员', null, '2020-02-21 20:35:52');
INSERT INTO `gem_role` VALUES ('18', '2020-01-09 22:17:09', '2020-02-14 21:57:24', '0', '测试演示角色', 'test', '测试角色', null, null);

-- ----------------------------
-- Table structure for gem_role_depts
-- ----------------------------
DROP TABLE IF EXISTS `gem_role_depts`;
CREATE TABLE `gem_role_depts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_role_depts
-- ----------------------------
INSERT INTO `gem_role_depts` VALUES ('57', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '1', '2', null, null);
INSERT INTO `gem_role_depts` VALUES ('58', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '5', '2', null, null);
INSERT INTO `gem_role_depts` VALUES ('59', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '2', '2', null, null);
INSERT INTO `gem_role_depts` VALUES ('60', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '3', '2', null, null);
INSERT INTO `gem_role_depts` VALUES ('61', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '4', '2', null, null);
INSERT INTO `gem_role_depts` VALUES ('62', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '1', '4', null, null);
INSERT INTO `gem_role_depts` VALUES ('63', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '5', '4', null, null);
INSERT INTO `gem_role_depts` VALUES ('64', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '2', '5', null, null);
INSERT INTO `gem_role_depts` VALUES ('65', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '3', '5', null, null);
INSERT INTO `gem_role_depts` VALUES ('66', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '4', '5', null, null);
INSERT INTO `gem_role_depts` VALUES ('67', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '6', '5', null, null);
INSERT INTO `gem_role_depts` VALUES ('68', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '11', '5', null, null);
INSERT INTO `gem_role_depts` VALUES ('69', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '1', '11', null, null);
INSERT INTO `gem_role_depts` VALUES ('70', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '5', '11', null, null);
INSERT INTO `gem_role_depts` VALUES ('71', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '2', '11', null, null);
INSERT INTO `gem_role_depts` VALUES ('72', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '3', '11', null, null);
INSERT INTO `gem_role_depts` VALUES ('73', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '2', '13', null, null);
INSERT INTO `gem_role_depts` VALUES ('74', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '3', '13', null, null);
INSERT INTO `gem_role_depts` VALUES ('75', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '4', '13', null, null);
INSERT INTO `gem_role_depts` VALUES ('150', '2020-01-09 21:20:04', '2020-01-09 21:20:04', '1', '17', null, null);
INSERT INTO `gem_role_depts` VALUES ('151', '2020-01-09 21:20:04', '2020-01-09 21:20:04', '5', '17', null, null);
INSERT INTO `gem_role_depts` VALUES ('168', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '1', '19', null, null);
INSERT INTO `gem_role_depts` VALUES ('169', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '5', '19', null, null);
INSERT INTO `gem_role_depts` VALUES ('170', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '1', '20', null, null);
INSERT INTO `gem_role_depts` VALUES ('171', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '5', '20', null, null);
INSERT INTO `gem_role_depts` VALUES ('252', null, null, '1', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('253', null, null, '5', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('254', null, null, '2', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('255', null, null, '3', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('256', null, null, '4', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('257', null, null, '6', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('258', null, null, '11', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('259', null, null, '12', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('260', null, null, '7', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('261', null, null, '13', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('262', null, null, '14', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('263', null, null, '16', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('264', null, null, '8', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('265', null, null, '15', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('266', null, null, '10', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_depts` VALUES ('267', null, null, '17', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');

-- ----------------------------
-- Table structure for gem_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `gem_role_menus`;
CREATE TABLE `gem_role_menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=551 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_role_menus
-- ----------------------------
INSERT INTO `gem_role_menus` VALUES ('106', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '10', '2', null, null);
INSERT INTO `gem_role_menus` VALUES ('107', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '11', '2', null, null);
INSERT INTO `gem_role_menus` VALUES ('108', '2020-01-08 19:27:34', '2020-01-08 19:27:34', '12', '2', null, null);
INSERT INTO `gem_role_menus` VALUES ('109', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '7', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('110', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '9', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('111', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '8', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('112', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '10', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('113', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '11', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('114', '2020-01-08 19:27:40', '2020-01-08 19:27:40', '12', '4', null, null);
INSERT INTO `gem_role_menus` VALUES ('115', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '7', '5', null, null);
INSERT INTO `gem_role_menus` VALUES ('116', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '9', '5', null, null);
INSERT INTO `gem_role_menus` VALUES ('117', '2020-01-08 19:27:46', '2020-01-08 19:27:46', '8', '5', null, null);
INSERT INTO `gem_role_menus` VALUES ('118', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '7', '11', null, null);
INSERT INTO `gem_role_menus` VALUES ('119', '2020-01-08 19:27:51', '2020-01-08 19:27:51', '8', '11', null, null);
INSERT INTO `gem_role_menus` VALUES ('120', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '2', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('121', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '6', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('122', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '5', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('123', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '4', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('124', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '3', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('125', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '7', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('126', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '9', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('127', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '8', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('128', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '10', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('129', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '11', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('130', '2020-01-08 19:27:55', '2020-01-08 19:27:55', '12', '13', null, null);
INSERT INTO `gem_role_menus` VALUES ('216', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '2', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('217', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '6', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('218', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '5', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('219', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '4', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('220', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '3', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('221', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '10', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('222', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '11', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('223', '2020-01-09 19:41:44', '2020-01-09 19:41:44', '12', '16', null, null);
INSERT INTO `gem_role_menus` VALUES ('281', '2020-01-09 21:20:04', '2020-01-09 21:20:04', '7', '17', null, null);
INSERT INTO `gem_role_menus` VALUES ('282', '2020-01-09 21:20:04', '2020-01-09 21:20:04', '9', '17', null, null);
INSERT INTO `gem_role_menus` VALUES ('283', '2020-01-09 21:20:04', '2020-01-09 21:20:04', '8', '17', null, null);
INSERT INTO `gem_role_menus` VALUES ('330', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '2', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('331', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '6', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('332', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '21', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('333', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '14', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('334', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '25', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('335', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '26', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('336', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '5', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('337', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '15', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('338', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '18', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('339', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '27', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('340', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '28', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('341', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '29', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('342', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '23', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('343', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '4', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('344', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '16', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('345', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '19', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('346', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '20', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('347', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '3', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('348', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '17', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('349', '2020-01-12 12:07:45', '2020-01-12 12:07:45', '24', '19', null, null);
INSERT INTO `gem_role_menus` VALUES ('350', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '2', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('351', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '6', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('352', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '21', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('353', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '14', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('354', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '25', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('355', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '26', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('356', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '5', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('357', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '15', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('358', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '18', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('359', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '27', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('360', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '28', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('361', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '29', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('362', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '23', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('363', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '4', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('364', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '16', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('365', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '19', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('366', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '20', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('367', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '3', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('368', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '17', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('369', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '24', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('370', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '30', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('371', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '31', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('372', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '41', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('373', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '10', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('374', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '11', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('375', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '12', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('376', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '7', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('377', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '9', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('378', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '8', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('379', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '32', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('380', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '35', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('381', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '33', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('382', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '34', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('383', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '36', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('384', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '37', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('385', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '38', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('386', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '39', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('387', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '40', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('388', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '44', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('389', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '45', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('390', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '46', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('391', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '47', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('392', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '48', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('393', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '49', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('394', '2020-01-27 23:00:01', '2020-01-27 23:00:01', '50', '20', null, null);
INSERT INTO `gem_role_menus` VALUES ('395', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '2', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('396', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '3', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('397', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '17', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('398', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '24', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('399', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '45', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('400', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '46', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('401', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '47', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('402', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '48', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('403', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '49', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('404', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '50', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('405', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '51', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('406', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '52', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('407', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '53', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('408', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '54', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('409', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '55', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('410', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '56', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('411', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '64', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('412', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '65', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('413', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '66', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('414', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '57', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('415', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '58', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('416', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '59', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('417', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '60', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('418', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '61', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('419', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '62', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('420', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '63', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('421', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '67', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('422', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '68', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('423', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '69', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('424', '2020-02-14 21:57:24', '2020-02-14 21:57:24', '70', '18', null, null);
INSERT INTO `gem_role_menus` VALUES ('530', null, null, '2', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('531', null, null, '6', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('532', null, null, '21', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('533', null, null, '14', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('534', null, null, '5', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('535', null, null, '15', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('536', null, null, '18', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('537', null, null, '23', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('538', null, null, '4', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('539', null, null, '16', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('540', null, null, '19', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('541', null, null, '20', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('542', null, null, '3', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('543', null, null, '17', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('544', null, null, '24', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('545', null, null, '7', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('546', null, null, '9', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('547', null, null, '8', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('548', null, null, '10', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('549', null, null, '11', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');
INSERT INTO `gem_role_menus` VALUES ('550', null, null, '12', '1', '2020-02-21 20:35:52', '2020-02-21 20:35:52');

-- ----------------------------
-- Table structure for gem_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `gem_sys_log`;
CREATE TABLE `gem_sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `account` varchar(10) DEFAULT NULL COMMENT '操作帐号',
  `address` varchar(32) DEFAULT NULL COMMENT '地理地址',
  `client_ip` varchar(32) DEFAULT NULL COMMENT '客户端IP',
  `operate_status` tinyint(1) DEFAULT NULL COMMENT '操作状态 0成功 1失败',
  `operate_type` tinyint(1) DEFAULT NULL COMMENT '操作类型 0登录 1其他',
  `request_args` varchar(100) DEFAULT NULL COMMENT '请求参数',
  `request_mothod` varchar(10) DEFAULT NULL COMMENT '请求方法',
  `request_url` varchar(100) DEFAULT NULL COMMENT '请求URL',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_sys_log
-- ----------------------------
INSERT INTO `gem_sys_log` VALUES ('1', '2020-02-20 18:21:38', '2020-02-20 18:21:38', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('2', '2020-02-20 20:33:47', '2020-02-20 20:33:47', 'admin', '获取IP地址异常：null', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('3', '2020-02-20 22:35:33', '2020-02-20 22:35:33', 'admin', '内网IP,内网IP', '127.0.0.1', '1', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('4', '2020-02-20 22:35:37', '2020-02-20 22:35:37', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('5', '2020-02-21 18:57:00', '2020-02-21 18:57:00', 'admin', '获取IP地址异常：null', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('6', '2020-02-21 19:46:57', '2020-02-21 19:46:57', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('7', '2020-02-21 19:50:08', '2020-02-21 19:50:08', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('8', '2020-02-21 19:55:47', '2020-02-21 19:55:47', 'admin', '获取IP地址异常：null', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('9', '2020-02-21 19:55:47', '2020-02-21 19:55:47', 'admin', '获取IP地址异常：null', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('10', '2020-02-21 19:55:53', '2020-02-21 19:55:53', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');
INSERT INTO `gem_sys_log` VALUES ('11', '2020-02-21 20:05:32', '2020-02-21 20:05:32', 'test', '获取IP地址异常：null', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'test');
INSERT INTO `gem_sys_log` VALUES ('12', '2020-02-21 20:19:07', '2020-02-21 20:19:07', 'admin', '内网IP,内网IP', '127.0.0.1', '0', '0', null, 'POST', 'http://127.0.0.1:8088/admin/login', 'admin');

-- ----------------------------
-- Table structure for gem_user
-- ----------------------------
DROP TABLE IF EXISTS `gem_user`;
CREATE TABLE `gem_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
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
INSERT INTO `gem_user` VALUES ('7', null, '2020-01-08 13:30:29', '北京市市辖区顺义区北京庄园', '110113', null, '110100', '769990999@qq.com', '$2a$10$rMuB65K93Ch2QQ.mcklt..rROCWThLWRsLnbL2fv4xt2FjNAYLIHa', '13338880040', '1', '110000', '', '张先生', '1', '', 'zhangysh', '1001', '123', '5', null, null);
INSERT INTO `gem_user` VALUES ('8', null, '2020-01-05 22:58:54', '河北省秦皇岛市山海关区', '130303', '2020-01-31 00:00:00', '130300', '769922@qq.com', '$2a$10$g5HO4XFXVmvvqRRC10EkwOM0cewbXLzasjV4YQSjEFI8QA1sfPvO6', '13338880041', '1', '130000', '', '刘三', '0', '', 'zhaoxy', '1002', '', '8', null, null);
INSERT INTO `gem_user` VALUES ('9', null, '2019-12-30 22:12:06', '河北省唐山市路南区', '130202', null, '130200', 'wukong@qq.com', '', '13338880022', '3', '130000', '', '孙悟空', '1', '022-1233212', 'sunwuk', '1003', '', '4', null, null);
INSERT INTO `gem_user` VALUES ('10', null, '2020-01-05 22:41:34', '123456', '140303', '2019-12-28 00:00:00', '140300', '11233344444@33', '$2a$10$C7dt6zjXEmZKipEbgLaWEu9p6oYS1AahvVi1ZOxM1fzhDGudDaeQ2', '18500029040', '4', '140000', '', 'LISI', '0', '1', 'lisi', '1005', '21212', '4', null, null);
INSERT INTO `gem_user` VALUES ('12', null, '2019-12-30 22:19:46', '河北省秦皇岛市山海关区', '130303', '2019-01-01 00:00:00', '130300', 'zhubajie@qq.com', '', '18500029043', '1', '130000', 'zhubajie521', '猪八戒', '0', '', 'zhubajie', '1004', '天蓬元帅下凡', '4', null, null);
INSERT INTO `gem_user` VALUES ('13', null, '2020-01-05 22:41:51', '山西省阳泉市矿区', '140303', '2017-01-02 00:00:00', '140300', 'q4444@33', '$2a$10$2RHRFoltZ2KuqHkrWzCRGu.F7w70WC1JG8aQOxX59Cy4u0u1PkUV2', '13381022222', '3', '140000', '2bajie521', '121212', '0', '', 'lixs', '1006', '23423WWW', '4', null, null);
INSERT INTO `gem_user` VALUES ('14', '2020-01-02 22:15:21', '2020-01-02 23:07:27', '北京市市辖区东城区', '110101', '2020-12-31 00:00:00', '110100', 'jindong@163.com', '$2a$10$DgfwOcfsNYWSCaQMLObIs.3UpdYbjwVqr5z7/5nQ2Q1rn.vd79ReS', '18500038222', '4', '110000', '2', '靳东', '0', '1', 'jindong', '1009', '当红男演员', '5', null, null);
INSERT INTO `gem_user` VALUES ('18', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '北京市市辖区东城区', '110101', '2020-12-31 00:00:00', '110100', 'ww@183.com', '$2a$10$1WyEWj//I6Q0Z0DP4OBNK.VgtzwuDrQgGgdQsZNYG4SsTgY0gAQp2', '18522299999', '1', '110000', '', '王宝强', '0', '', 'wangbao', '1010', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('19', '2020-01-03 11:39:48', '2020-01-03 11:39:48', '北京市县延庆县', '110229', null, '110200', '7699122@qq.com', '$2a$10$khKKTy/UvAAu09M8.AVnQOKokwgMZd20qLZLmcNgiZfKufotUV0AK', '13338320042', '1', '110000', '', '1111', '0', '', 'sunwuk1', '111', '', '4', null, null);
INSERT INTO `gem_user` VALUES ('20', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '北京市市辖区朝阳区', '110105', '2020-01-01 00:00:00', '110100', 'gem@163.com', '$2a$10$znRrt4wtQVQ4qRshq05apO7SzjX04OAr8rCu1Ar4Qu05PdOjW2r2.', '18522299991', '1', '110000', '', 'gem宝石', '0', '', 'gem', '2001', '', '15', null, null);
INSERT INTO `gem_user` VALUES ('21', '2020-01-05 22:51:26', '2020-01-05 22:51:26', '天津市县宁河县', '120221', '2020-01-02 00:00:00', '120200', 'gem1@163.com', '$2a$10$WMzYbiWtTYLnuufpZ13Oz.6poiZ.Ovk2P9XrwkLvMMw1h8lVmC31C', '13338880141', '2', '120000', '', '苏西', '1', '', 'suxi', '2002', '', '11', null, null);
INSERT INTO `gem_user` VALUES ('22', '2020-01-05 22:52:52', '2020-01-05 22:52:52', '河北省石家庄市市辖区', '130101', '2020-01-01 00:00:00', '130100', 'ajiao@qq.com', '$2a$10$Uf4cuqGrGBnUclvgSsUBeOox.vFtfBkvXKYz2zPsn/7TeTwkJH3bW', '18429340234', '1', '130000', '', '阿娇', '1', '', 'ajiao', '2003', '', '2', null, null);
INSERT INTO `gem_user` VALUES ('23', '2020-01-05 22:53:33', '2020-01-05 22:53:33', '吉林省四平市铁西区', '220302', '2020-01-08 00:00:00', '220300', 'aiqim@163.com', '$2a$10$geGwqvAzYeI70fFlBPzhSe6IntHDuficNpbEIMO6PvyrRDxmkKXn2', '13338280040', '3', '220000', '', '爱奇', '1', '', 'aiqi', '2003', '', '7', null, null);
INSERT INTO `gem_user` VALUES ('24', '2020-01-05 22:54:18', '2020-01-21 13:57:53', '河北省邢台市临城县', '130522', '2020-01-26 00:00:00', '130500', 'ls@qq.com', '$2a$10$4VCCFN2laJK8AdmTFusbr.5YHyspDOT37N8alPCLDXU5m2ZGRLJXy', '18338880022', '1', '130000', '', '刘飒', '0', '', 'liusa', '2004', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('25', '2020-01-05 22:55:00', '2020-01-06 22:42:06', '山东省烟台市莱山区', '370613', null, '370600', 'niuize@qq.com', '$2a$10$/5a5yufxiJf66faZUF9ffuYyBVmVxZxQp4saIpAs76UySGQouBLmG', '15338880042', '1', '370000', '', '妞紫', '1', '', 'niuniu', '2005', '', '10', null, null);
INSERT INTO `gem_user` VALUES ('26', '2020-01-06 20:23:08', '2020-01-06 20:23:08', '河北省秦皇岛市昌黎县', null, null, null, 'sem@163.com', '$2a$10$/GzcBUpnKfei5EwJ1nZZx.RTyaG5YiK2A2RU1MDyZxpmLX/4JNv9i', '13338880010', '3', null, '', '史小菲', '1', '', 'shixiaof', '2008', '', '5', null, null);
INSERT INTO `gem_user` VALUES ('27', '2020-01-06 20:25:00', '2020-01-06 20:25:00', '内蒙古自治区乌海市市辖区', '150301', '2020-01-24 00:00:00', '150300', 'lem@163.com', '$2a$10$zdvFAj69Rrau6E1HoNfYmufBBRDwaPdBkew/nsZf4a7F8AYO5R22i', '13338880031', '1', '150000', '', '李库', '1', '', 'liku', '2009', '', '13', null, null);
INSERT INTO `gem_user` VALUES ('28', '2020-01-06 20:51:27', '2020-01-26 14:49:51', '内蒙古自治区呼和浩特市市辖区', '150101', '2020-01-10 00:00:00', '150100', '1558882222@qq.com', '$2a$10$oxp97zlAjJ/12kNxXo6sBuTv1iR6cdooL4ffE4rijpJLsA8D9w5Ve', '18500029041', '1', '150000', '', '管理员', '0', '', 'admin', '888', '', '11', null, null);
INSERT INTO `gem_user` VALUES ('29', '2020-01-06 20:58:31', '2020-01-06 22:45:15', '北京市县延庆县山西省吉林省', null, null, null, '1358882222@qq.com', '$2a$10$H86l7PrVCMDN7AfiPvsJm.NHG3OVgCoiA0nhjkToSDUx1aAB7NTPe', '18200029040', '1', null, '', '刘松', '0', '', 'liusong', '2011', '', '13', null, null);
INSERT INTO `gem_user` VALUES ('30', '2020-01-06 21:04:12', '2020-01-09 22:17:22', '北京市县延庆县山西省吉林省', null, null, null, '1344444@33', '$2a$10$WZ7JiYZKal.3AnpKnG6hQ.Q0U7DIp0BzUGyLwBP6Fewp0Xmzkgl3.', '18500029022', '1', null, '', '121212', '0', '', 'niha', '1212', '', '1', null, '2020-02-21 20:36:16');
INSERT INTO `gem_user` VALUES ('31', '2020-01-06 21:06:28', '2020-01-06 21:52:47', '北京市县延庆县山西省吉林省', null, null, null, '1338345222@qq.com', '$2a$10$.xY5qgEIuTfHq5hAoqiYxOtFMoBkn.xqeP/GjWrB7j8JXRH1L6WRa', '18200034040', '1', null, '', '赵本山', '0', '', 'zhaobens', '2011', '', '3', null, '2020-02-21 20:28:35');
INSERT INTO `gem_user` VALUES ('32', '2020-01-06 21:19:36', '2020-02-14 21:57:53', '天津市市辖区河西区', '120103', null, '120100', '112333424@33', '$2a$10$b2PYGoInsBf6WiqyqrvXGuD5ffCwmg8jKTzJaGb8qZldqJz1QSEtq', '18500029020', '1', '120000', '', '121212', '0', '', 'test', '1212', '', '1', null, '2020-02-21 20:28:38');

-- ----------------------------
-- Table structure for gem_user_depts
-- ----------------------------
DROP TABLE IF EXISTS `gem_user_depts`;
CREATE TABLE `gem_user_depts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `dept_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_user_depts
-- ----------------------------
INSERT INTO `gem_user_depts` VALUES ('16', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '2', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('17', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '3', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('18', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '4', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('19', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '6', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('20', '2020-01-03 08:24:16', '2020-01-03 08:24:16', '11', '18', null, null);
INSERT INTO `gem_user_depts` VALUES ('21', '2020-01-03 11:39:48', '2020-01-03 11:39:48', '2', '19', null, null);
INSERT INTO `gem_user_depts` VALUES ('22', '2020-01-03 11:39:48', '2020-01-03 11:39:48', '3', '19', null, null);
INSERT INTO `gem_user_depts` VALUES ('23', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '1', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('24', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '5', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('25', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '2', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('26', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '3', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('27', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '4', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('28', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '6', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('29', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '11', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('30', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '12', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('31', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '7', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('32', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '13', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('33', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '14', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('34', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '8', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('35', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '15', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('36', '2020-01-05 22:50:28', '2020-01-05 22:50:28', '10', '20', null, null);
INSERT INTO `gem_user_depts` VALUES ('37', '2020-01-05 22:51:26', '2020-01-05 22:51:26', '2', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('38', '2020-01-05 22:51:26', '2020-01-05 22:51:26', '3', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('39', '2020-01-05 22:51:26', '2020-01-05 22:51:26', '4', '21', null, null);
INSERT INTO `gem_user_depts` VALUES ('40', '2020-01-05 22:52:52', '2020-01-05 22:52:52', '2', '22', null, null);
INSERT INTO `gem_user_depts` VALUES ('41', '2020-01-05 22:52:52', '2020-01-05 22:52:52', '4', '22', null, null);
INSERT INTO `gem_user_depts` VALUES ('42', '2020-01-05 22:53:33', '2020-01-05 22:53:33', '7', '23', null, null);
INSERT INTO `gem_user_depts` VALUES ('43', '2020-01-05 22:53:33', '2020-01-05 22:53:33', '14', '23', null, null);
INSERT INTO `gem_user_depts` VALUES ('44', '2020-01-05 22:54:18', '2020-01-05 22:54:18', '2', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('45', '2020-01-05 22:54:18', '2020-01-05 22:54:18', '3', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('46', '2020-01-05 22:54:18', '2020-01-05 22:54:18', '4', '24', null, null);
INSERT INTO `gem_user_depts` VALUES ('47', '2020-01-05 22:55:00', '2020-01-05 22:55:00', '8', '25', null, null);
INSERT INTO `gem_user_depts` VALUES ('48', '2020-01-05 22:55:00', '2020-01-05 22:55:00', '15', '25', null, null);

-- ----------------------------
-- Table structure for gem_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `gem_user_roles`;
CREATE TABLE `gem_user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gem_user_roles
-- ----------------------------
INSERT INTO `gem_user_roles` VALUES ('50', '2020-01-21 13:57:53', '2020-01-21 13:57:53', '1', '24', null, null);
INSERT INTO `gem_user_roles` VALUES ('52', '2020-01-26 14:49:42', '2020-01-26 14:49:42', '1', '28', null, null);
INSERT INTO `gem_user_roles` VALUES ('56', '2020-02-14 21:57:53', '2020-02-14 21:57:53', '18', '32', null, null);
INSERT INTO `gem_user_roles` VALUES ('57', null, null, '1', '30', '2020-02-21 20:36:16', '2020-02-21 20:36:16');
INSERT INTO `gem_user_roles` VALUES ('58', null, null, '18', '30', '2020-02-21 20:36:16', '2020-02-21 20:36:16');

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
