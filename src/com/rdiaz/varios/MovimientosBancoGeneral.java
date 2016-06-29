package com.rdiaz.varios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MovimientosBancoGeneral {
    private static final String patronDelNombre = String.format("%s\\Dropbox\\Documents\\Archivos\\Movimientos {tipo} {fechaInicial} {fechaFinal}.txt", System.getProperty("user.home"));

    public static void main(String[] args) {
        Chronometer c = new Chronometer();
        c.start();
        String cuenta = "Banco";
        if("Banco".equals(cuenta))
            leerArchivo("Banco", 2014, 2016);
        else if("Tarjeta".equals(cuenta))
            leerArchivo("Tarjeta", 2015, 2016);
        else
            leerArchivoOtero();
        c.stop();
        System.out.printf("%dms%n", c.getTime());
    }

    private static void leerArchivo(String tipo, int fechaInicial, int fechaFinal) {
        try {
            String nombreDelArchivo = patronDelNombre.replace("{tipo}", tipo).replace("{fechaInicial}", String.valueOf(fechaInicial)).replace("{fechaFinal}", String.valueOf(fechaFinal));
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String linea;
            int contador = 0;

            while((linea = br.readLine()) != null){
                String arreglo[] = linea.split(";");
                for(String string : arreglo) System.out.print(string + "\t");
                System.out.println();
                contador++;
            }
            System.out.println("Cuenta: " + contador);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerArchivoOtero() {
        try {
            String nombreDelArchivo = patronDelNombre.replace("{tipo}", "Banco").replace("{fechaInicial}", "2014").replace("{fechaFinal}", "2016");
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String linea;
            boolean esLaPrimeraLinea = true;

            while((linea = br.readLine()) != null){
                String arreglo[] = linea.split(";");
                if("ACH - VENTAS Y MERCADE".equals(arreglo[3]) || arreglo[3].indexOf("0430019695096") > 0 || esLaPrimeraLinea) {
                    for(String string : arreglo) System.out.print(string + "\t");
                    System.out.println();
                }
                esLaPrimeraLinea = false;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
