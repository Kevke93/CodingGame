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
        int n = in.nextInt(); // the number of adjacency relations
        System.err.println(n);
        HashMap<Integer,Node> map= new HashMap<Integer,Node>();
        
        int result=0;
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            System.err.println(xi + " "+ yi);
            if( map.get(xi)==(null))
            	
            {Node node= new Node();
            	map.put(xi,node );
            }
            if( map.get(yi)==(null))
            	
            {Node node= new Node();
            	map.put(yi,node );
            }
            Node node=map.get(xi);
            node.addConection(yi);
            map.put(xi, node);

            node=map.get(yi);
            node.addConection(xi);
            map.put(yi, node);
    }
        

        	//System.err.println(list.size());
        while(map.size()>1) {
        	result++;
        	
        	ArrayList<Integer> con = new ArrayList<>();
        	Node node;
        	for ( Integer key:map.keySet()) {
        		node=map.get(key);       		
        		if(node.hasOnlyOnConnection())
        			con.add(key);
        	}
        	for(Integer key:con) {
        		node=map.get(key);
        		map.remove(key);
        		if(!node.getAllConnections().isEmpty()) {
        		int test=node.getAllConnections().get(0);
        		node=map.get(test);
        		node.deleteConnection(key);
        		map.put(test, node);	}
        	}
        }
        System.out.println(result);
        }

    	
    

}
class Node{
	protected ArrayList<Integer> connections =new ArrayList<>();
	protected int val;
	

	protected void setVal(int val){this.val=val;}
	protected int getVal(){return val;}
	protected ArrayList<Integer> getAllConnections() {return connections;}
	protected void addConection(int numb) {connections.add(numb);}
	protected void deleteConnection(Integer numb) {connections.remove(numb);}
	protected boolean hasOnlyOnConnection() { if(connections.size()==1) return true;
	else return false;
	}

}