/*
*3.3: Implement a list of stacks where each stack has a size limit. If it is full, the next item passes onto a new stack.
        * Also, if an item has to be eliminated from a previous stack, it should be maintained accordingly.
*/

import java.util.*;

class ListOfStacks{
    //List of stacks
    ArrayList<Stacks> list = new ArrayList();
    //current stack in use
    int current=0;
    //Capacity of an individual stack
    int capacity;
    
    //extend stack class to hold a top value for each stack
    class Stacks extends Stack{
        //Current top value for each stack
        int top;
        
        public Stacks(){
            top = 0;
        }
    }
 
    public void push(int value){
        Stacks temp = new Stacks();
        
        if(list.isEmpty()){                                 // if it is the first stack in the list
            temp.push(value);
            list.add(temp);
            
        }else if(list.get(current).top>=capacity-1){        // if current stack is full, create a new stack
            temp.push(value);
            list.add(temp);
            current++;
        }            
        else{                                               // else add the value to the current stack
            list.get(current).push(value);        
            list.get(current).top++;
        }
    }
    
    public int pop(){
        int ret = (int)list.get(current).pop();
        if(list.get(current).empty()){                      // if removing the element makes current stack empty, last stack becomes current stack
            list.remove(current);
            current--;
        }
        return ret;
    }
    
    public int popFromIndex(int index){                     // Remove top element from a given stack
        int ret = (int)list.get(index).pop();
        if(list.get(index).empty()){
            list.remove(index);
        }
        return ret;
    }
    
    public void display(){                                  // Display contents of all stacks the list
        int counter = 1;
        for(Stacks temp: list){
            System.out.println("Stack "+ (counter++)+": "+temp);
        }
    }
}

public class StackOfPlates{
    public static void main(String[] args){
        ListOfStacks myStack = new ListOfStacks();
        System.out.println("Enter the capacity of individual Stacks:");
        Scanner scan = new Scanner(System.in);
        myStack.capacity = scan.nextInt();
        System.out.println("Enter number of elements to be entered");
        int n = scan.nextInt();
        System.out.println("Enter "+n+" elements");
        while((n--)!=0)
            myStack.push(scan.nextInt());
        
        myStack.pop();
        myStack.popFromIndex(1);
        myStack.popFromIndex(1);
        myStack.display();
    }
}