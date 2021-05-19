package database;

import java.lang.reflect.Field;

public class SQLBuilder implements Cloneable{
    private String SQL = "";
    private String nameMark = "";
    private String bodyType = "";
    private String transmissionType = "";
    private String petrolType = "";
    private String driveType = "";
    private String manufacture = "";
    private String color = "";
    private String yearFrom = "";
    private String yearTo = "";
    private String seatsCount = "";
    private String doorsCount = "";
    private String costTo = "";
    private String costFrom = "";
    private String costSell = "";
    private int countEmptyParam; //without SQL

    {
        try {
            countEmptyParam = getCountEmptyParam()-1;//without SQL
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public SQLBuilder(String nameMark, String bodyType, String transmissionType, String petrolType, String driveType,
                      String manufacture, String color, int yearFrom, int yearTo, String seatsCount, String doorsCount,
                        int costFrom, int costTo) {

        this.nameMark = nameMark;
        this.bodyType = bodyType;
        this.transmissionType = transmissionType;
        this.petrolType = petrolType;
        this.driveType = driveType;
        this.manufacture = manufacture;
        this.color = color;
        this.yearFrom = yearFrom+"";
        this.yearTo = yearTo + "";
        this.costTo = costTo + "";
        this.costFrom = costFrom + "";
        this.seatsCount = seatsCount;
        this.doorsCount = doorsCount;
        try {
            setFieldWhichContainsAny();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public SQLBuilder(String nameMark, String bodyType, String transmissionType, String petrolType, String driveType,
                      String manufacture, String color, int yearFrom, int yearTo, String seatsCount, String doorsCount,
                      int costFrom, int costTo, int costSell) {

        this.nameMark = nameMark;
        this.bodyType = bodyType;
        this.transmissionType = transmissionType;
        this.petrolType = petrolType;
        this.driveType = driveType;
        this.manufacture = manufacture;
        this.color = color;
        this.yearFrom = yearFrom+"";
        this.yearTo = yearTo + "";
        this.costTo = costTo + "";
        this.costFrom = costFrom + "";
        this.costSell = costSell + "";
        this.seatsCount = seatsCount;
        this.doorsCount = doorsCount;
        try {
            setFieldWhichContainsAny();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private int getCountEmptyParam() throws IllegalAccessException, CloneNotSupportedException {
        Field[] fields = this.getClass().getDeclaredFields();
        int count = 0;
        for (Field f: fields) {
            f.setAccessible(true);
            SQLBuilder sqlBuilder = (SQLBuilder) this.clone();
            if (f.getType() == String.class){
                if (f.get(sqlBuilder).equals("")){
                    count++;
                }
            }
        }
        return count;
    }

    private void setFieldWhichContainsAny() throws IllegalAccessException, CloneNotSupportedException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            f.setAccessible(true);
            SQLBuilder sqlBuilder = (SQLBuilder) this.clone();
            if (f.getType() == String.class){
                if (f.get(sqlBuilder).equals("--Any--")){
                    f.set(this, "");
                }
            }
        }

    }

    public String searchCarBy() throws CloneNotSupportedException, IllegalAccessException {
        SQL += "SELECT `cost_car`.id_car, SUM(uni.count_car), cost_sell , cost , `auto_mark`.`name_mark`, model, color,  region, `engine_volume`, `year`,\n" +
                "`type_body`.`type_body`, `transmission_type`.`transmission_type`, `petrol_type`.`petrol_type`, `type_drive`.`type_drive`, `seats_number`, `door_number`\n" +
                "FROM uni INNER JOIN cost_car ON uni.id = cost_car.id_cost_car INNER JOIN car ON cost_car.id_car = car.id_car\n" +
                "INNER JOIN type_body ON car.`id_type_body` = type_body.id_type_body\n" +
                "INNER JOIN `auto_mark` ON car.`id_mark` = `auto_mark`.`id_mark`\n" +
                "INNER JOIN `transmission_type` ON car.`id_transmission` = `transmission_type`.`id_transmission`\n" +
                "INNER JOIN `petrol_type` ON `car`.`id_petrol` = `petrol_type`.`id_petrol`\n" +
                "INNER JOIN `type_drive` ON `car`.`id_type_drive` = `type_drive`.`id_type_drive`\n" +
                "WHERE ";
        int count = getCountEmptyParam();
        if (!nameMark.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "auto_mark.name_mark LIKE '%" + nameMark + "' ";
            }
            else {
                SQL += "auto_mark.name_mark LIKE '%" + nameMark + "' AND ";
            }
        }

        if (!bodyType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "type_body.type_body LIKE '%" + bodyType + "' ";
            }
            else {
                SQL += "type_body.type_body LIKE '%" + bodyType + "' AND ";
            }
        }

        if (!transmissionType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "transmission_type LIKE '%" + transmissionType + "' ";
            }
            else {
                SQL += "transmission_type LIKE '%" + transmissionType + "' AND ";
            }
        }

        if (!petrolType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "petrol_type LIKE '%" + petrolType + "' ";
            }
            else {
                SQL += "petrol_type LIKE '%" + petrolType + "' AND ";
            }
        }

        if (!driveType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "type_drive LIKE '%" + driveType + "' ";
            }
            else {
                SQL += "type_drive LIKE '%" + driveType + "' AND ";
            }
        }

