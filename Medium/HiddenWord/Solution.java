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
        System.err.println(n);
        
        char [][] chWords = new char[2*n][];
        for (int i = 0; i < 2*n; i=i+2) {
        	String word =in.next();
            chWords[i] = word.toCharArray();
            StringBuilder sb= new StringBuilder(word);
            sb.reverse();
            chWords[i+1]=sb.toString().toCharArray();
            System.err.println(word);
        }
        int h = in.nextInt();
        int w = in.nextInt();
        System.err.println(h + " "+w);
        
        char [][] chGrid = new char[h][w];
        char [][] chRest = new char[h][w];
        for (int i = 0; i < h; i++) {
        	String str = in.next();
        	char []temp =str.toCharArray();
            chGrid[i] = temp;
            chRest[i]=temp.clone();
            System.err.println(str);
        }
        // Vertikal

        for (char ch[]:chWords) {
        	
        		
        	int correctCh=0;
        	 row:
        		 for (int i=0;i<h;i++) {
        			 correctCh=0;
        		for (int j=0;j<w;j++)
        		{
        			
        		 if(ch[correctCh]==chGrid[i][j])
        			{
        				correctCh++;
        			}
        			else if (ch[0]==chGrid[i][j])
        				correctCh=1;
        			else correctCh=0;
        				
        		 if (correctCh==ch.length) {
        			 for (int k=j-correctCh+1;k<=j;k++) {
        				 chRest[i][k]=' ';
        			 }
        			 break row;
        		 }
        		}
        	}
        }
        // Horizontal
        
        for (char ch[]:chWords) {
        	int correctCh=0;
        	 row:
        		 for (int i=0;i<w;i++) {
        			 correctCh=0;
        		for (int j=0;j<h;j++)
        		{
        			
        		 if(ch[correctCh]==chGrid[j][i])
        			{
        				correctCh++;
        			}
        		 else if (ch[0]==chGrid[j][i])
     				correctCh=1;
     			else correctCh=0;
        			
        		 if (correctCh==ch.length) {
        			 for (int k=j-correctCh+1;k<=j;k++) {
        				 chRest[k][i]=' ';
        			 }
        			 break row;
        		 }
        		}
        	}
        }
        // Diagonal Buttom to Top
        int originalW=-1;
        int originalH=-1;
        for (char ch[]:chWords) {
        	int correctCh=0;
        	 row:
        		 for (int i=h-1;i>=0;i--) {
        		for (int j=0;j<w;j++)
        		{
        			System.err.print(chGrid[i][j]);
        		 if(ch[correctCh]==chGrid[i][j])
        			{
        				correctCh++;
        			}
        			else correctCh=0;
        			
        		 if (correctCh==ch.length) {
        			 for (int k=0;k<correctCh;k++) {
        				 chRest[originalH-k][originalW+k]=' ';
        			 }
        			 break row;
        		 }
        		 if (originalH==-1) {
        			 originalW=j;
  					originalH=i;
        		 }
        		 
        		 
 				if (j<w-1 && i>0) {
					i=i-1;
				}
 				else { 
 					System.err.println();
 					correctCh=0;
 					j= originalW;
 					i=originalH;
 					originalW=-1;
 					originalH=-1;
    				}
        		}
        	}
        }
        
        
        
        // Diagonal   TOP to  Buttom
        for (char ch[]:chWords) {
        	int correctCh=0;
        	 row:
        		 for (int i=0;i<h;i++) {
        		for (int j=0;j<w;j++)
        		{
        			
        		 if(ch[correctCh]==chGrid[i][j])
        			{
        				correctCh++;
        			}
        			else correctCh=0;
        			
        		 if (correctCh==ch.length) {
        			 for (int k=0;k<correctCh;k++) {
        				 chRest[originalH+k][originalW+k]=' ';
        			 }
        			 break row;
        		 }
        		 if (originalH==-1) {
        			 originalW=j;
  					originalH=i;
        		 }
        		 
        		 
 				if (j<w-1 && i<h-1) {
					i=i+1;
				}
 				else { 
 					
 					correctCh=0;
 					j= originalW;
 					i=originalH;
 					originalW=-1;
 					originalH=-1;
    				}
        		}
        	}
        }

        for (int i=0;i<h;i++) {
        	for (int j=0;j<w;j++) {
        		if(chRest[i][j]!=' ') {System.out.print(chRest[i][j]);}
        		
        	}
        	
        }

    }
}