package com.caesarcrypto;

public class CaesarEncrypt {
	private static char[] encryptorArray = new char[26];
//	private static char[] decryptorArray = new char[26];

	public CaesarEncrypt(int rotation) {
		for (int i=0;i<26;++i) {
			encryptorArray[i] = (char) ( 'A' + (i + rotation)%26);
		}
	}
	
	public void encrypt(char[] data) {
		for (int i=0;i<data.length;++i) {
			data[i] = encryptorArray[data[i] - 'A'];
		}
		
	}
	public void decrypt(char[] data) {
		
	}
	public static void main(String... args) {
	
		CaesarEncrypt c = new CaesarEncrypt(2);
		for (char e:encryptorArray)
			System.out.print(e+"  ");
		char []data = {'A','D','I','T','Y','A'};
		c.encrypt(data);
		System.out.println("\nData After Encryption");
		for (char e:data)
			System.out.print(e+"  ");
		
	}
}
