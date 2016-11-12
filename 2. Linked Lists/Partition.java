/*
* 2.4: Partition: Given a value x, partition the linkedlist such that all elements that are less than x come before elements equal or greater than x
*/

import java.util.*;

public class Partition{
    
    static void partition(LinkedList list,int x){
        for(int i = 0; i<list.size();i++){
            if((int)list.get(i)<x){
                Object temp = list.get(i);
                list.remove(list.get(i));
                list.addFirst(temp);
            }
        }
        System.out.print("The partitioned list is: ");
        for(int i = 0; i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> list  = new LinkedList<>();
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();
        System.out.println("Enter "+n+" elements: ");
        for(int i =0; i<n;i++){
            list.add(scan.nextInt());
        }
        
        System.out.println("Enter the partition element.");
        int x = scan.nextInt();
        
        partition(list,x);
    }
}