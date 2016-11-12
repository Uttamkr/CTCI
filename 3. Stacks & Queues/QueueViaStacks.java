/*
*3.4: Queue Via Stacks: Implement a queue using two stacks
*/

import java.util.*;

class Qstack{
    Stack stackNew = new Stack();                       // To store elements in enqueue
    Stack stackOld = new Stack();                       // To store reverse of first stack for dequeue
    
    public void shiftStacks(){                          //To allow using only half memory at a time
        if(stackOld.isEmpty()){
            while(!stackNew.isEmpty()){
                stackOld.push(stackNew.pop());
            }
        }else{
            while(!stackOld.isEmpty()){
                stackNew.push(stackOld.pop());
            }
        }
    }
    
    public void enQ(int value){                         // To add elements to the queue
        if(!stackOld.isEmpty()){
            shiftStacks();
        }
        stackNew.push(value);
    }
    
    public int deQ(){                                   // To remove elements from the queue
        if(this.size()==0){
            return -1;
        }
        if(stackOld.isEmpty()){
            shiftStacks();
        }
        return (int)stackOld.pop();
        
    }
    
    public int size(){
        return stackNew.size()+stackOld.size();
    }
}

public class QueueViaStacks{
    public static void main(String[] args){
        Qstack myQ = new Qstack();
        System.out.println("Enter the number of elements to be entered");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Now enter "+n+" elements");
        while((n--)!=0){
            myQ.enQ(new Scanner(System.in).nextInt());
        }
        myQ.deQ();
        System.out.println("Stack New: "+myQ.stackNew+"\nStack Old: "+myQ.stackOld);
    }
}