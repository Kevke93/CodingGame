import java.util.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char []B = in.nextLine().toCharArray();
        
        int indexBestUri=Integer.MIN_VALUE;
        int mostFreedom=0;
        
        for (int i =0; i <B.length-mostFreedom; i++){
            
        	if(B[i]=='U') {
        		
        		int rightBound=-1;
        		for(int j =i ; j<B.length ;j++) {
        			if(B[j]!='U') {
        				rightBound=j;
        				break;
        			}
        		}
        		
        		if(i!=0 && rightBound>0) {
        			
        			if(rightBound-1-i>mostFreedom) {
        				mostFreedom=	rightBound	-	1	-i;
        				indexBestUri=	i+((rightBound-i)/2);
        				
        			}
        			
        		}
        		else if(i==0) {
        			if(rightBound-1>mostFreedom) {
        				mostFreedom=rightBound-1;
        				indexBestUri=i;
        			}
        		}
        		else {
        			if(B.length-1-i>mostFreedom) {
        				mostFreedom=B.length-1-i;
        				indexBestUri=B.length-1;
        				
        			}
        			break;
        			}
        		i=rightBound;
            	}
            }

        System.out.println(indexBestUri);
    }
}