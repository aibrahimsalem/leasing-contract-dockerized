CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthdate` datetime(6) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
