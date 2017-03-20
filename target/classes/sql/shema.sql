--创建数据库表

--秒杀库存表
'CREATE TABLE `killer` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `seckill_id` bigint(255) NOT NULL COMMENT ''产品id'',
  `user_phone` varchar(255) DEFAULT NULL COMMENT ''用户电话'',
  `state` tinyint(4) DEFAULT ''0'' COMMENT ''-1无效,0成功,1已经付款'',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_id` (`seckill_id`,`user_phone`) USING BTREE COMMENT ''一个用户同一个产品只能抢一次''
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8'

'CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT ''奖品名称'',
  `number` int(11) DEFAULT NULL COMMENT ''奖品数量'',
  `start_time` timestamp NULL DEFAULT NULL COMMENT ''秒杀开始时间'',
  `end_time` timestamp NULL DEFAULT NULL COMMENT ''秒杀结束时间'',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT ''更新时间'',
  PRIMARY KEY (`seckill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8'

-- Query: SELECT * FROM nanshan.killer
LIMIT 0, 1000

-- Date: 2016-12-30 15:22
*/
INSERT INTO `killer` (`id`,`seckill_id`,`user_phone`,`state`,`create_time`,`update_time`) VALUES (1,1,'13261250343',1,'2016-12-22 21:53:17','2016-12-22 21:53:17');
INSERT INTO `killer` (`id`,`seckill_id`,`user_phone`,`state`,`create_time`,`update_time`) VALUES (2,3,'13261250343',1,'2016-12-29 21:04:40','2016-12-29 21:04:46');
/*
-- Query: SELECT * FROM nanshan.seckill
LIMIT 0, 1000

-- Date: 2016-12-30 15:23
*/
INSERT INTO `seckill` (`seckill_id`,`name`,`number`,`start_time`,`end_time`,`create_time`,`update_time`) VALUES (1,'1000元秒杀iphone6',100,'2016-12-22 21:26:25','2016-12-23 21:25:26','2016-12-22 21:26:25','2016-12-22 21:26:25');
INSERT INTO `seckill` (`seckill_id`,`name`,`number`,`start_time`,`end_time`,`create_time`,`update_time`) VALUES (2,'500元秒杀ipad2',200,'2016-12-22 21:26:26','2016-12-23 21:25:26','2016-12-22 21:26:26','2016-12-22 21:26:26');
INSERT INTO `seckill` (`seckill_id`,`name`,`number`,`start_time`,`end_time`,`create_time`,`update_time`) VALUES (3,'300秒杀小米5',300,'2016-12-22 21:26:27','2016-12-23 21:25:26','2016-12-22 21:26:27','2016-12-22 21:26:27');
INSERT INTO `seckill` (`seckill_id`,`name`,`number`,`start_time`,`end_time`,`create_time`,`update_time`) VALUES (4,'200元秒杀红米note',400,'2016-12-22 21:26:28','2016-12-23 21:25:26','2016-12-22 21:26:28','2016-12-22 21:26:28');
