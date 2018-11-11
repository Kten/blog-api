CREATE TABLE `boards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT false,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE `board_contents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) NOT NULL,
  `contents` text,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;