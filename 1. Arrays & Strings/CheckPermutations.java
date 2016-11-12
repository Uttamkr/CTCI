/*
 * 1.2: Check if a string is a permutation of the other
 */

import java.util.*;

class PermChecker{
    String str1,str2;
    
    public PermChecker(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    //Sorts the strings then compares if they are same
    public boolean check(){
        if(str1.length() != str2.length()){
            return false;
        }
        
        //Sort the strings
        char[] temp1 = str1.toCharArray();
        Arrays.sort(temp1);
        char[] temp2 = str2.toCharArray();
        Arrays.sort(temp2);
        
        str1 = String.valueOf(temp1);
        str2 = String.valueOf(temp2);
        
        return str1.equals(str2);
    }
}

public class CheckPermutations {
    
    public static void main(String[] args){
        String str1,str2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1st string");
        str1 = scan.nextLine();
        System.out.println("Enter 2nd string");
        str2 = scan.nextLine();
        PermChecker agent = new PermChecker(str1,str2);
        System.out.println("Method1: isPermutation: "+agent.check());
    }
    
    
}
