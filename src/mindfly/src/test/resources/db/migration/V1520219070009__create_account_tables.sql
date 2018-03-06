-- create account tables

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` BIGINT(20) unsigned NOT NULL,
  `nick_name` VARCHAR(100) NOT NULL,
  `create_time` DATETIME NOT NULL,
  `delete_flag` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `common_account` (
  `username` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `email_checked` int(1) NOT NULL DEFAULT 0,
  `password` VARCHAR(100) NOT NULL,
  `user_id` BIGINT(20) unsigned NOT NULL,
  `create_time` DATETIME NOT NULL);