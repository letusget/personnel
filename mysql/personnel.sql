/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : personnel

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 06/09/2021 20:50:21
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
INSERT INTO `departments` VALUES ('wQUFnlBl', '测试组', '进行测试工作', 'test');
INSERT INTO `departments` VALUES ('XWVAXFiS', '1', '1', '1');

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
  `emp_entry` date NULL DEFAULT NULL COMMENT '入职时间',
  `emp_marital` tinyint(0) NULL DEFAULT NULL COMMENT '1 为已婚，0为未婚',
  `emp_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('20210101', 'https://tvax3.sinaimg.cn/large/006x3t5Xgy1gu0agwe5rvj60zk1ds42502.jpg', '夏海藻', 1, 'a14705129922@163.com', '14705129922', '底层架构组', '327584199905058542', '2021-08-31', 1, '新员工');
INSERT INTO `employees` VALUES ('EOHWX6Om', 'https://tvax4.sinaimg.cn/large/006x3t5Xgy1gu4z6sowa6j60hr0ew74e02.jpg', '王小花', 0, 'klajdfajfklj@qq.com', '14758429512', '测试组', '147854135894158453158', '2021-09-04', 0, '新员工3');
INSERT INTO `employees` VALUES ('lAF81ZMq', 'https://tvax4.sinaimg.cn/large/006x3t5Xgy1gu5yychkxjj60m80xc77a02.jpg', '孙小美', 0, 'jkasfhjk@qq.com', '14785428922', '测试组', '14854125841239686541', '2021-09-05', 0, '新员工2');
INSERT INTO `employees` VALUES ('t93pHrIt', 'https://tva1.sinaimg.cn/large/006x3t5Xgy1gu4p0vap1pj60gd0gt0y302.jpg', '张三', 1, '3038845564@qq.com', '13145148542', '底层架构组', '35128456521541528455', '2021-09-04', 0, '新员工');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `emp_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `eva_attendance` int(0) NULL DEFAULT NULL COMMENT '满勤为一个月22天',
  `eva_late` int(0) NULL DEFAULT NULL COMMENT '迟到每天 每人扣20',
  `eva_level` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `eva_overtime` int(0) NULL DEFAULT NULL,
  `eva_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('20210101', 22, 5, 'B', 12, '员工');

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
-- Table structure for salaries
-- ----------------------------
DROP TABLE IF EXISTS `salaries`;
CREATE TABLE `salaries`  (
  `emp_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sal_base` decimal(32, 0) NULL DEFAULT NULL,
  `sal_bonus` decimal(32, 0) NULL DEFAULT NULL,
  `sal_bonus_describes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sal_fine` decimal(32, 0) NULL DEFAULT NULL,
  `sal_fine_describes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sal_benefits` decimal(32, 0) NULL DEFAULT NULL,
  `sal_final` decimal(32, 0) NULL DEFAULT NULL,
  `sal_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salaries
-- ----------------------------
INSERT INTO `salaries` VALUES ('20210101', '夏海藻', 8000, 1000, '满勤，评级为A', 100, '多次迟到', 1100, 10000, '员工');

SET FOREIGN_KEY_CHECKS = 1;
