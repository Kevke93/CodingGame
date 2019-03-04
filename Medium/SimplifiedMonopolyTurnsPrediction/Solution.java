import java.util.*;


class Solution {
	static MonPlayer[]players;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        players = new MonPlayer[P];
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < P; i++) {
            String player[] = in.nextLine().split(" ");
            MonPlayer play = new MonPlayer(Integer.parseInt(player[1]),player[0]);
            players[i]=play;
        }
        
        int D = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        /*----------------------------------------------------------------------------------------
         * Sumulation
         */
        int playT=0;
        for (int i = 0; i < D; i++) {
            int dice [] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int diceSum=dice[0]+dice[1];
            

            /*---------------------------------------
             * Not in Jail
             */
            if(!players[playT].getInJail()) {
            	players[playT].addMove(diceSum);
            	
             	if(dice[0]==dice[1]) {
            		players[playT].addDouble();
            		players[playT].resetTurnsWithoutDoubler();
            		
            	}
              	else {
              		players[playT].resetDouble();
              	}

             	
            	if(players[playT].getInJail() ||dice[0]!=dice[1]) {
            		players[playT].resetDouble();
                 	playT++;
                	if(playT==P) {
                		playT=0;
                	}
            	}
       
            }
            /*---------------------------------------
             *  in Jail
             */
            else {
            	if(dice[0]==dice[1] ||players[playT].getTurnsWithoutDouble()==2)  {
            		players[playT].addMove(diceSum);
            		players[playT].setInJail(false);
            		players[playT].resetDouble();
            		
            	}
            	
            	else {
            		players[playT].addTurnWithoutDouble();
            	}
            	
            	playT++;
            	if(playT==P) {
            		playT=0;
            	}
            }

        }
        for(int i =0; i <players.length;i++) {
        	System.out.println(players[i].getName() + " "+ players[i].getPos());
        }
    }
}
class MonPlayer {
	private int pos;
	private int doubleCount;
	private int turnsWithoutDouble;
	private boolean inJail;
	private String name;
	
	MonPlayer(int pos, String name ){
		this.pos=pos;
		this.name=name;
		this.inJail=false;
		this.doubleCount=0;
		this.turnsWithoutDouble=0;
	}
	void addMove(int move) {
		
		pos+=move; 
		
		if(pos>39) {
			pos-=40;
		}
		
		else if(pos==30) {
			setInJail(true);
			pos=10;
		}
		
	}
	int getPos() {return pos;}
	void addDouble() {
		
		doubleCount++;
	
		if(doubleCount==3) {
			pos=10;
			setInJail(true);
		}
		
	}
	void resetDouble() {doubleCount=0;}
	int getDouble() {return doubleCount;}
	void setInJail(boolean inJail) {	
		resetTurnsWithoutDoubler();
		this.inJail=inJail;}
	boolean getInJail() {
		return inJail;}
	String getName() {return name;}
	int getTurnsWithoutDouble() {return turnsWithoutDouble;}
	void addTurnWithoutDouble() {turnsWithoutDouble++;
	}
	void resetTurnsWithoutDoubler() {turnsWithoutDouble=0;}
}