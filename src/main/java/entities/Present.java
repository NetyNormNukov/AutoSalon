package entities;

public class Present {
    private Car car;
    private int countCar;
    private double costAllCar;

    public void setCountCar(int countCar) {
        this.countCar = countCar;
    }

    public void setCostCar(int costCar) {
        this.costAllCar = costCar;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getCostCar(){

        return costAllCar /countCar;
    }

    @Override
    public String toString() {
        return "Present{" +
                "car=" + car +
                ", countCar=" + countCar +
                ", costCar=" + costAllCar +
                '}';
    }
}
