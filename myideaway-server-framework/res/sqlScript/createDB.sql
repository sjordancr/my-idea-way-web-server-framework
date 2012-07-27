/*
Navicat MySQL Data Transfer

Source Server         : mysqltest
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2012-07-20 18:05:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `entityId` varchar(64) NOT NULL,
  `loginName` varchar(64) NOT NULL,
  `loginPassword` varchar(128) NOT NULL,
  `nickName` varchar(128) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`entityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('0b8450effd864d658d4db22e5d939f39c462c7d2', '111', '111', '111', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('1fe0e75c5074401bb204e6eb82f8ac3eaf395f13', '地撒打算', 'dsadas ', '的撒', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('434c527825e04bcd9254caa32e12187ea693a35b', '333', '333', '333', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('a32fa9632b34479b8aa158d1f66fd87daf395f13', '111', '111', '11', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('a68e085bf21e4ec1a170c470569b180c6fc13c1d', 'ddd', 'ddd', 'ddd', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('b7afa62e7a03455082d5f74a83470d48691e9a61', '凤飞飞', '凤飞飞', ' 房东发生的', '2012-07-18');
INSERT INTO `tbl_user` VALUES ('c155f87a173f4ce586bed9702ad1678baf395f13', '多得多', 'dd ', '的撒旦撒', '2012-07-18');
