package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {	
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		
		List<String> symptoms = reader.getSymptoms();
		List<String> symptoms_number = new ArrayList<String>();;
		Set<String> symptoms_not_repeat = new HashSet<String>();
		symptoms_not_repeat.addAll(symptoms);
	
		
		for(String symptom: symptoms_not_repeat ) {
			symptoms_number.add(symptom + ": " +Collections.frequency(symptoms,symptom));
			
		}
		Collections.sort(symptoms_number);
		
		
		try {
		      FileWriter myWriter = new FileWriter("result.out");
		      for(String symptom: symptoms_number ) {
					System.out.println(symptom);
					myWriter.write(symptom+"\n");		
				}
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }


	}
	
}
