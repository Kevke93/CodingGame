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
        int width = in.nextInt();
        int height = in.nextInt();
        int count = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char field[][] = new char[height][width]; 
        for (int i = 0; i < height; i++) {
            field[i] = in.nextLine().toCharArray();
        }

       while (count>0) {
        	 char newField [][]=new char [field[0].length][field.length];
        	
        	// Sort the field to the Left
        	 for (char[] chField:field) {
        		 
        		 for (int i=0;i<chField.length;i++) {
        			 for (int j=0;j<chField.length-i-1;j++) {
        				 if (chField[j]<chField[j+1]) {
        					 char tempChar = chField[j];
        					 chField[j]=chField[j+1];
        					 chField[j+1]=tempChar;
        				 }
        			 }
        		 }
        	 }

        	 // Vertauschen Koordinaten
        	 for (int i=0;i<field.length;i++) {
        		 for(int j =0;j<field[0].length;j++) {
        			 newField[j][i]= field[i][j];
        		 }
        	 }
        	 
    		/* for(int j =0;j<field[0].length;j++) {
    				System.err.println(new String(newField[j]));
    				 
    			 }*/
    		 count--;
    		field=newField;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
		 for(int j =0;j<field.length;j++) {
				System.out.println(new String(field[j]));
				 
			 }
    }
}