-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `seller`

CREATE TABLE `seller`
(
 `id_seller`    INT NOT NULL AUTO_INCREMENT ,
 `id_type`      INT NOT NULL ,
 `name_seller`  VARCHAR(45) NOT NULL ,
 `requisites`   VARCHAR(100) NOT NULL ,
 `address`      VARCHAR(60) NOT NULL ,
 `phone_number` VARCHAR(15) NOT NULL ,
 `email`        VARCHAR(45) NOT NULL ,
 `bank_account` INT NOT NULL ,

PRIMARY KEY (`id_seller`),
KEY `fkIdx_114` (`id_type`),
CONSTRAINT `FK_113` FOREIGN KEY `fkIdx_114` (`id_type`) REFERENCES `business_type` (`id_type`)
);





