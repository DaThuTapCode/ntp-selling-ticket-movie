package com.trongphu.ticketmovie.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Trong Phu on 5/30/2024 18:25:44
 *
 * @author Trong Phu
 */
public class TimeUtil {
    public  static Date formatToTime(Date time){

        SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss");
        try {
            String timeStr = formater.format(time);
            time = formater.parse(timeStr);
            return time;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public  static Date formatToDate(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String dateStr = formater.format(date);
            date = formater.parse(dateStr);
            return date;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
