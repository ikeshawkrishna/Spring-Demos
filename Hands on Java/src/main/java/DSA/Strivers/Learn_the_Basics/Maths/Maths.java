package DSA.Strivers.Learn_the_Basics.Maths;

import com.sun.source.tree.ReturnTree;

public class Maths {
    public static void main(String[] args) {
        System.out.println(countDigit(24));
        System.out.println(reverseNumber(1234));
        System.out.println(checkPalindrome("keshaahsek"));
        System.out.println(armstrongNumber(153));
    }

    static int countDigit(int number){
        return  String.valueOf(number).length();
    }

    static int reverseNumber(int number){//1234
        //Approach 1
//        int result = 0;
//        while(number != 0){
//            int rem = number % 10;
//            result = (result * 10) + rem;
//            number = number / 10;
//        }
//        return result;

        //Approach 2
        String resultStr = new StringBuilder(String.valueOf(number)).reverse().toString();
        return  Integer.parseInt(resultStr);
    }

    static boolean checkPalindrome(String value){
        //Approach 1
//        int size = value.length()-1;
//        for(int i = 0; i < size/2; i++){
//            if(value.charAt(i) != value.charAt(size-i)){
//                return false;
//            }
//        }
//        return true;

        //Approach 2
        return value.equalsIgnoreCase(new StringBuilder(value).reverse().toString()) ? true : false;
    }

    static boolean armstrongNumber(int number){
        int length = String.valueOf(number).length();
        int temp = number;
        int result = 0;
        while (number != 0){
            int rem = number % 10;
            result = result + (int) Math.pow(rem,length);
            number = number / 10;
        }
        return temp == result ? true : false;
    }

}
