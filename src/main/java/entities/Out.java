package entities;

import java.util.Date;

public class Out {
    private Manager manager;
    private Customer customer;
    private Car car;
    private Date date;
    private int count;
    private double cost;
    private String annotation;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return "Out{" +
                "manager=" + manager +
                ", customer=" + customer +
                ", car=" + car +
                ", date=" + date +
                ", count=" + count +
                ", cost=" + cost +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
