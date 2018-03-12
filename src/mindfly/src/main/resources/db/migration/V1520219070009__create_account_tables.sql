-- create account tables

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL,
  `nick_name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NULL,
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NULL,
  `delete_flag` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `username_account` (
  `user_id` BIGINT(20) NOT NULL,
  `username` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `phone_account` (
  `user_id` BIGINT(20) NOT NULL,
  `phone` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;