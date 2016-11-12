/*
* 2.7: Given two linkedLists, determine if they intersect. return the intersecting node
*/

import java.util.*;

public class LinkedListIntersection{
    
    static String checkIntersection(MyLinkedList list1, MyLinkedList list2){
        String ret="";
        MyLinkedList longer = new MyLinkedList();
        MyLinkedList shorter = new MyLinkedList();
        if(list1.tail != list2.tail){
            ret+="False";
            return ret;
        }
        int diff = list1.getSize()-list2.getSize();
        if(Math.abs(diff)>0){
            if(diff>0){
                longer = list1;
                shorter = list2;
            }else{
                longer = list2;
                shorter = list1;
            }
            //shorten the longer list
            while(diff!=0){
                longer.head = longer.head.next;
            }
        }
        
        //Now that the lists are of same length, traverse them until the common node is found
        while(longer!=shorter){
            longer.head = longer.head.next;
            shorter.head = shorter.head.next;
        }
        ret+=" at node "+longer.head.value;
        
        return ret;
    }
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        MyLinkedList list1 = new MyLinkedList();
        System.out.println("Enter the size of the first list.");
        int n = scan.nextInt();
        System.out.println("Enter "+n+" elements:");
        while(n!=0){
            list1.add(scan.nextInt());
            n--;
        }
        
        MyLinkedList list2 = new MyLinkedList();
        System.out.println("Enter the size of the second list.");
        n = scan.nextInt();
        System.out.println("Enter "+n+" elements:");
        while(n!=0){
            list2.add(scan.nextInt());
            n--;
        }
        
        System.out.println("The lists collide: "+checkIntersection(list1,list2));
    }
}