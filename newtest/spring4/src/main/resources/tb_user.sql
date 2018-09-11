/*
Navicat MySQL Data Transfer

Source Server         : localhostmybatis
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-11 15:40:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `NAME` varchar(18) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `SEX` char(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `AGE` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
