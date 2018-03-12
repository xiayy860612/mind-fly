-- create account tables

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL,
  `nick_name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NULL,
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NULL,
  `delete_flag` int(1) DEFAULT 0 NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `username_account` (
  `user_id` BIGINT(20) NOT NULL,
  `username` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE IF NOT EXISTS `phone_account` (
  `user_id` BIGINT(20) NOT NULL,
  `phone` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`));
