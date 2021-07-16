/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : tianlelake

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 02/07/2021 14:48:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `EmployeeId` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `isAdmin` tinyint(1) NULL DEFAULT 0,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '在职',
  UNIQUE INDEX `EmployeeId`(`EmployeeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('猫南北', 'tldj001', '123456', '女', 25, 0, '在职');
INSERT INTO `employee` VALUES ('狗东西', 'tldj002', '123456', '男', 25, 0, '在职');
INSERT INTO `employee` VALUES ('王海', 'tldj003', '123456', '男', 25, 0, '在职');
INSERT INTO `employee` VALUES ('王铁柱', 'tldj004', '123456', '男', 25, 0, '在职');
INSERT INTO `employee` VALUES ('王后', 'tldj005', '123456', '男', 25, 0, '在职');
INSERT INTO `employee` VALUES ('太奶奶', 'tldj006', '123456', '男', 25, 0, '在职');
INSERT INTO `employee` VALUES ('管理', 'tldj007', '1314', '男', 25, 1, '在职');

-- ----------------------------
-- Table structure for scenicprojects
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic`  (
  `scenicID` int(100) NOT NULL AUTO_INCREMENT,
  `scenicName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isOnService` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`scenicID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenicprojects
-- ----------------------------
INSERT INTO `scenic` VALUES (1, '云霄飞车', 1);
INSERT INTO `scenic` VALUES (2, '摩天轮', 1);
INSERT INTO `scenic` VALUES (3, '碰碰车', 1);
INSERT INTO `scenic` VALUES (4, '射箭', 1);
INSERT INTO `scenic` VALUES (5, '滑草', 1);
INSERT INTO `scenic` VALUES (6, '卡丁车', 1);
INSERT INTO `scenic` VALUES (7, '鬼屋', 1);
INSERT INTO `scenic` VALUES (8, '迷宫', 1);
INSERT INTO `scenic` VALUES (9, '电影院', 1);
INSERT INTO `scenic` VALUES (10, '3d5d影院', 1);
INSERT INTO `scenic` VALUES (11, '旋转木马', 1);
INSERT INTO `scenic` VALUES (12, '丛林飞鼠', 1);
INSERT INTO `scenic` VALUES (13, '枪林弹雨', 1);
INSERT INTO `scenic` VALUES (14, '大锅灶台', 1);
INSERT INTO `scenic` VALUES (15, '摇头飞椅', 1);
INSERT INTO `scenic` VALUES (16, '激情跳跃', 1);
INSERT INTO `scenic` VALUES (17, '手摇船、遥控船', 1);
INSERT INTO `scenic` VALUES (18, '青虫滑车', 1);
INSERT INTO `scenic` VALUES (19, '儿童蹦床', 1);
INSERT INTO `scenic` VALUES (20, '360度旋转太空环', 1);
INSERT INTO `scenic` VALUES (21, '旋转咖啡杯', 1);
INSERT INTO `scenic` VALUES (22, '体能乐园', 1);
INSERT INTO `scenic` VALUES (23, '水车', 1);
INSERT INTO `scenic` VALUES (24, '碰碰车', 1);
INSERT INTO `scenic` VALUES (25, '水塔餐厅', 1);
INSERT INTO `scenic` VALUES (26, '游乐长廊', 1);
INSERT INTO `scenic` VALUES (27, '水塔厕所', 1);
INSERT INTO `scenic` VALUES (28, '树上行走', 1);
INSERT INTO `scenic` VALUES (29, '水塔厕所', 1);
INSERT INTO `scenic` VALUES (30, '摩天轮', 1);
INSERT INTO `scenic` VALUES (31, '萌宠动物园', 1);
INSERT INTO `scenic` VALUES (32, '神舟飞碟', 1);
INSERT INTO `scenic` VALUES (33, '空中飞人', 1);
INSERT INTO `scenic` VALUES (34, '射箭', 1);
INSERT INTO `scenic` VALUES (35, '儿童广场', 1);
INSERT INTO `scenic` VALUES (36, '小挖机', 1);
INSERT INTO `scenic` VALUES (37, '骑马场', 1);
INSERT INTO `scenic` VALUES (38, '卡丁车', 1);
INSERT INTO `scenic` VALUES (39, '碰碰船', 1);
INSERT INTO `scenic` VALUES (40, '彩虹滑道', 1);
INSERT INTO `scenic` VALUES (41, '水上游艇码头', 1);
INSERT INTO `scenic` VALUES (42, '真人CS', 1);
INSERT INTO `scenic` VALUES (43, '高空拓展场地（豆腐坊）', 1);
INSERT INTO `scenic` VALUES (44, '水上乐园', 1);

-- ----------------------------
-- Table structure for ticketreception
-- ----------------------------
DROP TABLE IF EXISTS `ticketRecord`;
CREATE TABLE `ticketRecord`  (
  `timeDate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `timeClock` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `ticketID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `scenicID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `employeeID` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `remark` int(11) NULL DEFAULT 0
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticketreception
-- ----------------------------

-- ----------------------------
-- Table structure for workrecord
-- ----------------------------
DROP TABLE IF EXISTS `employeeRecord`;
CREATE TABLE `employeeRecord`  (
  `timeDate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `employeeID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci not null ,
  `scenicID` int(11) not null,
  `punchIn` time(0) not null,
  `punchOff` time(0) NULL DEFAULT NULL,
  `receptionCount` int(10) NULL DEFAULT 0,
  `fiveStarCount` int(11) NULL DEFAULT 0,
  `fourStarCount` int(11) NULL DEFAULT 0,
  `threeStarCount` int(11) NULL DEFAULT 0,
  `twoStarCount` int(11) NULL DEFAULT 0,
  `oneStarCount` int(11) NULL DEFAULT 0,
  `isOnline` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`timeDate`,`employeeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workrecord
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;


```sql
begin
select count employeeID from workRecord where employeeID='' and timeDate='';
```

