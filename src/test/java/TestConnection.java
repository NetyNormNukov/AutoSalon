import database.MySQLManager;
import database.SQLBuilder;
import entities.*;
import javafx.scene.control.Tab;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;

public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MySQLManager mySQLManager = new MySQLManager();
        SQLBuilder sqlBuilder = new SQLBuilder("BMW");
//        System.out.println(sqlBuilder.searchCarBy());
        mySQLManager.openConnection();
        sqlBuilder.getCountNotEmptyParam();



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
}
