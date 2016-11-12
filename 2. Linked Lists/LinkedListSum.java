/*
 * 2.5: Find sum of two numbers where each node contains  a single digit
 */

/**
 *
 * @author Uttam Kumar
 */

import java.util.*;

public class LinkedListSum {
    
    static int listToNumber(MyLinkedList myList){
        int number = 0;
        MyLinkedList temp = myList;
        int n = myList.getSize();
        for(int i = 0; i<n;i++){
            number+=Math.pow(10,i)*temp.head.value;
            temp.head = temp.head.next;
        }
        return number;
    }
    
    static MyLinkedList numberToList(int num){
        MyLinkedList list = new MyLinkedList();
        
        while(num!=0){
            list.add(num%10);
            num/=10;
        }
        
        return list;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        System.out.println("Enter the first number");
        list1 = numberToList(scan.nextInt());
        System.out.println("List1: "+list1.toString());
        System.out.println("Enter the second number");
        list2 = numberToList(scan.nextInt());
        
        int sum = listToNumber(list1)+listToNumber(list2);
        System.out.println("Sum in list is: "+numberToList(sum).toString());
    }
}
