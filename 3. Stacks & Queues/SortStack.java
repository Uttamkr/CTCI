/*
3.5: Sort a stack such that smallest element is on the top. A temporary stack may be used but do not copy contents into any other data structure.
*/

import java.util.*;

public class SortStack{
    
    static Stack<Integer> stack = new Stack<>();                    // Original stack
    static Stack<Integer> temp = new Stack<>();                     // Temporary stack to help sorting
    
    public static void sortStack(){
        int n = stack.size();
        while((n--)!=0){
            int element = stack.pop();
            int counter = 0;
            if(temp.isEmpty()){                                     // If temp stack is empty, add first element
                temp.push(element);
            }else{                                                  // Else check if the top element of array is larger than current element
                while(!temp.isEmpty() && temp.peek()>element){
                    if((temp.peek())>element){
                        stack.push(temp.pop());                     // Save temp elements on stack
                        counter++;
                    }
                }                                                   
                temp.push(element);                 
                while(counter!=0){                                  //  Restore elements from stack to the sorted array. 
                    temp.push(stack.pop());
                    counter--;
                }
            }
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
                
        System.out.println("Enter the size of the stack");
        int n = scan.nextInt();
        
        System.out.println("Enter "+n+" elements");
        while(n!=0){
            stack.push(scan.nextInt());
            n--;
        }
        
        sortStack();
        System.out.println("The sorted stack is: ");
        Stack printer = stack;
        while(!printer.isEmpty()){
            System.out.print(printer.pop()+" ");
        }
        System.out.print("\n");
    }
}