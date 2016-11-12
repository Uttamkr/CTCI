/*
* 1.7: Rotate matrix clockwise
*/

import java.util.*;

public class MatrixRotate{
    
    static void rightRotate(int[][]matrix){
        int size = matrix[0].length;
        System.out.println("Right rotated matrix:");
        for(int i = 0; i<size;i++){
            for(int j = 0; j<size;j++){               
                System.out.print(matrix[size-1-j][i]+" ");
            }
            System.out.print("\n");
        }
    }
    
    public static void inPlaceRotate(int[][] matrix){
         int size = matrix[0].length;
        System.out.println("In place rotated matrix: ");
        for(int layer = 0; layer<size/2;layer++){
            int first = layer;
            int last = size-1-layer;
            
            for(int i  = first ; i<last ; i++){
                int offset = i-first;
                
                //save top
                int top = matrix[first][i];
                //left->top
                matrix[first][i] = matrix[last-offset][first];
                //bottom->left
                matrix[last-offset][first] = matrix[last][last-offset];
                //right->bottom
                matrix[last][last-offset] = matrix[i][last];
                
                //top->right
                matrix[i][last] = top;
            }
        }
        
        for(int[] row : matrix){
            for(int element: row){
                System.out.print(element+" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        int size = scan.nextInt();
        System.out.println("Great. Now enter elements for the "+size+"x"+size+" matrix");
        int[][] matrix = new int[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0; j<size; j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        
        inPlaceRotate(matrix);
        rightRotate(matrix);
    }
}