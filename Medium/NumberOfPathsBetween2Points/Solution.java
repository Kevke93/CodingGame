import java.util.Scanner;

public class Solution {

    public static void main(String args[])  {
        Scanner in = new Scanner(System.in);
    
    		int M = in.nextInt();
		    int N = in.nextInt();
		    		
		    if (in.hasNextLine()) {
		        in.nextLine();
		    }
		    int field [][] = new int [M][N];
		    
		    for ( int i = 0; i < M; i++ ) {
		    	
		        String ROW[] = in.nextLine().split("");
		        
		        for( int j = 0 ; j <N ; j++ ) {
		        	field[i][j] = Integer.parseInt(ROW[j]);	        	
		        }
		    }
	
        System.out.println( minCost( field, N-1, M-1, 0 , 0 ));
    }
    
	private static int minCost( int[][] cost , int goalX , int goalY, int CurrentX , int CurrentY ) {
		
		if( goalX == CurrentX && goalY == CurrentY ) {
			return 1;
		}
		
		if( CurrentY == goalY ) {
			if( CurrentX+1 == cost.length ) {
				return 0;
			}			
			return ( cost[CurrentY] [CurrentX+1] == 0 ) ? minCost( cost, goalX, goalY, CurrentX+1, CurrentY ) :0;

		}
		else if( CurrentX == goalX ) {
			if( CurrentY+1 == cost[goalX].length ) {
				return 0;
			}			
			return ( cost[CurrentY+1][CurrentX] ==0 )? minCost( cost, goalX, goalY, CurrentX, CurrentY+1 ) :0;
		}
		else
		
			return (( cost[CurrentY+1] [CurrentX] == 0) ? minCost( cost, goalX, goalY, CurrentX, CurrentY+1 ) :0 ) + 
					+ (( cost[CurrentY][CurrentX+1] == 0 ) ? minCost( cost, goalX, goalY, CurrentX+1, CurrentY ) :0);
	}
} 