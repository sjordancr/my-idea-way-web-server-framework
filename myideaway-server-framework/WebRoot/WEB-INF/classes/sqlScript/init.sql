/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-12-02 22:02:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `referrer` varchar(50) NOT NULL,
  `receiver` varchar(50) NOT NULL,
  `is_order_store` smallint(1) NOT NULL COMMENT '1 是 0 不是',
  `login_name` varchar(50) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `card_id` varchar(50) NOT NULL,
  `account_bank` varchar(100) DEFAULT NULL,
  `bank_card_code` varchar(20) DEFAULT NULL,
  `bank_province` int(11) DEFAULT NULL,
  `bank_city` int(11) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `detail_addres` varchar(100) DEFAULT NULL,
  `is_check_cash` int(11) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `store_agent_address` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `remit_account` varchar(50) DEFAULT NULL,
  `remit_account_bank` varchar(50) DEFAULT NULL,
  `remit_datetime` datetime DEFAULT NULL,
  `remit_peple` varchar(20) DEFAULT NULL,
  `remit_money` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('24', 'admin', 'admin', '0', 'admin', '管理员', '123123123123123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('27', 'admin', 'asdf', '0', '11111', '1', '1111111111111111111', '111111111', '11111111111', '1', '1', '11111111111', '1111111111111', '0', '', '', '111111@111.com', '', '', '2012-12-12 00:00:00', null, '1111');
INSERT INTO `t_member` VALUES ('28', 'admin', '22222', '0', '2222', '22222', '2222222222222', '22222222', '222222222222222', '2', '1', '010-2938473', '22222', '0', '22222222', '222222', '2222222@123.com', '', '', '2012-12-12 00:00:00', null, '22222');

-- ----------------------------
-- Table structure for `t_member_tree`
-- ----------------------------
DROP TABLE IF EXISTS `t_member_tree`;
CREATE TABLE `t_member_tree` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `isChecked` tinyint(3) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member_tree
-- ----------------------------
INSERT INTO `t_member_tree` VALUES ('24', '0', 'admin', '000');
INSERT INTO `t_member_tree` VALUES ('27', '24', '11111', '000');
INSERT INTO `t_member_tree` VALUES ('28', '24', '2222', '000');

-- ----------------------------
-- Table structure for `t_peple_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_peple_info`;
CREATE TABLE `t_peple_info` (
  `t_peple_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `connect_peple` bigint(20) NOT NULL,
  `own_money` decimal(10,2) NOT NULL,
  `own_peple` tinyint(4) NOT NULL,
  `pay_money` decimal(10,2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_peple_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_peple_info
-- ----------------------------
INSERT INTO `t_peple_info` VALUES ('1', '王伟鹏', '0', '100.00', '0', '100.20', null, '111111');
INSERT INTO `t_peple_info` VALUES ('2', 'aaa', '1', '0.00', '0', '100.00', null, '111111');

DROP TABLE IF EXISTS `t_peple_info`;
CREATE TABLE `t_peple_info` (
  `t_peple_info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `connect_peple` bigint(20) NOT NULL,
  `own_money` decimal(10,2) NOT NULL,
  `own_peple` tinyint(4) NOT NULL,
  `pay_money` decimal(10,2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_peple_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_peple_info
-- ----------------------------
INSERT INTO `t_peple_info` VALUES ('1', '王伟鹏', '0', '100.00', '0', '100.20', null, '111111');
INSERT INTO `t_peple_info` VALUES ('2', 'aaa', '1', '0.00', '0', '100.00', null, '111111');
