/**
To enter the code breaker competition you will have to decrypt a set of words we have already encrypted using the following encryption algorithm.

When a plaintext and a key N is provided, each letter of the plaintext will be incremented sequentially till N letters and the incrementing sequence will repeat again.

For an example consider the word:DOTITUDE and the key (N)=3
Then the encrypted text would be:EQWJVXEG

As the key given is 3, letter D is incremented by 1, O is incremented by 2, T is incremented by 3 and again I is incremented by 1 , T is incremented by 2 and so on.

Your task is to decrypt the encrypted words we will be providing.

Input Format

First line will consist the encrypted word
The second line will be the Key (N)

Constraints

0 < N < 27
Encrypted word only consist with uppercase and lowercase characters

Output Format

Decrypted word (Plaintext)

Sample Input 0

EQWJVXEG

3
Sample Output 0

DOTITUDE
Sample Input 1

BDDFfhHJ

2
Sample Output 1

ABCDefGH

*/

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {
    
    //Method to decrypt the encrypted word
    public static String decryptWord(String word, int key){
        //Initializing the alphabet to map with keys
        char[] alphabet1= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                          'O','P','Q','R','S','T','U','V','W','X','Y','Z'};   
        char[] alphabet2= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                          'o','p','q','r','s','t','u','v','w','x','y','z'}; 
        
        char[] encrypted = word.toCharArray();
        char[] decrypted= new char[encrypted.length];
        
        int kCount= 1; //variable that holds the incrementing key value
        int index=0;
            for(int i=0;i<encrypted.length;i++){
                
                if(kCount>key){
                    kCount= kCount-key;
                }
                
                if(Character.isUpperCase(encrypted[i])){
                    index = new String(alphabet1).indexOf((int) encrypted[i]);   
                    if(index>=kCount){
                        decrypted[i]= alphabet1[index-kCount]; //Passing the decrypted char value new decrypted array
                    }
                    else{
                        decrypted[i]= alphabet1[26+index-kCount]; //Passing the decrypted char value new decrypted array
                    }
                    
                }
                else{                    
                     index = new String(alphabet2).indexOf((int) encrypted[i]);
                    if(index>=kCount){
                        decrypted[i]= alphabet2[index-kCount]; //Passing the decrypted char value new decrypted array 
                    }
                    else{
                        decrypted[i]= alphabet2[26+index-kCount]; //Passing the decrypted char value new decrypted array
                    }
                                   
                }
                
                kCount++;
            }
        
        return (new String(decrypted));
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int key = 0;
        String encrypted = in.nextLine();
        
        if(encrypted.matches("[a-zA-Z]+")){ // Making sure system only accepts uppercase and lowercase characters in the string
            key = in.nextInt(); 
            
            if(key>0 && key<27){
              
                System.out.println(decryptWord(encrypted, key));                    
            }
        }
      
    }
    
    
    
}