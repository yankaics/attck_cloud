/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : attck_cloud

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-01-22 19:08:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attck_diction
-- ----------------------------
DROP TABLE IF EXISTS `attck_diction`;
CREATE TABLE `attck_diction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_path` text,
  `type` int(2) DEFAULT NULL COMMENT '1 web字典 2',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_diction
-- ----------------------------
INSERT INTO `attck_diction` VALUES ('1', '/admin,/admin.php,/static,/test,/static,/adminaa,/123456789,/abcd', '1', '2016-01-22 14:06:47');

-- ----------------------------
-- Table structure for attck_scan_port
-- ----------------------------
DROP TABLE IF EXISTS `attck_scan_port`;
CREATE TABLE `attck_scan_port` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `port` text,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_scan_port
-- ----------------------------

-- ----------------------------
-- Table structure for attck_scan_web
-- ----------------------------
DROP TABLE IF EXISTS `attck_scan_web`;
CREATE TABLE `attck_scan_web` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `url_path` text,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_scan_web
-- ----------------------------
INSERT INTO `attck_scan_web` VALUES ('2', '1', 'http://www.atool.org/', '', '2016-01-22 14:29:39');

-- ----------------------------
-- Table structure for attck_user
-- ----------------------------
DROP TABLE IF EXISTS `attck_user`;
CREATE TABLE `attck_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `passwd` varchar(32) DEFAULT NULL,
  `nikeName` varchar(12) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_user
-- ----------------------------
INSERT INTO `attck_user` VALUES ('1', 'test@test.com', '098f6bcd4621d373cade4e832627b4f6', '小A', '1', '1', '2016-01-14 22:00:21');
