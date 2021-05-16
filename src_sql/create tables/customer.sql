-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `customer`

CREATE TABLE `customer`
(
 `id_customer`  INT NOT NULL AUTO_INCREMENT ,
 `name_cust`    VARCHAR(45) NOT NULL ,
 `requisites`   VARCHAR(100) NOT NULL ,
 `address`      VARCHAR(60) NOT NULL ,
 `phone_number` VARCHAR(15) NOT NULL ,
 `email`        VARCHAR(45) NOT NULL ,
 `banc_account` INT NOT NULL ,

PRIMARY KEY (`id_customer`)
);





