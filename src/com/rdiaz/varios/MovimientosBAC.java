package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MovimientosBAC {
    static String filePattern = "C:\\Users\\rdiaz\\Downloads\\BAC{type}\\BAC {date}.csv";
    static String[] dates = {"201407", "201408", "201409", "201410", "201411", "201412", "201501", "201502", "201503", "201504", "201505", "201506", "201507", "201508", "201509", "201510", "201511", "201512", "201601", "201602", "201603", "201604", "201605"};

    public static void main(String[] args) {
        Chronometer c = new Chronometer();
        c.start();
        readIDs();
        readIDs(201506);
        c.stop();
        System.out.println(c.getTime());
    }

    public static void readIDs()
    {
        try {
            for(String date : dates) {
                String actualFile = filePattern.replace("{date}", date).replace("{type}", "MC");
                BufferedReader br = new BufferedReader(new FileReader(actualFile));
                String line;

                while((line = br.readLine()) != null){
                    String str[] = line.split(",");
                    for(String string : str) System.out.print(string + "\t");
                    System.out.println();
                }
                System.out.println();
                br.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readIDs(int fechaInicial)
    {
        try {
            for(String date : dates) {
                int id = Integer.parseInt(date);
                if(id > fechaInicial) {
                    String actualFile = filePattern.replace("{date}", date).replace("{type}", "V");
                    BufferedReader br = new BufferedReader(new FileReader(actualFile));
                    String line;

                    while((line = br.readLine()) != null){
                        String str[] = line.split(",");
                        for(String string : str) System.out.print(string + "\t");
                        System.out.println();
                    }
                    System.out.println();
                    br.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