        if (!yearFrom.equals("") && !yearTo.equals("")) {
            countEmptyParam--;
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "car.year BETWEEN '"+ yearFrom + "' AND '"+ yearTo + "' " ;
            }
            else {
                SQL += "car.year BETWEEN '"+ yearFrom + "' AND '"+ yearTo + "' AND ";
            }
        }

        if (!manufacture.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "region LIKE '%" + manufacture + "' ";
            }
            else {
                SQL += "region LIKE '%" + manufacture + "' AND ";
            }
        }

        if (!color.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "color LIKE '%" + color + "' ";
            }
            else {
                SQL += "color LIKE '%" + color + "' AND ";
            }
        }

        if (!seatsCount.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "seats_number LIKE '%" + seatsCount + "' ";
            }
            else {
                SQL += "seats_number LIKE '%" + seatsCount + "' AND ";
            }
        }

        if (!doorsCount.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "door_number LIKE '%" + doorsCount + "' ";
            }
            else {
                SQL += "door_number LIKE '%" + doorsCount + "' AND ";
            }
        }

        if (!costTo.equals("") && !costFrom.equals("")) {
            countEmptyParam--;
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "cost BETWEEN '"+ costFrom + "' AND '"+ costTo + "' " ;
            }
            else {
                SQL += "cost BETWEEN '"+ costFrom + "' AND '"+ costTo + "' AND ";
            }
        }
        SQL += "\nGROUP BY uni.id";

        System.out.println("count = " + count + "count empty: " + countEmptyParam);
        return SQL;
    }

    public String searchCar() throws CloneNotSupportedException, IllegalAccessException {
        SQL += "SELECT `cost_car`.id_car, cost ,`auto_mark`.`name_mark`, model, color,  region, `engine_volume`, `year`,\n" +
                "`type_body`.`type_body`, `transmission_type`.`transmission_type`, `petrol_type`.`petrol_type`, `type_drive`.`type_drive`, `seats_number`, `door_number`\n" +
                "FROM cost_car INNER JOIN car ON cost_car.id_car = car.id_car\n" +
                "INNER JOIN type_body ON car.`id_type_body` = type_body.id_type_body\n" +
                "INNER JOIN `auto_mark` ON car.`id_mark` = `auto_mark`.`id_mark`\n" +
                "INNER JOIN `transmission_type` ON car.`id_transmission` = `transmission_type`.`id_transmission`\n" +
                "INNER JOIN `petrol_type` ON `car`.`id_petrol` = `petrol_type`.`id_petrol`\n" +
                "INNER JOIN `type_drive` ON `car`.`id_type_drive` = `type_drive`.`id_type_drive`\n" +
                "WHERE ";

        int count = getCountEmptyParam();
        if (!nameMark.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "auto_mark.name_mark LIKE '%" + nameMark + "' ";
            }
            else {
                SQL += "auto_mark.name_mark LIKE '%" + nameMark + "' AND ";
            }
        }

        if (!bodyType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "type_body.type_body LIKE '%" + bodyType + "' ";
            }
            else {
                SQL += "type_body.type_body LIKE '%" + bodyType + "' AND ";
            }
        }

        if (!transmissionType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "transmission_type LIKE '%" + transmissionType + "' ";
            }
            else {
                SQL += "transmission_type LIKE '%" + transmissionType + "' AND ";
            }
        }

        if (!petrolType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "petrol_type LIKE '%" + petrolType + "' ";
            }
            else {
                SQL += "petrol_type LIKE '%" + petrolType + "' AND ";
            }
        }

        if (!driveType.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "type_drive LIKE '%" + driveType + "' ";
            }
            else {
                SQL += "type_drive LIKE '%" + driveType + "' AND ";
            }
        }

        if (!yearTo.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "car.year = '"+ yearTo + "' " ;
            }
            else {
                SQL += "car.year = '"+ yearTo + "' AND ";
            }
        }

        if (!manufacture.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "region LIKE '%" + manufacture + "' ";
            }
            else {
                SQL += "region LIKE '%" + manufacture + "' AND ";
            }
        }

        if (!color.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "color LIKE '%" + color + "' ";
            }
            else {
                SQL += "color LIKE '%" + color + "' AND ";
            }
        }

        if (!seatsCount.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "seats_number LIKE '%" + seatsCount + "' ";
            }
            else {
                SQL += "seats_number LIKE '%" + seatsCount + "' AND ";
            }
        }

        if (!doorsCount.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "door_number LIKE '%" + doorsCount + "' ";
            }
            else {
                SQL += "door_number LIKE '%" + doorsCount + "' AND ";
            }
        }

        if (!costTo.equals("") && !costFrom.equals("")) {
            countEmptyParam--;
            countEmptyParam--;
            countEmptyParam--;

            if (countEmptyParam == count){
                SQL += "cost = '"+ costTo + "' " ;
            }
            else {
                SQL += "cost = '"+ costTo + "' AND ";
            }
        }

        if (!costSell.equals("")) {
            countEmptyParam--;
            if (countEmptyParam == count){
                SQL += "cost_sell = '" + costSell + "' ";
            }
            else {
                SQL += "cost_sell = '" + costSell + "'  AND ";
            }
        }

        SQL += "\nGROUP BY cost_car.id_car";
        System.out.println("count = " + count + "count empty: " + countEmptyParam);
        System.out.println(SQL);
        return SQL;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
