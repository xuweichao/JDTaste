/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22 : Database - jdtaste
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jdtaste` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `jdtaste`;

/*Table structure for table `product_base` */

DROP TABLE IF EXISTS `product_base`;

CREATE TABLE `product_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_code` varchar(10) DEFAULT NULL COMMENT '分类代码',
  `product_id` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `title` varchar(10) NOT NULL COMMENT '商品名称',
  `display_title` varchar(30) DEFAULT NULL COMMENT '商品标题',
  `sale_price` double DEFAULT '0' COMMENT '销售价格',
  `origin_price` double DEFAULT '0' COMMENT '原价',
  `summary` varchar(100) DEFAULT NULL COMMENT '简单描述',
  `stock` int(11) DEFAULT '0' COMMENT '库存数量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数量',
  `select_num` int(11) DEFAULT '0' COMMENT '收藏数量',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态 0下架 1上架',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COMMENT='商品基本信息表';

/*Data for the table `product_base` */

/*Table structure for table `product_classify` */

DROP TABLE IF EXISTS `product_classify`;

CREATE TABLE `product_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '分类名称',
  `code` varchar(10) DEFAULT NULL COMMENT '分类代码',
  `parent_id` int(11) DEFAULT '0' COMMENT '父分类id',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COMMENT='产品分类表';

/*Data for the table `product_classify` */

insert  into `product_classify`(`id`,`name`,`code`,`parent_id`,`status`,`create_time`,`update_time`) values (23,'特色水果','A',0,1,'2018-07-13 18:32:30','2018-07-17 12:19:09'),(46,'特色海产品','H',0,1,'2018-07-16 15:13:04','2018-07-16 15:13:04'),(52,'苹果','A-PG',23,1,'2018-07-16 15:44:09','2018-07-17 14:05:42'),(54,'草莓','A-CM',23,1,'2018-07-16 16:03:19','2018-07-17 14:05:49'),(56,'海鲜','H-HX',46,1,'2018-07-16 16:04:34','2018-07-18 10:30:26'),(59,'网纹瓜','A-WWG',23,1,'2018-07-16 17:57:54','2018-07-16 17:57:54'),(66,'土特产','T',0,1,'2018-07-17 13:48:49','2018-07-17 13:48:49'),(67,'花生','T-HS',66,1,'2018-07-17 13:49:16','2018-07-17 14:05:32'),(68,'干货','H-GH',46,1,'2018-07-17 13:49:56','2018-07-18 10:30:53'),(69,'樱桃','A-YT',23,1,'2018-07-17 14:06:29','2018-07-17 14:06:29'),(71,'蔬菜','T-SC',66,1,'2018-07-18 10:29:31','2018-07-18 10:29:31'),(72,'特色副食品','F',0,1,'2018-07-20 18:00:31','2018-07-20 18:00:31'),(73,'花生油','F-HSY',72,1,'2018-07-20 18:07:38','2018-07-20 18:07:38');

/*Table structure for table `product_specific` */

DROP TABLE IF EXISTS `product_specific`;

