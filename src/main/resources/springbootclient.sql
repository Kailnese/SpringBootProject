/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100109
 Source Host           : localhost:3306
 Source Schema         : springbootclient

 Target Server Type    : MySQL
 Target Server Version : 100109
 File Encoding         : 65001

 Date: 27/10/2020 01:07:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `gender` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (7, 'emliy', '123', '2020-10-25', 'ddd@gmail.com', 21, 'female');
INSERT INTO `client` VALUES (11, 'admin', 'admin', '1994-04-24', 'none', 0, 'male');
INSERT INTO `client` VALUES (12, 'honming', '123456', '2020-10-07', 'ddd@gmail.com', 11, 'male');
INSERT INTO `client` VALUES (13, 'amy', '1234', '2020-10-07', 'amy@gmail.com', 16, 'female');
INSERT INTO `client` VALUES (14, 'nina', '12331', '2020-10-03', 'emily@gmail.com', 21, 'female');
INSERT INTO `client` VALUES (15, 'Jonny', '546', '2020-10-04', 'jonny@gmail.com', 32, 'male');
INSERT INTO `client` VALUES (16, 'richeal', '123', '2020-10-04', 'emily@gmail.com', 22, 'female');
INSERT INTO `client` VALUES (17, 'Tonny', '32131', '2020-10-16', 'tonny@gmail.com', 25, 'male');
INSERT INTO `client` VALUES (18, 'Timi', '123', '2020-10-05', 'timi@gmail.com', 21, 'female');
INSERT INTO `client` VALUES (19, 'Kadi', '321321', '2020-10-16', 'timi@gmail.com', 21, 'female');

SET FOREIGN_KEY_CHECKS = 1;
