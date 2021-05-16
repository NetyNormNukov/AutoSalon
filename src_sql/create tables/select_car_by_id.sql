SELECT `auto_mark`.`name_mark`, model, `color`,  region, `engine_volume`, `year`,
`type_body`.`type_body`, `transmission_type`.`transmission_type`, `petrol_type`.`petrol_type`,
`type_drive`.`type_drive`, `seats_number`, `door_number`
FROM car
INNER JOIN type_body ON car.`id_type_body` = type_body.id_type_body
INNER JOIN `auto_mark` ON car.`id_mark` = `auto_mark`.`id_mark`
INNER JOIN `transmission_type` ON car.`id_transmission` = `transmission_type`.`id_transmission`
INNER JOIN `petrol_type` ON `car`.`id_petrol` = `petrol_type`.`id_petrol`
INNER JOIN `type_drive` ON `car`.`id_type_drive` = `type_drive`.`id_type_drive`
WHERE auto_mark.name_mark LIKE '%'