/*
 * 1.1: IsUnique : Check if string has all unique characters
 */

import java.util.*;



class Checker{
    String str;
    
    public Checker(String str){
        this.str = str;
    }

//Uses HashMap to store and check if character is being repeated. Since no chaining is allowed in HashMap here, worst acase O(N)
    public boolean check(){
        HashMap<Character,Integer> map = new HashMap<>();
        char[] charString = str.toCharArray();
        for(char temp : charString){
            if(!map.containsKey(temp))
                map.put(temp, 1);
            else{
                return true;
            }
        }
        return false;
    }
    
//Sorts the string and compares each char with next char. Worst case O(NlogN) since sorting is the bottleneck
    public boolean checkNoDS(){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        for(int i = 0; i<temp.length-1;i++){
            if(temp[i]==temp[i+1]){
                return true;
            }
        }
        return false;
    }
}

public class IsUnique {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string to be checked.");
        String str = scan.nextLine();
        
        Checker agent = new Checker(str);
        //check using a HashMap
        System.out.println("Method1: String contains duplicate characters: "+agent.check());
        
        //additional data structure not allowed
        System.out.println("Method2: String contains duplicate characters: "+agent.checkNoDS());
    }
    
}
