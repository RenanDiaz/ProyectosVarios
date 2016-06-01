package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MovimientosBancoGeneral {
	static String actualFile = "C:\\Users\\rdiaz\\Dropbox\\Archivos\\Movimientos Banco 2014 2016.txt";

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
			String line;
			boolean isFirst = true;

			while((line = br.readLine()) != null){
				String str[] = line.split(";");
				if("ACH - VENTAS Y MERCADE".equals(str[3]) || str[3].indexOf("0430019695096") > 0 || isFirst) {
					for(String string : str) {
						System.out.print(string + "\t");
					}
					System.out.println();
				}
				isFirst = false;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
