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

 Date: 29/05/2019 09:24:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_group_to_user
-- ----------------------------
DROP TABLE IF EXISTS `chat_group_to_user`;
CREATE TABLE `chat_group_to_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '聊天群用户关联表id',
  `user_id` int(11) DEFAULT NULL,
  `c_group_id` int(11) DEFAULT NULL COMMENT '聊天群id',
  `nikename` varchar(255) DEFAULT NULL COMMENT '群内用户昵称',
  `is_top` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否置顶',
  `is_no_disturb` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否免打扰',
  `bg_url` varchar(255) DEFAULT NULL COMMENT '聊天背景',
  `user_status` int(1) DEFAULT NULL COMMENT '-1黑名单，0待审核，1正常',
  `validate_content` varchar(50) DEFAULT NULL COMMENT '验证信息',
  `add_time` datetime DEFAULT NULL COMMENT '入群时间',
  `update_time` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_group_to_user
-- ----------------------------
BEGIN;
INSERT INTO `chat_group_to_user` VALUES (1, 1, 1, NULL, 0, 0, NULL, NULL, NULL, '2019-05-10 00:00:00', NULL, 0);
INSERT INTO `chat_group_to_user` VALUES (2, 1, 2, NULL, 0, 0, NULL, NULL, NULL, '2019-05-11 00:00:00', NULL, 0);
INSERT INTO `chat_group_to_user` VALUES (3, 2, 1, NULL, 0, 0, NULL, NULL, NULL, '2019-05-12 00:00:00', NULL, 0);
INSERT INTO `chat_group_to_user` VALUES (4, 3, 1, NULL, 0, 0, NULL, NULL, NULL, '2019-05-13 00:00:00', NULL, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
