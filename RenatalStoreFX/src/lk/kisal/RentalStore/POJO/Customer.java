package lk.kisal.RentalStore.POJO;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String fullName;
    private String email;
    private String NIC;
    public static List<Customer> customerDetails = new ArrayList<>();

    public Customer() {
    }

    public Customer(String fullName, String email, String NIC) {
        this.fullName = fullName;
        this.email = email;
        this.NIC = NIC;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", NIC='" + NIC + '\'' +
                '}';
    }
}
