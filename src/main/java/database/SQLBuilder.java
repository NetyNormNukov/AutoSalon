package database;

import java.lang.reflect.Field;

public class SQLBuilder {
    private String SQL = "";
    private String by ;
    private String nameMark = "";
    private String bodyType = "";
    private String transmissionType = "";
    private String petrolType = "";
    private String driveType = "";
    private String search = "";
    private boolean checkWhere;
    private int countNotEmptyParam;

    public SQLBuilder(String nameMark) {
        this.nameMark = nameMark;
    }

    public int getCountNotEmptyParam() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field f: fields) {
            f.setAccessible(true);
            SQLBuilder sqlBuilder = new SQLBuilder();
            try {
                sqlBuilder = this.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            if (f.getType() == String.class && f.get(sqlBuilder).equals("") ){
                System.out.println();
            }
        }
        return 3;
    }

    @Override
    public SQLBuilder clone() throws CloneNotSupportedException {

        SQLBuilder sqlBuilderClone = (SQLBuilder) super.clone();
        return sqlBuilderClone;
    }

    public SQLBuilder() {
    }

    public String searchCarBy(){
        SQL += "SELECT `auto_mark`.`name_mark`, model, color,  region, `engine_volume`, `year`,\n" +
                "`type_body`.`type_body`, `transmission_type`.`transmission_type`, `petrol_type`.`petrol_type`,\n" +
                "`type_drive`.`type_drive`, `seats_number`, `door_number`\n" +
                "FROM car\n" +
                "INNER JOIN type_body ON car.`id_type_body` = type_body.id_type_body\n" +
                "INNER JOIN `auto_mark` ON car.`id_mark` = `auto_mark`.`id_mark`\n" +
                "INNER JOIN `transmission_type` ON car.`id_transmission` = `transmission_type`.`id_transmission`\n" +
                "INNER JOIN `petrol_type` ON `car`.`id_petrol` = `petrol_type`.`id_petrol`\n" +
                "INNER JOIN `type_drive` ON `car`.`id_type_drive` = `type_drive`.`id_type_drive`\n" +
                "WHERE ";

        if (!nameMark.equals("")) {
            SQL += "auto_mark.name_mark LIKE '%" + nameMark + "' AND";
        }


//        if(!genre.equals("Any genre")){
//            SQL += "AND book.isbn IN (SELECT id_b FROM book_genre INNER JOIN genre ON book_genre.id_g = genre.id WHERE genre.genre = '"+genre+"') ";
//        }
//        if(!language.equals("Any language")){
//            SQL+= "AND language = '"+language+"' ";
//        }
//        if(!publisher.equals("Any publisher")){
//            SQL += "AND publisher.name = '"+publisher+"' ";
//        }
        return SQL;
    }
}
