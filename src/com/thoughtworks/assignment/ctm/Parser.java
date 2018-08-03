package com.thoughtworks.assignment.ctm;

import com.thoughtworks.assignment.ctm.exception.InvalidInputException;
import com.thoughtworks.assignment.ctm.utility.ErrorConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser class is used to parse each inputLine and create talk object .
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class Parser {

    Parser() {

    }

    public static Talk talkCreation(String input) {

        Talk talk;

        if (input == null)
            return null;

        /* Below regex used for handling input string without numbers, NULLs in the talk . */

        Pattern pattern = Pattern.compile("^(\\D+)\\s?(\\d+)?\\s?((min)|(lightning))$");
        Matcher matcher = pattern.matcher(input);
        boolean result = matcher.matches();

        if (result) {
            String name = matcher.group(1);
            String length = matcher.group(2);
            String unit = matcher.group(3);

            if (length != null) {
                talk = new Talk(name, length, unit);
            } else {
                return null;
            }

        } else {
            throw new InvalidInputException(ErrorConstant.INVALID_INPUT_TALK_DETAIL_IS_NOT_PROPER);
        }
        return talk;

    }
}
