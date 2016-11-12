/*
* 2.1: Remove duplicate nodes from a LinkedList
*/

import java.util.*;

public class RemoveDups{
    
    static void remDups(LinkedList list){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                list.remove(list.get(i));
                //Decrement counter since list is shortened and next element is now at current location
                i--;
            }else{
                map.put((int)list.get(i),1);
            }
        }
        System.out.println("List after remove duplicates: "+list);
        
    }
    //No extra data structure used. Takes O(n^2) worst case
    static void remDuplicate(LinkedList list){
        for(int i = 0; i<list.size();i++){
            while(list.lastIndexOf(list.get(i))!=i){
                list.remove(list.get(list.lastIndexOf(list.get(i))));
            }
        }
        
        System.out.println("The new list is: "+ list);
    }
    
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of items");
        int n = scan.nextInt();
        for(int i = 0; i< n; i++){
            list.add(scan.nextInt());
        }
        
        remDups(list); // users hashmap to perform in O(n) time
        remDuplicate(list); // no extra data structure used. Worst case O(n^2) time
    }
}