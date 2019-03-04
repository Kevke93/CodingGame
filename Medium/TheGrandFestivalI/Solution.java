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

		Node startNode = new Node( 0 , 0, 0 );
		
		ArrayList< Node > lastLevel = new ArrayList< Node >();
		lastLevel.add( startNode );

		for (int i = 0; i < N; i++ ) {
			
			ArrayList< Node > currentLevel = new ArrayList<Node>();
			
			for (Node node : lastLevel) {

				if (node.getPlayDays() < R) {
					Node nextNode = new Node(node.getPrice() + price[i], node.getPlayDays() + 1, 0);
					currentLevel.add(nextNode);
					
					if(node.getRestDays()<=1) {
					Node restNode = new Node(node.getPrice(), 0, node.getRestDays() + 1);
					currentLevel.add(restNode);
					}
					
				} else {
					Node restNode = new Node(node.getPrice(), 0, node.getRestDays() + 1);
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
		for(Node node: lastLevel) {
			
			if(node.getPrice()>maxPrice) {
				maxPrice=node.getPrice();
			}
			
		}
		System.out.println(maxPrice);
	}
}

class Node {
	private int price;
	private int playDays;
	private int restDays;

	Node(int price, int playDays, int restDays) {
		this.price = price;
		this.playDays = playDays;
		this.restDays = restDays;
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

}