package br.com.mafeed.mafeed.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileManager {
	
	public static String openToStr(String path) {
		File arq = new File(path);
		String str = "";
		if(arq.exists()) { 
			try {
				BufferedReader r = new BufferedReader(new FileReader(arq));
				String text = null;
				while ((text = r.readLine()) != null) {
			        str += " " + text;
			    }
				r.close();
				return str;
			} catch(Exception ex) {
				return str;
			}
		} else {
			return str;
		}
	}
}
