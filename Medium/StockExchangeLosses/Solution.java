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
        int n = in.nextInt();
        int currentHigh=-1;
        int currentLow=-1;
        int maxLos=0;
        int []pos=new int [n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
        }
        
        currentHigh=pos[0];
        currentLow=pos[0];
        int tempMaxLos =0;
        for (int i =1;i<n;i++){
        	tempMaxLos=0;
            if (pos[i]>currentHigh){
                
                tempMaxLos=currentLow-currentHigh;
                currentHigh=pos[i];
                currentLow =pos[i];
                }
            else if (pos[i]<currentHigh && pos[i]<currentLow) {
            	currentLow=pos[i];
            	 tempMaxLos=currentLow-currentHigh;
            }
            
            if (tempMaxLos<maxLos) {
            	maxLos=tempMaxLos;
            }
            
            System.err.println("CurrentHigh "+ currentHigh);
            System.err.println("CurrentLow " + currentLow);
            System.err.println("TempMaxLos " + tempMaxLos);
            }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(maxLos);
    }
}