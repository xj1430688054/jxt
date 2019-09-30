/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.56 : Database - tong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tong` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tong`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`name`,`password`) values (2,'2222','96e79218965eb72c92a549dd5a330112');

/*Table structure for table `tb_category` */

DROP TABLE IF EXISTS `tb_category`;

CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL COMMENT '系别id',
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `tb_category_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_category` */

insert  into `tb_category`(`id`,`name`,`department_id`) values (1,'BIM',2),(2,'结构设计',2),(4,'装饰工程设计',2),(5,'钢结构设计',2);

/*Table structure for table `tb_department` */

DROP TABLE IF EXISTS `tb_department`;

CREATE TABLE `tb_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '系别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_department` */

insert  into `tb_department`(`id`,`name`) values (2,'土木工程'),(3,'工程管理'),(5,'给排水设计');

/*Table structure for table `tb_group` */

DROP TABLE IF EXISTS `tb_group`;

CREATE TABLE `tb_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '队名',
  `captain_id` int(11) DEFAULT NULL COMMENT '队长id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `tb_group` */

insert  into `tb_group`(`id`,`name`,`captain_id`,`create_time`) values (1,'qqq',2,'2018-11-17 14:40:03'),(69,'666',NULL,'2018-12-06 00:31:31');

/*Table structure for table `tb_item` */

DROP TABLE IF EXISTS `tb_item`;

CREATE TABLE `tb_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `type` int(11) DEFAULT NULL COMMENT '选取类型',
  `state` int(11) DEFAULT '0' COMMENT '状态 未取:0 已取:1',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `tb_item` */

insert  into `tb_item`(`id`,`name`,`type`,`state`,`create_time`) values (1,'www',1,0,'2018-11-08 22:10:49'),(2,'茂名中学宿舍楼',1,0,'2018-11-25 22:14:30'),(12,'深圳市混凝土公司',0,NULL,'2018-12-11 16:35:53'),(13,'湛江小学教学楼',NULL,NULL,'2018-12-11 18:04:59'),(14,'广东省佛山市依岸康堤花园-幼儿园',0,NULL,'2018-12-11 18:10:32'),(15,'广西省合山市人民医院妇儿科病房楼',0,NULL,'2018-12-11 18:10:44'),(16,'江西省上饶市美地印象33号住宅楼',0,NULL,'2018-12-11 18:10:49'),(17,'广东省广州市幸福花园项目',0,NULL,'2018-12-11 18:10:54'),(18,'宁夏省银川市荣丰苑',0,NULL,'2018-12-11 18:10:59'),(19,'四川省成都市钢木门生产项目-1号办公楼',0,NULL,'2018-12-11 18:11:08'),(20,'河南省南阳市城乡一体化示范区盆窑棚户区安置房1号楼',0,NULL,'2018-12-11 18:11:12'),(21,'广东省佛山市依岸康堤花园-幼儿园',0,NULL,'2018-12-11 18:11:16'),(22,'广东省湛江市麻章区职工宿舍倒班楼',0,NULL,'2018-12-11 18:11:20'),(23,'河北省廊坊市嘉美服装服饰有限公司-1号楼',0,NULL,'2018-12-11 18:11:25'),(24,'安微六安市社保局办公楼工程',0,NULL,'2018-12-11 18:11:29'),(25,'海南省清水湾工程',0,NULL,'2018-12-11 18:11:33'),(26,'杭州市农机学校1号楼',0,NULL,'2018-12-11 18:11:38'),(27,'南阳市盆窑安置房1#楼',0,NULL,'2018-12-11 18:11:41'),(28,'泉州市保利地产1#楼',0,NULL,'2018-12-11 18:11:46'),(29,'泉州市保利地产2#楼',0,NULL,'2018-12-11 18:11:51'),(30,'泉州市保利地产5#楼',0,NULL,'2018-12-11 18:11:55'),(31,'福建省武夷山市华庭5号楼',0,NULL,'2018-12-11 18:12:01'),(32,'江苏省连云港市康乐园小区住宅楼',0,NULL,'2018-12-11 18:12:06'),(33,'江西省南昌市东方塞纳住宅楼',0,NULL,'2018-12-11 18:12:10'),(34,'深圳市混凝土分公司',0,NULL,'2018-12-13 21:23:19');

/*Table structure for table `tb_item_category` */

