/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:13306
 Source Schema         : dczx

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 31/03/2022 20:19:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_no` int(11) NULL DEFAULT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `chinese` decimal(65, 1) NULL DEFAULT NULL,
  `math` decimal(65, 1) NULL DEFAULT NULL,
  `english` decimal(65, 1) NULL DEFAULT NULL,
  `politics` decimal(65, 1) NULL DEFAULT NULL,
  `history` decimal(65, 1) NULL DEFAULT NULL,
  `geography` decimal(65, 1) NULL DEFAULT NULL,
  `biology` decimal(65, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 238 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (196, 7428, '刘辛铭', 75.0, 90.0, 105.0, 59.0, 73.0, 37.0, 48.0);
INSERT INTO `t_student` VALUES (197, 7401, '范俊文', 74.0, 78.0, 106.0, 63.0, 69.0, 28.0, 34.0);
INSERT INTO `t_student` VALUES (198, 7425, '何莉梅', 78.0, 85.0, 109.0, 63.0, 58.0, 21.0, 35.0);
INSERT INTO `t_student` VALUES (199, 7431, '曾伟铨', 78.0, 75.0, 105.0, 58.0, 63.0, 28.0, 37.0);
INSERT INTO `t_student` VALUES (200, 7433, '钟燕玲', 80.0, 70.0, 99.0, 64.0, 57.0, 30.0, 39.0);
INSERT INTO `t_student` VALUES (201, 7403, '刘道锋', 56.0, 85.0, 95.0, 55.0, 64.0, 35.0, 45.0);
INSERT INTO `t_student` VALUES (202, 7415, '丁家利', 72.0, 69.0, 107.0, 59.0, 53.0, 31.0, 31.0);
INSERT INTO `t_student` VALUES (203, 7406, '赖聪聪', 72.0, 65.0, 101.0, 64.0, 59.0, 26.0, 31.0);
INSERT INTO `t_student` VALUES (204, 7417, '刘志成', 65.0, 68.0, 107.0, 52.0, 65.0, 21.0, 38.0);
INSERT INTO `t_student` VALUES (205, 7407, '叶小雪', 68.0, 60.0, 101.0, 58.0, 58.0, 32.0, 36.0);
INSERT INTO `t_student` VALUES (206, 7424, '丁宋萍', 68.0, 70.0, 111.0, 59.0, 48.0, 18.0, 26.0);
INSERT INTO `t_student` VALUES (207, 7434, '钟小莉', 77.0, 30.0, 96.0, 61.0, 70.0, 18.0, 30.0);
INSERT INTO `t_student` VALUES (208, 7408, '管语清', 63.0, 52.0, 103.0, 57.0, 55.0, 22.0, 29.0);
INSERT INTO `t_student` VALUES (209, 7421, '凌安铭', 56.0, 57.0, 100.0, 54.0, 52.0, 24.0, 38.0);
INSERT INTO `t_student` VALUES (210, 7414, '赖艳萍', 60.0, 49.0, 98.0, 53.0, 59.0, 29.0, 28.0);
INSERT INTO `t_student` VALUES (211, 7426, '李智勇', 54.0, 63.0, 95.0, 48.0, 58.0, 31.0, 27.0);
INSERT INTO `t_student` VALUES (212, 7422, '肖荣林', 50.0, 64.0, 85.0, 55.0, 57.0, 30.0, 26.0);
INSERT INTO `t_student` VALUES (213, 7427, '钟德鑫', 50.0, 68.0, 91.0, 40.0, 44.0, 30.0, 25.0);
INSERT INTO `t_student` VALUES (214, 7402, '刘博涛', 50.0, 33.0, 83.0, 49.0, 59.0, 25.0, 39.0);
INSERT INTO `t_student` VALUES (215, 7416, '丁邦根', 52.0, 54.0, 62.0, 46.0, 55.0, 15.0, 27.0);
INSERT INTO `t_student` VALUES (216, 7410, '邓国焱', 55.0, 22.0, 82.0, 37.0, 65.0, 19.0, 27.0);
INSERT INTO `t_student` VALUES (217, 7404, '丁家鸿', 69.0, 45.0, 21.0, 56.0, 67.0, 17.0, 23.0);
INSERT INTO `t_student` VALUES (218, 7412, '何志斌', 34.0, 34.0, 81.0, 36.0, 48.0, 35.0, 28.0);
INSERT INTO `t_student` VALUES (219, 7420, '卢欣萍', 59.0, 15.0, 71.0, 62.0, 50.0, 14.0, 23.0);
INSERT INTO `t_student` VALUES (220, 7440, '钟婷', 57.0, 57.0, 59.0, 49.0, 36.0, 13.0, 17.0);
INSERT INTO `t_student` VALUES (221, 7413, '叶焰华', 68.0, 16.0, 67.0, 49.0, 43.0, 18.0, 23.0);
INSERT INTO `t_student` VALUES (222, 7411, '陈淦森', 56.0, 23.0, 71.0, 43.0, 52.0, 15.0, 21.0);
INSERT INTO `t_student` VALUES (223, 7442, '丁伟芸', 61.0, 26.0, 48.0, 49.0, 47.0, 9.0, 27.0);
INSERT INTO `t_student` VALUES (224, 7405, '赖伟涛', 12.0, 12.0, 81.0, 42.0, 65.0, 23.0, 28.0);
INSERT INTO `t_student` VALUES (225, 7439, '邓国清', 64.0, 16.0, 44.0, 53.0, 36.0, 18.0, 27.0);
INSERT INTO `t_student` VALUES (226, 7409, '张晴', 53.0, 16.0, 51.0, 44.0, 54.0, 14.0, 13.0);
INSERT INTO `t_student` VALUES (227, 7437, '凌全勇', 45.0, 45.0, 52.0, 35.0, 27.0, 10.0, 19.0);
INSERT INTO `t_student` VALUES (228, 7438, '管艳芳', 58.0, 21.0, 49.0, 40.0, 35.0, 11.0, 15.0);
INSERT INTO `t_student` VALUES (229, 7418, '范伟', 34.0, 49.0, 45.0, 16.0, 16.0, 23.0, 33.0);
INSERT INTO `t_student` VALUES (230, 7429, '刘娇', 53.0, 15.0, 30.0, 33.0, 35.0, 7.0, 21.0);
INSERT INTO `t_student` VALUES (231, 7441, '李彩萍', 69.0, 10.0, 33.0, 37.0, 25.0, 6.0, 13.0);
INSERT INTO `t_student` VALUES (232, 7436, '曾妍', 43.0, 25.0, 24.0, 32.0, 24.0, 11.0, 16.0);
INSERT INTO `t_student` VALUES (233, 7419, '刘林', 36.0, 3.0, 29.0, 22.0, 10.0, 12.0, 19.0);
INSERT INTO `t_student` VALUES (234, 7432, '黄奕森', 32.0, 21.0, 23.0, 18.0, 16.0, 8.0, 0.0);
INSERT INTO `t_student` VALUES (235, 7430, '陈棚', 17.0, 9.0, 26.0, 20.0, 18.0, 0.0, 11.0);
INSERT INTO `t_student` VALUES (236, 7423, '肖志豪', 0.0, 3.0, 27.0, 10.0, 6.0, 13.0, 31.0);
INSERT INTO `t_student` VALUES (237, 7435, '张文静', 16.0, 3.0, 18.0, 8.0, 8.0, 2.0, 8.0);

SET FOREIGN_KEY_CHECKS = 1;
