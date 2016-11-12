/*
 * 1.6: Compress the string and add number of iterations of the character after each character
 *      if length of string doesn't change after compression, return the original string
 */

/**
 *
 * @author Uttam Kumar
 */

import java.util.*;
import java.util.Map.Entry;

public class StringCompress {
    
    public static String compress(String str){
        StringBuilder ret = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char temp:str.toCharArray()){
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }
            else{
                map.put(temp,1);
            }
        }
        for (Entry<Character,Integer> entry : map.entrySet()) {
            ret = ret.append(entry.getKey().toString()).append(entry.getValue().toString());
        }
        
        return (ret.toString().length()<str.length())?ret.toString():str;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string to be compressed");
        String inp = scan.nextLine();
        System.out.println("Compressed string is: "+compress(inp));
    }
}
