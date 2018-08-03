package com.thoughtworks.assignment.ctm;

import java.util.ArrayList;
import java.util.List;

/**
 * Conference class is used to handle Tracks details .
 *
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */

public class Conference {

    private List<Track> tracks;

    public Conference() {
        tracks = new ArrayList<>();

    }

    public void addTrack(Track a) {
        tracks.add(a);
    }

    public List<Track> getTracks() {
        return tracks;
    }

}
