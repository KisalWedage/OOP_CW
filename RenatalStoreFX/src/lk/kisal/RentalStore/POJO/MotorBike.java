package lk.kisal.RentalStore.POJO;

import lk.kisal.RentalStore.Date.Schedule;

import java.sql.Date;
import java.util.Objects;

public class MotorBike extends Vehical {
    private boolean helmetAvailability;
    private boolean boxCompartmentAvailability;

    public MotorBike(String plateNo, double rent, String make, String model, int seatCapacity, int cylinderCapacity,
                     String topSpeed, boolean vehicalAvailability, int milage, String transmission, Date pickUpDate, Date dropOffDate, boolean helmetAvailability,
                     boolean boxCompartmentAvailability) {
        super(plateNo,rent,  make, model, seatCapacity, cylinderCapacity, topSpeed, vehicalAvailability, milage,
                transmission, pickUpDate, dropOffDate);
        this.helmetAvailability = helmetAvailability;
        this.boxCompartmentAvailability = boxCompartmentAvailability;
    }

    public MotorBike( String plateNo,double rent, String make, String model, int seatCapacity, int cylinderCapacity, String topSpeed, boolean vehicalAvailability, int milage, String transmission, boolean helmetAvailability, boolean boxCompartmentAvailability) {
        super( plateNo,rent, make, model, seatCapacity, cylinderCapacity, topSpeed, vehicalAvailability, milage, transmission);
        this.helmetAvailability = helmetAvailability;
        this.boxCompartmentAvailability = boxCompartmentAvailability;
    }

    public boolean isHelmetAvailability() {
        return helmetAvailability;
    }

    public boolean isBoxCompartmentAvailability() {
        return boxCompartmentAvailability;
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
        return "MotorBike{" +
                "helmetAvailability=" + helmetAvailability +
                ", boxCompartmentAvailability=" + boxCompartmentAvailability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotorBike)) return false;
        MotorBike motorBike = (MotorBike) o;
        return isHelmetAvailability() == motorBike.isHelmetAvailability() &&
                isBoxCompartmentAvailability() == motorBike.isBoxCompartmentAvailability();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHelmetAvailability(), isBoxCompartmentAvailability());
    }
}
