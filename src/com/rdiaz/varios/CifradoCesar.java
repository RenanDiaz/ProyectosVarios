package com.rdiaz.varios;

import java.util.ArrayList;

class CifradoCesar
{
	private static final String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	private static final ArrayList<String> abecedario = new ArrayList<>();

	public static void main(String[] args) {
		llenarArrayList();
		String mensaje = "Este es un mensaje encriptado en clave cesar ROT nueve";
		String cifrada = cifrar(mensaje, 9);
		System.out.println(cifrada);
		String descifrada = descifrar(cifrada, 9);
		System.out.println(descifrada);
	}

	private static void llenarArrayList() {
		for(char caracter : abc.toCharArray())
		{
			String letra = "" + caracter;
			abecedario.add(letra);
		}
	}

	private static String cifrar(String palabra, int rot)
	{
		String palabraCifrada = "";
		for(char caracter : palabra.toUpperCase().toCharArray())
		{
			String letra = "" + caracter;
			if(" ".equals(letra))
			{
				palabraCifrada += letra;
				continue;
			}
			int posicion = abecedario.indexOf(letra);
			int nuevaPosicion = (posicion + rot) % abecedario.size();
			String letraCifrada = abecedario.get(nuevaPosicion);
			palabraCifrada += letraCifrada;
		}
		return palabraCifrada;
	}

	private static String descifrar(String palabra, int rot)
	{
		String palabraDescifrada = "";
		for(char caracter : palabra.toUpperCase().toCharArray())
		{
			String letra = "" + caracter;
			if(" ".equals(letra))
			{
				palabraDescifrada += letra;
				continue;
			}
			int posicion = abecedario.indexOf(letra);
			int nuevaPosicion = posicion - rot;
			if(nuevaPosicion < 0) nuevaPosicion += abecedario.size();
			String letraDescifrada = abecedario.get(nuevaPosicion);
			palabraDescifrada += letraDescifrada;
		}
		return palabraDescifrada;
	}
}
