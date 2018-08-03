package com.thoughtworks.assignment.ctm;

import com.thoughtworks.assignment.ctm.utility.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConferenceScheduler is main business logic class which do scheduling of all the tracks
 * to particular session .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */

public class ConferenceScheduler {

    private List<Talk> talksList;
    
    private Talk breakOfFiveMin ;

    public ConferenceScheduler(){
    	
    	 breakOfFiveMin = new Talk(Constant.BREAK, "5", "min");
    }
    public void schedule(String input) {

        Conference con = new Conference();

        Talk lunchBreak = new Talk(Constant.LUNCH, "60", "min");
        Talk networking = new Talk(Constant.NETWORKING_SESSION, "60", "min");
        //Talk breakOfFiveMin = new Talk(Constant.BREAK, "5", "min");

        talkCreation(input);
        
        while (!talksList.isEmpty()) {

            Session morning = new Session(Constant.MORNING);
            talksAllocation(morning);

            Session lunch = new Session(Constant.LUNCH);
            lunch.addTalks(lunchBreak, 12 * 60);

            Session afternoon = new Session(Constant.AFTERNOON);
            talksAllocation(afternoon);

            Session networkingSession = new Session(Constant.NETWORKING_SESSION);
            networkingSession.addTalks(networking, afternoon.getStartTime() + (240 - afternoon.getTimeLeft()));

            Track track = new Track();
            track.addSession(morning);
            track.addSession(lunch);
            track.addSession(afternoon);
            track.addSession(networkingSession);

            con.addTrack(track);
        }

        printOutput(con);
    }

    private void talkCreation(String name){
    	
    	InputFileReader reader = new InputFileReader();
        List<String> talksInput = reader.processInputFileAndGenerateTalkList(name);

        talksList = new ArrayList<>();

        for (String string : talksInput) {

            Talk talk = Parser.talkCreation(string);
            if (talk != null)
                talksList.add(talk);
        }
    }
    
    /* iterate through the list of talks and add them to the session */
    private void talksAllocation(Session session) {

        Iterator<Talk> itr = talksList.iterator();
        int duration = session.getTimeLeft();
        int timeLeft = duration;

        while (itr.hasNext() && timeLeft > 0) {
            Talk talk = itr.next();
            if (talk.getTalkLength() <= timeLeft) {
                session.addTalks(talk, session.getStartTime() + (duration - timeLeft));
                session.addTalks(breakOfFiveMin, session.getStartTime() + (duration - session.getTimeLeft()));
                itr.remove();
            }
            timeLeft = session.getTimeLeft();
        }

    }

    /* print the whole schedule on console */
    public void printOutput(Conference con) {
        for (Track track : con.getTracks()) {
            System.out.println(Constant.TRACK + track.getId() + Constant.NEW_LINE);
            for (Session s : track.getSessions()) {
                for (Talk Talk : s.getSessionSchedule()) {
                    System.out.println(Talk.getTime() + Constant.COLON + Talk.getName() + Constant.COLON
                            + Talk.getTalkLength() + Talk.getUnit());
                }

            }

        }
    }
}
