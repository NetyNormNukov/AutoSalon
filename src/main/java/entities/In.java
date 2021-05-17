package entities;

import java.util.Date;

public class In {
    private Seller seller;
    private Car car;
    private Date date;
    private int count;
    private double cost;
    private String annotation;

    public Seller getSeller() {
        return seller;
    }

    public Car getCar() {
        return car;
    }

    public Date getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    public double getCost() {
        return cost;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "In{" +
                "seller=" + seller +
                ", car=" + car +
                ", date=" + date +
                ", count=" + count +
                ", cost=" + cost +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
