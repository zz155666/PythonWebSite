/*
Navicat MySQL Data Transfer

Source Server         : localhostmybatis
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-28 16:39:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(18) DEFAULT NULL,
  `PASSWORD` varchar(18) DEFAULT NULL,
  `NAME` varchar(18) DEFAULT NULL,
  `SEX` char(2) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `phone` varchar(21) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `state` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