DROP TABLE IF EXISTS `tb_item_category`;

CREATE TABLE `tb_item_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL COMMENT '条目id',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `state` int(11) DEFAULT '0' COMMENT '选取状态 0:未选取 1:以选取',
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `tb_item_category_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`id`),
  CONSTRAINT `tb_item_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Data for the table `tb_item_category` */

insert  into `tb_item_category`(`id`,`item_id`,`category_id`,`state`) values (11,12,1,0),(12,12,2,1),(13,12,4,1),(14,13,1,0),(15,13,2,0),(16,2,1,0),(17,2,2,0),(18,14,1,0),(19,14,2,0),(20,15,1,0),(21,15,2,0),(22,16,1,0),(23,16,2,0),(24,17,1,0),(25,17,2,0),(26,18,1,0),(27,18,2,0),(28,19,1,0),(29,19,2,0),(30,19,4,0),(31,20,1,0),(32,20,2,0),(33,20,4,0),(34,21,1,0),(35,21,2,0),(36,21,4,0),(37,22,1,0),(38,22,2,0),(39,22,4,0),(40,23,1,0),(41,23,2,0),(42,23,4,0),(43,24,1,0),(44,24,2,0),(45,24,4,0),(46,25,1,0),(47,25,2,0),(48,25,4,0),(49,26,1,0),(50,26,2,0),(51,26,4,0),(52,27,1,0),(53,27,2,0),(54,27,4,0),(55,28,1,0),(56,28,2,0),(57,28,4,0),(58,29,1,0),(59,29,2,0),(60,29,4,0),(61,30,1,0),(62,30,2,0),(63,30,4,0),(64,31,1,0),(65,31,2,0),(66,31,4,0),(67,32,1,0),(68,32,2,0),(69,33,1,0),(70,33,2,0),(71,34,1,0),(72,34,2,0),(73,34,5,0),(75,1,1,0),(76,1,2,0);

/*Table structure for table `tb_member` */

DROP TABLE IF EXISTS `tb_member`;

CREATE TABLE `tb_member` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `number` varchar(84) DEFAULT NULL COMMENT '学号',
  `name` varchar(100) DEFAULT '' COMMENT '姓名',
  `department_id` int(100) DEFAULT NULL COMMENT '系别id',
  `class` varchar(100) DEFAULT '' COMMENT '班级',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `contact_phone` varchar(100) DEFAULT '' COMMENT '联系电话',
  `contact_email` varchar(100) DEFAULT '' COMMENT '电子邮箱',
  `state` int(11) DEFAULT '0' COMMENT '状态 未选：0 已选：1',
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `tb_member_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `tb_member` */

insert  into `tb_member`(`id`,`number`,`name`,`department_id`,`class`,`password`,`contact_phone`,`contact_email`,`state`) values (2,'10086','Lucas',2,'1502','123','13413639666','296282000@qq.com',1),(3,'13123','ooo',2,'1502','3333','13413632222','296282000@qq.com',0),(5,'213','weqw',NULL,'15土木工程三班','111','31234551331','296282000@qq.com',0),(6,'11234','erwr',2,'1502','111','31234551331','296282000@qq.com',0),(7,'123123','erwr',2,'1502','111','31234551331','296282000@qq.com',0),(11,'12312','ease',2,'1502','111','31234551331','296282000@qq.com',0),(12,'1231','wwwq',2,'1502','111','31234551331','296282000@qq.com',0),(13,'2015017250212','李其林',3,'1502','96e79218965eb72c92a549dd5a330112','1313133232321','6666@qq.com',1),(15,'2015017250111','李其林',3,'1502','96e79218965eb72c92a549dd5a330112','1313133232321','Lucas001@qq.com',0),(16,'2015017251111','李其林',3,'1502','96e79218965eb72c92a549dd5a330112','13131332111','Lucas001@qq.com',0),(17,'2015017250233','王龙海',3,'1502','96e79218965eb72c92a549dd5a330112','13131313131313','Lucas001@qq.com',0),(18,'2015017253333','李其林',2,'1502','96e79218965eb72c92a549dd5a330112','13131313131313','Lucas001@qq.com',0),(19,'2015017254444','李其林',2,'1502','96e79218965eb72c92a549dd5a330112','13131313131313','Lucas001@qq.com',0);

/*Table structure for table `tb_member_order` */

