/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : lvyou

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-11-27 19:22:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ly_advice`
-- ----------------------------
DROP TABLE IF EXISTS `ly_advice`;
CREATE TABLE `ly_advice` (
  `id` varchar(50) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  `versionNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7tewx0kasbhtc00tisqlr61no` (`guest_id`),
  KEY `FKsir3gtq4rumfub2qd9ruf6eog` (`site_id`),
  CONSTRAINT `FK7tewx0kasbhtc00tisqlr61no` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKsir3gtq4rumfub2qd9ruf6eog` FOREIGN KEY (`site_id`) REFERENCES `ly_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_advice
-- ----------------------------

-- ----------------------------
-- Table structure for `ly_comment`
-- ----------------------------
DROP TABLE IF EXISTS `ly_comment`;
CREATE TABLE `ly_comment` (
  `id` varchar(50) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnxr79t7laacjk9mqms0o5x38p` (`guest_id`),
  KEY `FKpd7dv2eikomxu20tca1719wy0` (`site_id`),
  CONSTRAINT `FKnxr79t7laacjk9mqms0o5x38p` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKpd7dv2eikomxu20tca1719wy0` FOREIGN KEY (`site_id`) REFERENCES `ly_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `ly_employee`
-- ----------------------------
DROP TABLE IF EXISTS `ly_employee`;
CREATE TABLE `ly_employee` (
  `id` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `position` varchar(2) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `employName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj3v9nsr72ajndvxi2k3whdhsn` (`user_id`),
  KEY `FK8rnql7iitnwsckxncw43acb04` (`scene_id`),
  CONSTRAINT `FK8rnql7iitnwsckxncw43acb04` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`),
  CONSTRAINT `FKj3v9nsr72ajndvxi2k3whdhsn` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_employee
-- ----------------------------
INSERT INTO `ly_employee` VALUES ('emp02', null, null, null, '123444', null, null, null, '1', 'sc1', 'e1641b63-e4bc-448d-bb5b-5c338e491270', '猴子02');

-- ----------------------------
-- Table structure for `ly_guest`
-- ----------------------------
DROP TABLE IF EXISTS `ly_guest`;
CREATE TABLE `ly_guest` (
  `id` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs0vnvdwb1o3yiyl2a2hxe1v` (`user_id`),
  CONSTRAINT `FKs0vnvdwb1o3yiyl2a2hxe1v` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_guest
-- ----------------------------
INSERT INTO `ly_guest` VALUES ('1', '2017-11-16', null, '17828425537', '王五', '1', '4ecbbae7-35b9-4a48-b7cd-807b80a3fd9e');

-- ----------------------------
-- Table structure for `ly_scene`
-- ----------------------------
DROP TABLE IF EXISTS `ly_scene`;
CREATE TABLE `ly_scene` (
  `id` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `open` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_scene
-- ----------------------------
INSERT INTO `ly_scene` VALUES ('sc-jpa-1', null, null, null, '华山', '1', null);
INSERT INTO `ly_scene` VALUES ('sc-jpa-3', null, null, null, '华山33', '1', null);
INSERT INTO `ly_scene` VALUES ('sc1', null, null, null, '峨眉山', '1', null);

-- ----------------------------
-- Table structure for `ly_site`
-- ----------------------------
DROP TABLE IF EXISTS `ly_site`;
CREATE TABLE `ly_site` (
  `id` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `open` varchar(1) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `siteImage` varchar(200) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdq5cucujm5oal21v0qlw1qqng` (`scene_id`),
  CONSTRAINT `FKdq5cucujm5oal21v0qlw1qqng` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_site
-- ----------------------------
INSERT INTO `ly_site` VALUES ('site-jpa-3', null, '思过崖', '0', null, null, 'sc-jpa-3');
INSERT INTO `ly_site` VALUES ('site1', null, '长寿寺', '1', null, null, 'sc1');

-- ----------------------------
-- Table structure for `ly_ticketrecord`
-- ----------------------------
DROP TABLE IF EXISTS `ly_ticketrecord`;
CREATE TABLE `ly_ticketrecord` (
  `id` varchar(50) NOT NULL,
  `instruction` varchar(200) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `tickettype_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2myfnoeudfur1prlpbguolrca` (`employee_id`),
  KEY `FK8ikidcbhcryi763y1ox09udax` (`guest_id`),
  KEY `FKd5ajct54hwd2yx26gb3qja3yo` (`tickettype_id`),
  CONSTRAINT `FK2myfnoeudfur1prlpbguolrca` FOREIGN KEY (`employee_id`) REFERENCES `ly_employee` (`id`),
  CONSTRAINT `FK8ikidcbhcryi763y1ox09udax` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKd5ajct54hwd2yx26gb3qja3yo` FOREIGN KEY (`tickettype_id`) REFERENCES `ly_tickettype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_ticketrecord
-- ----------------------------
INSERT INTO `ly_ticketrecord` VALUES ('1', '逛成都', '2017-11-20', 'emp02', '1', '1');

-- ----------------------------
-- Table structure for `ly_tickettype`
-- ----------------------------
DROP TABLE IF EXISTS `ly_tickettype`;
CREATE TABLE `ly_tickettype` (
  `id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKclit0c12yo0weynmokc33rvti` (`scene_id`),
  CONSTRAINT `FKclit0c12yo0weynmokc33rvti` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_tickettype
-- ----------------------------
INSERT INTO `ly_tickettype` VALUES ('1', '哈哈哈', '100', 'sc1');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  `no` varchar(30) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2jrf4gb0gjqi8882gxytpxnhe` (`parent_id`),
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'icon-cogs', '系统管理', '', null, '01', '1');
INSERT INTO `sys_menu` VALUES ('2', 'icon-bank', '景区管理', '', null, '02', '2');
INSERT INTO `sys_menu` VALUES ('advice', 'icon-asterisk', '投诉建议', 'ly/advice/list', '2', '0206', '26');
INSERT INTO `sys_menu` VALUES ('comment', 'icon-asterisk', '评论', 'ly/comment/list', '2', '0207', '27');
INSERT INTO `sys_menu` VALUES ('employee', 'icon-user', '工作人员', 'ly/employee/list', '2', '0204', '24');
INSERT INTO `sys_menu` VALUES ('guest', 'icon-user', '游客', 'ly/guest/list', '2', '0208', '28');
INSERT INTO `sys_menu` VALUES ('menu', 'icon-user', '菜单', 'sys/menu/list', '1', '0101', '11');
INSERT INTO `sys_menu` VALUES ('role', 'icon-asterisk', '角色', 'sys/role/list', '1', '0103', '13');
INSERT INTO `sys_menu` VALUES ('scene', 'icon-asterisk', '景区', 'ly/scene/list', '2', '0201', '21');
INSERT INTO `sys_menu` VALUES ('site', 'icon-bars', '景点', 'ly/site/list', '2', '0202', '22');
INSERT INTO `sys_menu` VALUES ('ticketrecord', 'icon-asterisk', '购票记录', 'ly/ticketrecord/list', '2', '0205', '25');
INSERT INTO `sys_menu` VALUES ('tickettype', 'icon-asterisk', '票类型', 'ly/tickettype/list', '2', '0203', '23');
INSERT INTO `sys_menu` VALUES ('user', 'icon-asterisk', '用户', 'sys/user/list', '1', '0102', '12');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('admin', '具有最高权限', '系统管理员');
INSERT INTO `sys_role` VALUES ('employee', '工作人员可以管理景区所有数据', '工作人员');
INSERT INTO `sys_role` VALUES ('guest', '仅查看购票记录、景区、景点信息', '游客');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(50) NOT NULL,
  `menu_id` varchar(50) NOT NULL,
  KEY `FKf3mud4qoc7ayew8nml4plkevo` (`menu_id`),
  KEY `FKkeitxsgxwayackgqllio4ohn5` (`role_id`),
  CONSTRAINT `FKf3mud4qoc7ayew8nml4plkevo` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `FKkeitxsgxwayackgqllio4ohn5` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('employee', '2');
INSERT INTO `sys_role_menu` VALUES ('employee', 'scene');
INSERT INTO `sys_role_menu` VALUES ('employee', 'site');
INSERT INTO `sys_role_menu` VALUES ('employee', 'tickettype');
INSERT INTO `sys_role_menu` VALUES ('employee', 'employee');
INSERT INTO `sys_role_menu` VALUES ('employee', 'ticketrecord');
INSERT INTO `sys_role_menu` VALUES ('employee', 'advice');
INSERT INTO `sys_role_menu` VALUES ('employee', 'comment');
INSERT INTO `sys_role_menu` VALUES ('guest', '2');
INSERT INTO `sys_role_menu` VALUES ('guest', 'scene');
INSERT INTO `sys_role_menu` VALUES ('guest', 'site');
INSERT INTO `sys_role_menu` VALUES ('guest', 'tickettype');
INSERT INTO `sys_role_menu` VALUES ('guest', 'ticketrecord');
INSERT INTO `sys_role_menu` VALUES ('guest', 'advice');
INSERT INTO `sys_role_menu` VALUES ('guest', 'comment');
INSERT INTO `sys_role_menu` VALUES ('guest', 'guest');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2n5scdnrxopq9btfgbqwlxdxy` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', null, '2017-10-30 11:08:56');
INSERT INTO `sys_user` VALUES ('4ecbbae7-35b9-4a48-b7cd-807b80a3fd9e', '17828425537', '123456', null, '2017-11-20 11:08:40');
INSERT INTO `sys_user` VALUES ('e1641b63-e4bc-448d-bb5b-5c338e491270', '123444', '123456', null, null);
