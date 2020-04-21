CREATE TABLE `COMMENT` (
  `comment_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(500) NULL,
  `create_at` DATETIME NOT NULL,
  PRIMARY KEY (`comment_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `COMMENT` (`comment_id`, `message`, `create_at`) VALUES ('1', '더미메시지1', '2020-04-21 22:57:25');
INSERT INTO `COMMENT` (`comment_id`, `message`, `create_at`) VALUES ('2', '더미메시지2', '2020-04-21 23:57:25');
