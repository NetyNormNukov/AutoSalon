-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `out`

CREATE TABLE `out`
(
 `id_o`        INT NOT NULL AUTO_INCREMENT ,
 `id_m`        INT NOT NULL ,
 `id_customer` INT NOT NULL ,
 `id_cost_car` INT NOT NULL ,
 `date_deal`   DATE NOT NULL ,
 `count`       INT NOT NULL ,
 `annotation`  VARCHAR(100) NOT NULL ,

PRIMARY KEY (`id_o`),
KEY `fkIdx_202` (`id_cost_car`),
CONSTRAINT `FK_201` FOREIGN KEY `fkIdx_202` (`id_cost_car`) REFERENCES `cost_car` (`id_cost_car`),
KEY `fkIdx_86` (`id_m`),
CONSTRAINT `FK_85` FOREIGN KEY `fkIdx_86` (`id_m`) REFERENCES `manager` (`id_m`),
KEY `fkIdx_89` (`id_customer`),
CONSTRAINT `FK_88` FOREIGN KEY `fkIdx_89` (`id_customer`) REFERENCES `customer` (`id_customer`)
);





