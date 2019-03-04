import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {
	static ArrayList<Node> allNodes = new ArrayList<Node>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int E = in.nextInt();
		int S = in.nextInt();
		int G = in.nextInt();
		//System.err.println(N+ " "+ E + " "+ S+ " "+ G);
		for (int i = 0; i < N; i++) {
			int node = in.nextInt();
			//System.err.println(node);
			Node newNode = new Node(i);
			newNode.setHValue(node);
			allNodes.add(newNode);

		}
		
		for (int i = 0; i < E; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int c = in.nextInt();
			//System.err.println(x+ " "+ y +" "+ c);
			allNodes.get(x).addConnection(allNodes.get(y), c);
			allNodes.get(y).addConnection(allNodes.get(x), c);
		}
		//System.err.println();
		AStar(allNodes.get(S), allNodes.get(G));
	}

	public static void AStar(Node start, Node end) {
		start.setDistanceToStart(0);

		HashSet<Node> visited = new HashSet<>();
		ArrayList<Node> prio = new ArrayList<>();

		prio.add(start);

		while (! prio.isEmpty()) {


			Collections.sort(prio, new NodeComperator());

			Node currentNode = prio.remove(0);

			if (currentNode.equals(end)) {
				System.out.println( currentNode.getID()+" "+currentNode.getFValue());
				return;
			}

			currentNode.getConnection().forEach((neibour, dis) -> {
				if (! visited.contains(neibour)) {

					if (currentNode.getDistanceToStart() + dis <= neibour.getDistanceToStart()) {
						neibour.setDistanceToStart( currentNode.getDistanceToStart() + dis );
						if(!prio.contains(neibour))
						prio.add(neibour);
					}

				}
			});	
			System.out.println( currentNode.getID()+" "+currentNode.getFValue());
			visited.add(currentNode);
		}

	}
}
class NodeComperator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		
		if(o1.getFValue()>o2.getFValue())
		{return 2;}
		else if(o1.getFValue()<o2.getFValue())
			return -2;
		else
			if(o1.getID()>o2.getID()) {return 1;}
			else return -1;
	}
}
class Node{
	private int ID;
	private int hValue;
	private int distanceToStart;
	
	private LinkedList<Node>shortestPath=new LinkedList<>();
	private HashMap<Node,Integer> adjustentNodes=new HashMap<>();
	
	
	Node(int val){
		distanceToStart=Integer.MAX_VALUE;
		this.ID=val;

	}
	protected int getID() {return ID;}
	protected void setHValue( int hValue) {this.hValue=hValue;}
	protected int getHValue() {return hValue;}
	protected void setDistanceToStart(int distance){this.distanceToStart=distance;}
	protected int getDistanceToStart() {return distanceToStart;}
	protected void addConnection(Node node,int dis) {adjustentNodes.put(node,dis);}
	protected HashMap<Node,Integer> getConnection(){return adjustentNodes;}
	protected LinkedList<Node> getShortestPath(){return shortestPath;}
	protected void setShortestPath(LinkedList<Node>list) {shortestPath=list;}
	protected int getFValue() {return distanceToStart+hValue;}

}