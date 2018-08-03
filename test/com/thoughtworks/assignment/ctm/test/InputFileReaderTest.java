package com.thoughtworks.assignment.ctm.test;

import static org.junit.Assert.assertEquals;

import com.thoughtworks.assignment.ctm.InputFileReader;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class InputFileReaderTest {

	@Test
	public void canProcessInputFileAndGetTalkList() {
		InputFileReader reader =  new InputFileReader();
		String filePath = "input";
		List<String> actualList = reader.processInputFileAndGenerateTalkList(filePath);
		List<String> expectedList =  new ArrayList<String>();
		expectedList.add("Writing Fast Tests Against Enterprise Rails 60min");
		assertEquals(expectedList.get(0), actualList.get(0));
	}

}
