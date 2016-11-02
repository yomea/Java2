CREATE DATABASE seckill;

USE seckill; 

DROP TABLE IF EXISTS seckill\g

CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '��ɱid��',
  `name` varchar(120) NOT NULL COMMENT '��Ʒ����',
  `number` int(11) NOT NULL COMMENT '�������',
  `start_time` datetime NOT NULL COMMENT '��ɱ��ʼʱ��',
  `end_time` datetime NOT NULL COMMENT '��ɱ����ʱ��',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`seckill_id`),
  KEY `index_starttime` (`start_time`),
  KEY `index_endtime` (`end_time`),
  KEY `index_createtime` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ��Ʒ��'\g

DROP TABLE IF EXISTS success_seckill\g

CREATE TABLE success_seckill(
     `seckill_id` bigint not null COMMENT '��ɱ�ɹ�id',
     `user_phone` bigint not null COMMENT '��ɱ�ɹ��ߵĵ绰',
     `state` tinyint not null default -1 comment '-1:��Ч,0:��ɱ�ɹ�,1:�Ѹ���,2:�ѷ���',
     `create_time` datetime not null default current_timestamp comment '����ʱ��',
     primary key(seckill_id,user_phone),
     index index_createtime(create_time)
)engine=InnoDB charset=utf8 comment='��ɱ��Ʒ��'\g