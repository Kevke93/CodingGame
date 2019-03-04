import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long start = in.nextLong();
        long n = in.nextLong();
        
        for(long i =0 ; i <n;i++) {
        	 long n1=Long.bitCount(start);
        	 long n2=Long.toBinaryString(start).length()-n1;
        	 
        	 long Currentstart=n1*3+n2*4;

        	 if(Currentstart==start && i>2) {
        		 start=Currentstart;
        		 break; 
        	 }
        	 
        	 start=Currentstart;

        	
        }
        System.out.println(start);
    }
}