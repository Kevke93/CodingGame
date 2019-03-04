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
        int R = in.nextInt();
        int L = in.nextInt();
        
        int [][] list = new int [L+1][10000];
        
        list[0][0]=R;
        
        
        for (int i =1;i<=L;i++){
            int placeCounter=0;
            	int tempcounter=1;
            	int number =list[i-1][0];
            
            	for (int j=0;j<10000;j++){
            		if (list[i-1][j+1]==number) {
            			tempcounter++;
            		}
            		else if(number!=0){
            			list[i][placeCounter]=tempcounter;
                		list[i][placeCounter+1]=number;
                		placeCounter=placeCounter+2;}
            			
                		if (list[i-1][j+1]!=number) {
            			tempcounter=1;
            			number=list[i-1][j+1];
                		}
            	if(number==0){break;} 
                }
                
                
        for (int j =0;j<10000;j++) {
        	
        	System.err.print(list[i][j]);
        	if (list[i][j+1]==0)break;
        	else System.err.print(" ");
        }
            	System.err.println();
            	
            	
            
            }
        
        System.err.println();

        for (int i =0;i<10000;i++) {
        	
        	System.out.print(list[L-1][i]);
        	if (list[L-1][i+1]==0)break;
        	else System.out.print(" ");
        }
        
    }
}