package entities;

import java.util.Date;

public class Car {
    private int id;
    private String nameMark;
    private String model;
    private String color;
    private String region;
    private double engineVolume;
    private int year;
    private String bodyType;
    private String transmissionType;
    private String petrolType;
    private String driveType;
    private int seatsNumber;
    private int doorNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameMark(String nameMark) {
        this.nameMark = nameMark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setPetrolType(String petrolType) {
        this.petrolType = petrolType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getNameMark() {
        return nameMark;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegion() {
        return region;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getYear() {
        return year;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getPetrolType() {
        return petrolType;
    }

    public String getDriveType() {
        return driveType;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameMark='" + nameMark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", region='" + region + '\'' +
                ", engineVolume=" + engineVolume +
                ", year=" + year +
                ", bodyType='" + bodyType + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", petrolType='" + petrolType + '\'' +
                ", driveType='" + driveType + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", doorNumber=" + doorNumber +
                '}';
    }
}
