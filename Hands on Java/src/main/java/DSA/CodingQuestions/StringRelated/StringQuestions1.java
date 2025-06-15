package DSA.CodingQuestions.StringRelated;

import javax.xml.transform.SourceLocator;
import java.util.*;

public class StringQuestions1 {
    public static void main(String[] args) {
        reverseTheStringSentenceSeperatedBydDot("i.like.this.questions");
        checkStringRotationOfEachOther("abcd","cdab");
        firstNotRepeatingCharacterInString("Keshaw");
    }

    public static void firstNotRepeatingCharacterInString(String Word){
        
    }

    //abcd,cdab --> cdab
    public static void checkStringRotationOfEachOther(String str1, String str2) {
        int str1length = str1.length();

        String firstPart = "";
        String secondPart = "";
        for (int i = 1; i < str1length; i++) {
            firstPart = str1.substring(0,i);
            secondPart = str1.substring(i,str1length);
            if(str2.equalsIgnoreCase(secondPart.concat(firstPart))){
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    //i.like.this.questions --> questions.this.like.i
    public static void reverseTheStringSentenceSeperatedBydDot(String sentence) {

        StringBuilder resp = new StringBuilder();
        List<String> list = Arrays.asList(sentence.split("\\."));
        for (int i = list.size() - 1; i >= 0; i--) {
            resp.append(list.get(i));
            if (i != 0) {
                resp.append(".");
            }
        }
        System.out.println(resp);

    }
}
