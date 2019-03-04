import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		long xN = in.nextLong();
		System.err.println(N + " "+ M+ " "+ xN);
		long xN1;
		long xN2;
		Point horse[] = new Point[N+M];
		for (int i = 0; i < 2 * M; i = i + 2) {
			
			if (i == 0) {
				xN2 = (1103515245 * xN + 12345) % (long) Math.pow(2, 31);
				horse[0] = new Point(xN,xN2);
			} else {
				xN1 = (1103515245 * xN + 12345) % (long) Math.pow(2, 31);
				xN2 = (1103515245 * xN1 + 12345) % (long) Math.pow(2, 31);
				horse[i/2]=new Point(xN1,xN2);
			}
			
			xN = xN2;
		}
		
		for (int i = 0; i < N; i++) {
			horse[i + M] = new Point (in.nextInt(),in.nextInt());		
			System.err.println(horse[i+M].getX()+ " "+ horse[i+M].getY());
		}
		
		
		
		
		
		mergeSort(horse, 0, horse.length-1);
		//long result=closestDistance(horse);
		long shortestDis=Long.MAX_VALUE;
		for(int i=0;i<horse.length;i++) {
			for(int j=i+1;j<horse.length;j++) {
				long score=(long)Math.abs(horse[i].getX()-horse[j].getX())+Math.abs(horse[i].getY()-horse[j].getY());
				
				if(score<shortestDis) {shortestDis=score;}
				else if((long)Math.abs(horse[i].getX()-horse[j].getX())>shortestDis){
					break;
				}
			}
		}
		
		System.out.println(shortestDis);
		
		
		/*for(Point p:horse) {
			System.err.println(p.getX()+" "+ p.getY());
		}*/

    }
	public static long closestDistance(Point []horse,int numberOfPoints) {
		
		int middle= numberOfPoints/2;
		Point middlePoint=horse[middle];
	
		
		
		
		return 1;
	}
	
	public static void merge(Point[] p, int indexL, int indexR, int middle) {

		int numberOfPointsLeft = middle - indexL + 1;
		int numberOfPointsRight = indexR - middle;

		Point left[] = new Point[numberOfPointsLeft];
		Point right[] = new Point[numberOfPointsRight];

		for (int i = 0; i < numberOfPointsLeft; i++) {
			left[i] = p[indexL + i];
		}
		for (int i = 0; i < numberOfPointsRight; i++) {
			right[i] = p[middle + i + 1];
		}
		int l = 0;
		int r = 0;
		int k = indexL;
		while (l < numberOfPointsLeft && r < numberOfPointsRight) {

			if (left[l].getX() <= right[r].getX()) {
				p[k] = left[l];
				l++;

			} else {
				p[k] = right[r];
				r++;
			}
			k++;

		}
		while (l < numberOfPointsLeft) {
			p[k] = left[l];
			l++;
			k++;
		}
		while(r < numberOfPointsRight) {
			p[k] = right[r];
			r++;
			k++;
		}

	}
	
	public static void mergeSort(Point[] p,int indexL, int indexR) {
		
		if(indexL<indexR) {
			int middle =(indexL+(indexR-1))/2;
			
			mergeSort(p,indexL,middle);
			mergeSort(p, middle+1, indexR);
			
			// merge them together
			merge(p, indexL, indexR, middle);
		}
	}
	
}
 class Point{
	protected long x;
	protected long y;
	
	Point(long x, long y){this.x=x; this.y=y;}
	protected long getX() {return this.x;}
	protected long getY() {return this.y;}
}