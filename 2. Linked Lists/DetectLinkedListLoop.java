/*
* 2.8: Loop Detection: Detect if the given linkedlist has a loop.
*/

import java.util.*;

public class DetectLinkedListLoop{
    
    static boolean checkLoop(MyLinkedList list){
        // Use floyd's loop detection algorithm
        Node slow = list.head;
        Node fast = list.head;
        if(list.head == null){
            return false;
        }
        
        while(fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null)
                return false;
            if(slow==fast){
                return true;
            }
            
        }
        
        return false;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        System.out.println("Enter size of linkedlist");
        int n = scan.nextInt();
        System.out.println("Enter "+n+" elements");
        while(n!=0){
            list.add(scan.nextInt());
            n--;
        }
        //check when no loop.
        System.out.println("Check loop: "+checkLoop(list));
        System.out.println("\n*************\nCreating loop\n*************\n");
        //create loop
        list.tail.next = list.head.next.next;
        
        //Check Loop
        System.out.println("Checking loop in LinkedList: "+checkLoop(list));
    }
}