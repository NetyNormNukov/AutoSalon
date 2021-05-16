-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `cost_car`

CREATE TABLE `cost_car`
(
 `id_cost_car` INT NOT NULL AUTO_INCREMENT ,
 `id_car`      INT NOT NULL ,
 `cost`        DOUBLE NOT NULL ,

PRIMARY KEY (`id_cost_car`),
KEY `fkIdx_182` (`id_car`),
CONSTRAINT `FK_181` FOREIGN KEY `fkIdx_182` (`id_car`) REFERENCES `car` (`id_car`)
);





