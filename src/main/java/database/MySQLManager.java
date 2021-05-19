package database;

import Exceptions.IdNotFoundException;
import entities.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//TODO insertIntoIn
public class MySQLManager {

    private Connection conn;

    public boolean isManager(String email, String password) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT email, password\n" +
                    "FROM manager";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if (rs.getString(1).equals(email) && rs.getString(2).equals(password)){
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return false;
    }

    public ArrayList<Customer> getCustomers(String str) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT `name_cust`, `requisites`, `address`, `phone_number`, `email`, `banc_account`" +
                    "FROM `customer`\n" +
                    "WHERE name_cust LIKE '" + str + "%'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Customer cust = new Customer();
                cust.setName(rs.getString(1));
                cust.setRequisites(rs.getString(2));
                cust.setAddress(rs.getString(3));
                cust.setPhoneNumber(rs.getString(4));
                cust.setEmail(rs.getString(5));
                cust.setBankAccount(rs.getString(6));
                customers.add(cust);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return customers;
    }

    public ArrayList<Customer> getCustomers(String nameCust, String requisites, String address, String phoneNumber,
                                                  String email, String bancAccount) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            String sql = "SELECT `name_cust`, `requisites`, `address`, `phone_number`, `email`, `banc_account`, id_customer\n" +
                    "FROM `customer`\n" +
                    "WHERE name_cust LIKE '" + nameCust + "%' AND requisites LIKE '" + requisites + "%' AND address LIKE '" + address + "%' AND phone_number LIKE '" + phoneNumber + "%' AND" +
                    " email LIKE '" + email + "%' AND banc_account LIKE '" + bancAccount + "%'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Customer cust = new Customer();
                cust.setName(rs.getString(1));
                cust.setRequisites(rs.getString(2));
                cust.setAddress(rs.getString(3));
                cust.setPhoneNumber(rs.getString(4));
                cust.setEmail(rs.getString(5));
                cust.setBankAccount(rs.getString(6));
                cust.setId(rs.getInt(7));
                customers.add(cust);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return customers;
    }

    public Customer getCustomersById(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Customer cust = new Customer();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT `name_cust`, `requisites`, `address`, `phone_number`, `email`, `banc_account`" +
                    "FROM `customer`" +
                    "WHERE id_customer = '"+id+"' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            cust.setName(rs.getString(1));
            cust.setRequisites(rs.getString(2));
            cust.setAddress(rs.getString(3));
            cust.setPhoneNumber(rs.getString(4));
            cust.setEmail(rs.getString(5));
            cust.setBankAccount(rs.getString(6));
            cust.setId(id);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return cust;
    }

    public ArrayList<Seller> getSellers(String name) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Seller> sellers = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT  `name_seller`, `requisites`, `address`, `phone_number`, `email`, `bank_account`, id_seller\n" +
                    "FROM seller\n" +
                    "WHERE name_seller LIKE '" + name + "%'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Seller seller = new Seller();
                seller.setName(rs.getString(1));
                seller.setRequisites(rs.getString(2));
                seller.setAddress(rs.getString(3));
                seller.setPhoneNumber(rs.getString(4));
                seller.setEmail(rs.getString(5));
                seller.setBankAccount(rs.getString(6));
                seller.setId(rs.getInt(7));
                sellers.add(seller);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return sellers;
    }

    public ArrayList<String> getSellersName() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> sellersNames = new ArrayList<String>();
        try {
            String sql = "SELECT name_seller\n" +
                    "From seller";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                sellersNames.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return sellersNames;
    }

    private Seller getSellersById(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Seller seller = new Seller();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT  `name_seller`, `requisites`, `address`, `phone_number`, `email`, `bank_account`\n" +
                    "FROM seller\n" +
                    "WHERE id_seller = '"+id+"' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            seller.setName(rs.getString(1));
            seller.setRequisites(rs.getString(2));
            seller.setAddress(rs.getString(3));
            seller.setPhoneNumber(rs.getString(4));
            seller.setEmail(rs.getString(5));
            seller.setBankAccount(rs.getString(6));
            seller.setId(id);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return seller;
    }

    public ArrayList<In> getInTable(String yearFrom, String yearTo, String nameSeller) throws SQLException {//TODO where statement
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<In> ins = new ArrayList<In>();
        if (nameSeller.equals("--Any--")){
            nameSeller = "";
        }
        try {
            String sql = "SELECT `in`.id_seller, id_car, date_deal, count, cost, annotation\n" +
                    "FROM  `in`\n" +
                    "INNER JOIN seller s on `in`.id_seller = s.id_seller\n" +
                    "INNER JOIN cost_car cc on `in`.id_cost_car = cc.id_cost_car\n" +
                    "WHERE date_deal BETWEEN '" + yearFrom + "' AND '" + yearTo + "' AND name_seller LIKE '" + nameSeller + "%'\n"+
                    "ORDER BY date_deal DESC ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                In in = new In();
                Seller seller = getSellersById(rs.getInt(1));
                in.setSeller(seller);
                Car car = getCarById(rs.getInt(2));
                in.setCar(car);
                Date date = new Date();
                try{
                     date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(3));
                }catch(Exception e){
                    e.printStackTrace();
                }
                in.setDate(date);
                in.setCount(rs.getInt(4));
                in.setCost(rs.getDouble(5));
                in.setAnnotation(rs.getString(6));
                ins.add(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return ins;
    }

    public ArrayList<Out> getOutTable(String yearFrom, String yearTo) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Out> outs = new ArrayList<Out>();
        try {
            String sql = "SELECT `out`.id_customer, id_car,  date_deal, count, cost_sell, annotation, `out`.id_m\n" +
                    "FROM  `out`\n" +
                    "INNER JOIN customer c on `out`.id_customer = c.id_customer\n" +
                    "INNER JOIN cost_car cc on `out`.id_cost_car = cc.id_cost_car\n" +
                    "INNER JOIN manager m on `out`.id_m = m.id_m\n" +
                    "WHERE date_deal BETWEEN '" + yearFrom + "' AND '" + yearTo + "'\n" +
                    "ORDER BY date_deal DESC ";
            stmt = conn.createStatement();
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Out out = new Out();
                Customer customer = getCustomersById(rs.getInt(1));
                out.setCustomer(customer);
                Car car = getCarById(rs.getInt(2));
                out.setCar(car);
                Date date = new Date();
                try{
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(3));
                }catch(Exception e){
                    e.printStackTrace();
                }
                out.setDate(date);
                out.setCount(rs.getInt(4));
                out.setCost(rs.getDouble(5));
                out.setAnnotation(rs.getString(6));
                Manager manager = getManagerById(rs.getInt(7));
                out.setManager(manager);
                outs.add(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return outs;
    }

    public Manager getManagerByPasswordAndName(String email, String password) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Manager manager = new Manager();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT `name`, `surname`, `address`,`phone_number`,`email`,`password`, id_m\n" +
                    "FROM `manager`" +
                    "WHERE manager.password = '" + password + "' AND manager.email = '" + email +  "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            manager.setName(rs.getString(1));
            manager.setSurname(rs.getString(2));
            manager.setAddress(rs.getString(3));
            manager.setPhoneNumber(rs.getString(4));
            manager.setEmail(rs.getString(5));
            manager.setPassword(rs.getString(6));
            manager.setId(rs.getInt(7));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return manager;
    }

    public Manager getManagerById (int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Manager manager = new Manager();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "SELECT `name`, `surname`, `address`,`phone_number`,`email`,`password`, id_m \n" +
                    "FROM `manager`\n" +
                    "WHERE id_m = '"+ id +"' " ;
            stmt = conn.createStatement();
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            rs.next();
            manager.setName(rs.getString(1));
            manager.setSurname(rs.getString(2));
            manager.setAddress(rs.getString(3));
            manager.setPhoneNumber(rs.getString(4));
            manager.setEmail(rs.getString(5));
            manager.setPassword(rs.getString(6));
            manager.setId(rs.getInt(7));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return manager;
    }

    public Present insertIntoCarAndGetNewPresent(String nameMark, String model, String color, String region, String engineVolume, String year, String bodyType,
                              String transmissionType, String petrolType, String driveType, String seatsNumber, String doorNumber, double cost, int count) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Present car = new Present();
        Double.parseDouble(engineVolume);
        Integer.parseInt(year);
        Integer.parseInt(seatsNumber);
        Integer.parseInt(doorNumber);
        String sql = "INSERT INTO car (id_type_body, id_mark, id_transmission, id_petrol, id_type_drive, model, region, engine_volume, YEAR, seats_number, door_number, color)\n" +
                "VALUES ((SELECT id_type_body FROM type_body WHERE type_body = '" + bodyType + "'), (SELECT id_mark FROM auto_mark WHERE name_mark = '" + nameMark + "'), (SELECT id_transmission FROM transmission_type WHERE transmission_type = '" + transmissionType + "'),\n" +
                "(SELECT id_petrol FROM petrol_type WHERE petrol_type = '" + petrolType + "'), (SELECT id_type_drive FROM type_drive WHERE type_drive = '" + driveType + "'), '" + model + "'" +
                " , '" + region + "', " + engineVolume + " , " + year + ", " +
                " " + seatsNumber + ", " + doorNumber + ", '" + color + "')";
        Query(sql);

        String sqlId = "SELECT MAX(id_car)\n" +
                "FROM car";
        try {
            Car car1;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlId);
            rs.next();
            car1 = getCarById(rs.getInt(1));
            car.setCar(car1);
            car.setCostCar(cost);
            car.setCountCar(count);
            System.out.println(car.toString());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return car;
    }

    public void insertIntoOut(int manager, int customer, int count, String annotation, int car, double cost ) throws SQLException {
        String sql = "INSERT INTO `out`(id_m, id_customer, id_cost_car, date_deal, count, annotation) \n" +
                "VALUES ('" + manager + "', '" + customer + "', (SELECT id_cost_car\n" +
                "FROM cost_car\n" +
                "WHERE cost = '" + cost + "' AND id_car = '" + car + "'), NOW(), '" + count + "', '" + annotation + "' )";
        Query(sql);
    }

    public void insertIntoIn(String seller, int count, String annotation, int car, double cost ) throws SQLException {
        String sql = "INSERT INTO `in`( id_seller, id_cost_car, date_deal, count, annotation) \n" +
                "VALUES ( (SELECT id_seller\n" +
                "FROM seller\n" +
                "WHERE name_seller = '" +seller +  "'), (SELECT id_cost_car\n" +
                "FROM cost_car\n" +
                "WHERE cost = '" + cost + "' AND id_car = '" + car + "'), NOW(), '" + count + "', '" + annotation + "' )";
        System.out.println(sql);
        Query(sql);
    }

    public Customer insertIntoCustomerAndGetNewCustomer(String nameCust, String requisites, String address, String phoneNumber,
                                                        String email, String bancAccount) throws SQLException {

        Statement stmt = null;
        ResultSet rs = null;
        Customer cust = new Customer();
        String sql = "INSERT INTO customer(name_cust, requisites, address, phone_number, email, banc_account)\n" +
                "VALUES ('" + nameCust  + "', '" + requisites  + "', '" + address  + "', '" + phoneNumber  + "', '" + email  + "', '" + bancAccount  + "')";
        Query(sql);

        String sqlId = "SELECT MAX(id_customer)\n" +
                "FROM customer";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlId);
            rs.next();
            cust = getCustomersById(rs.getInt(1));

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return cust;
    }

    public void insertIntoSeller(String name, String req, String address, String phoneNumber, String email, String bancAcccount ) throws SQLException {
        String sql = "INSERT INTO seller(name_seller, requisites, address, phone_number, email, bank_account)\n" +
                "VALUES ( '" + name + "', '" + req + "', '" + address + "', '" + phoneNumber + "', '" + email + "', '" + bancAcccount + "' )";
        Query(sql);
    }

    public void insertIntoCustomer(String name, String req, String address, String phoneNumber, String email, String bancAcccount ) throws SQLException {
        String sql = "INSERT INTO customer(name_cust, requisites, address, phone_number, email, banc_account)\n" +
                "VALUES ( '" + name + "', '" + req + "', '" + address + "', '" + phoneNumber + "', '" + email + "', '" + bancAcccount + "' )";
        Query(sql);
    }

