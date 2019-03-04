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
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        ArrayList<Node> list = new  ArrayList<Node>();
        int adjMat[][]= new int [N][N];
        for (int i=0;i<N;i++) {
        	Node node= new Node(i);
        	list.add(node);    	
        }
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            adjMat[N1][N2]=1;
            adjMat[N2][N1]=1;
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            list.get(EI).setExit(true);
        }
        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            list.get(SI).setSI(true);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            ArrayList<Integer>NeiList= findNeigbour(adjMat, SI);

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println(SI + " "+ findExitForShi(list,NeiList));
            list.get(SI).setSI(false);
        }
    }
    
    public static int findExitForShi (ArrayList<Node> allNodes,ArrayList<Integer> neibour) {
    	
    	for(int i=0;i<allNodes.size();i++) {
    		for(int j =0;j<neibour.size();i++)
    		if(i==neibour.get(j)) return i;    			
    	}
    	return -1;
    }
    public static ArrayList<Integer> findNeigbour (int adjMat[][],int main) {
    	ArrayList<Integer>list = new ArrayList<Integer>();
    	for (int i =0;i<adjMat.length;i++) {
    		if (adjMat[main][i]==1)list.add(i);    		
    	}
    	return list; 
    }
}
class Node{

	protected int val;
	protected boolean isVisited;
	protected boolean hasSI;
	protected boolean isExit;
	
	Node(int val){
		this. val= val;
		isVisited=false;
		hasSI=false;
		isExit=false;
	}
	protected  void setExit(boolean isExit) {this.isExit=isExit;}
	protected void setSI(boolean SI) {this.hasSI=SI;}
	protected void setVisit(boolean visit) {this.isVisited=visit;}
	
	protected  boolean isExit() {return isExit;}
	protected  boolean hasSI() {return hasSI;}
	protected boolean isVited() {return isVisited;}
}