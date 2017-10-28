import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		System.out.println("To encrypt pres 'e' , to decrypt press 'd'");
		Scanner s = new Scanner(System.in);
		String c = s.next();
		if (c.equals("e")) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your text without spaces - eg 'nikos kon' - \n where 'nikos' is the text you want to encrypt and 'kon' is your key word ");
			String str = in.next();
			str = str.toLowerCase();
			String key = in.next();
			key = key.toLowerCase();
			System.out.println("encrypted is : " + encrypt(str, key));
		}
		else if (c.equals("d")) {
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter your text without spaces - eg 'nikos kon' - \n where 'xwxyg' is the text you want to decrypt and 'kon' is your key word ");
			String str = in.next();
			str = str.toLowerCase();
			String key = in.next();
			key = key.toLowerCase();
			System.out.println("decrypted is : " + decrypt(str, key));
		}
		else 
			System.out.println( "'" +c +"'" +" is not what i expected...");
	}
	
	public static String decrypt(String str, String key) {
		String decrypted = "";
		for (int i = 0; i < str.length(); i++) {
			char cStr = str.charAt(i);
			char cKey = key.charAt(i%key.length());
			int indexStr = cStr - 'a';
			int indexKey = cKey - 'a';
			int n = indexStr - indexKey;
			if (n < 0) {
				n = n + 26;
			}
			int x = n + 'a';
			String ch = Character.toString((char) x);
			decrypted += ch;
		}
		return decrypted;
	}
	
	public static String encrypt(String str, String key) {
		String encrypted = "";
		for (int i = 0; i < str.length(); i++) {
			char cStr = str.charAt(i);
			char cKey = key.charAt(i%key.length());
			int indexStr = cStr - 'a';
			int indexKey = cKey - 'a';
			int x = (indexStr + indexKey)%26 + 'a';
			String ch = Character.toString((char) x);
			encrypted += ch;
		}
		return encrypted;
	}

}