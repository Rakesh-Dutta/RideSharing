CREATE TABLE `drivers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `violation` int(11) NOT NULL DEFAULT '0',
  `eligible` tinyint(4) NOT NULL DEFAULT '1',
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));