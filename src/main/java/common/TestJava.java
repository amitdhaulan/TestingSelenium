package common;

import java.util.Arrays;

public class TestJava {
    public static void main(String... args) {
        /*String str1 = "123456789";
        String str2 = "123456789 , amitsdfjhdskjh sdfjhsdkjfh ljsdhfkjdhsf ";
        String str = str2.substring(0,str1.length()+1);
        System.out.println(str);*/

        System.out.println("----------------------------------------");
        String string1 = "       This is test string1!";
        String string2 = "This is test string2!               ";

        System.out.println(string1);
        System.out.println(string2);
        System.out.println();

        System.out.println("------------ After trimming ------------");

        System.out.println(string1.trim());
        System.out.println(string2.trim());
        System.out.println("----------------------------------------");
    }
}
