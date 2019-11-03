package com;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils{
    public static Date StringtoDate(String patter, String s) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patter);
        Date parse = simpleDateFormat.parse(s);
        return parse;

    }
    public static String DatetoString (String patter ,Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patter);
        String format = simpleDateFormat.format(date);
        return format;
    }
}
