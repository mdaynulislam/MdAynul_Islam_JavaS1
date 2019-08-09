package com.company;

import com.company.Converter;

public class ConverterSwitch implements Converter {

                @Override
                public String convertMonth(int month) {
                    String monthName="";
                    switch(month){
                        case 1:
                            monthName = "January";

                            break;
                        case 2:
                            monthName = "February";

                            break;
                        case 3:
                            monthName = "March";

                            break;
                        case 4:
                            monthName = "April";

                            break;
                        case 5:
                            monthName = "May";

                            break;
                        case 6:
                            monthName = "June";
                            break;
                        case 7:
                            monthName = "July";

                            break;
                        case 8:
                            monthName = "August";

                            break;
                        case 9:
                            monthName = "September";

                            break;
                        case 10:
                            monthName = "October";

                            break;
                        case 11:
                            monthName = "November";

                            break;
                        case 12:
                            monthName = "December";

                            break;
                        default:
                            return ("Not a valid number for a month");

                    }
                    return monthName;
                }




    @Override
    public String convertDay(int day) {
        String dayName="";
        switch(day){
            case 1:
                dayName = "Sunday";

                break;
            case 2:
                dayName = "Monday";

                break;
            case 3:
                dayName = "Tuesday";

                break;
            case 4:
                dayName = "Wednesday";

                break;
            case 5:
                dayName = "Thursday";

                break;
            case 6:
                dayName = "Friday";
                break;

            case 7:
                dayName = "Saturday";

                break;
            default:
                return ("Not a valid number for a day");

        }
        return dayName;


    }
}
