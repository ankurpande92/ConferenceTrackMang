package com.thoughtworks.assignment.ctm;

import java.util.ArrayList;
import java.util.List;

/**
 * Track class is used to maintain Track number/ID and multiple session details of particular day .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class Track {
    private List<Session> sessions;
    static int count = 0;
    private final int id;

    public Track() {
        sessions = new ArrayList<>();
        count++;
        id = count;

    }

    public int getId() {
        return id;
    }

    public void addSession(Session a) {
        sessions.add(a);
    }

    public List<Session> getSessions() {
        return sessions;
    }

}
