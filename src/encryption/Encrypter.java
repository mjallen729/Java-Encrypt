package encryption;

import java.math.BigInteger;
import java.util.Scanner;

public class Encrypter {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		Vars var = new Vars();
		BigInteger inkey = BigInteger.valueOf(0);
		BigInteger outkey = BigInteger.valueOf(0);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input message to be encrypted:");
		String message = scan.nextLine();
		
		System.out.print("Input sender's in_key: ");
		inkey = scan.nextBigInteger();
		
		System.out.print("Input receiver's in_key (out_key): ");
		outkey = scan.nextBigInteger();
		
		System.out.print("Input deciding number: ");
		int decide = scan.nextInt();
		scan.close();
		
		BigInteger baseSum = (inkey.add(outkey));
		BigInteger sum = var.sum(baseSum);
		
		if (BigInteger.valueOf(decide).compareTo(sum) <= 0) { //in_key added because decide is less than sum
			char[] mess = message.toCharArray();
			BigInteger[] crypt = new BigInteger[mess.length];
			
			for (int i = 0; i < mess.length; i++) {
				for (int r = 0; r < var.getList().length; r++) {
					if (mess[i] == var.getList()[r]) {
						crypt[i] = BigInteger.valueOf(r);
						crypt[i] = crypt[i].add(inkey);
						crypt[i] = crypt[i].multiply(inkey);
						crypt[i] = crypt[i].multiply(outkey);
						System.out.print(crypt[i] + ",");
					}
				}
			}
		}
		
		if (BigInteger.valueOf(decide).compareTo(sum) > 0) { //out_key added because decide is greater than sum
			char[] mess = message.toCharArray();
			BigInteger[] crypt = new BigInteger[mess.length];
			
			for (int i = 0; i < mess.length; i++) {
				for (int r = 0; r < var.getList().length; r++) {
					if (mess[i] == var.getList()[r]) {
						crypt[i] = BigInteger.valueOf(r);
						crypt[i] = crypt[i].add(outkey);
						crypt[i] = crypt[i].multiply(inkey);
						crypt[i] = crypt[i].multiply(outkey);
						System.out.print(crypt[i] + ",");
					}
				}
			}
		}
	}
}
