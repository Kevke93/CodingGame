import java.util.*;

import javax.lang.model.element.NestingKind;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
	static   ArrayList<Node> allnodes= new ArrayList<>();
	static int temp;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        char [][] map = new char[H][W];
       
        int X = in.nextInt();
        int Y = in.nextInt();
        System.err.println(W+ " "+ H + " "+ X+" "+ Y);
        if (in.hasNextLine()) {
            in.nextLine();
            System.err.println();
        }
        for (int i = 0; i < H; i++) {
        	String s =in.nextLine();
        	map[i] = s.toCharArray() ;
        	System.err.println(s);
        }
        createNodes(map,H,W);
        
        Node start=null;
        // Check if the Start Already exist as a Node
        boolean startIsAlreadyCreated=false;
        for(Node node: allnodes) {
        	if(node.getX()==X && node.getY()==Y) {
        		startIsAlreadyCreated=true; 
        		start=node;
        	}
        }
        if(startIsAlreadyCreated==false) {
        	 start= new Node(X,Y);
        	connectToNode(start,map);
        	allnodes.add(start);
        }
        
        Dijstar(start,map);
        ArrayList<Node> exits= new ArrayList<>();
        for(Node node :allnodes) {
        	
        	if(node.getPotentialExit() && node.getDistance()<Integer.MAX_VALUE) {
        		exits.add(node);		
        	}
        }
        Collections.sort(exits, new  OutputComperator());


        // Debug
        for(Node node: allnodes) {
        	System.err.println(node.getX()+" "+node.getY() + node.getPotentialExit());
        	
        	node.getConnections().forEach((neibour, dis) -> {
        	System.err.println(" Connection "+neibour.getX() + " "+ neibour.getY()+ " "+ "Distance "+dis);
        	});
        	}
        
        System.out.println(exits.size());
        for(Node node: exits) {
        	System.out.println(node.getX() + " "+ node.getY());
        }
        
        
        }

    
	public static void Dijstar(Node start, char [][]map) {
		start.setDistance(0);

		HashSet<Node> visited = new HashSet<>();
		ArrayList<Node> prio = new ArrayList<>();

		prio.add(start);

		while (!prio.isEmpty()) {
			Collections.sort(prio, new NodeComperator());
			Node currentNode = prio.remove(0);

			currentNode.getConnections().forEach((neigbour, dis) -> {

				if (!visited.contains(neigbour)) {

					if (currentNode.getDistance() + dis < neigbour.getDistance()) {
						neigbour.setDistance(currentNode.getDistance() + dis);
							if(!prio.contains(neigbour))
							prio.add(neigbour);

					}

				}
			});
			visited.add(currentNode);
			

			
		}

	}

    
	public static void createNodes(char[][] map, int H, int W) {
    	
    
        for (int i=0;i<H;i++) {
        	for(int j=0;j<W;j++) {
        		if(map[i][j]=='.') {
        			if(j==0 || j==W-1 || i==0 || i==H-1) {
        				Node neuNode= new Node(j,i);
        				neuNode.setPotentialExit(true);
        				allnodes.add(neuNode);
        				connectToNode(neuNode,map);
        			}
        			else if(map[i][j-1]=='#') {
        				if(map[i+1][j]=='#' ||map[i-1][j]=='#' || (map[i+1][j]=='.'&& map[i][j+1]=='.'&& map[i-1][j]=='.')) {
            				Node neuNode= new Node(j,i);
            				
            				allnodes.add(neuNode);
            				connectToNode(neuNode,map);
        				}
        			}
        			else if(map[i][j-1]=='.') {
        				if(map[i][j+1]=='#'|| map[i][j+1]=='.' && map[i-1][j]=='.' || map[i][j+1]=='.' && map[i+1][j]=='.') {
            				Node neuNode= new Node(j,i);
            				allnodes.add(neuNode);
            				connectToNode(neuNode,map);
        				}
        				
        			}
        		}
            }
        }

    }
	
	public static void connectToNode(Node node, char [][] map) {
		
		int nodeX=node.getX();
		int nodeY= node.getY();
		for(Node possibleConnection: allnodes) {
			
			if(possibleConnection.getX()==nodeX ) {
				int move=1;
				while(true) {
					if(nodeY-move<0) {break;}
					if(map[nodeY-move][nodeX]=='#')break;
					else if(nodeY-move==possibleConnection.getY()) {
						node.addConnection(possibleConnection, move);
						possibleConnection.addConnection(node, move);
						break;
					}
					else move++;
				}
					
				
			}
			else if(possibleConnection.getY()==nodeY && nodeX>0) {
				int move=1;
				while(true) {
					if(nodeX-move<0) {break;}
					if(map[nodeY][nodeX-move]=='#')break;
					else if(nodeX-move==possibleConnection.getX()) {
						node.addConnection(possibleConnection, move);
						possibleConnection.addConnection(node, move);
						break;
					}
					else move++;
				
			}
		}
	}
}}
class OutputComperator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		
		if(o1.getX()>o2.getX())return 2;
		else if(o1.getX()<o2.getX())return -2;
		else {
			if(o1.getY()>o2.getY())return 1;
			else return -1;
		}
		
	
	}
	
	
	
}
class NodeComperator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		
		if(o1.getDistance()>o2.getDistance())return 1;
		else if(o1.getDistance()<o2.getDistance())return -1;
		else return 0;
		
		
		
	}
	
	
	
	
	
}

class Node{
	private int x;
	private int y;
	private boolean isExit;
	private boolean potentialExit;
	private int distance;
	private HashMap<Node, Integer> adjustendNodes= new HashMap<>();
	private LinkedList<Node> shortestPath = new LinkedList<>();
	
	Node(int x, int y){
		this.x=x;
		this.y=y;
		this.potentialExit=false;
		this.isExit=false;
		this.distance=Integer.MAX_VALUE;
	}
	protected boolean isExit() {return isExit;}
	protected boolean getPotentialExit() {return potentialExit;}
	protected void setExit() {isExit=true;}
	protected void setPotentialExit(boolean potential) {this.potentialExit=potential;}

	protected void addConnection(Node node, int dis) {adjustendNodes.put(node, dis);}
	protected HashMap<Node,Integer> getConnections(){return adjustendNodes;}
	protected int getX() {return x;}
	protected int getY() {return y;}
	protected void setLinkedList(LinkedList<Node> list) {shortestPath=list;}
	protected LinkedList<Node> getShortestPath(){return shortestPath;}
	protected void setDistance(int dis) {distance=dis;}
	protected int getDistance() {return distance;}
	
}