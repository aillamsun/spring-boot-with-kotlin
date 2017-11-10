/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : spring-boot-kotlin

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 11/10/2017 18:47:46 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin', '123456', '2017-11-08 13:57:46'), ('2', 'zhangsan', '123456', '2017-11-08 14:19:33'), ('3', 'wangwu', '123456', '2017-11-08 14:19:43'), ('4', 'lisi', '123456', '2017-11-16 14:19:54'), ('5', 'zhaoliu', '123456', '2017-11-10 14:20:08'), ('6', '1', null, null), ('7', '1', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
