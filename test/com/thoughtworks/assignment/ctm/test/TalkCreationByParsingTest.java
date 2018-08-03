package com.thoughtworks.assignment.ctm.test;

import static org.junit.Assert.assertEquals;

import com.thoughtworks.assignment.ctm.Parser;
import com.thoughtworks.assignment.ctm.Talk;
import org.junit.Test;

public class TalkCreationByParsingTest {

    @Test
    public void canTalkCreationByParsing() {

        String string = "Writing Fast Tests Against Enterprise Rails 60min";
        Talk actualTalk = Parser.talkCreation(string);
        Talk expectedTalk = new Talk("Writing Fast Tests Against Enterprise Rails ", "60", "min");

        assertEquals(expectedTalk.getTalkLength(), actualTalk.getTalkLength());
        assertEquals(expectedTalk.getName(), actualTalk.getName());
        assertEquals(expectedTalk.getUnit(), actualTalk.getUnit());

    }

}
