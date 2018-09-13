/*
Navicat MySQL Data Transfer

Source Server         : localhostmybatis
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-13 16:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_clazz
-- ----------------------------
DROP TABLE IF EXISTS `tb_clazz`;
CREATE TABLE `tb_clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(18) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