CREATE TABLE `product_specific` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag` varchar(10) NOT NULL COMMENT '标签名称',
  `code` varchar(10) DEFAULT NULL COMMENT '标签代码',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COMMENT='产品规格表';

/*Data for the table `product_specific` */

insert  into `product_specific`(`id`,`tag`,`code`,`status`,`create_time`,`update_time`) values (42,'重量','weight',1,'2018-07-18 16:18:07','2018-07-18 16:18:07'),(44,'产地','origin',1,'2018-07-18 16:39:13','2018-07-18 16:53:13'),(45,'省份','privince',1,'2018-07-18 16:52:41','2018-07-18 16:52:41'),(46,'城市','city',1,'2018-07-18 16:53:01','2018-07-18 16:53:01'),(47,'供应方式','supply',1,'2018-07-18 16:55:01','2018-07-18 16:55:01'),(48,'打包方式','package',1,'2018-07-20 15:58:47','2018-07-20 15:58:47'),(49,'商品类型','type',1,'2018-07-20 16:00:08','2018-07-20 16:00:08'),(50,'是否有机','organic',1,'2018-07-20 16:44:01','2018-07-20 16:44:01');

/*Table structure for table `product_specific_tmp` */

DROP TABLE IF EXISTS `product_specific_tmp`;

CREATE TABLE `product_specific_tmp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_id` int(11) NOT NULL COMMENT '分类id',
  `classify_name` varchar(10) NOT NULL COMMENT '分类名称',
  `specifics` text COMMENT '规格列表',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='产品规格模板表';

/*Data for the table `product_specific_tmp` */

insert  into `product_specific_tmp`(`id`,`classify_id`,`classify_name`,`specifics`,`status`,`create_time`,`update_time`) values (2,23,'特色水果','[{\"id\":50,\"tag\":\"是否有机\",\"code\":\"organic\",\"value\":null},{\"id\":49,\"tag\":\"商品类型\",\"code\":\"type\",\"value\":null},{\"id\":48,\"tag\":\"打包方式\",\"code\":\"package\",\"value\":null},{\"id\":47,\"tag\":\"供应方式\",\"code\":\"supply\",\"value\":null},{\"id\":44,\"tag\":\"产地\",\"code\":\"origin\",\"value\":null},{\"id\":44,\"tag\":\"产地\",\"code\":\"origin\",\"value\":null},{\"id\":46,\"tag\":\"城市\",\"code\":\"city\",\"value\":null},{\"id\":45,\"tag\":\"省份\",\"code\":\"privince\",\"value\":null},{\"id\":42,\"tag\":\"重量\",\"code\":\"weight\",\"value\":null},{\"id\":42,\"tag\":\"重量\",\"code\":\"weight\",\"value\":null}]',1,'2018-07-20 11:06:32','2018-07-20 17:28:02'),(3,46,'特色海产品','[{\"id\":48,\"tag\":\"打包方式\",\"code\":\"package\",\"value\":null},{\"id\":47,\"tag\":\"供应方式\",\"code\":\"supply\",\"value\":null},{\"id\":44,\"tag\":\"产地\",\"code\":\"origin\",\"value\":null},{\"id\":46,\"tag\":\"城市\",\"code\":\"city\",\"value\":null},{\"id\":45,\"tag\":\"省份\",\"code\":\"privince\",\"value\":null},{\"id\":42,\"tag\":\"重量\",\"code\":\"weight\",\"value\":null}]',1,'2018-07-20 12:12:26','2018-07-20 17:28:16'),(6,66,'土特产','[{\"id\":49,\"tag\":\"商品类型\",\"code\":\"type\",\"value\":null},{\"id\":48,\"tag\":\"打包方式\",\"code\":\"package\",\"value\":null},{\"id\":47,\"tag\":\"供应方式\",\"code\":\"supply\",\"value\":null},{\"id\":44,\"tag\":\"产地\",\"code\":\"origin\",\"value\":null},{\"id\":46,\"tag\":\"城市\",\"code\":\"city\",\"value\":null},{\"id\":45,\"tag\":\"省份\",\"code\":\"privince\",\"value\":null},{\"id\":42,\"tag\":\"重量\",\"code\":\"weight\",\"value\":null}]',1,'2018-07-20 16:42:26','2018-07-20 16:42:26'),(7,72,'特色副食品','[{\"id\":50,\"tag\":\"是否有机\",\"code\":\"organic\",\"value\":null},{\"id\":49,\"tag\":\"商品类型\",\"code\":\"type\",\"value\":null},{\"id\":48,\"tag\":\"打包方式\",\"code\":\"package\",\"value\":null},{\"id\":47,\"tag\":\"供应方式\",\"code\":\"supply\",\"value\":null},{\"id\":44,\"tag\":\"产地\",\"code\":\"origin\",\"value\":null},{\"id\":46,\"tag\":\"城市\",\"code\":\"city\",\"value\":null},{\"id\":45,\"tag\":\"省份\",\"code\":\"privince\",\"value\":null},{\"id\":42,\"tag\":\"重量\",\"code\":\"weight\",\"value\":null}]',1,'2018-07-20 18:00:45','2018-07-20 18:00:45');

/*Table structure for table `user_base` */

DROP TABLE IF EXISTS `user_base`;

CREATE TABLE `user_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(16) NOT NULL COMMENT '账号',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_base` */

insert  into `user_base`(`id`,`account`,`phone`,`password`,`email`,`user_name`,`status`,`create_time`,`update_time`) values (16,'18612908620','18612908620','96e79218965eb72c92a549dd5a330112',NULL,'小丑鱼',1,'2018-07-03 11:22:53','2018-07-03 14:14:34'),(17,'18612908622','18612908622','96e79218965eb72c92a549dd5a330112',NULL,NULL,1,'2018-07-05 14:03:59','2018-07-05 14:03:59');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
