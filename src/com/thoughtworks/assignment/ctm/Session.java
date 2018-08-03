package com.thoughtworks.assignment.ctm;

import com.thoughtworks.assignment.ctm.utility.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Session class is used to schedule the sessions ( morning, afternoon,lunch break or
 * the networking session ) for each talk occurrence .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class Session {

    private int timeLeft;
    private String sessionName;
    private List<Talk> sessionSchedule;
    private int startTime;

    public Session(String name) {

        this.sessionName = name;
        sessionSchedule = new ArrayList<>();

        if (name == Constant.MORNING) {
            timeLeft = 180;
            startTime = 9 * 60;
        } else if (name == Constant.AFTERNOON) {
            timeLeft = 240;
            startTime = 13 * 60;
        } else {
            timeLeft = 60;
            startTime = 0;
        }
    }

    public void addTalks(Talk talk, int minutes) {
        talk.setTime(Time.timeFormat(minutes));

        sessionSchedule.add(talk);

        // time left is decremented after every talk gets added
        timeLeft = timeLeft - talk.getTalkLength();

    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public String getSessionName() {
        return sessionName;
    }

    public List<Talk> getSessionSchedule() {
        return sessionSchedule;
    }

    public int getStartTime() {
        return startTime;
    }

}
