package lk.kisal.RentalStore.Database;

import lk.kisal.RentalStore.Manager.WestminsterVehicalRentalManager;
import lk.kisal.RentalStore.POJO.Car;
import lk.kisal.RentalStore.POJO.ConsoleMenu;
import lk.kisal.RentalStore.POJO.MotorBike;
import lk.kisal.RentalStore.POJO.Vehical;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class Database {


    public static void spacesLeft(){
        int count=0;
        int count1=0;
        try {
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            try {
                Statement st = myConnection.createStatement();
                ResultSet res = st.executeQuery("SELECT COUNT(*) FROM CAR");
                while (res.next()){
                    count = res.getInt(1);
                    WestminsterVehicalRentalManager.spaceUsed+=count;
                }
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        try {
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            try {
                Statement st = myConnection.createStatement();
                ResultSet res = st.executeQuery("SELECT COUNT(*) FROM MOTORBIKE");
                while (res.next()){
                    count1 = res.getInt(1);
                    WestminsterVehicalRentalManager.spaceUsed+=count;
                }
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        int totalNum=count+count1;
        System.out.println("Spaces left "+(WestminsterVehicalRentalManager.MAX_SIZE-totalNum));
    }


    public static void addCarDatabase(Car car){
        try{
            Connection myConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            PreparedStatement myStatement=myConnection.prepareStatement("INSERT INTO CAR" + "(plateNo,rent,make,model,seatCapacity,cylinderCapacity,topSpeed,vehicalAvailability,milage,transmission,pickUpDate,dropOffDate,noOfDoors,airConditionAvailability )"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            myStatement.setString(1,car.getPlateNo());
            myStatement.setDouble(2,car.getRent());
            myStatement.setString(3,car.getMake());
            myStatement.setString(4,car.getModel());
            myStatement.setInt(5,car.getSeatCapacity());
            myStatement.setInt(6,car.getCylinderCapacity());
            myStatement.setString(7,car.getTopSpeed());
            myStatement.setBoolean(8,car.isVehicalAvailability());
            myStatement.setInt(9,car.getMilage());
            myStatement.setString(10,car.getTransmission());
            myStatement.setDate(11,null);
            myStatement.setDate(12,null);
            myStatement.setInt(13,car.getNoOfDoors());
            myStatement.setBoolean(14,car.isAirConditionAvailability());
            myStatement.execute();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public static void addMotorDatabase(MotorBike moto){
        try{
            Connection myConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            PreparedStatement myStatement=myConnection.prepareStatement("INSERT INTO motorbike" + "(plateNo,rent,make,model,seatCapacity,cylinderCapacity,topSpeed,vehicalAvailability,milage,transmission,pickUpDate,dropOffDate,helmetAvailability,boxCompartmentAvailability )"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            myStatement.setString(1,moto.getPlateNo());
            myStatement.setDouble(2,moto.getRent());
            myStatement.setString(3,moto.getMake());
            myStatement.setString(4,moto.getModel());
            myStatement.setInt(5,moto.getSeatCapacity());
            myStatement.setInt(6,moto.getCylinderCapacity());
            myStatement.setString(7,moto.getTopSpeed());
            myStatement.setBoolean(8,moto.isVehicalAvailability());
            myStatement.setInt(9,moto.getMilage());
            myStatement.setString(10,moto.getTransmission());
            myStatement.setDate(11,null);
            myStatement.setDate(12,null);
            myStatement.setBoolean(13,moto.isHelmetAvailability());
            myStatement.setBoolean(14,moto.isBoxCompartmentAvailability());
            myStatement.execute();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public static void deleteCar(String number){
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root", "");
            PreparedStatement myStatement=myConnection.prepareStatement("DELETE FROM car WHERE plateNo=?");
            myStatement.setString(1,number);
            myStatement.executeUpdate();
            WestminsterVehicalRentalManager.spaceUsed--;
        }
        catch(Exception exc){
            System.out.println("Your plate number doesn't exist ");
        }
    }
    public static void deleteMoto(String number){
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root", "");
            PreparedStatement myStatement=myConnection.prepareStatement("DELETE FROM motorbike WHERE plateNo=?");
            myStatement.setString(1,number);
            myStatement.executeUpdate();
            WestminsterVehicalRentalManager.spaceUsed--;
        }
        catch(Exception exc){
            System.out.println("Your plate number doesn't exist ");
        }
    }

    public static void takeFromDatabase(){
        WestminsterVehicalRentalManager.vehicalDetailsFromDatabase.removeAll(WestminsterVehicalRentalManager.vehicalDetailsFromDatabase);
        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            Statement start=myConnection.createStatement();
            ResultSet set=start.executeQuery("SELECT * FROM Car");//retrieve items

            while (set.next()){
                String plateNum=set.getString(1);
                double Rent =set.getDouble(2);
                String make=set.getString(3);
                String model=set.getString(4);
                int seat =set.getInt(5);
                int cylinderCap=set.getInt(6);
                String topSpeed=set.getString(7);
                boolean vehicalAva = set.getBoolean(8);
                int milage = set.getInt(9);
                String trans=set.getString(10);
                Date pickup=set.getDate(11);
                Date dropOff=set.getDate(12);
                int doors=set.getInt(13);
                boolean AC =set.getBoolean(14);

                Vehical car=new Car(plateNum,Rent,make,model,seat,cylinderCap,topSpeed,vehicalAva,milage,trans,pickup,dropOff,doors,AC);
                WestminsterVehicalRentalManager.vehicalDetailsFromDatabase.add(car);
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            Statement start=myConnection.createStatement();
            ResultSet set=start.executeQuery("SELECT * FROM motorbike");//retrieve items

            while (set.next()){
                String plateNum=set.getString(1);
                double Rent =set.getDouble(2);
                String make=set.getString(3);
                String model=set.getString(4);
                int seat =set.getInt(5);
                int cylinderCap=set.getInt(6);
                String topSpeed=set.getString(7);
                boolean vehicalAva = set.getBoolean(8);
                int milage = set.getInt(9);
                String trans=set.getString(10);
                Date pickup=set.getDate(11);
                Date dropOff=set.getDate(12);
                boolean helmet=set.getBoolean(13);
                boolean box =set.getBoolean(14);

                Vehical motoB=new MotorBike(plateNum,Rent,make,model,seat,cylinderCap,topSpeed,vehicalAva,milage,trans,pickup,dropOff,helmet,box);
                WestminsterVehicalRentalManager.vehicalDetailsFromDatabase.add(motoB);
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

    }
    public static void takePlateFromDatabase(){
        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            Statement start=myConnection.createStatement();
            ResultSet set=start.executeQuery("SELECT plateNo FROM Car");//retrieve items

            while (set.next()){
                String plateNum=set.getString(1);
                ConsoleMenu.plateNum.add(plateNum);
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            Statement start=myConnection.createStatement();
            ResultSet set=start.executeQuery("SELECT plateNo FROM motorbike");//retrieve items

            while (set.next()){
                String plateNum=set.getString(1);
                ConsoleMenu.plateNum.add(plateNum);
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public static void addDates(Date pickUpDate, Date dropOffDate, String plateSearch){

        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            String sql="UPDATE CAR SET vehicalAvailability='"+0+"', pickUpDate='"+pickUpDate+"',dropOffDate='"+dropOffDate+"' WHERE plateNo ='"+plateSearch+"'";
            PreparedStatement pst=myConnection.prepareStatement(sql);
            pst.execute();

        }catch (Exception exc){
        }
        System.out.println("hihi");
        try{
            Connection myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root","");
            String sql="UPDATE motorbike SET vehicalAvailability='"+0+"', pickUpDate='"+pickUpDate+"',dropOffDate='"+dropOffDate+"' WHERE plateNo ='"+plateSearch+"'";
            PreparedStatement pst=myConnection.prepareStatement(sql);
            pst.execute();

        }catch (Exception exc){
        }
        System.out.println("hihihihihih");
    }
    public static Boolean getAvailability(String plSearch) {
        Boolean vehAva=false ;
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root", "");
            Statement start = myConnection.createStatement();
            ResultSet set = start.executeQuery("SELECT vehicalAvailability FROM car where plateNo '" + plSearch + "' ");//retrieve items


            if (!set.next()) {//if ResultSet is empty
                try {
                    Connection myConnection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVACW2YEAR?serverTimezone=UTC", "root", "");
                    Statement start1 = myConnection1.createStatement();
                    set = start.executeQuery("SELECT vehicalAvailability FROM motorbike where plateNo '" + plSearch + "' ");

                    while (set.next()) {
                        vehAva = set.getBoolean(1);
                        if(!vehAva){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
                catch (Exception exc) {

                }
            }
        }
        catch (Exception exc) {

        }
        if(!vehAva){
            return false;
        }else{
            return true;
        }
    }
}
