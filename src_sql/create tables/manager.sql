-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `manager`

CREATE TABLE `manager`
(
 `id_m`          INT NOT NULL AUTO_INCREMENT ,
 `id_department` INT NOT NULL ,
 `name`          VARCHAR(45) NOT NULL ,
 `surname`       VARCHAR(45) NOT NULL ,
 `address`       VARCHAR(45) NOT NULL ,
 `phone_number`  VARCHAR(45) NOT NULL ,
 `email`         VARCHAR(45) NOT NULL ,
 `password`      VARCHAR(8) NOT NULL ,

PRIMARY KEY (`id_m`),
KEY `fkIdx_104` (`id_department`),
CONSTRAINT `FK_103` FOREIGN KEY `fkIdx_104` (`id_department`) REFERENCES `department` (`id_department`)
);





