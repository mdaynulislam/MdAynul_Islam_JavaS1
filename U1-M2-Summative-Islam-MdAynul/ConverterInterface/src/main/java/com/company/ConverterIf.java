package com.company;

import com.company.Converter;

public class ConverterIf implements Converter {

                @Override
                public String convertMonth(int month) {

                    String monthName;
                    if(month == 1){
                        monthName = "January";
                        return monthName;
                    }
                    else if(month == 2){
                        monthName = "February";
                        return monthName;
                    }
                    else if(month == 3){
                        monthName = "March";
                        return monthName;
                    }
                    else if(month == 4){
                        monthName = "April";
                        return monthName;
                    }
                    else if(month == 5){
                        monthName = "May";
                        return monthName;
                    }
                    else if(month == 6){
                        monthName = "June";
                        return monthName;
                    }
                    else if(month == 7){
                        monthName = "July";
                        return monthName;
                    }
                    else if(month == 8){
                        monthName = "August";
                        return monthName;
                    }
                    else if(month == 9){
                        monthName = "September";
                        return monthName;
                    }
                    else if(month == 10){
                        monthName = "October";
                        return monthName;
                    }else if(month == 11){
                        monthName = "November";
                        return monthName;
                    }else if(month == 12){
                        monthName = "December";
                        return monthName;
                    }else{
                        monthName = "Not a valid number for month";
                        return monthName;

                    }

                }

    @Override
    public String convertDay(int day) {


        String dayName;
        if(day==1){
            dayName = "Sunday";
        }
        else if(day==2){
            dayName = "Monday";
        }
        else if(day==3){
            dayName = "Tuesday";
        }
        else if(day==4){
            dayName = "Wednesday";
        }
        else if(day==5){
            dayName = "Thursday";
        }
        else if(day==6){
            dayName = "Friday";
        }
        else if(day==7){
            dayName = "Saturday";
        }
        else{
            dayName = "Not a valid number for a day";
        }
        return dayName;
    }
}
