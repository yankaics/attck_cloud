/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : attck_cloud

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2016-01-15 09:04:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attck_scan_port`
-- ----------------------------
DROP TABLE IF EXISTS `attck_scan_port`;
CREATE TABLE `attck_scan_port` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `ip` varchar(255) default NULL,
  `port` text,
  `create_time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_scan_port
-- ----------------------------
INSERT INTO `attck_scan_port` VALUES ('1', '1', '123.57.37.131', '3306', '2016-01-14 22:44:46');
INSERT INTO `attck_scan_port` VALUES ('2', '1', '123.57.37.131', '80,8081', '2016-01-14 22:44:47');
INSERT INTO `attck_scan_port` VALUES ('3', '1', '182.92.78.113', '3306, 8080, 3306', '2016-01-14 22:44:48');
INSERT INTO `attck_scan_port` VALUES ('4', '1', '182.92.184.249', '8080, 22', '2016-01-14 22:51:47');
INSERT INTO `attck_scan_port` VALUES ('5', '1', '115.239.211.112', '80', '2016-01-14 23:21:00');
INSERT INTO `attck_scan_port` VALUES ('6', '1', '115.239.211.112', '80', '2016-01-14 23:22:56');

-- ----------------------------
-- Table structure for `attck_user`
-- ----------------------------
DROP TABLE IF EXISTS `attck_user`;
CREATE TABLE `attck_user` (
  `id` int(11) NOT NULL auto_increment,
  `account` varchar(255) default NULL,
  `passwd` varchar(32) default NULL,
  `nikeName` varchar(12) default NULL,
  `type` int(2) default NULL,
  `status` int(2) default NULL,
  `create_time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attck_user
-- ----------------------------
INSERT INTO `attck_user` VALUES ('1', 'test@test.com', '098f6bcd4621d373cade4e832627b4f6', '小A', '1', '1', '2016-01-14 22:00:21');
