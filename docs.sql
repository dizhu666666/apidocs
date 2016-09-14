/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50630
 Source Host           : localhost
 Source Database       : docs

 Target Server Version : 50630
 File Encoding         : utf-8

 Date: 07/11/2016 14:51:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `docs_api`
-- ----------------------------
DROP TABLE IF EXISTS `docs_api`;
CREATE TABLE `docs_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '接口名称',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '访问路径',
  `note` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `add_time` int(10) NOT NULL DEFAULT '0',
  `type` int(1) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '0',
  `content` text COMMENT '内容',
  `response` longtext COMMENT '接口返回信息',
  `request` text COMMENT '请求信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `docs_api_column`
-- ----------------------------
DROP TABLE IF EXISTS `docs_api_column`;
CREATE TABLE `docs_api_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_title` varchar(100) NOT NULL DEFAULT '' COMMENT '字段名称',
  `co_type` varchar(100) NOT NULL DEFAULT '' COMMENT '字段类型',
  `co_note` varchar(100) NOT NULL DEFAULT '' COMMENT '字段说明',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '访问路径',
  `note` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `add_time` int(10) NOT NULL DEFAULT '0',
  `type` int(1) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '0',
  `api_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `docs_function`
-- ----------------------------
DROP TABLE IF EXISTS `docs_function`;
CREATE TABLE `docs_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '字段名称',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '访问路径',
  `note` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `add_time` int(10) NOT NULL DEFAULT '0',
  `type` int(1) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '0',
  `content` text COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `docs_menu`
-- ----------------------------
DROP TABLE IF EXISTS `docs_menu`;
CREATE TABLE `docs_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '接口名称',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '图片',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '访问路径',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `add_time` int(10) NOT NULL DEFAULT '0',
  `type` int(1) NOT NULL DEFAULT '0' COMMENT '0接口1功能',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '1废弃0正常',
  `api_func_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