DROP TABLE IF EXISTS `tb_member_order`;

CREATE TABLE `tb_member_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL COMMENT '成员id',
  `item_id` int(11) NOT NULL COMMENT '条目id',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `group_id` int(11) DEFAULT NULL COMMENT '团队id',
  `teacher_id` int(11) NOT NULL COMMENT '教师id',
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `item_id` (`item_id`),
  KEY `category_id` (`category_id`),
  KEY `group_id` (`group_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `tb_member_order_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tb_member` (`id`),
  CONSTRAINT `tb_member_order_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`id`),
  CONSTRAINT `tb_member_order_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`),
  CONSTRAINT `tb_member_order_ibfk_4` FOREIGN KEY (`group_id`) REFERENCES `tb_group` (`id`),
  CONSTRAINT `tb_member_order_ibfk_5` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `tb_member_order` */

insert  into `tb_member_order`(`id`,`member_id`,`item_id`,`category_id`,`group_id`,`teacher_id`) values (14,2,12,4,NULL,34),(18,13,12,2,NULL,9);

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_order_id` int(11) NOT NULL COMMENT '成员订单id',
  `group_id` int(11) DEFAULT NULL COMMENT '团队id',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类别 0:个人 1:团队',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `member_order_id` (`member_order_id`),
  KEY `tb_order_ibfk_2` (`group_id`),
  CONSTRAINT `tb_order_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `tb_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tb_order_ibfk_4` FOREIGN KEY (`member_order_id`) REFERENCES `tb_member_order` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

insert  into `tb_order`(`id`,`member_order_id`,`group_id`,`type`,`create_time`) values (14,14,NULL,0,'2018-12-14 15:46:23'),(18,18,NULL,0,'2018-12-16 16:02:56');

/*Table structure for table `tb_system` */

DROP TABLE IF EXISTS `tb_system`;

CREATE TABLE `tb_system` (
  `jkey` varchar(100) NOT NULL,
  `jvalue` varchar(500) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_system` */

insert  into `tb_system`(`jkey`,`jvalue`,`description`) values ('IS_OPEN_CHOOSE','0','是否开放选择条目 1:关闭 0:开启'),('IS_OPEN_GROUP','1','是否开启团队功能 1:关闭 0:开启'),('IS_OPEN_REGISTER','0','是否开启注册功能 1:关闭 0:开启'),('MEMBER_MAX_COUNT','20','学生最大数量'),('MEMBER_ORDER_DELETE','0','是否开放用户删除订单 1:关闭 0:开启');

/*Table structure for table `tb_teacher` */

DROP TABLE IF EXISTS `tb_teacher`;

CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL COMMENT '容量',
  `student_count` int(11) DEFAULT NULL COMMENT '学生数量',
  `content` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher` */

insert  into `tb_teacher`(`id`,`name`,`capacity`,`student_count`,`content`) values (9,'李其林',23,23,'凄凄切切去去去'),(11,'高刚性',22,2,''),(12,'王五',22,2,'一行白鹭上青天'),(13,'赵信',22,2,''),(14,'韩星',22,3,''),(15,'信息',22,6,''),(16,'之前',22,8,''),(17,'dome1',22,8,''),(18,'dome2',22,8,''),(19,'dome3',22,8,''),(20,'dome4',22,8,''),(21,'dome5',22,8,''),(22,'dome6',22,8,''),(23,'dome7',22,8,''),(24,'dome8',22,8,''),(25,'dome9',22,8,''),(26,'dome10',22,8,''),(27,'dome11',22,8,''),(28,'dome12',22,8,''),(29,'dome13',22,8,''),(30,'dome14',22,8,''),(31,'dome15',22,8,''),(32,'dome16',22,8,''),(34,'罗伟',40,30,''),(35,'王龙海',15,15,'我是王龙海');

/*Table structure for table `tb_teacher_category` */

DROP TABLE IF EXISTS `tb_teacher_category`;

CREATE TABLE `tb_teacher_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `tb_teacher_category_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`),
  CONSTRAINT `tb_teacher_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher_category` */

insert  into `tb_teacher_category`(`id`,`teacher_id`,`category_id`) values (8,9,2),(9,16,1),(10,16,2),(13,35,5),(14,14,1),(15,14,2),(16,14,4),(17,14,5),(18,12,1),(19,12,2),(20,12,4),(21,12,5),(22,34,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
