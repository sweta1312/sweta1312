package com.example.config;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import java.time.*;
import java.util.*;


public class HelloTestDmo {

            static void
            findDifference(String startTime,
                           String end_date) throws ParseException {
                Date date1=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(startTime);
                Date date2=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse( end_date);
                // Calucalte time difference
                // in milliseconds
                long difference_In_Time
                        =  date2.getTime()- date1.getTime() ;

                // Calucalte time difference in seconds,
                // minutes, hours, years, and days
                long seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
                long hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
                long days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
                long years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;

                System.out.print("Total Time of Inspection year:day:hours:minute:second:");
                System.out.println(years + ":" + days +
                        ":" + hours + ":" + minutes
                        + ":" + seconds );
            }

            public static void main(String[] args) throws ParseException {
                String startTime="10-01-2018 01:18:27";
                String endTime="11-01-2019 02:10:20";
                findDifference(startTime, endTime);
            }
        }

       /* String createdOn = "10/04/14 09:29:58";
        String modifiedOn = "28/08/14 10:33:43";

        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(createdOn);
            d2 = format.parse(modifiedOn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();

        long days = TimeUnit.MILLISECONDS.toDays(diff);
        long remainingHoursInMillis = diff - TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(remainingHoursInMillis);
        long remainingMinutesInMillis = remainingHoursInMillis - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(remainingMinutesInMillis);
        long remainingSecondsInMillis = remainingMinutesInMillis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingSecondsInMillis);

        //  System.out.println("Days: " + days + ", hours: " + hours );
        System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds);*/

         /* Supplier<String> s = () -> {
            String otp = "IN-";
*/
/*
            SimpleDateFormat specificformat = new SimpleDateFormat("dd-MM-yy");
            String currentDate = Integer.toString(Date.from(Instant.now()).getMonth());
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            String date = "";
            try {
                date = df.parse(currentDate).toString().replace("-","").substring(0,8);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date);

            // Get the date using calendar object
            Date today = Calendar.getInstance()
                    .getTime();
            // Convert the date into a
            // string using format() method
            String dateToString = df.format(today);
            for (int i = 1; i <= 5; i++) {
                otp = otp + (int)( Math.random()*10);
            }
            return otp;
        };*/
//System.out.println(s.get());
           /* Supplier<String> s = () -> {
                String otp = "";

                for (int i = 1; i <= 5; i++) {
                    otp = otp+(int)( Math.random()*10);
                }
                Date localDateTime ;
                return "IN"+LocalDate.now().getDayOfYear()+LocalDate.now().getMonthValue()+LocalDate.now().getYear()+ otp;
            };

            System.out.println(s.get());
        System.out.println(s.get());*/
