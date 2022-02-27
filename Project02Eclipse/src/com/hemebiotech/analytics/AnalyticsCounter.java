package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {	
	
	public static void main(String args[]) throws Exception {
		
		//Read
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.getSymptoms();
		
		//Process
		List<String> symptoms_number = new ArrayList<String>();;
		Set<String> symptoms_not_repeat = new HashSet<String>();
		symptoms_not_repeat.addAll(symptoms);
		for(String symptom: symptoms_not_repeat ) {
			symptoms_number.add(symptom + ": " +Collections.frequency(symptoms,symptom));	
		}
		Collections.sort(symptoms_number);
		
		new FileSymtomWriter("result.out").write(symptoms_number);


	}
	
}
