/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2012-12-04 00:04:11
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('24', 'admin', 'admin', '0', 'admin', '管理员', '123123123123123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_member` VALUES ('27', 'admin', 'asdf', '0', '11111', '1', '1111111111111111111', '111111111', '11111111111', '1', '1', '11111111111', '1111111111111', '0', '', '', '111111@111.com', '', '', '2012-12-12 00:00:00', null, '1111');
INSERT INTO `t_member` VALUES ('28', 'admin', '22222', '0', '2222', '22222', '2222222222222', '22222222', '222222222222222', '2', '1', '010-2938473', '22222', '0', '22222222', '222222', '2222222@123.com', '', '', '2012-12-12 00:00:00', null, '22222');
INSERT INTO `t_member` VALUES ('29', '11111', '123123', '0', 'dsafasa', '王伟鹏', '1231231231231231', '阿斯顿发骚的', '111111111111', '1', '2', '010-2938471', '阿斯蒂芬', '0', '', '', '1231231@123.com', '', '', '2012-12-12 00:00:00', null, '2000');
INSERT INTO `t_member` VALUES ('30', '11111', '123123', '0', '1', '1', '1111111111111', '阿斯顿发骚的', '1111111111111', '1', '1', '010-2938471', '陕西省西安市', '0', '', '', '1111111@111.com', '', '', '2012-12-12 00:00:00', null, '11111');
INSERT INTO `t_member` VALUES ('31', '2222', '123123', '0', '5', '5', '555555555555555', '555555555555', '55555555555555555', '1', '1', '010-2938475', '陕西省西安市', '0', '', '', '5555555@123.com', '', '', '2012-12-12 00:00:00', null, '5555');
INSERT INTO `t_member` VALUES ('32', '2222', '123123', '0', '6', '6', '666666666666', '阿斯顿发骚的', '66666666666', '6', '6', '010-2938466', '6666666666', '0', '', '', '66666@123.com', '', '', '2012-12-12 00:00:00', null, '6666');
INSERT INTO `t_member` VALUES ('33', 'dsafasa', '123123', '0', '7', '7', '7777777777777', '阿斯顿发骚的', '77777777777777', '7', '7', '010-2938477', '77777777777777', '0', '', '', '7777777@123.com', '', '', '2012-12-12 00:00:00', null, '77777');
INSERT INTO `t_member` VALUES ('34', 'dsafasa', '123123', '0', '8', '8', '888888888888888', '阿斯顿发骚的', '88888888888888', '8', '8', '010-2938478', '888888888', '0', '', '', '888888@123.com', '', '', '2012-12-12 00:00:00', null, '8888');
INSERT INTO `t_member` VALUES ('35', '1', '9', '0', '9', '9', '999999999999', '阿斯顿发骚的', '99999999999', '9', '9', '010-2938479', '9999999', '0', '9999999', '', '9999999999@123.com', '', '', '2012-12-12 00:00:00', null, '9999');
INSERT INTO `t_member` VALUES ('36', '1', '10', '0', '10', '10', '111111111111000', '阿斯顿发骚的', '1010101010010101', '1', '1', '010-2938410', '1111111111111111', '0', '', '', '123123233@123.com', '', '', '2012-12-12 00:00:00', null, '100001');
INSERT INTO `t_member` VALUES ('37', '5', '11', '0', '11', '11', '111111111111111', '阿斯顿发骚的', '1111111111111111', '1', '1', '010-2938411', '阿斯蒂芬', '0', '111111111111', '1', '111111111111@111.com', '', '', '2012-12-12 00:00:00', null, '111111');
INSERT INTO `t_member` VALUES ('38', '5', '123123', '0', '12', '12', '121212121212', '阿斯顿发骚的', '121212121212', '1', '2', '010-2938412', '阿斯蒂芬', '0', '', '', '1212121212@12.com', '2', '', '2012-12-12 00:00:00', null, '22121');
INSERT INTO `t_member` VALUES ('39', '6', '123123', '0', '13', '123', '1313131313', '13131313', '131313131313', '1', '3', '010-29384713', '1313', '0', '', '', '1313131313@13.com', '', '', '2012-12-12 00:00:00', null, '13131');
INSERT INTO `t_member` VALUES ('40', '6', '123123', '0', '14', '14', '141414141414', '阿斯顿发骚的', '1313144114141', '1', '4', '010-2938414', '阿斯蒂芬', '0', '', '', '141414141414@14.com', '', '', '2012-12-12 00:00:00', null, '141414');
INSERT INTO `t_member` VALUES ('41', '7', '123123', '0', '15', '15', '1515151515151515', '阿斯顿发骚的', '1555555555555111', '1', '1', '010-2938415', '15151515', '0', '', '', '11111123@111.com', '', '', '2012-12-12 00:00:00', null, '141515');
INSERT INTO `t_member` VALUES ('42', '7', '123123', '0', '16', '16', '116616161616', '阿斯顿发骚的', '111111111111111166', '1', '6', '010-29384716', '阿斯蒂芬', '0', '', '', '11111166666@111.com', '', '', '2012-12-12 00:00:00', null, '114');
INSERT INTO `t_member` VALUES ('43', '8', '123123', '0', '17', '17', '17', '17', '1717171717171717', '1', '1', '010-29384177', '171717', '0', '', '', '17@17.com', '', '', '2012-12-12 00:00:00', null, '171717');
INSERT INTO `t_member` VALUES ('44', '8', '123123', '0', '18', '18', '1818181818181818', '1818181818181818', '181818181818', '1', '1', '010-2938418', '阿斯蒂芬', '0', '', '', '1818181818@18.com', '', '', '2012-12-12 00:00:00', null, '181818');
INSERT INTO `t_member` VALUES ('45', '9', '123123', '0', '19', '19', '19191919191919', '1919191919', '1919191919191', '11', '1', '010-2938419', '19191919', '0', '', '', '1919191919@19.com', '', '', '2012-12-12 00:00:00', null, '1919');
INSERT INTO `t_member` VALUES ('46', '9', '123123', '0', '20', '20', '20202020202020', '阿斯顿发骚的', '2020202020202020', '1', '2', '010-2938420', '20202020', '0', '', '', '2020202020@20.com', '', '', '2012-12-12 00:00:00', null, '202020');
INSERT INTO `t_member` VALUES ('47', '10', 'asdf', '0', '21', '21', '212121212121212121', '阿斯顿发骚的', '212121212121212121', '1', '1', '010-2938421', '21212121212121', '0', '', '', '212121212121@21.com', '', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('48', '10', '123123', '0', '22', '22', '22222222222222222', '222222222222', '222222222222222222', '1', '22', '010-2938422', '222222222222', '0', '', '', '2222222222@123.com', '', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('49', '11', '123123', '0', '23', '23', '23', '23232323', '23232323232323', '1', '2', '010-2938423', '232323232323', '0', '', '', '12312323@123.com', '', '', '2012-12-12 00:00:00', null, '232323');
INSERT INTO `t_member` VALUES ('50', '11', 'asdfsadf', '0', '25', '25', '25252525', '阿斯顿发骚的', '25252525252525', '1', '2', '010-29384725', '阿斯蒂芬', '0', '', '', '252525252525@25.com', '', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('51', '12', '25', '0', '26', '26', '262626262626', '阿斯顿发骚的', '26262626262626', '1', '1', '010-2938426', '262626262626', '0', '', '', '26262626@123.com', '', '', '2012-12-12 00:00:00', null, '26262600');
INSERT INTO `t_member` VALUES ('52', '12', 'asdf', '0', '27', '27', '27272727', '27272727', '2727272727', '1', '1', '010-2938427', '阿斯蒂芬', '0', '', '', '2727272727272727@d.com', '', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('53', '13', 'asdf', '0', '28', '28', '2828282828', '阿斯顿发骚的', '11111111111282828', '1', '1', '010-2938428', '28282828', '0', '', '', '28282828@28.com', '1', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('54', '13', '123123', '0', '29', '29', '2929292929', '阿斯顿发骚的', '29292929292929', '2', '1', '11111111111', '29292929', '0', '', '', '1111112929@111.com', '', '', '2012-12-12 00:00:00', null, '1000');
INSERT INTO `t_member` VALUES ('55', '14', 'asdf', '0', '30', '30', '30303030303030', '111111111', '3030303030303030', '1', '1', '010-2938430', '303030303030', '0', '', '', '30@111.com', '', '', '2010-12-23 12:12:21', null, '1000');
INSERT INTO `t_member` VALUES ('56', '14', 'asdf', '0', '31', '31', '3131313131313131', '111111111', '1231231233131313131', '2', '1', '010-2938431', '阿斯蒂芬', '0', '', '', '11311111@111.com', '', '', '2012-12-12 00:00:00', null, '31313100');

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
INSERT INTO `t_member_tree` VALUES ('29', '27', 'dsafasa', '000');
INSERT INTO `t_member_tree` VALUES ('30', '27', '1', '000');
INSERT INTO `t_member_tree` VALUES ('31', '28', '5', '000');
INSERT INTO `t_member_tree` VALUES ('32', '28', '6', '000');
INSERT INTO `t_member_tree` VALUES ('33', '29', '7', '000');
INSERT INTO `t_member_tree` VALUES ('34', '29', '8', '000');
INSERT INTO `t_member_tree` VALUES ('35', '30', '9', '000');
INSERT INTO `t_member_tree` VALUES ('36', '30', '10', '000');
INSERT INTO `t_member_tree` VALUES ('37', '31', '11', '000');
INSERT INTO `t_member_tree` VALUES ('38', '31', '12', '000');
INSERT INTO `t_member_tree` VALUES ('39', '32', '13', '000');
INSERT INTO `t_member_tree` VALUES ('40', '32', '14', '000');
INSERT INTO `t_member_tree` VALUES ('41', '33', '15', '000');
INSERT INTO `t_member_tree` VALUES ('42', '33', '16', '000');
INSERT INTO `t_member_tree` VALUES ('43', '34', '17', '000');
INSERT INTO `t_member_tree` VALUES ('44', '34', '18', '000');
INSERT INTO `t_member_tree` VALUES ('45', '35', '19', '000');
INSERT INTO `t_member_tree` VALUES ('46', '35', '20', '000');
INSERT INTO `t_member_tree` VALUES ('47', '36', '21', '000');
INSERT INTO `t_member_tree` VALUES ('48', '36', '22', '000');
INSERT INTO `t_member_tree` VALUES ('49', '37', '23', '000');
INSERT INTO `t_member_tree` VALUES ('50', '37', '25', '000');
INSERT INTO `t_member_tree` VALUES ('51', '38', '26', '000');
INSERT INTO `t_member_tree` VALUES ('52', '38', '27', '000');
INSERT INTO `t_member_tree` VALUES ('53', '39', '28', '000');
INSERT INTO `t_member_tree` VALUES ('54', '39', '29', '000');
INSERT INTO `t_member_tree` VALUES ('55', '40', '30', '000');
INSERT INTO `t_member_tree` VALUES ('56', '40', '31', '000');
