import java.util.Scanner;
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	Scanner input = new Scanner(System.in);

	public static boolean stringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}

		public static String encryptCaesar(String plainText, int key) {
		String encrypted = "";
		char ch;
		for (int i = 0; i < plainText.length(); i++) {
			ch = (char) ((plainText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
			encrypted += ch;
		}
		return encrypted;
	}
	
		public static String encryptBellaso(String plainText, String bellasoStr) {
		String encrypted = "";
		char ch;
		for (int i = 0; i < plainText.length(); i++) {
			ch = (char) ((plainText.charAt(i) + bellasoStr.charAt(i % bellasoStr.length()) - LOWER_BOUND) % RANGE + LOWER_BOUND);
			encrypted += ch;
		}
		return encrypted;
	}
	
	public static String decryptCaesar(String encryptedText, int key) {
		key = RANGE - key;
		
		String encrypted = "";
		char ch;
		for (int i = 0; i < encryptedText.length(); i++) {
			ch = (char) ((encryptedText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
			encrypted += ch;
		}
		return encrypted;
	}
	
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		int key;
		
		String encrypted = " ";
		char ch;
		for (int i = 0; i < encryptedText.length(); i++) {
			key = RANGE - (bellasoStr.charAt(i % bellasoStr.length()) % RANGE);
			ch = (char) ((encryptedText.charAt(i) + key - LOWER_BOUND) % RANGE + LOWER_BOUND);
			encrypted += ch;
		}
		return encrypted;
	}
}
