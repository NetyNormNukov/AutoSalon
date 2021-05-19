import database.MySQLManager;
import database.SQLBuilder;
import entities.*;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;

public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, CloneNotSupportedException {
        MySQLManager mySQLManager = new MySQLManager();
        mySQLManager.openConnection();
        SQLBuilder sqlBuilder = new SQLBuilder("BMW", "", "--Any--", "",
                "", "", "", 1970, 2020, "--Any--", "", 0,200000);

        System.out.println(sqlBuilder.searchCarBy());
//        mySQLManager.insertIntoOut(2, 1, 2, "annotation", 2, 80000);
//        mySQLManager.insertIntoIn(2, 3, "ann", 4, 50000);
//        ArrayList <Out> outs =  mySQLManager.getOutTable("2019", "2021");
//        for (Out out: outs) {
//            System.out.println(out.toString());
//        }
//        ArrayList<Present> presents  = mySQLManager.presentBySQL(sqlBuilder.searchCarBy());
//
//        for (Present pr: presents) {
//            System.out.println(pr.toString());
//        }

//        System.out.println(sqlBuilder.searchCarBy());
//        Car car = mySQLManager.getCarBySql(sqlBuilder.searchCarBy());
//        System.out.println(car.toString());
//        Car car = mySQLManager.getCarById(1);
//        System.out.println(car.toString());

        //count cars by id_car
//        HashMap<Integer, Integer> countCarById= mySQLManager.getCountCarByIdCar();
//
//        for (Integer integer: countCarById.values()) {
//            System.out.println(integer.toString());
//        }


//        mySQLManager.insertIntoCar("BMW", "M5", "Black", "New York", "2.0", "2021", "Crossover",
//                "Automatic", "Gas", "RWD", "4", "4");
        //Out check
//        ArrayList<Out> outs = mySQLManager.getOutTable();
//        for (Out out: outs) {
//            System.out.println(out.toString());
//        }

        //INTable data check
//        ArrayList<In> ins = mySQLManager.getInTable();
//        for (In in : ins) {
//            System.out.println(in.toString());
//        }
        //managers data check
//        ArrayList<Manager> managers = mySQLManager.getManagers();
//        for (Manager manager: managers) {
//            System.out.println(manager.toString());

//        }

//        Car car = mySQLManager.getCarById(1);
//        System.out.println(car.toString());
//        System.out.println(sqlBuilder.searchCarBy());
//        ArrayList<String> arrayList = mySQLManager.getAutoMark();
//
//        for (String at: arrayList) {
//            System.out.println(at);
//        }
//        System.out.println("sssssssssssssssssssss");
//        ArrayList<String> arrayList2 = mySQLManager.getAutoMark();
//
//        for (String at: arrayList2) {
//            System.out.println(at);
//        }
//
//

        //gain from cars
//        HashMap<Integer, Integer> gain = mySQLManager.gainFromCars();
//        for (Integer key: gain.values()) {
//            System.out.println(key.toString());
//        }

        //manager
//        boolean manager = mySQLManager.isManager("worki@gmail.com", "pass");
//        System.out.println(manager);

        //all cars
//        ArrayList<Car> autoMark = mySQLManager.getCars();
//        for (Car oneMark: autoMark) {
//            System.out.println(oneMark.toString());;
//        }

        //present
//        ArrayList<Present> presents = mySQLManager.present();
//        for (Present pr: presents) {
//            System.out.println(pr.toString());
//        }
//        Car car = mySQLManager.getCarById(1);
//        System.out.println(car.toString());
        mySQLManager.close();
    }

    public static int test(){
        try {
            int i = 0;
            int j = 5/0;
            return 0;
        }
        catch (Exception e){
            return 5;
        }
        finally {
            return 2;
        }
    }
}
