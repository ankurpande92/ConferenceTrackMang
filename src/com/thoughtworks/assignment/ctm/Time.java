package com.thoughtworks.assignment.ctm;

import com.thoughtworks.assignment.ctm.utility.Constant;

/**
 * Time class is used to converts the time to a ' HH:MM a ' format based on session details .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class Time {

    Time() {

    }

    public static String timeFormat(int minutes) {
        String formatedString;

        String min = String.format("%02d", minutes % 60);
        int hour = minutes / 60;

        if (minutes < 12 * 60)
            formatedString = String.format("%02d", hour) + Constant.COLON + min + Constant.AM;
        else if (hour >= 13)
            formatedString = String.format("%02d", hour - 12) + Constant.COLON + min + Constant.PM;
        else
            formatedString = String.format("%02d", hour) + Constant.COLON + min + Constant.PM;

        return formatedString;
    }

}
