import java.util.*;


class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int R = in.nextInt();
		int price[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++ ) {
			price[ i ] = in.nextInt();
		}

		Node startNode = new Node( 0 , 0, 0 ,"");
		
		ArrayList< Node > lastLevel = new ArrayList< Node >();
		lastLevel.add( startNode );

		for (int i = 0; i < N; i++ ) {
			
			ArrayList< Node > currentLevel = new ArrayList<Node>();
			
			for (Node node : lastLevel) {

				if (node.getPlayDays() < R) {
					Node nextNode = new Node(node.getPrice() + price[i], node.getPlayDays() + 1, 0,node.getPath());
					nextNode.addPath(">"+(i+1));
					currentLevel.add(nextNode);
					
					if(node.getRestDays()<=1) {
					Node restNode = new Node(node.getPrice(), 0, node.getRestDays() + 1,node.getPath());
					currentLevel.add(restNode);
					}
					
				} else {
					Node restNode = new Node(node.getPrice(), 0, node.getRestDays() + 1,node.getPath());
					currentLevel.add(restNode);
				}
			}
			
			if(i>R) {	
					Map< Integer,Node > bestResults = new HashMap< Integer,Node >();
					
					for(Node node: currentLevel ) {
						
						if(!bestResults.containsKey( node.getPlayDays()) ) {
							bestResults.put(node.getPlayDays(), node);
						}
						else 
						{
							if(node.getPrice()>bestResults.get(node.getPlayDays()).getPrice()) {
								bestResults.put(node.getPlayDays(), node);
							}
							
						}
					}
					lastLevel=new ArrayList<Node>(bestResults.values());
					
			}
			else
			lastLevel=currentLevel;
		}
		
		int maxPrice=0;
		Node maxNode=null;
		for(Node node: lastLevel) {
			
			if(node.getPrice()>maxPrice) {
				maxPrice=node.getPrice();
				maxNode=node;
			}
			
		}
		System.out.println(maxNode.getPath());
	}
}

class Node {
	private int price;
	private int playDays;
	private int restDays;
	private String path="";
	Node(int price, int playDays, int restDays, String path) {
		this.price = price;
		this.playDays = playDays;
		this.restDays = restDays;
		this.path=path;
	}

	int getPrice() {
		return price;
	}

	int getPlayDays() {
		return playDays;
	}

	int getRestDays() {
		return restDays;
	}
	void addPath(String add) {
		if(path.length()==0) {
			path=add.substring(1);
		}
		else 
		path=path+add;}
		
	String getPath(){return path;}
}