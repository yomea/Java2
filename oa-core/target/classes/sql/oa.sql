CREATE TABLE `t_orgnization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sn` varchar(20) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `descripion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `duty` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_personId` (`id`),
  KEY `FK_org_id` (`org_id`),
  CONSTRAINT `FK_org_id` FOREIGN KEY (`org_id`) REFERENCES `t_orgnization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL COMMENT '”√ªßid£¨oneToone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_person_id` (`person_id`),
  CONSTRAINT `FK_person_id` FOREIGN KEY (`person_id`) REFERENCES `t_person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     

CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sn` varchar(20) NOT NULL,
  `url` varchar(20) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_name` (`name`),
  UNIQUE KEY `UK_sn` (`sn`),
  KEY `FK_parent_id` (`parent_id`),
  CONSTRAINT `FK_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `t_person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_id` (`role_id`),
  KEY `FK_user_id` (`user_id`),
  CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;