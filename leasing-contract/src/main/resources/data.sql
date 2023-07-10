INSERT INTO `leasing_contract`.`customer`(`id`, `birthdate`,`firstname`,`lastname`) VALUES (1, '1990-03-10','ahmed','ibrahim');
INSERT INTO `leasing_contract`.`vehicle` (`id`, `brand`, `model`, `model_year`, `price`, `vehicle_identification_number`) VALUES (1, 'bmw', 'x3', '2022', '10000', '123');
INSERT INTO `leasing_contract`.`leasing_contract` (`id`, `contract_number`, `monthly_rate`, `customer_id`, `vehicle_id`) VALUES (1, 1234, 1.7, 1, 1);

