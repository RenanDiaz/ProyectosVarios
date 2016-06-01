package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FLO_ConnectIDReader {
	
	static String testFile = "C:\\Users\\Renan.Diaz\\Documents\\csv_sample_file.txt";
	static String actualFile = "C:\\Users\\rdiaz\\Documents\\CurrentFloConnectIDs.csv";

	public static void main(String[] args) {
		Chronometer c = new Chronometer();
		c.start();
		readIDs();
		c.stop();
		System.out.println(c.getTime());
	}

	public static void readIDs()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(actualFile));
			String line = null;
			HashMap<String, String> map = new HashMap<String, String>();
			br.readLine();

			while((line = br.readLine()) != null){
				String str[] = line.split(",");
				map.put(str[0], str[5]);
			}
			br.close();
//			System.out.println(map);
//			System.out.println(map.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
