package lk.kisal.RentalStore.POJO;

import lk.kisal.RentalStore.Date.Schedule;

import java.sql.Date;
import java.util.Objects;

public abstract class Vehical {
    private double rent;
    private String plateNo ;
    private String make ;
    private String model ;
    private int seatCapacity ;
    private int cylinderCapacity ;
    private String topSpeed;
    private boolean vehicalAvailability;
    private int milage;
    private String transmission;
    private Date pickUpDate;
    private Date dropOffDate;

    private static int PARKING_LOTS =50;

    public Vehical() {
    }

    public Vehical( String plateNo,double rent, String make, String model, int seatCapacity, int cylinderCapacity, String topSpeed, boolean vehicalAvailability, int milage, String transmission) {
        this.rent = rent;
        this.plateNo = plateNo;
        this.make = make;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.cylinderCapacity = cylinderCapacity;
        this.topSpeed = topSpeed;
        this.vehicalAvailability = vehicalAvailability;
        this.milage = milage;
        this.transmission = transmission;
    }

    public Vehical(String plateNo, double rent , String make, String model, int seatCapacity, int cylinderCapacity, String topSpeed, boolean vehicalAvailability, int milage, String transmission, Date pickUpDate, Date dropOffDate) {
        this.plateNo = plateNo;
        this.rent=rent;
        this.make = make;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.cylinderCapacity = cylinderCapacity;
        this.topSpeed = topSpeed;
        this.vehicalAvailability = vehicalAvailability;
        this.milage = milage;
        this.transmission = transmission;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        PARKING_LOTS--;
    }

    public static int getPARKING_LOTS() {
        return PARKING_LOTS;
    }



    public double getRent() {
        return rent;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public boolean isVehicalAvailability() {
        return vehicalAvailability;
    }

    public int getMilage() {
        return milage;
    }

    public String getTransmission() {
        return transmission;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setVehicalAvailability(boolean vehicalAvailability) {
        this.vehicalAvailability = vehicalAvailability;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehical)) return false;
        Vehical vehical = (Vehical) o;
        return Double.compare(vehical.getRent(), getRent()) == 0 &&
                getSeatCapacity() == vehical.getSeatCapacity() &&
                getCylinderCapacity() == vehical.getCylinderCapacity() &&
                isVehicalAvailability() == vehical.isVehicalAvailability() &&
                getMilage() == vehical.getMilage() &&
                Objects.equals(getPlateNo(), vehical.getPlateNo()) &&
                Objects.equals(getMake(), vehical.getMake()) &&
                Objects.equals(getModel(), vehical.getModel()) &&
                Objects.equals(getTopSpeed(), vehical.getTopSpeed()) &&
                Objects.equals(getTransmission(), vehical.getTransmission()) &&
                Objects.equals(getPickUpDate(), vehical.getPickUpDate()) &&
                Objects.equals(getDropOffDate(), vehical.getDropOffDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRent(), getPlateNo(), getMake(), getModel(), getSeatCapacity(), getCylinderCapacity(), getTopSpeed(), isVehicalAvailability(), getMilage(), getTransmission(), getPickUpDate(), getDropOffDate());
    }
}
