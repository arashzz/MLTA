package com.example.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.entities.Website;

public class CsvParser {
	public static List<String[]> parse(String path, String delimiter) {
		String line = "";
		List<String[]> dataArray = new ArrayList<>();
		BufferedReader br;
		Pattern pattern = Pattern.compile(Pattern.quote(delimiter));
		try {
			br = new BufferedReader(new FileReader(path));
			int counter = 0;
			while ((line = br.readLine()) != null) {
				if(counter++ != 0) {
					String[] data = pattern.split(line);
					dataArray.add(data);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataArray;
	}
}
