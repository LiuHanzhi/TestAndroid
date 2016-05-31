package com.example.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liuhanzhi on 16/3/22.
 */
public class TimeFormat {

    public static void main(String[] args) {
        checkTime();
    }

    private static boolean checkTime() {
        try {
            System.out.println(System.currentTimeMillis());
            Date date = DateTool.longToDate(System.currentTimeMillis(), "yyyyMMddHH");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            System.out.println("year:" + year + " month:" + month + " day:" + day + " hour:" + hour);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append(month < 10 ? ("0" + month) : month);
            stringBuilder.append(day < 10 ? ("0" + day) : day);
            stringBuilder.append(hour < 10 ? ("0" + hour) : hour);
            System.out.println("str:" + stringBuilder.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh");

            long millionSeconds = sdf.parse(stringBuilder.toString()).getTime();//毫秒
            System.out.println(millionSeconds);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

}
