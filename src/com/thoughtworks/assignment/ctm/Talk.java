package com.thoughtworks.assignment.ctm;

import com.thoughtworks.assignment.ctm.utility.Constant;

/**
 * Talk class is used for each talk occurrence .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class Talk {

    private String name; // title of talk
    private int talkLength; // duration of talk
    private String time; // time at which talk starts
    private String unit; // unit associated with the duration

    public Talk(String name, String talkLength, String unit) {
        this.name = name;
        this.unit = unit;

        /* time conversion ; lightning = 5 minutes */
        if (unit == Constant.LIGHTNING)
            this.talkLength = 5 * Integer.parseInt(talkLength);
        else
            this.talkLength = Integer.parseInt(talkLength);

        time = " ";
    }

    public String getName() {
        return name;
    }

    public int getTalkLength() {
        return talkLength;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getUnit() {
        return unit;
    }
}
