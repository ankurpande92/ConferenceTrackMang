package com.thoughtworks.assignment.ctm.main;

import com.thoughtworks.assignment.ctm.ConferenceScheduler;

import java.util.Scanner;

/**
 * CTMApplication is the main function of Conference Track management
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class CTMApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the file path :");
        String filePath = input.next();

        ConferenceScheduler confgScheduler = new ConferenceScheduler();

        confgScheduler.schedule(filePath);

    }

}
