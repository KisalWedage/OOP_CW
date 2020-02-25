/*
package lk.kisal.RentalStore.Date;


import lk.kisal.RentalStore.POJO.ConsoleMenu;

public class Date{
    private int year;
    private int month;
    private int day;

    public Date() {
    }


    public Date(int day, int month, int year) {
        this.year = setYear(year);
        this.month = setMonth(month);
        this.day = setDay(day,month);
    }



    public int setMonth(int month){
        if(month > 0 && month < 13){
            return month;
        }else{
            do{
                System.out.println("Enter the month again.");
                month= ConsoleMenu.getInputInt();
            }while(month>12 || month <1);
            return month;
        }
    }

    public int setDay(int dateS,int monthS){

        if (monthS < 1 || monthS > 12){
            monthS = setMonth(monthS);
        }

        int[] datesArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(dateS >=1 && dateS<=31){
            int day = datesArr[monthS-1];
            if (day >= dateS) {
                return dateS;
            }else{
                do{
                    System.out.println("Date is not valid please re enter");
                    dateS=ConsoleMenu.getInputInt();
                }while(day <= dateS);
            }

        }else{
            do{
                System.out.println("Date is not valid please re enter ");
                dateS=ConsoleMenu.getInputInt();
            }while(dateS>32 || dateS <0);


        }

        return dateS;
    }

    public int setYear(int year){
        while (!(year>999 && year<10000)){
            System.out.println("Invalid year entered\nEnter again");
            year=ConsoleMenu.getInputInt();
        }
        return year;
    }




    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
*/
