/*
 * 1.5: Check if string is one edit away from one string. Edit includes add, remove or replace character
 */

/**
 *
 * @author Uttam Kumar
 */

import java.util.Scanner;

public class OneAway {
    
    public static boolean check(String str1, String str2){
        int i = 0; 
        int j = 0;
        int counter = 0;
        //assign longer(if) to string to s1 and smaller to s2
        String s1 = (str1.length()>=str2.length())?str1:str2;
        String s2 = (str1.length()>=str2.length())?str2:str1;
        
        //if difference in length is more than one, it cannot be one off
        if(Math.abs(s1.length()-s2.length())>1){
            return false;
        }
        
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                counter++;
                if(s1.length()==s2.length()){
                    i++;
                }
            }else{
                i++;
            }
            j++;
        }
        return (counter<=1);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = scan.nextLine();
        System.out.println("Enter the second string");
        String str2 = scan.nextLine();
        
        System.out.println("Strings are one-away: "+check(str1,str2));
    }
}