//    private HashMap<Integer, Integer> gainFromCars(String nameMark, String model, String color, String region, String engineVolume, String year, String bodyType,
//                                                  String transmissionType, String petrolType, String driveType, String seatsNumber, String doorNumber) throws SQLException {
//        Statement stmt = null;
//        ResultSet rs = null;
//        ArrayList<Present> presents = new ArrayList<>();
//        HashMap<Integer, Integer> gain = new HashMap<Integer, Integer>();
//        try {
//            conn.setAutoCommit(false);
//            String sql = "INSERT INTO auto_mark(name_mark)"  +
//                    "                "VALUE ('"+"val"+"')";
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                gain.put(rs.getInt("id"), rs.getInt(2));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (stmt != null){ stmt.close(); }
//            if (rs != null) { rs.close(); }
//        }
//        return gain;
//    }

    public ArrayList<Present> presentBySQL(String sql) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Present> presents = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Present present = new Present();
                Car car = getCarById(rs.getInt(1));
                present.setCar(car);
                present.setCountCar(rs.getInt(2));
                present.setCostCar(rs.getInt(3));
                presents.add(present);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return presents;
    }

    public ArrayList<String> getAutoMark() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> autoMark = new ArrayList<String>();
        try {
            String sql = "SELECT * from auto_mark";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                autoMark.add(rs.getString("name_mark"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return autoMark;
    }

    public ArrayList<String> getPetrolType() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> petrolType = new ArrayList<String>();
        try {
            String sql = "SELECT petrol_type FROM petrol_type";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                petrolType.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return petrolType;
    }

    public ArrayList<String> getManufactureRegion() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> manufacture = new ArrayList<String>();
        try {
            String sql = "SELECT DISTINCT (car.region) FROM car";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                manufacture.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return manufacture;
    }

    public ArrayList<String> getColor() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> color = new ArrayList<String>();
        try {
            String sql = "SELECT DISTINCT (car.color) FROM car";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                color.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return color;
    }

    public ArrayList<String> getBodyType() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> bodyType = new ArrayList<String>();
        try {
            String sql = "SELECT type_body FROM type_body";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                bodyType.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return bodyType;
    }

    public ArrayList<String> getTransmissionType() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> transmissionType = new ArrayList<String>();
        try {
            String sql = "SELECT transmission_type FROM transmission_type";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                transmissionType.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return transmissionType;
    }

    public ArrayList<String> getTypeOfDrive() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> typeDrive = new ArrayList<String>();
        try {
            String sql = "SELECT type_drive FROM type_drive";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                typeDrive.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return typeDrive;
    }

    public ArrayList<Present> getPresentBySql(String sql) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Present> presents = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Present present = new Present();
                Car car = getCarById(rs.getInt(1));
                present.setCar(car);
                present.setCostCar(rs.getDouble(2));
                presents.add(present);
            }
//            System.out.println(rs.getString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return presents;
    }

    public Car getCarById(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Car car = new Car();
        try {
            conn.setAutoCommit(false);
            String ifIdExistSQL = "SELECT Count(car.id_car) AS id_c\n" +
                    "FROM car\n" +
                    "WHERE id_car = '"+id+"' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ifIdExistSQL);
            while (rs.next()){
                if (Integer.parseInt(rs.getString("id_c")) != 1){
                    throw  new IdNotFoundException("id_car from table car on id=" + id + " not found");
                }
            }
            String sql = "SELECT `auto_mark`.`name_mark`, model, color,  region, `engine_volume`, `year`,\n" +
                    "`type_body`.`type_body`, `transmission_type`.`transmission_type`, `petrol_type`.`petrol_type`,\n" +
                    "`type_drive`.`type_drive`, `seats_number`, `door_number`\n" +
                    "FROM car\n" +
                    "INNER JOIN type_body ON car.`id_type_body` = type_body.id_type_body\n" +
                    "INNER JOIN `auto_mark` ON car.`id_mark` = `auto_mark`.`id_mark`\n" +
                    "INNER JOIN `transmission_type` ON car.`id_transmission` = `transmission_type`.`id_transmission`\n" +
                    "INNER JOIN `petrol_type` ON `car`.`id_petrol` = `petrol_type`.`id_petrol`\n" +
                    "INNER JOIN `type_drive` ON `car`.`id_type_drive` = `type_drive`.`id_type_drive`\n" +
                    "WHERE `car`.`id_car` = '"+id+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            car.setNameMark(rs.getString("name_mark"));
            car.setModel(rs.getString("model"));
//            Date date = new Date();
//            try{
//                 date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("year"));
//            }catch(Exception e){
//                System.out.println(e);
//            }
            car.setYear(rs.getInt("year"));
            car.setBodyType(rs.getString("type_body"));
            car.setColor(rs.getString("color"));
            car.setDoorNumber(Integer.parseInt(rs.getString("door_number")));
            car.setDriveType(rs.getString("type_drive"));
            car.setEngineVolume(Double.parseDouble(rs.getString("engine_volume")));
            car.setPetrolType(rs.getString("petrol_type"));
            car.setRegion(rs.getString("region"));
            car.setSeatsNumber(Integer.parseInt(rs.getString("seats_number")));
            car.setTransmissionType(rs.getString("transmission_type"));
            car.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return car;
    }

    public ArrayList<Car> getCarBySql(String sql) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Car> cars = new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Car car = new Car();
                car.setNameMark(rs.getString("name_mark"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setBodyType(rs.getString("type_body"));
                car.setColor(rs.getString("color"));
                car.setDoorNumber(Integer.parseInt(rs.getString("door_number")));
                car.setDriveType(rs.getString("type_drive"));
                car.setEngineVolume(Double.parseDouble(rs.getString("engine_volume")));
                car.setPetrolType(rs.getString("petrol_type"));
                car.setRegion(rs.getString("region"));
                car.setSeatsNumber(Integer.parseInt(rs.getString("seats_number")));
                car.setTransmissionType(rs.getString("transmission_type"));
                cars.add(car);
            }
//            System.out.println(rs.getString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){ stmt.close(); }
            if (rs != null) { rs.close(); }
        }
        return cars;
    }

    public void openConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/autosalon?useSSL=false&serverTimezone=UTC";
        String connectionUserName = "root";
        String connectionPassword = "root";
        Class.forName(driver);
        conn = DriverManager.getConnection(connectionString, connectionUserName, connectionPassword);
    }

    private void Query (String sql) throws SQLException {
        Statement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null){
                stmt.close();
            }
        }
    }

    public void  close() throws SQLException {
        conn.close();
    }

}
