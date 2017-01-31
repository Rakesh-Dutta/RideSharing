CREATE TABLE `car_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `model` VARCHAR(45) NOT NULL,
  `make` VARCHAR(45) NULL,
  `year` INT NULL,
  `type` ENUM('BASIC', 'LUX') NULL,
  `created` TIMESTAMP NULL DEFAULT now(),
  `modified` TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (`id`));