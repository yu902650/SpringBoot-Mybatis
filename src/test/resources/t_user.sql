CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8