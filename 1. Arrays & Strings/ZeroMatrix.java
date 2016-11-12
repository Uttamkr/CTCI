/*
* 1.8: Zero Matrix: If an element in given matrix is zero, its entire row and column is set to zero.
*/

import java.util.*;

public class ZeroMatrix{
    
    static void convert(int i, int j, int row, int column, int[][] matrix){
        for(int p = 0; p<column;p++){
            matrix[i][p] = 0;
        }
        for(int p = 0; p<row; p++){
            matrix[p][j] = 0;
        }
    }
    
    static void setZero(int row,int column,int[][] matrix){
        ArrayList<Integer> rowCount = new ArrayList<>();
        ArrayList<Integer> colCount = new ArrayList<>();
        for(int i = 0; i<row;i++){
            for(int j = 0;j<column;j++){
                if(rowCount.contains(i) || colCount.contains(j))
                    continue;
                if(matrix[i][j]==0){
                    convert(i,j,row,column,matrix);
                    rowCount.add(i);
                    colCount.add(j);
                }
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row size of the matrix");
        int row = scan.nextInt();
        System.out.println("Enter column size of the matrix");
        int column = scan.nextInt();
        
        int[][] matrix = new int[row][column];
        System.out.println("Great. Now enter a "+row+"x"+column+" matrix");
        for(int i = 0; i<row; i++){
            for(int j = 0; j<column;j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        
        setZero(row,column,matrix);
        
        System.out.println("The converted matrix is:");
        
        for(int[] rows: matrix){
            for(int element: rows){
                System.out.print(element+" ");
            }
            System.out.println("");
        }
    }
}