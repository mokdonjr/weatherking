CREATE TABLE `VF_VSRT` (
  `notice_time` BIGINT(20) NOT NULL COMMENT '기상청 발표 시각',
  `forecast_time` BIGINT(20) NOT NULL COMMENT '예보 시각',
  `nx` INT(11) NOT NULL COMMENT 'x좌표',
  `ny` INT(11) NOT NULL COMMENT 'y좌표',
  `category` ENUM('T1H', 'RN1', 'SKY', 'UUU', 'VVV', 'REH', 'PTY', 'LGT', 'VEC', 'WSD') NOT NULL COMMENT '코드',
  `value` VARCHAR(45) NOT NULL COMMENT '코드 값',
  `create_at` DATETIME NOT NULL COMMENT '날씨왕 서버에 기록된 시각',
  PRIMARY KEY (`notice_time`, `forecast_time`, `nx`, `ny`, `category`))
COMMENT = '초단기 예보 조회 기록';
