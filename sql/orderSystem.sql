/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.0.104:3306
 Source Schema         : orderSystem

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 14/03/2021 14:04:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DISHES
-- ----------------------------
DROP TABLE IF EXISTS `DISHES`;
CREATE TABLE `DISHES`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `DISHES_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜品名称',
  `DISHES_PRICE` decimal(10, 2) NULL DEFAULT NULL COMMENT '菜品价格',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DISHES
-- ----------------------------
INSERT INTO `DISHES` VALUES (1, '鱼香肉丝', 15.00);
INSERT INTO `DISHES` VALUES (2, '肉末瘸子', 13.00);
INSERT INTO `DISHES` VALUES (3, '回锅肉', 15.00);

-- ----------------------------
-- Table structure for ORDER
-- ----------------------------
DROP TABLE IF EXISTS `ORDER`;
CREATE TABLE `ORDER`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `ORDER_PRICE` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ORDER
-- ----------------------------

-- ----------------------------
-- Table structure for ORDER_DISHES
-- ----------------------------
DROP TABLE IF EXISTS `ORDER_DISHES`;
CREATE TABLE `ORDER_DISHES`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ORDER_ID` bigint(0) NOT NULL COMMENT '订单id',
  `DISHES_ID` bigint(0) NOT NULL COMMENT '菜品id',
  `STATUS` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单和菜品关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ORDER_DISHES
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE IF EXISTS `SYS_MENU`;
CREATE TABLE `SYS_MENU`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `MENU_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `MENU_HREF` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由地址',
  `MENU_LEVEL` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单层级',
  `MENU_ICON` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单icon',
  `PRENT_ID` bigint(0) NULL DEFAULT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO `SYS_MENU` VALUES (1, '用户点餐', NULL, NULL, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES (2, '订单', NULL, NULL, NULL, NULL);
INSERT INTO `SYS_MENU` VALUES (3, '菜品', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER`;
CREATE TABLE `SYS_USER`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `USER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `NIKE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO `SYS_USER` VALUES (1, 'admin', '123456', '超级管理员');
INSERT INTO `SYS_USER` VALUES (2, 'user', '123456', '客户');
INSERT INTO `SYS_USER` VALUES (3, 'chef', '123456', '厨师');
INSERT INTO `SYS_USER` VALUES (4, 'waiter', '123456', '服务员');

-- ----------------------------
-- Table structure for SYS_USER_MENU
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER_MENU`;
CREATE TABLE `SYS_USER_MENU`  (
  `ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `USER_ID` bigint(0) NOT NULL COMMENT '用户id',
  `MENU_ID` bigint(0) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of SYS_USER_MENU
-- ----------------------------
INSERT INTO `SYS_USER_MENU` VALUES (1, 1, 1);
INSERT INTO `SYS_USER_MENU` VALUES (2, 1, 2);
INSERT INTO `SYS_USER_MENU` VALUES (3, 1, 3);
INSERT INTO `SYS_USER_MENU` VALUES (4, 2, 1);
INSERT INTO `SYS_USER_MENU` VALUES (5, 2, 2);
INSERT INTO `SYS_USER_MENU` VALUES (6, 3, 3);
INSERT INTO `SYS_USER_MENU` VALUES (7, 4, 2);
INSERT INTO `SYS_USER_MENU` VALUES (8, 4, 3);

SET FOREIGN_KEY_CHECKS = 1;
