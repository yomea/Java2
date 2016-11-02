CREATE DATABASE seckill;

USE seckill; 

DROP TABLE IF EXISTS seckill\g

CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀id号',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` datetime NOT NULL COMMENT '秒杀开始时间',
  `end_time` datetime NOT NULL COMMENT '秒杀结束时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建表时间',
  PRIMARY KEY (`seckill_id`),
  KEY `index_starttime` (`start_time`),
  KEY `index_endtime` (`end_time`),
  KEY `index_createtime` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀商品表'\g

DROP TABLE IF EXISTS success_seckill\g

CREATE TABLE success_seckill(
     `seckill_id` bigint not null COMMENT '秒杀成功id',
     `user_phone` bigint not null COMMENT '秒杀成功者的电话',
     `state` tinyint not null default -1 comment '-1:无效,0:秒杀成功,1:已付款,2:已发货',
     `create_time` datetime not null default current_timestamp comment '创建时间',
     primary key(seckill_id,user_phone),
     index index_createtime(create_time)
)engine=InnoDB charset=utf8 comment='秒杀商品表'\g