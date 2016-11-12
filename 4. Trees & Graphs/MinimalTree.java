/*
* 4.2: Minimal Tree: Given a sorted (ascending) array, design an algorithm which returns a minimal BST. i.e: a BST with minimum possible height.
*/

import java.util.*;

class BinTree{
    TreeNode root;
    
    public BinTree(){
        root = null;
    }
    public BinTree(TreeNode root){
        this.root = root;
    }
    
    //Will print PreOrder representation of the tree
    public void display(TreeNode node){
        if(node == null){
            return;
        }
        
        System.out.print(node.value+" ");
        display(node.leftChild);
        display(node.rightChild);
    }
}

class TreeNode{
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    
    public TreeNode(){
        value = 0;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
    
    public void setLeft(TreeNode node){
        this.leftChild = node;
    }
    public void setRight(TreeNode node){
        this.rightChild = node;
    }
}

public class MinimalTree{
    
    static TreeNode genMinimalTree(int[] array, int start, int end){
        
        if(end<start){
            return null;
        }
        TreeNode temp = new TreeNode();
        int mid = (start+end)/2;
        try{
        temp.value = array[mid];
        }catch(Exception e){
            System.out.println("mid "+mid);
        }
        temp.setLeft(genMinimalTree(array,start,mid-1));
        temp.setRight(genMinimalTree(array,mid+1,end));
        
        return temp;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scan.nextInt();
        int[] array = new int[n];
        System.out.println("Enter "+n+" elements in the array");
        for(int i = 0; i<n;i++){
            array[i] = scan.nextInt();
        }
        
        BinTree tree = new BinTree(genMinimalTree(array,0,array.length-1));
        System.out.print("PreOrder BST: ");
        tree.display(tree.root);
    }
}