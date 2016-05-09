package com.example.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static void deleteFile(String path) {
		File file = new File(path);
		if(file.exists()) {
			file.delete();
		}
	}
	
	public static String saveFile(MultipartFile file) {
		String mimeType = file.getContentType();
        String filename = file.getOriginalFilename();
        FileOutputStream fos;
		try {
	        byte[] bytes = file.getBytes();
			fos = new FileOutputStream(filename);
	        fos.write(bytes);
	        fos.close();
		} catch (FileNotFoundException e) {
			filename = "";
			e.printStackTrace();
		} catch (IOException e) {
			filename = "";
			e.printStackTrace();
		}
		return filename;
	}
}
