package lk.kisal.RentalStore.POJO;

import javafx.application.Application;
import lk.kisal.RentalStore.Database.Database;
import lk.kisal.RentalStore.GUI.GUI;
import lk.kisal.RentalStore.Manager.WestminsterVehicalRentalManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    public static Scanner scan = new Scanner(System.in);
    public static List<String> plateNum = new ArrayList<>();
    public static void main(String[] args) throws ParseException {

        int mainOption = 0;
        WestminsterVehicalRentalManager ob = new WestminsterVehicalRentalManager();
        do {
            System.out.println("Choose one of below options");
            System.out.println("1. Add item");
            System.out.println("2. Delete item");
            System.out.println("3. Print item list");
            System.out.println("4. Save");
            System.out.println("5. GUI");
            System.out.println("6. Exit program");
            System.out.print(">");

            while (!scan.hasNextInt())   //check the validity
            {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is not a valid input");
                System.out.println("Enter a correct input");
            }
            mainOption = scan.nextInt();

            switch (mainOption) {
                case 1:
                    System.out.println("You choose to add vehicles");
                    Database.spacesLeft();
                    ob.addVehical();
                    break;
                case 2:
                    System.out.println("You choose to delete vehicles");
                    Database.spacesLeft();
                    ob.deleteVehical();
                    break;
                case 3:
                    System.out.println("You choose to Print the list");
                    ob.printList();
                    break;
                case 4:
                    System.out.println("You choose to write the items in a file");
                    ob.save();
                    break;
                case 5:
                    System.out.println("You choosed to show the GUI");
                    Database.takeFromDatabase();
                    try {
                        Application.launch(GUI.class);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("You exited the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unrecognized input");

            }
        } while (mainOption != 6);

    }

    public static int validateVal(String val){
        while(!scan.hasNextInt())   //check the validity
        {
            String wrongInput=scan.next();
            System.out.println(wrongInput+" is not a valid input for "+val);
            System.out.println("Enter a correct input");
        }
        return scan.nextInt();
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    public static String getInputPlate(){
        Scanner sc = new Scanner(System.in);
        String val=sc.next();
        while((plateNum.contains(val)) ){
            System.out.println("Plate number already exists");
            System.out.println("Enter plate number again");
            val=sc.next();
        }
        plateNum.add(val);
        return val;
    }

    public static int getInputInt(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt())   //check the validity
        {
            String wrongInput=sc.next();
            System.out.println(wrongInput+" is not a valid input");
            System.out.println("Enter a correct input");
        }
        return sc.nextInt();
    }

    public static boolean getInputBool(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextBoolean())   //check the validity
        {
            String wrongInput=sc.next();
            System.out.println(wrongInput+" is not a valid input");
            System.out.println("Enter a correct input");
        }
        return sc.nextBoolean();
    }

    public static double getInputDouble(){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextDouble() )   //check the validity
        {
            String wrongInput=sc.next();
            System.out.println(wrongInput+" is not a valid input");
            System.out.println("Enter a correct input");
        }
        return sc.nextDouble();
    }
}
