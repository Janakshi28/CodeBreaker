/**
Given five positive integers, You have to use exactly four of the five integers and calculate a value by adding two numbers together and subtracting two numbers from it.

Find the Largest value that can be calculated as mentioned above.

Input Format

A single line of five space-separated integers.

Constraints

Each integer is in the inclusive range [1,10 9 ].

Output Format

Print a single long integer denoting the largest value that can be calculated as mentioned above (The output can be greater than a 32 bit integer.)

Sample Input 0

1 5 3 2 4
Sample Output 0

6
Explanation 0

We add 5 and 4 together and substrate 1 and 2 from it. Then we have 6 that is the maximum value that can be calculated by adding two integers together and subtracting another two integers from it.

5 + 4 - 1 -2 = 6
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static int getAdditionValue(int[] integers){
        int largest1= Integer.MIN_VALUE; //Limit of minimum value
        int largest2= Integer.MIN_VALUE; //Limit of minimum value
        
        for(int num: integers){
           
            if (num > largest1) { 
                largest2 = largest1; 
                largest1 = num;
            } else if (num > largest2) { 
                largest2 = num;
            }
        }//Now largest1 and largest2 points to largest numbers in the array
       
        return (largest1+largest2);
        
    }
    
    public static int getSubtraction(int[] integers){
        int lowest1=Integer.MAX_VALUE; //Limit of maximum value
        int lowest2=Integer.MAX_VALUE; //Limit of maximum value
        
        
        for(int num: integers){
            
            if (num < lowest1) { 
                lowest2 = lowest1; 
                lowest1 = num;
            } else if (num < lowest2) { 
                lowest2 = num;
            }
            
        }//Now lowest1 and lowest2 points to lowest numbers in the array
        
        return (lowest1+lowest2);
        
    }
    
    public static int getLargestSum(int[] integers){
        int addValue= getAdditionValue(integers);
        int minusValue= getSubtraction(integers);
        
        return (addValue-minusValue);
    }
       

    public static void main(String[] args) {
        
        int[] integers = new int[5]; 
        int count=0;
        Scanner in= new Scanner(System.in);
        
        for(int i= 0;i<5;i++){
            integers[i] = in.nextInt();
            
            if(!(integers[i]>=1 && integers[i]<=1000000000)){ // Making sure the integers are in the range of [1, 1000000000]
                count++;
            }
        }
        
        if(count==0) { // Checking if all integers of the array are in range
            System.out.println(getLargestSum(integers));
        }
        
        
    }
}