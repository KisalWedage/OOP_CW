package lk.kisal.RentalStore.Date;

import lk.kisal.RentalStore.Database.Database;
import lk.kisal.RentalStore.POJO.ConsoleMenu;

import java.sql.Date;
import java.time.LocalDate;

public class Schedule{
    private static LocalDate pickUpDate;
    private static LocalDate dropOffDate;

    public Schedule()  {
    }


    public Schedule(LocalDate pickUpDate, LocalDate dropOffDate,String plateSearch ) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        Date pickUpDatedate = Date.valueOf(pickUpDate);
        Date dropOffDatedate = Date.valueOf(dropOffDate);
        Database.addDates(pickUpDatedate,dropOffDatedate,plateSearch);
    }

    public static int checkVal (LocalDate pickUpDate, LocalDate dropOffDate ){
        int sub=pickUpDate.compareTo(dropOffDate)  ;
        return sub;
    }




/*




    public static LocalDate getPickUpDate(){
        System.out.println("Enter year ");
        int year= ConsoleMenu.validateVal(" Year " );

        System.out.println("Enter month ");
        int month=ConsoleMenu.validateVal(" Month " );

        System.out.println("Enter day ");
        int day=ConsoleMenu.validateVal(" Day " );



        return new LocalDate(year,month,day);

    }



    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

  public static Date getDropOffDate(){
        System.out.println("Enter year ");
        int year=ConsoleMenu.validateVal(" Year " );

        System.out.println("Enter month ");
        int month=ConsoleMenu.validateVal(" Month " );

        System.out.println("Enter day ");
        int day=ConsoleMenu.validateVal(" Day " );

        return new Date(day,month,year);
    }


    public void setDropOffDate(LocalDate dropOffDate) {
        this.dropOffDate = dropOffDate;
    }
*/

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
