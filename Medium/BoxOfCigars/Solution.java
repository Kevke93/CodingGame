import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int diff[][]= new int [N][];
        int numbers[]= new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = in.nextInt();
        }
        
        /*------------------------------------------------------------------------
         * Logic: For each number there will be a row create
         * Each row contains the difference from the inital number(in the numbersArr) 
         * to the currentNumber
         * Afterwards you only have to go through the elements and decide with the corresponding difference
         * example for Row
         * Input (row of the final Result) 
         * --> 1 2 5 7 9 10 13 15
         * First iteration
         * 1-->2 stop
         * 2-->stop
         * 5-->10-->15
         */
        
        for (int i =0 ; i <N-1 ; i++) {
        	int counter=i;
        	diff[i]=new int [N-i-1];
        	
        	for( int j =0 ; j <N-i-1 ; j++) {
        		diff[i][j]=numbers[counter+1]-numbers[i];	
        			counter++;
        	}
        }
        
        int bestresult =0;
        for (int i = 0 ; i < N -1-bestresult;i++ ) {
        	
        	for ( int j = 0 ; j <diff[i].length ; j++) {
        		
        		int dis = diff[i][j];
        		
        		int lastResult =dis;
        		int currentamount=2;
        		
        		for (int k = j+1; k < diff[i].length ;k++) {
        			
        			if(lastResult+dis==diff[i][k]) {
        				lastResult=diff[i][k];
        				currentamount++;
        			}
        			else if(lastResult+dis<diff[i][k] ) {
        				break;
        			}
        		}
        		if(currentamount >bestresult) {
        			bestresult=currentamount;
        		}	
        	}
        }
        System.out.println(bestresult);
    }
}