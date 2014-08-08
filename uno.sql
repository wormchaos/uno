/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : uno

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2014-08-08 17:22:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `uno_game`
-- ----------------------------
DROP TABLE IF EXISTS `uno_game`;
CREATE TABLE `uno_game` (
  `gameId` int(11) DEFAULT NULL,
  `createDttm` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uno_game
-- ----------------------------

-- ----------------------------
-- Table structure for `uno_player`
-- ----------------------------
DROP TABLE IF EXISTS `uno_player`;
CREATE TABLE `uno_player` (
  `userId` int(11) NOT NULL DEFAULT '0',
  `roomId` int(11) DEFAULT NULL,
  `gameId` int(11) DEFAULT NULL,
  `state` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uno_player
-- ----------------------------
INSERT INTO `uno_player` VALUES ('1', '1', '1', '1');
INSERT INTO `uno_player` VALUES ('2', '1', '1', '1');

-- ----------------------------
-- Table structure for `uno_room`
-- ----------------------------
DROP TABLE IF EXISTS `uno_room`;
CREATE TABLE `uno_room` (
  `roomId` int(11) DEFAULT NULL,
  `createDttm` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uno_room
-- ----------------------------

-- ----------------------------
-- Table structure for `uno_user`
-- ----------------------------
DROP TABLE IF EXISTS `uno_user`;
CREATE TABLE `uno_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` text,
  `password` text,
  `createDttm` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uno_user
-- ----------------------------
