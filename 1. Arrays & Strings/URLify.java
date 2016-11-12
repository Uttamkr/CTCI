/*
 * 1.3: Add "%20" in place of all spaces
 */

import java.util.*;

public class URLify {
    
    //method to convert string to url
    public static char[] url(char[] str){
        //count number of spaces
        int counter = 0;
        for(char temp: str){
            if(temp == ' '){
                counter++;
            }
        }
        
        //String has to contain atleast one space
        if(counter == 0){
            System.out.println("Error: String contains no white spaces.");
            System.exit(counter);
        }
        
        //create array to fit everything with '%20' in place of a space
        char[] newStr = new char[str.length+2*counter];
        
        //add all elements to new string
        counter = 0;
        for(char temp: str){
            if(temp == ' '){
                //adding "%20" if space is encountered
                newStr[counter++] = '%';
                newStr[counter++] = '2';
                newStr[counter++] = '0';
            }else{
                //else add the character directly
                newStr[counter++] = temp;
            }
        }
        return newStr;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string with white spaces");
        char[] str = scan.nextLine().toCharArray();
        
        System.out.println("The URLified string is: "+String.valueOf(url(str)));
    }
}
