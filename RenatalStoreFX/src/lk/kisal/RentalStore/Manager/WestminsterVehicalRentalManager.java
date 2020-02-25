package lk.kisal.RentalStore.Manager;

import lk.kisal.RentalStore.Comparator.IDComparator;
import lk.kisal.RentalStore.Database.Database;
import lk.kisal.RentalStore.POJO.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterVehicalRentalManager implements RentalVehicalManager {
    public static final int MAX_SIZE=50;
    public static List<Vehical> vehicalDetails = new ArrayList<>();
    public static List<Vehical> vehicalDetailsFromDatabase = new ArrayList<>();
    public static int spaceUsed=0;
    public static int subMenuOption=1;

    @Override
    public void addVehical() {
        Database.takePlateFromDatabase();
        if (vehicalDetails.size()<MAX_SIZE){
            subMenu();
            switch (subMenuOption){
                case 1:
                    System.out.println("Enter number of cars ");
                    int numberOfCars= ConsoleMenu.validateVal("Number of cars");
                    addCar(numberOfCars);
                    break;
                case 2:
                    System.out.println("Enter number of motorbikes ");
                    int numberOfMotorbikes=ConsoleMenu.validateVal("Number of motorbikes ");
                    addMotorbike(numberOfMotorbikes);
                    break;
                case 3:
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Option not recognized");
            }
        }
        else{
            System.out.println("All the parking lots are acquired!!!");
        }
    }

    @Override
    public void deleteVehical() {
        printList();
        subMenuDelete();
        String deletePlate;
        switch (subMenuOption){
            case 1:
                System.out.println("Enter the plate number of car that you want to delete ");
                deletePlate=ConsoleMenu.getInput();
                Database.deleteCar(deletePlate);
                break;
            case 2:
                System.out.println("Enter the plate number of motorbike that you want to delete ");
                deletePlate=ConsoleMenu.getInput();
                Database.deleteMoto(deletePlate);
                break;
            case 3:
                System.out.println("Exited");
                break;
            default:
                System.out.println("Option not recognized");
        }
    }

    @Override
    public void printList() {
        Database.takeFromDatabase();
        if (!vehicalDetailsFromDatabase.isEmpty()){
            Collections.sort(vehicalDetailsFromDatabase,new IDComparator());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t\t\t\t\tAlphabetical order of Vehicle make ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|  %30s  |  %30s  |  %30s  |\n", "Plate Number", "Make ", "Model");
            System.out.println("_______________________________________________________________________________________________________________________________________");
            for (Vehical veh : vehicalDetailsFromDatabase){
                String plateNumber = veh.getPlateNo();
                String make = veh.getMake();
                String model = veh.getModel();

                System.out.printf("  %30s    %30s    %30s  \n", plateNumber,make,model);
                System.out.println();
            }
        }else{
            System.out.println("No vehicals are added");
        }
    }

    @Override
    public void save() {
        Database.takeFromDatabase();
        File file =new File("SaveItem.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(file,true),true)) {
            pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            pw.printf("|  %10s  |  %10s  |  %10s  |  %10s  |  %10s  |  %10s  |  %10s  |  %10s  |\n", "Plate Number", "Model ", "Make" , "Top speed" , "Vehicle Availability " , "Pickup Date" , "Drop off date" , "Date saved");
            pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Vehical item :vehicalDetailsFromDatabase ) {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
                Calendar calobj = Calendar.getInstance();
                pw.printf("|  %10s     |  %10s  |  %10s  |  %10s  |  %10s            |  %10s  |  %10s  |  %10s  |\n",item.getPlateNo() ,item.getModel(), item.getMake() , item.getTopSpeed() , item.isVehicalAvailability() , item.getPickUpDate(), item.getDropOffDate() ,df.format(calobj.getTime()));
            }
            pw.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            pw.println("********************************************************************************************************************************************************");

        }catch (IOException e){
            e.printStackTrace();
        }


    }


    private void addCar(int number) {
        for (int i = 0; i < number; i++) {

            System.out.println("Enter the plate number ");
            String plateNumber = getPlateNumber();

            System.out.println("Enter the rent");
            double rent = getRent();

            System.out.println("Enter the make");
            String make = getMake();

            System.out.println("Enter the model");
            String model = getModel();

            System.out.println("Enter the seatCapacity");
            int seatCap = getSeatCapacity();

            System.out.println("Enter the cylinder capacity");
            int cylinCap = getCylinderCapacity();

            System.out.println("Enter the top speed");
            String topSpeed = getTopSpeed();

            System.out.println("Enter vehical availability");
            boolean vehicalAvailability = getVehicalAvailability();

            System.out.println("Enter the milage");
            int milage = getMilage();

            System.out.println("Enter the transmittion mode AUTO/MANUAL");
            String transmittion = getTransmission();

            System.out.println("Enter number of doors");
            int  numberDoors = getNoOfDoors();

            System.out.println("Enter air condition availability");
            boolean airConAvailability=getAirConditionAvailability();

            Vehical carVehicle=new Car(plateNumber,rent,make,model,seatCap,cylinCap,topSpeed,vehicalAvailability,milage,transmittion,numberDoors,airConAvailability);
            Car car=(Car)carVehicle;
            vehicalDetails.add(car);

            Database.addCarDatabase(car);

            spaceUsed++;
        }
    }



    private void addMotorbike(int number){
        for (int i = 0; i < number; i++) {

            System.out.println("Enter the plate number ");
            String plateNumber = getPlateNumber();

            System.out.println("Enter the rent");
            double rent = getRent();

            System.out.println("Enter the make");
            String make = getMake();

            System.out.println("Enter the model");
            String model = getModel();

            System.out.println("Enter the seatCapacity");
            int seatCap = getSeatCapacity();

            System.out.println("Enter the cylinder capacity");
            int cylinCap = getCylinderCapacity();

            System.out.println("Enter the top speed");
            String topSpeed = getTopSpeed();

            System.out.println("Enter vehical availability");
            boolean vehicalAvailability = getVehicalAvailability();

            System.out.println("Enter the milage");
            int milage = getMilage();

            System.out.println("Enter the transmittion mode AUTO/MANUAL");
            String transmittion = getTransmission();

            System.out.println("Enter helmet availability");
            boolean helmetAvailability = getHelmetAvailability();

            System.out.println("Enter Box Compartment availability");
            boolean boxCompartAvailability = getBoxCompartmentAvailability();

            Vehical motoBVehicle=new MotorBike(plateNumber,rent,make,model,seatCap,cylinCap,topSpeed,vehicalAvailability,milage,transmittion,helmetAvailability,boxCompartAvailability);
            MotorBike motoB =(MotorBike)motoBVehicle;
            vehicalDetails.add(motoB);

            Database.addMotorDatabase(motoB);

            spaceUsed++;
        }
    }


    private double getRent(){
        return ConsoleMenu.getInputDouble();
    }
    private String getPlateNumber(){
        return ConsoleMenu.getInputPlate();
    }
    private String getMake(){
        return ConsoleMenu.getInput();
    }
    private String getModel(){
        return ConsoleMenu.getInput();
    }
    private int getSeatCapacity(){
        return ConsoleMenu.getInputInt();
    }
    private int getCylinderCapacity(){
        return ConsoleMenu.getInputInt();
    }
    private String getTopSpeed(){
        return ConsoleMenu.getInput();
    }
    private boolean getVehicalAvailability(){
        return ConsoleMenu.getInputBool();
    }
    private int getMilage(){
        return ConsoleMenu.getInputInt();
    }
    private String getTransmission(){
        return ConsoleMenu.getInput();
    }
    private int getNoOfDoors(){
        return ConsoleMenu.getInputInt();
    }
    private boolean getAirConditionAvailability(){
        return ConsoleMenu.getInputBool();
    }
    private boolean getHelmetAvailability(){
        return ConsoleMenu.getInputBool();
    }
    private boolean getBoxCompartmentAvailability(){
        return ConsoleMenu.getInputBool();
    }



    public static void subMenu() {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the type of item you want to add\n1. Car\n2. Motorbike\n3. Exit");
        System.out.print(">");
        while(!scan.hasNextInt())   //check the validity
        {
            String wrongInput=scan.next();
            System.out.println(wrongInput+" is not a valid input");
            System.out.println("Enter a correct input");
        }
        subMenuOption=scan.nextInt();
    }

    public static void subMenuDelete() {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the type of item you want to delete\n1. Car\n2. Motorbike\n3. Exit");
        System.out.print(">");
        while(!scan.hasNextInt())   //check the validity
        {
            String wrongInput=scan.next();
            System.out.println(wrongInput+" is not a valid input");
            System.out.println("Enter a correct input");
        }
        subMenuOption=scan.nextInt();
    }




}
