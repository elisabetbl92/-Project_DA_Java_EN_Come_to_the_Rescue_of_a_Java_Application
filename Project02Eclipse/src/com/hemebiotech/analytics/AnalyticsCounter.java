package com.hemebiotech.analytics;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		SymptomProcessing processor = new SymptomProcessing("symptoms.txt", "result.out");

		processor.processSymptoms();

	}

}
