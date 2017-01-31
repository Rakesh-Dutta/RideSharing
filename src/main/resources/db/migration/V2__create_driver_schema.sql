CREATE TABLE `driver_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `gender` ENUM('M', 'F') NULL,
  `no_violation` INT NOT NULL DEFAULT 0,
  `created` TIMESTAMP NULL DEFAULT now(),
  `modified` TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (`id`));
