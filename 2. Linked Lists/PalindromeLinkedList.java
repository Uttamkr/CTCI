/*
*2.6: Given a LinkedList, check if it is a palindrome.
*/

import java.util.*;

public class PalindromeLinkedList{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the list");
        int n = scan.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> listRev = new LinkedList<>();
        
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter the list elements");
        //Get all the elements in the list 1
        for(int i = 0; i<n; i++){
            list.add(scan.nextInt());
        }
        //add all elements to a stack
        for(int i = 0; i<list.size();i++){
            stack.push(list.get(i));
        }
        //store elements from stack(pop) to reverse the string
        while(stack.size()>0){
            listRev.add(stack.pop());
        }
        
        /*
        *One more method can be to check all the elements of linkedlist comparing them to elements popped from the stack.
        *Or we can iteratively compare each i element with size-i element but it will take O(n^2) time.
        */
        
        //compare if the strings is equal to its reverse.
        System.out.println("It is a palindrome: "+list.equals(listRev));
    }
}