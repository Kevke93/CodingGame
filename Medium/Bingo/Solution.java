import java.util.*;

class Solution {
static ArrayList<BingoCard> cards= new ArrayList<>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < n; i++) {
        	int field[][]= new int  [5][];
        	for(int j = 0 ; j < 5 ; j++) {

        		field[j]= Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	}
        	  BingoCard card = new BingoCard(field);
        	  cards.add(card);
        	  
        }
        
          int calls [] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
          
          boolean lineBingo=false;
          
          for( int i = 0 ; i < calls.length ; i++ ) {
        	  int call = calls[i];
        	  
        	  for( BingoCard card : cards ) {
        		  
        		  card.AddCall( call );
        		   		  
        		  if( !lineBingo ) {
        			  
        			  if( card.hasBingoLine() ) {
        				  
        				  lineBingo=true;
        					System.out.println(i+1);  
        			  }
        		  }
        		  if(lineBingo) {
        			  if(card.hasFullBingo()) {
        				  System.out.println(i+1);
        				  return;
        			  }
        			  
        		  }
        		  
        	  }
          }

        System.out.println("No Bingo");
    }
}

class BingoCard{
	private int card [][]= new int[5][5];
	int numbersLeft;
	
	BingoCard(int card [][]) {
		this.card=card;	
		numbersLeft=24;
	}
	public void print() {
		
		for(int i =0 ; i  <5 ; i++) {
			for ( int j = 0 ; j < 5 ; j++) {
				System.err.print(card[i][j] +" ");
			}			
			System.err.println();
		}
	}
	void AddCall (int call) {
		for(int i =0;i<5;i++) {
			for(int j = 0; j < 5 ; j++) {
				if(card[i][j]==	call) {
					card[i][j]=0;
					numbersLeft--;
				}
			}	
		}
	}
	boolean hasBingoLine () {
		//Row
		for(int i =0;i<5;i++) {
			int correct=0;
			for(int j =0; j < 5 ; j++) {
					if(card[i][j]==0) {
						correct++;
					}
					else 
						break;
				
			}
			if(correct==5) {return true;}
		}
		//Collumns
		
		for(int i =0;i<5;i++) {
			int correct=0;
			for(int j =0; j < 5 ; j++) {
					if(card[j][i]==0) {
						correct++;
					}
					else 
						break;
				
			}
			if(correct==5) {return true;}
		}
		// Diagonal left 
		int correct=0;
		for(int i =0;i<5;i++) {
					
					if(card[i][i]==0) {
						correct++;
					}
					else 
						break;

		}
		if(correct==5) {return true;}
		
		// Diagonal Right
		 correct=0;
		for(int i =4 ; i>=0 ; i--) {
					
					if(card[i][i]==0) {
						correct++;
					}
					else 
						break;

		}
		if(correct==5) {return true;}
		
		return false;
	}
	boolean hasFullBingo() {
		
		if(numbersLeft==0) {return true;}
				  
			return false;

					
		
	}
}