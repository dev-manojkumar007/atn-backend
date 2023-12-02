package com.attention.atnbackend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : manojkumarpanchal
 * @created : 13/11/23, Monday
 **/
public class ApplicationUtil {

    public static Date formatDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDate = null;
        try {
            formattedDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            new ParseException("Exception while parsing date string", e.getErrorOffset());
        }
        return formattedDate;
    }
}
