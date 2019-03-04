import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        boolean[][] nodes = new boolean[N][N];
        boolean[] gateways = new boolean[N];
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            nodes[N1][N2] = true;
            nodes[N2][N1] = true;
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways[EI] = true;
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Agent near gateway?
            boolean agentTooClose = false;
            int node1 = 0;
            int node2 = 0;
            
            for (int i = 0; i < N; i++) {
                if (gateways[i]) {
                    if (nodes[i][SI]) { 
                        agentTooClose = true;
                        node1 = i;
                        node2 = SI;
                    }
                }
            }
            
            if (agentTooClose) System.out.println(node1 + " " + node2);
            // Agent too far
            else {
                boolean activate = false;
                for (int i = 0; i < N; i++) {
                    if (gateways[i]) 
                        for (int j = 0; j < N; j++)
                            if ((nodes[i][j]) && (!activate)) { 
                                activate = true;
                                node1 = i;
                                node2 = j;
                            }
                }
                System.out.println(node1 + " " + node2);
            }
        }
    }
}