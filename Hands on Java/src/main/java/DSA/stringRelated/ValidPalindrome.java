package DSA.stringRelated;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}
	
	public static boolean isPalindrome(String s) {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char temp = s.toLowerCase().charAt(i);
			if (temp >= 97 && temp <= 122) {
				str.append(temp);
			}
			System.out.println(str);
		}
		if(str.isEmpty()) {
			return true;
		}
		StringBuilder reverse = new StringBuilder(str).reverse();
		System.out.println(reverse);
        return str.toString().equalsIgnoreCase(reverse.toString());
    }
}
