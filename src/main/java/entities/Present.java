package entities;

public class Present {
    private Car car;
    private int countCar;
    private double costCar;
    private double costSell;

    public double getCostSell() {
        return costSell;
    }

    public void setCostSell(double costSell) {
        this.costSell = costSell;
    }

    public void setCountCar(int countCar) {
        this.countCar = countCar;
    }

    public void setCostCar(double costCar) {
        this.costCar = costCar;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public int getCountCar() {
        return countCar;
    }

    public double getCostCar() {
        return costCar;
    }

    @Override
    public String toString() {
        return "Present{" +
                "car=" + car +
                ", countCar=" + countCar +
                ", costCar=" + costCar +
                '}';
    }
}
