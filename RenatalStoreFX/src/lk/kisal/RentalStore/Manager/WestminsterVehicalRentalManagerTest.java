package lk.kisal.RentalStore.Manager;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WestminsterVehicalRentalManagerTest {

    @Test
    public void addVehical() {
        WestminsterVehicalRentalManager manager=new WestminsterVehicalRentalManager();
        manager.addVehical();
        assertEquals("Add vehicles","Add vehicles");
    }

    @org.junit.Test
    public void deleteVehical() {
    }
/*
    @org.junit.Test

//    public void printList() {
//    }*/

    @org.junit.Test
    public void save() {
    }

    @Test
    public void printList(){
        WestminsterVehicalRentalManager manager=new WestminsterVehicalRentalManager();
        manager.printList();
        assertEquals("Print List of vehicles","Print List of vehicles");
    }
}