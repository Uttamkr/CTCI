/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Uttam Kumar
 */
 class Node {
        Node next = null;
        int value;
        
        public Node(){
            this.value = 0;
            this.next = null;
        }
        
        public Node(int data){
            this.value = data;
            this.next = null;
        }
    }
    


public class MyLinkedList {
    Node head;
    Node tail;
    
   
    
    
    //add value at the end
    public void add(int data){
        if(head==null){
            head = new Node(data);
            tail = head;
        }else{
            Node temp = new Node(data);
            tail.next = temp;
            tail = temp;
        }
    }
    
    public void addAfter(int data,int value){
        Node temp = head;
        while(temp.next!=null && temp.value != data){
            temp = temp.next;
        }
        if(temp.next==null){
            System.out.println("Error. Value not found.");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        
    }
    
    public void remove(int data){
        Node temp = head;
        while(temp.next!=null && temp.next.value!=data)
            temp = temp.next;
        
        if(temp.next==null){
            System.out.println("Error. Data not found");
            return;
        }
        temp.next = temp.next.next;
        
    }
    
    public int getSize(){
        Node temp = this.head;
        int counter = 1;
        while(temp.next!=null){
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        Node temp = head;
        while(temp.next!=null){
            ret.append(temp.value);
            ret.append(",");
            temp = temp.next;
        }
        ret.append(temp.value);
        ret.append("]");
        return ret.toString();
    }
}
