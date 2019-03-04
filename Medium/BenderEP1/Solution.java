import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {
	static ArrayList<Bender> oldStates = new ArrayList<Bender>();
	static int[][] prios = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] priosChanged = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int C = in.nextInt();
		System.err.println(L + " " + C);
		if (in.hasNextLine()) {
			in.nextLine();
		}
		char map[][] = new char[L][];
		for (int i = 0; i < L; i++) {
			String s = in.nextLine();
			System.err.println(s);

			map[i] = s.toCharArray();
		}

		int[] benderPos = whereIsBender(map);
		int benderXPos = benderPos[1];
		int benderYPos = benderPos[0];
		boolean beerMode = false;
		boolean changedPrios = false;
		int mapChanged = 0;
		String dirSt = "";
		String move = "";
		String dic[] = { "SOUTH", "EAST", "NORTH", "WEST" };
		int tempCC=0;
		Bender ben1 = new Bender(benderXPos, benderYPos, beerMode, changedPrios, mapChanged, dirSt,0);
		oldStates.add(ben1);
		int tempcc=0;
		ArrayList<String>result = new ArrayList<>();
		boolean loop=false;
		while (true) {
			tempcc++;
			Bender ben = new Bender(benderXPos, benderYPos, beerMode, changedPrios, mapChanged, dirSt,tempcc);
			oldStates.add(ben);
            
            
            
			// Method check if ben was already with the same stat there
			
			int dir[][];
			if (ben.HasChangedPrios()) {
				dir = priosChanged;
			} else {
				dir = prios;}
			boolean prioDircPoss = false;
			if (dirSt == "SOUTH" && map[benderYPos + 1][benderXPos] != 'X' && map[benderYPos + 1][benderXPos] != '#') {
				benderYPos = benderYPos + 1;
				prioDircPoss = true;
				move = dirSt;
			} else if (dirSt == "NORTH" && map[benderYPos - 1][benderXPos] != 'X'
					&& map[benderYPos - 1][benderXPos] != '#') {
				benderYPos = benderYPos - 1;
				prioDircPoss = true;
				move = dirSt;
			} else if (dirSt == "EAST" && map[benderYPos][benderXPos + 1] != 'X'
					&& map[benderYPos][benderXPos + 1] != '#') {
				benderXPos = benderXPos + 1;
				prioDircPoss = true;
				move = dirSt;
			} else if (dirSt == "WEST" && map[benderYPos][benderXPos - 1] != 'X'
					&& map[benderYPos][benderXPos - 1] != '#') {
				benderXPos = benderXPos - 1;
				prioDircPoss = true;
				move = dirSt;
			} else if (dirSt == "SOUTH" && map[benderYPos + 1][benderXPos] != '#' && beerMode) {
				benderYPos = benderYPos + 1;
				prioDircPoss = true;
				move = dirSt;
				if (map[benderYPos ][benderXPos] == 'X') {
					map[benderYPos ][benderXPos] = ' ';mapChanged++;}
			}

			else if (dirSt == "NORTH" && map[benderYPos - 1][benderXPos] != '#' && beerMode) {
				benderYPos = benderYPos - 1;
				prioDircPoss = true;
				if (map[benderYPos ][benderXPos] == 'X') {
					map[benderYPos ][benderXPos] = ' ';mapChanged++;}
			} else if (dirSt == "EAST" && map[benderYPos][benderXPos + 1] != '#' && beerMode) {
				benderXPos = benderXPos + 1;
				prioDircPoss = true;
				move = dirSt;
				if (map[benderYPos][benderXPos ] == 'X') {
					map[benderYPos][benderXPos ] = ' ';mapChanged++;}
			} else if (dirSt == "WEST" && map[benderYPos][benderXPos - 1] != '#' && beerMode) {
				benderXPos = benderXPos - 1;
				prioDircPoss = true;
				move = dirSt;
				

				if (map[benderYPos][benderXPos ] == 'X') {
					map[benderYPos][benderXPos ] = ' ';mapChanged++;}
			}
		

		if (!prioDircPoss) {
			for (int i = 0; i < dir.length; i++) {
				if (map[benderYPos + dir[i][0]][benderXPos + dir[i][1]] != 'X'
						&& map[benderYPos + dir[i][0]][benderXPos + dir[i][1]] != '#') {
					benderXPos = benderXPos + dir[i][1];
					benderYPos = benderYPos + dir[i][0];
					if (!changedPrios)
						move = dic[i];

					else
						move = dic[3 - i];

					dirSt = move;
					break;
				} else if (map[benderYPos + dir[i][0]][benderXPos + dir[i][1]] != '#' && beerMode) {
					benderXPos = benderXPos + dir[i][1];
					benderYPos = benderYPos + dir[i][0];
					map[benderXPos][benderYPos] = ' ';mapChanged++;
					if (!changedPrios)
						move = dic[i];

					else
						move = dic[3 - i];

					dirSt = move;
					break;

				}
			}
		}

		char benStand = map[benderYPos][benderXPos];

		if (benStand == 'S' || benStand == 'W' || benStand == 'E' || benStand == 'N') {
			if (benStand == 'S')
				dirSt = "SOUTH";
			else if (benStand == 'W')
				dirSt = "WEST";
			else if (benStand == 'E')
				dirSt = "EAST";
			else
				dirSt = "NORTH";
		} else if (benStand == 'B')
			beerMode = !beerMode;
		else if (benStand == 'I')
			changedPrios = !changedPrios;
		else if (benStand=='T') {
			int temp[]=findAnotherTeleporter(map,benderXPos,benderYPos);
			benderXPos=temp[1];
			benderYPos=temp[0];
		}

		boolean stateAlreadyDone=check(oldStates, benderXPos, benderYPos, changedPrios, mapChanged, beerMode, dirSt,map,tempcc);
		if(stateAlreadyDone) 
		{ System.out.println("LOOP"); loop=true;break; }
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (i == benderYPos && j == benderXPos)
					System.err.print("A");
				else
					System.err.print(map[i][j]);
			}
			System.err.println();
		}
		result.add(move);
		
		if (benStand == '$')
			break;
	}
	
		if(!loop) {
			for(String s: result) {System.out.println(s);}
		}
		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

	}
	public static boolean check(ArrayList<Bender> list ,int benderXPos,int benderYPos,boolean changedPrios,int mapChanged,boolean beerMode, String dirSt, char[][]map, int tempcc) {
		
		for(Bender ben:list) {
			if(ben.getXpos()==benderXPos && ben.getYpos()==benderYPos)
				if(changedPrios==ben.HasChangedPrios() ) {
				if(dirSt==ben.getDir() ) {
					if(beerMode==ben.IsinBeerMude()) {
						if(mapChanged==ben.getmapChanged()) {
						System.err.println(ben.getNumberofMove()+ " "+ tempcc);
						return true;}
					}
				}
			}
		}
		
		
		
		
		
		return false;
	}

	
	

	public static int[] whereIsBender(char[][] map) {
		int result[] = new int[2];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '@')
					return new int[] { i, j };
			}

		}

		return result;
	}
	public static int[] findAnotherTeleporter(char[][] map,int x, int y) {
		int result[] = new int[2];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'T'&& !(y==i && x==j))
					return new int[] { i, j };
			}

		}

		return result;
	}
}

class Bender {
	protected int xPos;
	protected int yPos;
	protected boolean inBeerMude;
	protected boolean changedPrios;
	protected int mapChanged;
	protected String dir;
	protected int numberOfMove;

	Bender(int xPos, int yPos, boolean beerMode, boolean changedPrios, int mapChanged, String dir, int numberOfMove) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.inBeerMude = beerMode;
		this.changedPrios = changedPrios;
		this.mapChanged = mapChanged;
		this.dir = dir;
		this.numberOfMove=numberOfMove;
	}

	protected boolean HasChangedPrios() {
		return changedPrios;
	}

	protected boolean IsinBeerMude() {
		return inBeerMude;
	}

	protected int getXpos() {
		return xPos;
	}

	protected int getYpos() {
		return yPos;
	}

	protected int getmapChanged() {
		return mapChanged;
	}

	protected String getDir() {
		return dir;
	}
	protected int getNumberofMove() {
		return this.numberOfMove;
	}
}