package encryption;

import java.math.BigInteger;

public class Vars {
	private static char[] list= {'.',' ',',','?','!','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0',
			'\'','/','@','&','(',')','[',']','{','}',':',';','<','>','`','~','#','$','%','^','*','-','_','+','=','\\','|','"','"'};
	
	public static char[] getList() {
		return list;
	}
	
	public BigInteger sum(BigInteger input) {
		BigInteger finalSum = BigInteger.valueOf(0);
		String digits = input.toString();
		
		for (int i = 0; i < digits.length(); i++) {
			int digit = Character.getNumericValue(digits.charAt(i));
			finalSum = finalSum.add(BigInteger.valueOf(digit));
		}
		
		return finalSum;
	}
}
