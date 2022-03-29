package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymptomProcessing {
	
	private final String input;
	private final String output;
	

	public SymptomProcessing(String input, String output) {
		this.input = input;
		this.output = output;
	}


	public void processSymptoms() {
		List<String> symptoms = new ReadSymptomDataFromFile(input).getSymptoms();
		List<String> symptomsNumber = new ArrayList<String>();
		Set<String> symptomsNotRepeat = new HashSet<String>();
		symptomsNotRepeat.addAll(symptoms);
		for (String symptom : symptomsNotRepeat) {
			symptomsNumber.add(symptom + ": " + Collections.frequency(symptoms, symptom));
		}
		Collections.sort(symptomsNumber);

		new FileSymptomWriter(output).write(symptomsNumber);

	}

}
