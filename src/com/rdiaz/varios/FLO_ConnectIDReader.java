package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class FLO_ConnectIDReader {

	private static final String filename = String.format("%s\\Documents\\CurrentFloConnectIDs.csv", System.getProperty("user.home"));

	public static void main(String[] args) {
		Chronometer c = new Chronometer();
		c.start();
		readIDs();
		c.stop();
		System.out.println(c.getTime());
	}

	private static void readIDs()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			HashMap<String, String> map = new HashMap<>();
			br.readLine();

			while((line = br.readLine()) != null){
				String str[] = line.split(",");
				map.put(str[0], str[5]);
			}
			br.close();
			System.out.println(map);
			System.out.println(map.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
