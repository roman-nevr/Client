package ru.yoursolution.servermodule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */

public class Logger {
    private List<String> logs;

    public Logger() {
        logs = new ArrayList<>();
    }

    public void log(String message){
        logs.add("\n" + getCurrentTime()+ ": " + message);
    }

    private String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        return format.format(new Date());
    }

    public void clear(){
        logs.clear();
        logs.removeAll(logs);
    }

    public String print(){
        return logs.toString();
    }
}
