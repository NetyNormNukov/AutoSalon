-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `in`

CREATE TABLE `in`
(
 `id_i`        INT NOT NULL AUTO_INCREMENT ,
 `id_seller`   INT NOT NULL ,
 `id_cost_car` INT NOT NULL ,
 `date_deal`   DATE NOT NULL ,
 `count`       INT UNSIGNED NOT NULL ,
 `annotation`  VARCHAR(100) NOT NULL ,

PRIMARY KEY (`id_i`),
KEY `fkIdx_199` (`id_cost_car`),
CONSTRAINT `FK_198` FOREIGN KEY `fkIdx_199` (`id_cost_car`) REFERENCES `cost_car` (`id_cost_car`),
KEY `fkIdx_63` (`id_seller`),
CONSTRAINT `FK_62` FOREIGN KEY `fkIdx_63` (`id_seller`) REFERENCES `seller` (`id_seller`)
);





