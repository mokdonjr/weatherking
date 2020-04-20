CREATE TABLE `comment` (
  `comment_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(500) NULL,
  PRIMARY KEY (`comment_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO `weatherking`.`comment` (`comment_id`, `message`) VALUES ('1', '더미메시지1');
INSERT INTO `weatherking`.`comment` (`comment_id`, `message`) VALUES ('2', '더미메시지2');
