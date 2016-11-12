/*
* 4.1: Route between Nodes: Given a directed graph, find out whether there is a path between given two nodes
*/

import java.util.*;

class Graph{
    MyNode[] nodes;
    
    public Graph(int size){
        nodes = new MyNode[size];
    }
}

class MyNode{
    int value;
    boolean visited = false;
    MyNode[] adjacent;
    
    public MyNode(int value){
        this.value = value;
    }
}

public class RouteNodes{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //Creating the root node
        System.out.println("Enter the number of nodes");
        int n = scan.nextInt();
        if(n<=0){
            System.out.println("Error: Atleast two nodes should be in this graph.");
            return;
        }
        Graph graph = new Graph(n);
        
        int i = 0;
        while(i<n){
            System.out.println("Enter the value for node "+(i+1));
            graph.nodes[i++] = new MyNode(scan.nextInt());    
        }
        
        //add adjacent nodes to all nodes
        for(MyNode temp: graph.nodes){
            System.out.println("Number of adjacent nodes for node "+temp.value);
            n = scan.nextInt();
            temp.adjacent = new MyNode[n];
            for(i = 0; i<n;i++){
                System.out.println("Enter value for child "+(i+1)+" of node "+temp.value);
                temp.adjacent[i] = findNode(graph,scan.nextInt());
                if(temp.adjacent[i] == null){
                    System.out.println("****NODE NOT FOUND****");
                }
            }
            
        }
        
        System.out.println("Enter the first node.");
        MyNode first = findNode(graph,scan.nextInt());
        System.out.println("Enter the second node.");
        MyNode second = findNode(graph,scan.nextInt());
        if(first==null||second==null){
            System.out.println("Error: Atleast one of the nodes not found.");
        }else{
            findRoute(first,second);
        }
    }

    private static MyNode findNode(Graph graph, int val) {
        for (MyNode node : graph.nodes) {
            if (node.value == val) {
                return node;
            }
        }
        return null;
    }
    

    private static void findRoute(MyNode first, MyNode second) {
        ArrayList<MyNode> q = new ArrayList<>();
        q.add(first);
        while(!q.isEmpty()){
            MyNode current = q.remove(0);
            current.visited = true;
            if(current == second){
                System.out.println("Found.");
                return;
            }
            for(MyNode node: current.adjacent){
                if(!node.visited){
                    q.add(node);
                }
            }
        }
        System.out.println("Not found");
    }
}