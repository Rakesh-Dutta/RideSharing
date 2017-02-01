CREATE TABLE `cars` (
  `id`              int(11)         NOT NULL      AUTO_INCREMENT,
  `version`         int(11)         NOT NULL      DEFAULT '0',
  `model`           varchar(45)     NOT NULL,
  `make`            varchar(45)                   DEFAULT NULL,
  `year`            int(11)                       DEFAULT NULL,
  `type`            enum('BASIC','LUX')           DEFAULT NULL,
  `created`         timestamp       NULL          DEFAULT CURRENT_TIMESTAMP,
  `modified`        timestamp       NULL          DEFAULT CURRENT_TIMESTAMP,
  `driver_id` int(11)               NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_driver_id_idx` (`driver_id`),
  CONSTRAINT `fk_driver_id` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
