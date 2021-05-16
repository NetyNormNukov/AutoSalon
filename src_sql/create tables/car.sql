-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;


-- ************************************** `car`

CREATE TABLE `car`
(
 `id_car`          INT NOT NULL AUTO_INCREMENT ,
 `id_type_body`    INT NOT NULL ,
 `id_mark`         INT NOT NULL ,
 `id_color`        INT NOT NULL ,
 `id_transmission` INT NOT NULL ,
 `id_petrol`       INT NOT NULL ,
 `id_type_drive`   INT NOT NULL ,
 `model`           VARCHAR(45) NOT NULL ,
 `region`          VARCHAR(45) NOT NULL ,
 `engine_volume`   DOUBLE NOT NULL ,
 `year`            YEAR NOT NULL ,
 `seats_number`    INT NOT NULL ,
 `door_number`     INT NOT NULL ,

PRIMARY KEY (`id_car`),
KEY `fkIdx_124` (`id_type_body`),
CONSTRAINT `FK_123` FOREIGN KEY `fkIdx_124` (`id_type_body`) REFERENCES `type_body` (`id_type_body`),
KEY `fkIdx_131` (`id_mark`),
CONSTRAINT `FK_130` FOREIGN KEY `fkIdx_131` (`id_mark`) REFERENCES `auto_mark` (`id_mark`),
KEY `fkIdx_138` (`id_color`),
CONSTRAINT `FK_137` FOREIGN KEY `fkIdx_138` (`id_color`) REFERENCES `color` (`id_color`),
KEY `fkIdx_159` (`id_petrol`),
CONSTRAINT `FK_158` FOREIGN KEY `fkIdx_159` (`id_petrol`) REFERENCES `petrol_type` (`id_petrol`),
KEY `fkIdx_171` (`id_transmission`),
CONSTRAINT `FK_170` FOREIGN KEY `fkIdx_171` (`id_transmission`) REFERENCES `transmission_type` (`id_transmission`),
KEY `fkIdx_178` (`id_type_drive`),
CONSTRAINT `FK_177` FOREIGN KEY `fkIdx_178` (`id_type_drive`) REFERENCES `type_drive` (`id_type_drive`)
);





