package lk.kisal.RentalStore.POJO;

import lk.kisal.RentalStore.Date.Schedule;

import java.sql.Date;
import java.util.Objects;

public class Car extends Vehical {
    private int noOfDoors;
    private boolean airConditionAvailability;

    public Car(String plateNo, double rent, String make, String model, int seatCapacity, int cylinderCapacity,
               String topSpeed, boolean vehicalAvailability, int milage, String transmission,
               Date pickUpDate,Date dropOffDate, int noOfDoors, boolean airConditionAvailability) {
        super(plateNo,rent,  make, model, seatCapacity, cylinderCapacity, topSpeed, vehicalAvailability, milage,
                transmission, pickUpDate, dropOffDate);
        this.noOfDoors = noOfDoors;
        this.airConditionAvailability = airConditionAvailability;
    }

    public Car( String plateNo,double rent, String make, String model, int seatCapacity, int cylinderCapacity, String topSpeed, boolean vehicalAvailability, int milage, String transmission, int noOfDoors, boolean airConditionAvailability) {
        super( plateNo,rent, make, model, seatCapacity, cylinderCapacity, topSpeed, vehicalAvailability, milage, transmission);
        this.noOfDoors = noOfDoors;
        this.airConditionAvailability = airConditionAvailability;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public boolean isAirConditionAvailability() {
        return airConditionAvailability;
    }

    @Override
    public double getRent() {
        return super.getRent();
    }

    @Override
    public String getPlateNo() {
        return super.getPlateNo();
    }

    @Override
    public String getMake() {
        return super.getMake();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getSeatCapacity() {
        return super.getSeatCapacity();
    }

    @Override
    public int getCylinderCapacity() {
        return super.getCylinderCapacity();
    }

    @Override
    public String getTopSpeed() {
        return super.getTopSpeed();
    }

    @Override
    public boolean isVehicalAvailability() {
        return super.isVehicalAvailability();
    }

    @Override
    public int getMilage() {
        return super.getMilage();
    }

    @Override
    public String getTransmission() {
        return super.getTransmission();
    }

    @Override
    public String toString() {
        return "Car{" +
                "noOfDoors=" + noOfDoors +
                ", airConditionAvailability=" + airConditionAvailability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getNoOfDoors() == car.getNoOfDoors() &&
                isAirConditionAvailability() == car.isAirConditionAvailability();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoOfDoors(), isAirConditionAvailability());
    }
}
