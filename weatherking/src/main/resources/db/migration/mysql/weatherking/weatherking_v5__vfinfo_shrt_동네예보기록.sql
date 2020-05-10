CREATE TABLE `VF_SHRT` (
  `notice_at` DATETIME NOT NULL COMMENT '기상청 발표 시각',
  `forecast_at` DATETIME NOT NULL COMMENT '예보 시각',
  `nx` INT(11) NOT NULL COMMENT 'x좌표',
  `ny` INT(11) NOT NULL COMMENT 'y좌표',
  `category` ENUM('POP', 'PTY', 'R06', 'REH', 'S06', 'SKY', 'T3H', 'TMN', 'TMX', 'UUU', 'VVV', 'WAV', 'VEC', 'WSD') NOT NULL COMMENT '코드',
  `value` VARCHAR(45) NOT NULL COMMENT '코드 값',
  `create_at` DATETIME NOT NULL COMMENT '날씨왕 서버에 기록된 시각',
  PRIMARY KEY (`notice_at`, `forecast_at`, `nx`, `ny`, `category`))
COMMENT = '동네 예보 조회 기록';
