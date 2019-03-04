import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String[] numbers = new String[N];
		ArrayList<node> listParents = new ArrayList<node>();
		ArrayList<node> allNodes = new ArrayList<node>();
		
		for (int i = 0; i < N; i++) {
			numbers[i] = in.next();
		}
		for (String s : numbers) {
			// select the tree
			char ch[] = s.toCharArray();
			char startCh = ch[0];
			boolean newTree = true;
			node nodeStart = new node();
			for (node parent : listParents) {
				if (startCh == parent.getValue()) {
					nodeStart=parent;
					newTree = false;
					break;
				}
			}
			if (newTree) {
				nodeStart.setValue(startCh);
				listParents.add(nodeStart);
				allNodes.add(nodeStart);
			}

			for (int i = 1; i < ch.length; i++) {
				boolean foundNodeVal=false;
				for(node children:nodeStart.getChild()) {
					if (children.getValue()==ch[i]) {
						foundNodeVal=true;
						nodeStart=children;
					}
				}
				// Create new Npde
				if(!foundNodeVal) {
					node newNode= new node();
					newNode.setValue(ch[i]);
					newNode.setParent(nodeStart);
					nodeStart.addChild(newNode);
					allNodes.add(newNode);
					nodeStart=newNode;
				}
			}
		}

		System.out.println(allNodes.size());
	}
}
class node{
	protected ArrayList<node> child = new ArrayList<node>();
	protected node parent;
	protected char value;
	protected void setValue(char value) 
	{this.value = value;}
	protected void setParent(node parent) {this.parent=parent;}
	protected void addChild(node childNode) {this.child.add(childNode);}
	protected char getValue() {return value;}
	protected ArrayList<node> getChild() {return child;}
	
}