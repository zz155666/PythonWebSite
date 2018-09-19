/*
Navicat MySQL Data Transfer

Source Server         : localhostmybatis
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-17 14:45:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CODE` varchar(32) DEFAULT NULL COMMENT '订单号',
  `total` double DEFAULT NULL COMMENT '总额',
  `user_id` int(11) DEFAULT NULL COMMENT '客户',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
