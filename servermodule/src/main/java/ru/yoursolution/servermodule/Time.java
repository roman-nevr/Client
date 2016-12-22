package ru.yoursolution.servermodule;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 21.12.2016.
 */

public class Time {
    public static String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        return format.format(new Date());
    }
}
