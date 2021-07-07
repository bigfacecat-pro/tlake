package com.the.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
    public static String getDate(){
       return sdf.format(new Date());
    }
    public static String getClock(){
        return sdf2.format(new Date());
    }
}
