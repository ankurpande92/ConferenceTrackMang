package com.thoughtworks.assignment.ctm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * InputFileReader class is used to read the input file line by line and
 * generate the list of String containing the talk detail.
 * 
 * @author Ankur Pande
 * @version 1.0
 * @updated
 * @since 13 Dec 2016
 */
public class InputFileReader {

    public List<String> processInputFileAndGenerateTalkList(String filePath) {
        List<String> inputTalkList = new ArrayList<>();
        try (FileInputStream fstream = new FileInputStream(filePath);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String strLine = br.readLine();
            while (strLine != null) {
                inputTalkList.add(strLine);
                strLine = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Invalid File/ File not found :" + e.getMessage());
        }
        return inputTalkList;
    }

}
