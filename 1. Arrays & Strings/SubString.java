/*
*1.9: isSubString: Given two strings s1 and s2, check if s2 is a rotation of s1 using only one call to the method
*/

import java.util.*;

public class SubString{
    
    static boolean check(String s1, String s2){
        s2 = s2+s2;
        return (s2.indexOf(s1)<0)?false:true;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter string 1:\n");
        String s1 = scan.nextLine();
        System.out.println("Enter string 2");
        String s2 = scan.nextLine();
        
        //check 
        System.out.println("The string s2 is a substring(rotation) of string s1: "+check(s1,s2));
    }
} 