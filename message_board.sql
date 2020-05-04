/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : message_board

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-04 20:07:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `title` varchar(32) NOT NULL,
  `content` varchar(4096) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', 'admin', '慕课网好', '<span clolor=\'red\'>慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。</span>', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('2', '2', 'test', '慕课网好-test', '<span clolor=\'red\'>慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。</span>', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('3', '2', 'test', '慕课网好-test', '<span clolor=\'red\'>慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。</span>', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('4', '2', 'test', '慕课网好-test', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('5', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('6', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。', '2017-03-25 22:17:23');
INSERT INTO `message` VALUES ('7', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。', '2017-03-25 00:00:00');
INSERT INTO `message` VALUES ('8', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。', '2017-03-25 23:09:05');
INSERT INTO `message` VALUES ('9', '1', 'admin', '慕课网好', '慕课网好\r\n慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:11:36');
INSERT INTO `message` VALUES ('10', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:11:54');
INSERT INTO `message` VALUES ('11', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:11:59');
INSERT INTO `message` VALUES ('12', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:05');
INSERT INTO `message` VALUES ('13', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:09');
INSERT INTO `message` VALUES ('14', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:15');
INSERT INTO `message` VALUES ('15', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:20');
INSERT INTO `message` VALUES ('16', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:28');
INSERT INTO `message` VALUES ('17', '1', 'admin', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:34');
INSERT INTO `message` VALUES ('19', '2', 'test', '慕课网好-test', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-03-25 23:12:39');
INSERT INTO `message` VALUES ('20', '1', 'admin', '慕课网好-admin', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-04-04 15:45:22');
INSERT INTO `message` VALUES ('21', '8', 'mooc', '慕课网好', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-04-04 15:46:47');
INSERT INTO `message` VALUES ('22', '1', 'admin', '慕课网好-admin', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-04-09 19:51:16');
INSERT INTO `message` VALUES ('23', '1', 'admin', '慕课网好-admin-1', '慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术', '2017-04-09 19:55:05');
INSERT INTO `message` VALUES ('25', '1', 'admin', '这是一条留言', '这是一段内容', '2020-05-04 20:04:55');
INSERT INTO `message` VALUES ('26', '1', 'admin', '这是一条留言', '这是一段内容', '2020-05-04 20:05:49');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '张三丰', '1980-01-02', '123456', '武当山武当观1-2');
INSERT INTO `user` VALUES ('2', 'test', 'test', null, null, null, null);
INSERT INTO `user` VALUES ('8', 'mooc', 'mooc', null, null, null, null);
SET FOREIGN_KEY_CHECKS=1;
