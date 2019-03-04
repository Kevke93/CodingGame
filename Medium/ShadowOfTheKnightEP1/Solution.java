import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int W = in.nextInt(); // width of the building.
		int H = in.nextInt(); // height of the building.
		int N = in.nextInt(); // maximum number of turns before game over.
		int X = in.nextInt();
		int Y = in.nextInt();
		int [][] field = new int[H][W];
		int[] fieldH = new int[H];
		int []fieldW = new int [W];

		// game loop
		while (true) {
			String bombDir = in.next();
			char []bombDirChar =bombDir.toCharArray();// the direction of the bombs from batman's current location (U, UR, R, DR, D,
		// DL, L or UL)
            
			
			updateField(fieldH,fieldW, X, Y, bombDir, H, W);
			
			for(int i =0;i<bombDirChar.length;i++) {
			    int border=-1;
			    
				if (bombDirChar[i]=='R') {
					for (int j=X+1;j<W;j++) {
						if (fieldW[j]==-1)
							{border =j;break;}
					}
					if (border ==-1)border=W;
					
					X=X+((border-X)/2);
					
					
				}
				else if(bombDirChar[i]=='L') {
					for (int j=X-1;j>=0;j--) {
						if (fieldW[j]==-1){
							border =j;break;}
					}
					if (border ==-1)border=-1;
					
					X=X-((X-border)/2);
					
					}
				else if (bombDirChar[i]=='U') {
					for (int j=Y-1;j>=0;j--) {
						if (fieldH[j]==-1){
							border =j;break;}
					}
					if (border ==-1)border=-1;
					
					System.err.println("Border "+border+ " High "+ H);
					Y=Y-((Y-border)/2);
					
				}
				else if(bombDirChar[i]=='D') {
					for (int j=Y+1;j<H;j++) {
						if (fieldH[j]==-1){
							border =j;break;}
					}
					if (border ==-1)border=H;
					System.err.println("Border "+border+ " High "+ H);
					Y=Y+((border-Y)/2);
			}
			}
			
				
			// System err
			System.err.println(bombDir);
            
            
			fieldW[X]=1;
			fieldH[Y]=1;
				for (int j = 0; j < W; j++) {
					System.err.print(fieldW[j]);

				}
				System.err.println();
				
				for (int j = 0; j < H; j++) {
					System.err.println(fieldH[j]);

				}
			

			System.out.println(X + " " + Y);
		}
	}
	public static void updateField (int []fieldH,int[] fieldW, int X, int Y, String bombDir, int H, int W) {
		char[] bombDirChar=bombDir.toCharArray();
		for(int i =0;i<bombDirChar.length;i++) {
		    
			if (bombDirChar[i]=='R') {
				for (int j=X;j>=0;j--) {
					fieldW[j]=-1;
				}
			}
			else if(bombDirChar[i]=='L') {
				for (int j=X;j<W;j++) {
					fieldW[j]=-1;
				}
				}
			else if (bombDirChar[i]=='U') {
				for (int j=Y;j<H;j++) {
					fieldH[j]=-1;
				}
				
			}
			else if(bombDirChar[i]=='D') {
				for (int j=Y;j>=0;j--) {
					fieldH[j]=-1;
				}
		}
		}
		
		
	}
}