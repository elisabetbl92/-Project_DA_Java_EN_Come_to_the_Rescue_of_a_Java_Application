package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSymptomWriter implements ISymptomWriter {
	private final String filename;

	public FileSymptomWriter(String filename) {
		this.filename = filename;
	}

//SRP(Single Responsability Principle)
	@Override
	public void write(List<String> symptoms) {
		try {
			FileWriter writer = new FileWriter(filename);
			for (String symptom : symptoms) {
				// System.out.println(symptom);
				writer.write(symptom + "\n");
			}

			writer.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
