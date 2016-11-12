/*
*3.2: StackMin: Implement a stack which has functions push,pop and min which operate in O(1) time
*/

import java.util.*;

class MyStack{
    ArrayList<Integer> arr = new ArrayList<>();
    int top;
    int min;
    HashMap<Integer,Integer> minStore = new HashMap<>();
    
    public MyStack(){
        this.top = -1;
        min = 1000;
    }
    
    public void push(int value){
        
        arr.add(++top,value);
        if(value <min){
            min = value;
        }
        minStore.put(top,min);
        
    }
    
    public int pop(){
        if(top==-1)
            return -1;
        int ret = arr.get(--top);
        arr.remove(top);
        return ret;
    }
    
    public int min(){
        if(top==-1)
            return -1;
        if(minStore.containsKey(top))
            return minStore.get(top);
        else return -1;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while(i<arr.size())
            ret.append(arr.get(i++));
        return ret.toString();
    }
}

public class StackWithMin{

    public static void main(String[] args){
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        System.out.println("Current minima: "+stack.min());
        stack.push(15);
        stack.push(7);
        stack.push(5);
        System.out.println("Current minima: "+stack.min());
        stack.pop();
        System.out.println("Current minima: "+stack.min());
        
    }
}