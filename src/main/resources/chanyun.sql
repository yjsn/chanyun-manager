/*
Navicat MySQL Data Transfer

Source Server         : chanyun
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : chanyun

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-16 18:41:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_index_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_index_banner`;
CREATE TABLE `tb_index_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `img_url` varchar(100) NOT NULL COMMENT '图片路径',
  `img_description` varchar(500) NOT NULL COMMENT '描述',
  `img_link` varchar(100) NOT NULL COMMENT '链接',
  `sort` int(2) NOT NULL COMMENT '排序',
  `status` int(2) NOT NULL COMMENT '状态 0 启用 1禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_index_banner
-- ----------------------------
INSERT INTO `tb_index_banner` VALUES ('1', '/usr/img', '测试banner1', 'https://www.baidu.com/', '1', '0', '2018-09-16 18:08:01');

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `level` int(2) DEFAULT NULL COMMENT '菜单级数，父级为1',
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1705032710 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', 'menu-plugin', '系统菜单', '0', null, null, '-1');
INSERT INTO `tb_menu` VALUES ('10', '&#xe68e;', '内容管理', '0', null, null, '1');
INSERT INTO `tb_menu` VALUES ('60', '&#xe631;', '系统管理', '0', null, null, '1');
INSERT INTO `tb_menu` VALUES ('61', '&#xe705;', '新闻资讯', '0', 'http://www.ifeng.com/', null, '1');
INSERT INTO `tb_menu` VALUES ('1000', 'icon-text', '文章管理', '1', 'https://www.hongxiu.com/', null, '10');
INSERT INTO `tb_menu` VALUES ('6000', '&#xe631;', '菜单管理', '1', 'admin/menu/tomunemanage', null, '60');
INSERT INTO `tb_menu` VALUES ('6010', 'icon-icon10', '角色管理', '1', 'admin/role/torolemanage', null, '60');
INSERT INTO `tb_menu` VALUES ('6020', '&#xe612;', '用户管理', '1', 'admin/user/tousermanage', null, '60');
INSERT INTO `tb_menu` VALUES ('6030', '&#xe631;', 'sql监控', '1', 'druid/index.html', null, '60');
INSERT INTO `tb_menu` VALUES ('6040', 'icon-ziliao', '修改密码', '1', 'admin/user/toUpdatePassword', null, '60');
INSERT INTO `tb_menu` VALUES ('6050', 'icon-tuichu', '安全退出', '1', 'user/logout', null, '60');
INSERT INTO `tb_menu` VALUES ('6100', 'icon-text', '玉佛禅寺', '0', 'http://www.yufotemple.com/', null, '61');
INSERT INTO `tb_menu` VALUES ('1705032705', 'testIcon', '商户管理', '0', '/api/merchant/query', null, '1');
INSERT INTO `tb_menu` VALUES ('1705032706', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `tb_menu` VALUES ('1705032707', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `tb_menu` VALUES ('1705032708', 'string', 'string', '0', 'string', null, '0');
INSERT INTO `tb_menu` VALUES ('1705032709', 'string', 'string', '0', 'string', null, '0');

-- ----------------------------
-- Table structure for tb_merchant_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_merchant_account`;
CREATE TABLE `tb_merchant_account` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_number` varchar(50) NOT NULL COMMENT '账号',
  `account_password` varchar(50) NOT NULL COMMENT '账号密码',
  `account_name` varchar(200) NOT NULL COMMENT '账号名称',
  `temple_id` int(11) NOT NULL,
  `status` int(2) NOT NULL COMMENT '状态 0启用 1禁用  99删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_merchant_account
-- ----------------------------
INSERT INTO `tb_merchant_account` VALUES ('00000000001', 'admin', '123456', '超级管理员', '0', '0', '超级管理员账号', '2018-09-12 12:12:34');
INSERT INTO `tb_merchant_account` VALUES ('00000000002', 'test', 'e10adc3949ba59abbe56e057f20f883e', '测试用户', '0', '0', '测试用户', '2018-09-12 16:15:27');

-- ----------------------------
-- Table structure for tb_merchant_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_merchant_role`;
CREATE TABLE `tb_merchant_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `merchant_id` int(11) DEFAULT NULL COMMENT '商户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_merchant_role
-- ----------------------------
INSERT INTO `tb_merchant_role` VALUES ('1', '1', '1');
INSERT INTO `tb_merchant_role` VALUES ('19', '2', '2');
INSERT INTO `tb_merchant_role` VALUES ('20', '4', '2');
INSERT INTO `tb_merchant_role` VALUES ('21', '5', '2');
INSERT INTO `tb_merchant_role` VALUES ('28', '2', '3');
INSERT INTO `tb_merchant_role` VALUES ('29', '4', '3');
INSERT INTO `tb_merchant_role` VALUES ('30', '5', '3');
INSERT INTO `tb_merchant_role` VALUES ('31', '7', '3');
INSERT INTO `tb_merchant_role` VALUES ('49', '15', '5');
INSERT INTO `tb_merchant_role` VALUES ('50', '1', '5');

-- ----------------------------
-- Table structure for tb_merits
-- ----------------------------
DROP TABLE IF EXISTS `tb_merits`;
CREATE TABLE `tb_merits` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `merits_number` varchar(20) DEFAULT NULL COMMENT '功德编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `customer_name` varchar(100) DEFAULT NULL COMMENT '功德人姓名',
  `customer_year` int(4) DEFAULT NULL COMMENT '功德人年龄-年',
  `customer_month` int(2) DEFAULT NULL COMMENT '功德人年龄-月',
  `customer_day` int(2) DEFAULT NULL COMMENT '功德人年龄-天',
  `customer_hour` varchar(255) DEFAULT NULL COMMENT '功德人年龄-时',
  `customer_address_province` varchar(255) DEFAULT NULL COMMENT '功德人地址-省',
  `customer_address_city` varchar(255) DEFAULT NULL COMMENT '功德人地址-市',
  `customer_address_area` varchar(255) DEFAULT NULL COMMENT '功德人地址-区/县',
  `customer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '功德人地址-街道详细地址',
  `merits_type` int(11) DEFAULT NULL COMMENT '功德类型',
  `merits_name` varchar(255) DEFAULT NULL COMMENT '功德名称',
  `merits_account` int(11) DEFAULT NULL COMMENT '功德数量',
  `temple_id` int(11) DEFAULT NULL COMMENT '寺庙id',
  `god_name` varchar(255) DEFAULT NULL COMMENT '菩萨名称',
  `temple_house_name` varchar(255) DEFAULT NULL COMMENT '寺庙殿名',
  `merits_status` int(2) DEFAULT NULL COMMENT '功德事件状态 0 申请 1未支付 2进行中 3完成 4未完成 5退款 9异常',
  `apply_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `completion_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '完成时间',
  `var1` varchar(255) DEFAULT NULL COMMENT '预留字段1',
  `var2` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_merits
-- ----------------------------
INSERT INTO `tb_merits` VALUES ('00000000001', 'GD201809161455000001', '1', '张三', '1980', '2', '28', '14', '上海', '上海', '浦东新区', '惠南镇城西路118号', '2', '请平安香', '18', '1', '观音大士', '圆通宝殿', '1', '2018-09-16 14:57:08', '2018-09-17 14:57:13', null, null);

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `news_title` varchar(50) NOT NULL COMMENT '资讯标题',
  `news_description` varchar(200) NOT NULL COMMENT '资讯描述',
  `news_content` longtext NOT NULL COMMENT '资讯内容',
  `news_keywords` varchar(200) NOT NULL COMMENT '资讯关键字',
  `news_type` int(1) NOT NULL COMMENT '资讯类型 0佛门动态 1政策法规 2佛学入门 3 法会信息',
  `news_img` varchar(50) NOT NULL COMMENT '资讯封面',
  `news_sort` int(2) NOT NULL COMMENT '资讯首页排序',
  `news_status` int(2) NOT NULL COMMENT '资讯状态 0启用 1禁用',
  `news_recommend` int(2) NOT NULL COMMENT '资讯首页推荐 0推荐 1不推荐 默认不推荐',
  `news_templeid` int(11) NOT NULL COMMENT '寺庙id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `news_source` varchar(50) NOT NULL COMMENT '资讯来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(2) NOT NULL COMMENT '状态 0启用 1禁用',
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '0', '管理员', null);
INSERT INTO `tb_role` VALUES ('2', '0', '主管', null);
INSERT INTO `tb_role` VALUES ('4', '0', '采购员', null);
INSERT INTO `tb_role` VALUES ('5', '0', '销售经理', '22');
INSERT INTO `tb_role` VALUES ('7', '0', '仓库管理员', null);
INSERT INTO `tb_role` VALUES ('9', '0', '总经理', null);
INSERT INTO `tb_role` VALUES ('15', '0', '111111', null);
INSERT INTO `tb_role` VALUES ('16', '0', '222222', null);
INSERT INTO `tb_role` VALUES ('17', '0', '修改测试', 'test');
INSERT INTO `tb_role` VALUES ('18', '0', '444444', null);
INSERT INTO `tb_role` VALUES ('19', '0', '555555', null);
INSERT INTO `tb_role` VALUES ('20', '0', '666666', null);
INSERT INTO `tb_role` VALUES ('21', '0', '超级管理员', 'superadmin');

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
INSERT INTO `tb_role_menu` VALUES ('36', '10', '2');
INSERT INTO `tb_role_menu` VALUES ('42', '1', '2');
INSERT INTO `tb_role_menu` VALUES ('45', '1', '4');
INSERT INTO `tb_role_menu` VALUES ('48', '1', '5');
INSERT INTO `tb_role_menu` VALUES ('55', '1', '9');
INSERT INTO `tb_role_menu` VALUES ('65', '1', '7');
INSERT INTO `tb_role_menu` VALUES ('66', '10', '7');
INSERT INTO `tb_role_menu` VALUES ('126', '60', '15');
INSERT INTO `tb_role_menu` VALUES ('127', '6010', '15');
INSERT INTO `tb_role_menu` VALUES ('128', '6020', '15');
INSERT INTO `tb_role_menu` VALUES ('129', '6030', '15');
INSERT INTO `tb_role_menu` VALUES ('130', '6040', '15');
INSERT INTO `tb_role_menu` VALUES ('131', '6050', '15');
INSERT INTO `tb_role_menu` VALUES ('248', '2000', '1');
INSERT INTO `tb_role_menu` VALUES ('259', '100000', '1');
INSERT INTO `tb_role_menu` VALUES ('278', '10', '1');
INSERT INTO `tb_role_menu` VALUES ('279', '1000', '1');
INSERT INTO `tb_role_menu` VALUES ('280', '60', '1');
INSERT INTO `tb_role_menu` VALUES ('281', '6000', '1');
INSERT INTO `tb_role_menu` VALUES ('282', '6010', '1');
INSERT INTO `tb_role_menu` VALUES ('283', '6020', '1');
INSERT INTO `tb_role_menu` VALUES ('284', '6030', '1');
INSERT INTO `tb_role_menu` VALUES ('285', '6040', '1');
INSERT INTO `tb_role_menu` VALUES ('286', '6050', '1');
INSERT INTO `tb_role_menu` VALUES ('287', '61', '1');
INSERT INTO `tb_role_menu` VALUES ('288', '6100', '1');

-- ----------------------------
-- Table structure for tb_temple
-- ----------------------------
DROP TABLE IF EXISTS `tb_temple`;
CREATE TABLE `tb_temple` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `temple_number` varchar(10) NOT NULL COMMENT '寺庙编号',
  `temple_name` varchar(50) NOT NULL COMMENT '寺庙名称',
  `temple_province` varchar(50) DEFAULT NULL COMMENT '寺庙所在省',
  `temple_city` varchar(50) DEFAULT NULL COMMENT '寺庙所在市',
  `temple_county` varchar(50) DEFAULT NULL COMMENT '寺庙所在区/县',
  `temple_address` varchar(200) DEFAULT NULL COMMENT '寺庙详细地址',
  `status` int(2) DEFAULT NULL COMMENT '状态 0 申请 1启用 2禁用 3申请未通过 4异常',
  `temple_contact_name` varchar(50) DEFAULT NULL COMMENT '寺庙联系人姓名',
  `temple_contact_tel` varchar(20) DEFAULT NULL COMMENT '寺庙联系人电话',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '寺庙申请时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_temple
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_account` varchar(50) DEFAULT NULL COMMENT '用户登陆帐号',
  `user_password` varchar(50) DEFAULT NULL COMMENT '登陆密码',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户手机号',
  `webchat_id` varchar(100) DEFAULT NULL COMMENT '微信授权id',
  `merits_account` int(11) DEFAULT NULL COMMENT '用户总功能数',
  `merits_self_account` int(11) DEFAULT NULL COMMENT '用户本身总功德数',
  `regist_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户注册时间',
  `last_login_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户最后一次登陆时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '管理员', '1', '赵佳涛', 'admin', '1', null, null, null, null);
INSERT INTO `tb_user` VALUES ('2', '主管', '123', '王大锤', 'jack', '2', null, null, null, null);
INSERT INTO `tb_user` VALUES ('3', '销售经理', '123', '玛丽', 'marry', '33', null, null, null, null);
INSERT INTO `tb_user` VALUES ('5', '1', '111111', '1', '111111', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('6', '2', '222222', '2', '222222', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('7', '3', '333333', '3', '333333', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('8', '', '444444', '44', '444444', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('9', '5', '555555', '5', '555555', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('11', '7', '777777', '7', '777777', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('12', '88', '888888', '88', '888888', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('13', '9', '999999', '9', '999999', null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('14', '121212', '121212', '121212', '121212', null, null, null, null, null);
