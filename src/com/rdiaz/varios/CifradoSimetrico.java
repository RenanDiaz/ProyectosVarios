package com.ts.configuracion;

public class CifradoSimetrico {

	static String keys = "renan.diaz";

	public static void main(String[] args)
	{
		String mensaje = "Trata de descifrar este mensaje.";
		String mensajeCifrado = cifrar(mensaje);
		System.out.println(mensajeCifrado);
		String descifrada = descifrar(mensajeCifrado);
		System.out.println(descifrada);
	}

	static String cifrar(String codes)
	{
		StringBuilder result = new StringBuilder();

		char[] codeList = codes.toCharArray();
		char[] keyList  = keys.toCharArray();

		int maxCount = keys.length();
		System.out.println("The length is " + maxCount);
		System.out.println("char  key  new char new");
		int i = 0;

		for (Character code : codeList) {

			int key = Character.getNumericValue(keyList[i]);
			int res = key % 2 == 0 ? code + key : code - key;

			result.append((char)res);
			String oper = key % 2 == 0 ? "+" : "-";
			System.out.println(String.format("%3d %s %2d = %3d\t%c %s %c = %c", (int)code, oper, key, res, code, oper, keyList[i], (char)res));
			i++;
			if(i==maxCount)
			{
				i = 0;
			}
		}
		return result.toString();
	}

	static String descifrar(String codes)
	{
		StringBuilder result = new StringBuilder();

		char[] codeList = codes.toCharArray();
		char[] keyList  = keys.toCharArray();

		int maxCount = keys.length();
		System.out.println("The length is " + maxCount);
		int i = 0;

		for (Character code : codeList) {

			int key = Character.getNumericValue(keyList[i]);

			if(key % 2 == 0)
			{
				int res = code - key;
				result.append((char)res);
			}
			else
			{
				int res = code + key;
				result.append((char)res);
			}
			i++;
			if(i == maxCount)
			{
				i = 0;
			}
		}
		return result.toString();
	}
}
