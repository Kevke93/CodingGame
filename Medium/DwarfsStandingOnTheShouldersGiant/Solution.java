import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
	  static  HashMap<Integer, List<Integer>> matrix = new HashMap<>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
     
        
        int n = in.nextInt(); // the number of relationships of influence
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();
            
            if(matrix.get(x)==null) {
            	matrix.put(x, new ArrayList<Integer>());
            }
            matrix.get(x).add(y);
        }
        int high=0;
        for(Map.Entry<Integer, List<Integer>> entry:matrix.entrySet()) {
        	int current= getMaxDepth(entry.getKey(), 1);
        	if (current>high) {high=current;}
        	
        	
        }
        System.out.println(high);
    }
    public static int getMaxDepth(int key,int level) {
    	
    	List<Integer>list =matrix.get(key);
    	if(list==null)return level;
    	int next=level+1;
    	for(Integer i:list)
    	{	
    		int nextLevel=getMaxDepth(i, next);
    		if (nextLevel>level) {level=nextLevel;}
    	}
    	
    	return level;
    }
}