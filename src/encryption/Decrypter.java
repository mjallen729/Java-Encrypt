package encryption;

import java.util.List;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Decrypter {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Vars var = new Vars();
		BigInteger inkey = BigInteger.valueOf(0);
		BigInteger outkey = BigInteger.valueOf(0);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input message to be decrypted:");
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
			List<String> messA = Arrays.asList(message.split("\\s*,\\s*"));
			BigInteger[] mess = new BigInteger[messA.size()];
			String output = "";
			
			for (int i = 0; i < messA.size(); i++) {
				mess [i] = new BigInteger(messA.get(i));
			}
			
			for (int i = 0; i < mess.length; i++) {
				mess[i] = mess[i].divide(inkey.multiply(outkey));
				mess[i] = mess[i].subtract(inkey);
				try {
					char append = var.getList()[mess[i].intValue()];
					output += append;
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}
			}
			
			System.out.println(output);
		}
		
		if (BigInteger.valueOf(decide).compareTo(sum) > 0) { //out_key added because decide is greater than sum
			List<String> messA = Arrays.asList(message.split("\\s*,\\s*"));
			BigInteger[] mess = new BigInteger[messA.size()];
			String output = "";
			
			for (int i = 0; i < messA.size(); i++) {
				mess [i] = new BigInteger(messA.get(i));
			}
			
			for (int i = 0; i < mess.length; i++) {
				mess[i] = mess[i].divide(inkey.multiply(outkey));
				mess[i] = mess[i].subtract(outkey);
				try {
					char append = var.getList()[mess[i].intValue()];
					output += append;
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}
			}
			
			System.out.println(output);
		}
	}
}
