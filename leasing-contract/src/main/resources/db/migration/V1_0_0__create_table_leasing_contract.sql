CREATE TABLE `leasing_contract` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contract_number` bigint NOT NULL,
  `monthly_rate` double NOT NULL,
  `customer_id` bigint NOT NULL,
  `vehicle_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_srimp5tauqe3elaqxctstvkpn` (`vehicle_id`),
  KEY `FKpxeeq63s4vh9272vr2tipsh2s` (`customer_id`),
  CONSTRAINT `FKpxeeq63s4vh9272vr2tipsh2s` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKqpkf9hkk4ps9mg91ifuc16qni` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
