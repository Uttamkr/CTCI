/*
 * 1.4 : Check if a given string is a permutation of a palindrome
 */
import java.util.*;

public class PalindromePermutation {
    
    public static boolean checker(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        
        //add all characters to the map
        for(char temp: str.toCharArray()){
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp, 1);
            }
        }
        
        //check number of values not divisible by two ( to check if they are odd)
        int counter = 0;
        for(int temp: map.values()){
            if(temp%2 != 0){
                counter++;
            }
        }
        
        //check if it is palindrome
        if(counter<=1){
            return true;
        }
        System.out.println("The counter is: "+counter);
        return false;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string to be checked");
        System.out.println("String is a permutaion of a palindrome: "+checker(scan.nextLine()));
    }
}
