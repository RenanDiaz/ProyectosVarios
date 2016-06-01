package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MovimientosBAC {
    static String patronDelNombre = "C:\\Users\\rdiaz\\Downloads\\BAC{tipo}\\BAC {fecha}.csv";
    static String[] fechas = {"201407", "201408", "201409", "201410", "201411", "201412", "201501", "201502", "201503", "201504", "201505", "201506", "201507", "201508", "201509", "201510", "201511", "201512", "201601", "201602", "201603", "201604", "201605"};

    public static void main(String[] args) {
        Chronometer c = new Chronometer();
        c.start();
//        cargar("MC");
        cargar("V", 201506);
        c.stop();
        System.out.println(c.getTime());
    }

    public static void cargar(String tipo)
    {
        for(String date : fechas) {
            String nombreDelArchivo = patronDelNombre.replace("{fecha}", date).replace("{tipo}", tipo);
            leerArchivo(nombreDelArchivo);
        }
    }

    public static void cargar(String tipo, int fechaInicial)
    {
        for(String date : fechas) {
            int fechaNumerica = Integer.parseInt(date);
            if(fechaNumerica > fechaInicial) {
                String nombreDelArchivo = patronDelNombre.replace("{fecha}", date).replace("{tipo}", tipo);
                leerArchivo(nombreDelArchivo);
            }
        }
    }

    public static void leerArchivo(String nombreDelArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String linea = nombreDelArchivo.substring(nombreDelArchivo.lastIndexOf("\\") + 5, nombreDelArchivo.lastIndexOf('.'));
            System.out.println(linea);

            while((linea = br.readLine()) != null){
                String arreglo[] = linea.split(",");
                for(String campo : arreglo) System.out.print(campo + "\t");
                System.out.println();
            }
            System.out.println();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
