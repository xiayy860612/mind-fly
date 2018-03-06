-- create account tables

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL,
  `nick_name` VARCHAR(100) NOT NULL,
  `create_time` DATETIME NOT NULL,
  `delete_flag` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `common_account` (
  `username` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `email_checked` TINYINT NOT NULL DEFAULT 0,
  `password` VARCHAR(100) NOT NULL,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `create_time` DATETIME NOT NULL,
  UNIQUE INDEX `common_account_user_id_uq` (`user_id` ASC),
  UNIQUE INDEX `account_username_uq` (`username` ASC),
  UNIQUE INDEX `account_email_uq` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8