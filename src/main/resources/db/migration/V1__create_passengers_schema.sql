CREATE TABLE `passengers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NULL,
  `gender` ENUM('M', 'F') NULL,
  `age` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT now(),
  `modified` TIMESTAMP NOT NULL DEFAULT now(),
  `credit` DOUBLE NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`id`));