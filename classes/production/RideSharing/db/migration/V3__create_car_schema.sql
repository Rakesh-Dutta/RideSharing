CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `model` varchar(45) NOT NULL,
  `make` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `type` enum('BASIC','LUX') DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

