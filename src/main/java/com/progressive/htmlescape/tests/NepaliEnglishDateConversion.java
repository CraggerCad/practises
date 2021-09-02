package com.progressive.htmlescape.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NepaliEnglishDateConversion {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String d1E = "2021-06-15";
        String eqN = "2078-03-26"; // compute eng equivalent of this date
        String d1N = "2078-03-01";


        String d2E = "2021-07-16";
        // compute eng equivalent of 2078-07-21
        String d2N = "2078-04-01";

        Date D1E = dateFormat.parse(d1E);
        Date eqNN = dateFormat.parse(eqN);
        Date D1N = dateFormat.parse(d1N);

        Calendar c = Calendar.getInstance();

        long asd = eqNN.getTime() - D1N.getTime();
        Long days = TimeUnit.DAYS.convert(asd, TimeUnit.MILLISECONDS);
        c.setTime(D1E);
        c.add(Calendar.DATE, days.intValue());
        System.out.println("first english equivalent of " + eqN);
        System.out.println(TimeUnit.DAYS.convert(asd, TimeUnit.MILLISECONDS));
        System.out.println(c.getTime());

        Date D2E = dateFormat.parse(d2E);
        Date D2N = dateFormat.parse(d2N);
    }
}
