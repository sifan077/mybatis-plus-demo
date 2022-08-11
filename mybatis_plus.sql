/*
Navicat MySQL Data Transfer

Source Server         : hao
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : mybatis_plus

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-08-11 21:49:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookID` int NOT NULL AUTO_INCREMENT COMMENT 'ssm 整合学习',
  `bookName` varchar(100) NOT NULL COMMENT '书名',
  `bookCounts` int NOT NULL COMMENT '数量',
  `detail` varchar(200) NOT NULL COMMENT '描述',
  KEY `bookID` (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Java', '1', '从入门到放弃');
INSERT INTO `books` VALUES ('2', 'MySQL', '10', '从删库到跑路');
INSERT INTO `books` VALUES ('3', 'Linux', '5', '从进门到进牢');
INSERT INTO `books` VALUES ('4', 'php', '12', '厉害');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `deleted` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com', '0');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com', '0');
INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com', '0');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com', '0');
INSERT INTO `user` VALUES ('5', 'Billie', '20', 'test5@baomidou.com', '1');
