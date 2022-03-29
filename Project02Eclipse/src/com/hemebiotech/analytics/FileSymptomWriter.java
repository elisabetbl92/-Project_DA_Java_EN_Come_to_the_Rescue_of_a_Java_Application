package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSymptomWriter implements ISymptomWriter {
	private final String filename;

	public FileSymptomWriter(String filename) {
		this.filename = filename;
	}

	@Override
	public void write(List<String> symptoms) {
		try {
			FileWriter writer = new FileWriter(filename);
			for (String symptom : symptoms) {
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
