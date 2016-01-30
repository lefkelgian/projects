/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mhx_log

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-01-24 01:41:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user` varchar(50) NOT NULL,
  `strpass` varchar(50) DEFAULT NULL,
  `work` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('123', '123', 'admin');
INSERT INTO `login` VALUES ('giannis', '123', 'admin');
INSERT INTO `login` VALUES ('kelly', '123', 'worker');
INSERT INTO `login` VALUES ('lefteris', '123', 'worker');

-- ----------------------------
-- Table structure for `offers`
-- ----------------------------
DROP TABLE IF EXISTS `offers`;
CREATE TABLE `offers` (
  `name` varchar(50) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of offers
-- ----------------------------
INSERT INTO `offers` VALUES ('apokries', '2016-03-13', '2016-03-15', '2', '25');
INSERT INTO `offers` VALUES ('kalokairinh', '2016-06-15', '2016-06-20', '4', '100');
INSERT INTO `offers` VALUES ('pasxa', '2016-04-28', '2016-05-02', '4', '60');

-- ----------------------------
-- Table structure for `rooms`
-- ----------------------------
DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `ar_dom` int(2) unsigned NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `type_room` int(4) DEFAULT NULL,
  `name_reservation` varchar(50) DEFAULT NULL,
  `price` int(200) DEFAULT NULL,
  PRIMARY KEY (`ar_dom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 MIN_ROWS=10 MAX_ROWS=10 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rooms
-- ----------------------------
INSERT INTO `rooms` VALUES ('1', '2016-01-02', '2016-01-05', '2', 'lefteris', '100');
INSERT INTO `rooms` VALUES ('2', '2016-02-06', '2016-02-09', '4', 'giannis', '60');
INSERT INTO `rooms` VALUES ('3', '2016-03-01', '2016-03-04', '1', 'kelly', '30');
INSERT INTO `rooms` VALUES ('4', '2016-12-23', '2016-12-24', '1', 'maria', '10');
INSERT INTO `rooms` VALUES ('5', '2016-03-13', '2016-03-15', '2', 'patra', '30');
INSERT INTO `rooms` VALUES ('6', '2016-06-15', '2016-06-20', '4', null, null);
INSERT INTO `rooms` VALUES ('7', '2016-06-21', '2016-06-29', '4', null, null);
INSERT INTO `rooms` VALUES ('8', '2016-07-15', '2016-07-21', '2', null, null);
INSERT INTO `rooms` VALUES ('9', '2016-07-30', '2016-07-31', '1', null, null);
INSERT INTO `rooms` VALUES ('10', '2016-10-28', '2016-10-30', '2', null, null);
