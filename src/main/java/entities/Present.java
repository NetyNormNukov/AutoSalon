package entities;

public class Present {
    private Car car;
    private int countCar;
    private double costCar;

    public void setCountCar(int countCar) {
        this.countCar = countCar;
    }

    public void setCostCar(int costCar) {
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
