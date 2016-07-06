// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
   	private int[] color;
	static private int[] d;
	static private int[] pi;
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        color = new int[v];
        d = new int[v];
        pi = new int[v];
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
  
//    // prints BFS traversal from a given source s
//    void BFS(int s)
//    {
//        // Mark all the vertices as not visited(By default
//        // set as false)
//        boolean visited[] = new boolean[V];
// 
//        // Create a queue for BFS
//        LinkedList<Integer> queue = new LinkedList<Integer>();
// 
//        // Mark the current node as visited and enqueue it
//        visited[s]=true;
//        queue.add(s);
// 
//        while (queue.size() != 0)
//        {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s+" ");
// 
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            Iterator<Integer> i = adj[s].listIterator();
//            while (i.hasNext())
//            {
//                int n = i.next();
//                if (!visited[n])
//                {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//    }
    
    void BFS(int s){
    	boolean visited[] = new boolean[V];
    	visited[s] = true;
    	LinkedList<Integer> queue = new LinkedList();
    	
    	queue.add(s);
    	
    	while(!queue.isEmpty()){
    		s = queue.poll();
    		System.out.print(s+" ");
    		Iterator<Integer> iter = adj[s].iterator();
    		while(iter.hasNext()){
    			int index = iter.next();
    			if(!visited[index]){
    				visited[index] = true;
    				queue.add(index);
    			}
    		}
    	}
    	
    }
 
    void BFS1(int s){
    	//0:white,1:gray,2:black
 
    	for(int i=0;i<V;i++){
    		if(i!=s){
    			color[i] = 0;       
    			d[i] = 1000;
    			pi[i] = -1;
    		}
    	}
    	
    	color[s] = 1;
    	d[s] = 0;
    	pi[s] = -1;
    	
    	LinkedList<Integer> queue = new LinkedList();
    	queue.add(s);
    	while(!queue.isEmpty()){
    		int u = queue.poll();
    		//System.out.println("head"+u);
    		Iterator<Integer> iter = adj[u].iterator();
    		while(iter.hasNext()){
    			int current = iter.next();
    			if(color[current]==0){
    				color[current] = 1;
    				d[current] = d[u] + 1;
    				pi[current] = u;
    				queue.add(current);
    				//System.out.println(current);
    			}   
        		color[u] = 2;
    		}

    				
    	}
    }
    
    void print_path(int s,int v){
    	 if(v==s){
    		 System.out.print(s+" ");
    	 }else{
    		 if(pi[v]==-1){
    			 System.out.println("no path from "+ s +" to "+ v +" exists");
    		 }else{
    			 print_path(s,pi[v]);
    			 System.out.print(v + " ");
    		 }
    	 }
    }
    // Driver method to
    public static void main(String args[])
    {
        Graph g = new Graph(5);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(0, 4);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 3)");
 
        g.BFS1(0); 
        g.print_path(0, 3);
    }
}
// This code is contributed by Aakash Hasija