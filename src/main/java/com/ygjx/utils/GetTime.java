package com.ygjx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
    public static String getCurrenTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(day);
    }
}

