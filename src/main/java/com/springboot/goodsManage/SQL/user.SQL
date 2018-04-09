DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
