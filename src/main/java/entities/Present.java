package entities;

public class Present {
    private Car car;
    private int countCar;
    private double costCar;
    private double prevCostCar;

    public Present() {
    }

    public Present(Car car, int countCar, double costCar) {
        this.car = car;
        this.countCar = countCar;
        this.costCar = costCar;
    }

    public double getPrevCostCar() {
        return prevCostCar;
    }

    public void setPrevCostCar(double costSell) {
        this.prevCostCar = costSell;
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
