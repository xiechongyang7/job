/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : job

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-01-17 18:30:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for boss_area_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_area_info`;
CREATE TABLE `boss_area_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `area` varchar(8) NOT NULL,
  `area_code` varchar(32) NOT NULL,
  `province_key` int(11) NOT NULL,
  `city_key` int(11) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_area_info
-- ----------------------------

-- ----------------------------
-- Table structure for boss_city_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_city_info`;
CREATE TABLE `boss_city_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `city` varchar(8) NOT NULL,
  `city_code` varchar(32) NOT NULL,
  `province_key` int(11) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_city_info
-- ----------------------------
INSERT INTO `boss_city_info` VALUES ('1', '齐齐哈尔', '/c101050200-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('2', '牡丹江', '/c101050300-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('3', '佳木斯', '/c101050400-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('4', '绥化', '/c101050500-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('5', '黑河 ', '/c101050600-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('6', '伊春', '/c101050700-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('7', '大庆', '/c101050800-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('8', '七台河', '/c101050900-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('9', '鸡西', '/c101051000-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('10', '鹤岗', '/c101051100-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('11', '双鸭山', '/c101051200-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('12', '大兴安岭', '/c101051300-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('13', '哈尔滨', '/c101060100-p100101/d_202-e_104/', '1');
INSERT INTO `boss_city_info` VALUES ('14', '吉林', '/c101060200-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('15', '四平', '/c101060300-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('16', '通化', '/c101060400-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('17', '白城', '/c101060500-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('18', '辽源', '/c101060600-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('19', '松原', '/c101060700-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('20', '白山', '/c101060800-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('21', '延边', '/c101060900-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('22', '长春', '/c101050100-p100101/d_202-e_104', '2');
INSERT INTO `boss_city_info` VALUES ('23', '长春', '/c101060100-p100101/d_202-e_104/', '2');
INSERT INTO `boss_city_info` VALUES ('24', '沈阳', '/c101070100-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('25', '大连', '/c101070200-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('26', '鞍山', '/c101070300-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('27', '抚顺', '/c101070400-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('28', '本溪', '/c101070500-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('29', '丹东', '/c101070600-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('30', '锦州', '/c101070700-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('31', '营口', '/c101070800-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('32', '阜新', '/c101070900-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('33', '辽阳', '/c101071000-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('34', '铁岭', '/c101071100-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('35', '朝阳', '/c101071200-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('36', '盘锦', '/c101071300-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('37', '葫芦岛', '/c101071400-p100101/d_202-e_104/', '3');
INSERT INTO `boss_city_info` VALUES ('38', '济南', '/c101120100-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('39', '青岛', '/c101120200-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('40', '淄博', '/c101120300-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('41', '德州', '/c101120400-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('42', '烟台', '/c101120500-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('43', '潍坊', '/c101120600-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('44', '济宁', '/c101120700-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('45', '泰安', '/c101120800-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('46', '临沂', '/c101120900-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('47', '菏泽', '/c101121000-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('48', '滨州', '/c101121100-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('49', '东营', '/c101121200-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('50', '威海', '/c101121300-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('51', '枣庄', '/c101121400-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('52', '日照', '/c101121500-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('53', '聊城', '/c101121700-p100101/d_202-e_104/', '4');
INSERT INTO `boss_city_info` VALUES ('54', '南京', '/c101190100-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('55', '无锡', '/c101190200-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('56', '镇江', '/c101190300-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('57', '苏州', '/c101190400-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('58', '南通', '/c101190500-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('59', '扬州', '/c101190600-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('60', '盐城', '/c101190700-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('61', '徐州', '/c101190800-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('62', '淮安', '/c101190900-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('63', '连云港', '/c101191000-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('64', '常州', '/c101191100-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('65', '泰州', '/c101191200-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('66', '宿迁', '/c101191300-p100101/d_202-e_104/', '5');
INSERT INTO `boss_city_info` VALUES ('67', '杭州', '/c101210100-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('68', '湖州', '/c101210200-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('69', '嘉兴', '/c101210300-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('70', '宁波', '/c101210400-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('71', '绍兴', '/c101210500-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('72', '台州', '/c101210600-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('73', '温州', '/c101210700-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('74', '丽水', '/c101210800-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('75', '金华', '/c101210900-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('76', '衢州', '/c101211000-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('77', '舟山', '/c101211100-p100101/d_202-e_104/', '6');
INSERT INTO `boss_city_info` VALUES ('78', '合肥', '/c101220100-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('79', '蚌埠', '/c101220200-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('80', '芜湖', '/c101220300-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('81', '淮南', '/c101220400-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('82', '马鞍山', '/c101220500-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('83', '安庆', '/c101220600-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('84', '宿州', '/c101220700-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('85', '阜阳', '/c101220800-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('86', '亳州', '/c101220900-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('87', '滁州', '/c101221000-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('88', '淮北', '/c101221100-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('89', '铜陵', '/c101221200-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('90', '宣城', '/c101221300-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('91', '六安', '/c101221400-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('92', '池州', '/c101221500-p100101/d_202-e_104/', '7');
INSERT INTO `boss_city_info` VALUES ('93', '黄山', '/c101221600-p100101/d_202-e_104/', '7');

-- ----------------------------
-- Table structure for boss_educational_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_educational_info`;
CREATE TABLE `boss_educational_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `educational` varchar(10) NOT NULL,
  `educational_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_educational_info
-- ----------------------------
INSERT INTO `boss_educational_info` VALUES ('1', '不限', '0');
INSERT INTO `boss_educational_info` VALUES ('2', '初中及以下', '209');
INSERT INTO `boss_educational_info` VALUES ('3', '中技', '208');
INSERT INTO `boss_educational_info` VALUES ('4', '高中', '206');
INSERT INTO `boss_educational_info` VALUES ('5', '大专', '202');
INSERT INTO `boss_educational_info` VALUES ('6', '本科', '203');
INSERT INTO `boss_educational_info` VALUES ('7', '硕士', '204');
INSERT INTO `boss_educational_info` VALUES ('8', '博士', '205');

-- ----------------------------
-- Table structure for boss_experience_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_experience_info`;
CREATE TABLE `boss_experience_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `experience` varchar(10) NOT NULL,
  `experience_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_experience_info
-- ----------------------------
INSERT INTO `boss_experience_info` VALUES ('1', '不限', '0');
INSERT INTO `boss_experience_info` VALUES ('2', '在校生', '108');
INSERT INTO `boss_experience_info` VALUES ('3', '应届生', '102');
INSERT INTO `boss_experience_info` VALUES ('4', '1年以内', '103');
INSERT INTO `boss_experience_info` VALUES ('5', '1-3年', '104');
INSERT INTO `boss_experience_info` VALUES ('6', '3-5年', '105');
INSERT INTO `boss_experience_info` VALUES ('7', '5-10年', '106');
INSERT INTO `boss_experience_info` VALUES ('8', '10年以上', '107');

-- ----------------------------
-- Table structure for boss_financing_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_financing_info`;
CREATE TABLE `boss_financing_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `financing` varchar(10) NOT NULL,
  `financing_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_financing_info
-- ----------------------------
INSERT INTO `boss_financing_info` VALUES ('1', '不限', '0');
INSERT INTO `boss_financing_info` VALUES ('2', '未融资', '801');
INSERT INTO `boss_financing_info` VALUES ('3', '天使轮', '802');
INSERT INTO `boss_financing_info` VALUES ('4', 'A轮', '803');
INSERT INTO `boss_financing_info` VALUES ('5', 'B轮', '804');
INSERT INTO `boss_financing_info` VALUES ('6', 'C轮', '805');
INSERT INTO `boss_financing_info` VALUES ('7', 'D轮及以上', '806');
INSERT INTO `boss_financing_info` VALUES ('8', '已上市', '807');
INSERT INTO `boss_financing_info` VALUES ('9', '不需要融资', '808');

-- ----------------------------
-- Table structure for boss_hot_city_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_hot_city_info`;
CREATE TABLE `boss_hot_city_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `city` varchar(8) NOT NULL,
  `city_code` varchar(32) NOT NULL,
  `province_key` int(11) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_hot_city_info
-- ----------------------------
INSERT INTO `boss_hot_city_info` VALUES ('1', '全国', '/c100010000/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('2', '北京', '/c101010100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('3', '上海', '/c101020100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('4', '广州', '/c101280100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('5', '深圳', '/c101280600/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('6', '杭州', '/c101210100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('7', '天津', '/c101030100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('8', '西安', '/c101110100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('9', '苏州', '/c101190400/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('10', '武汉', '/c101200100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('11', '厦门', '/c101230200/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('12', '长沙', '/c101250100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('13', '成都', '/c101270100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('14', '郑州', '/c101180100/', '1');
INSERT INTO `boss_hot_city_info` VALUES ('15', '济南', '/c101120100/', '1');

-- ----------------------------
-- Table structure for boss_province_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_province_info`;
CREATE TABLE `boss_province_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `province` varchar(8) NOT NULL,
  `province_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_province_info
-- ----------------------------
INSERT INTO `boss_province_info` VALUES ('1', '哈尔滨', '/c101050100-p100101/d_202-e_104/');
INSERT INTO `boss_province_info` VALUES ('2', '吉林', '/c101060100-p100101/d_202-e_104/');
INSERT INTO `boss_province_info` VALUES ('3', '辽宁', '/');
INSERT INTO `boss_province_info` VALUES ('4', '山东', '/');
INSERT INTO `boss_province_info` VALUES ('5', '江苏', '/');
INSERT INTO `boss_province_info` VALUES ('6', '浙江', '/');
INSERT INTO `boss_province_info` VALUES ('7', '安徽', '/');

-- ----------------------------
-- Table structure for boss_salary_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_salary_info`;
CREATE TABLE `boss_salary_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `salary` varchar(10) NOT NULL,
  `salary_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_salary_info
-- ----------------------------
INSERT INTO `boss_salary_info` VALUES ('1', '不限', '0');
INSERT INTO `boss_salary_info` VALUES ('2', '3K以下', '1');
INSERT INTO `boss_salary_info` VALUES ('3', '3-5K', '2');
INSERT INTO `boss_salary_info` VALUES ('4', '5-10K', '3');
INSERT INTO `boss_salary_info` VALUES ('5', '10-15K', '4');
INSERT INTO `boss_salary_info` VALUES ('6', '15-20K', '5');
INSERT INTO `boss_salary_info` VALUES ('7', '20-30K', '6');
INSERT INTO `boss_salary_info` VALUES ('8', '30-50K', '7');
INSERT INTO `boss_salary_info` VALUES ('9', '50K以上', '8');

-- ----------------------------
-- Table structure for boss_scale_info
-- ----------------------------
DROP TABLE IF EXISTS `boss_scale_info`;
CREATE TABLE `boss_scale_info` (
  `primary_key` int(1) NOT NULL AUTO_INCREMENT,
  `scale` varchar(10) NOT NULL,
  `scale_code` varchar(32) NOT NULL,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss_scale_info
-- ----------------------------
INSERT INTO `boss_scale_info` VALUES ('1', '不限', '0');
INSERT INTO `boss_scale_info` VALUES ('2', '301', '0-20人');
INSERT INTO `boss_scale_info` VALUES ('3', '302', '20-99人');
INSERT INTO `boss_scale_info` VALUES ('4', '303', '100-499人');
INSERT INTO `boss_scale_info` VALUES ('5', '304', '500-999人');
INSERT INTO `boss_scale_info` VALUES ('6', '305', '1000-9999人');
INSERT INTO `boss_scale_info` VALUES ('7', '306', '10000人以上');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `primary_key` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(32) NOT NULL,
  `company_name` varchar(32) NOT NULL,
  `salary` decimal(10,0) NOT NULL,
  `area` int(1) DEFAULT NULL,
  `city` int(1) NOT NULL,
  `experience` int(1) NOT NULL,
  `educational` int(1) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`primary_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
