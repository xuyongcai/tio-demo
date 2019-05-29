/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : interact

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 29/05/2019 09:24:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_group
-- ----------------------------
DROP TABLE IF EXISTS `chat_group`;
CREATE TABLE `chat_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `master` int(11) DEFAULT NULL COMMENT '群主',
  `avatar` varchar(255) DEFAULT NULL COMMENT '群头像',
  `notice` varchar(255) DEFAULT NULL COMMENT '公告',
  `introduction` varchar(500) DEFAULT NULL COMMENT '群简介',
  `type` int(11) DEFAULT NULL COMMENT '群类型。0班级群，1讨论组',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_group
-- ----------------------------
BEGIN;
INSERT INTO `chat_group` VALUES (1, '群01', 1, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `chat_group` VALUES (2, '群02', NULL, NULL, NULL, NULL, 1, NULL, NULL, 0);
INSERT INTO `chat_group` VALUES (3, '群03', NULL, NULL, NULL, NULL, 0, NULL, NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
