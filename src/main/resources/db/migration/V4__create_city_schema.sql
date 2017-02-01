CREATE TABLE `cities` (
  `id`            INT         NOT NULL    AUTO_INCREMENT,
  `version`       INT         NOT NULL    DEFAULT 0,
  `name`          VARCHAR(45) NOT NULL,
  `state`         VARCHAR(45) NOT NULL,
  `day_rate`      DOUBLE      NOT NULL    DEFAULT 0.0,
  `night_rate`    DOUBLE      NOT NULL    DEFAULT 0.0,
  `created`       TIMESTAMP   NOT NULL    DEFAULT now(),
  `modified`      TIMESTAMP   NULL        DEFAULT now(),
  PRIMARY KEY (`id`));
