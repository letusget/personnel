/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : person

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 06/11/2021 21:44:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
  `dep_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dep_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep_describes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('1', '底层架构组', '负责底层代码搭建，基本框架构建', '重要');
INSERT INTO `departments` VALUES ('jfrcAYTu', '后台开发组', '负责后台开发', '氛围融洽');
INSERT INTO `departments` VALUES ('wQUFnlBl', '测试组', '进行测试工作', '测试主要功能');
INSERT INTO `departments` VALUES ('XWVAXFiS', '1', '1', '12');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `emp_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_id_photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_sex` tinyint(0) NULL DEFAULT NULL COMMENT '1 为男生，0 为女生',
  `emp_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `emp_id_card` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `emp_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('20210101', 'https://tvax3.sinaimg.cn/large/006x3t5Xgy1gu0agwe5rvj60zk1ds42502.jpg', '夏海藻', 1, 'a14705129921@163.com', '14705129921', '底层架构组', '327584199905058542', '暂无备注');
INSERT INTO `employees` VALUES ('20210102', 'https://tvax4.sinaimg.cn/large/006x3t5Xgy1gu4z6sowa6j60hr0ew74e02.jpg', '王小花', 0, 'klajdfajfklj@qq.com', '14758429512', '测试组', '147854135894158453158', '单身');
INSERT INTO `employees` VALUES ('LkINrmNV', 'https://tvax2.sinaimg.cn/large/006x3t5Xgy1gw5gvyq2ecj30820ab74d.jpg', 'Lisa', 1, '789425@126.com', '14795082544', '后台开发组', '150825197601092103', '新入职');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `eva_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `eva_absence` int(0) NULL DEFAULT NULL COMMENT '旷工天数，每次扣20分',
  `eva_attendance` int(0) NULL DEFAULT NULL COMMENT '每月满勤为22天，绩效分记100',
  `eva_late` int(0) NULL DEFAULT NULL COMMENT '迟到每天 每人扣5分',
  `eva_vacate` int(0) NULL DEFAULT NULL COMMENT '请假天数，每月3天之内不扣分',
  `eva_overtime` int(0) NULL DEFAULT NULL COMMENT '加班工时，每加班一小时绩效加1分',
  `eva_level` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '员工评级，涉及到工资奖金等',
  `eva_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`eva_id`) USING BTREE,
  INDEX `emp_id`(`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('A5OZKFvf', 'LkINrmNV', 'Lisa', 0, 22, 0, 0, 0, 'B', '暂无');
INSERT INTO `evaluation` VALUES ('eva01', '20210101', '夏海藻', 0, 21, 0, 1, 2, 'A', '请假一天');
INSERT INTO `evaluation` VALUES ('eva02', '20210102', '王小花', 1, 20, 2, 2, 2, 'B', '旷工一次，迟到两次');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(0) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `inf_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `inf_education` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学历：博士，研究生，本科生，其他',
  `inf_political` tinyint(0) NULL DEFAULT NULL COMMENT '政治面貌：0共青团员，1党员，2无党派人士，3其他党派人士，4群众',
  `inf_entry` date NULL DEFAULT NULL COMMENT '入职时间',
  `inf_place` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯，省市',
  `inf_marital` tinyint(0) NULL DEFAULT NULL COMMENT '婚姻状况：未婚，已婚，离异，丧偶',
  `inf_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`inf_id`) USING BTREE,
  INDEX `inf_emp`(`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('inf01', '20210101', '夏海藻', '本科', 1, '2021-10-29', '江苏南京', 0, '南林');
INSERT INTO `information` VALUES ('inf02', '20210102', '王小花', '研究生', 0, '2021-10-29', '江苏南京', 0, '南工');
INSERT INTO `information` VALUES ('NlRZvVE4', 'LkINrmNV', 'Lisa', '本科', 0, '2021-11-06', '江苏南京', 0, '无');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_flag` tinyint(0) NOT NULL COMMENT '登录标识，0为管理员，1为经理，2为员工',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1001', 0, 'root', '123456', '管理员');
INSERT INTO `users` VALUES ('1002', 1, 'manager', '123456', '经理');
INSERT INTO `users` VALUES ('1003', 2, 'Lisa', '123456', '职员');
INSERT INTO `users` VALUES ('1004', 2, '夏海藻', '123456', '职员');

SET FOREIGN_KEY_CHECKS = 1;
