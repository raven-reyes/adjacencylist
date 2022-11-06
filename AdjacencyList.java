// In this representation, for every vertex we store its neighbours in a chained list.
//In the worst case,if a graph is connected O(V) is required to store head  vertices 
// and O(E) is required for storing neighbours /adjacenct  to every vertex
// because in an adjacency list, every vertex is associated with a list of adjacent vertices
// Thus, overall space complexity is O(|V|+|E|).
import java.util.Vector;
// adjacency lit using java vector class
public class AdjacencyList { 
int V; 
// an edge can be inserted in O(1)time.
// because we just need to access directly(no traversal) the vertex i in which to insert an edge 
//and then add(directly at the end) this neighbour/ adjacent vertex j to its list of other neighbours 
//and that takes constant time.
// by adding a vertex  j to vertex i's  vector list means there is an edge between this two vertices
// an edge connects two vertices and makes them neighbours
// for undirected graph, the same process is repeated in the opposite direction 
public static void addEdge(Vector<Integer> adjList[], int i, int j) {
     adjList[i].add(j); // adding j in i's vector list
     adjList[j].add(i); // adding i in j's vector list
}
// To remove an edge traversing through the edges is required
//and in worst case,we need to traverse through all the edges
// Thus, the time complexity is O(|E|).
public static void removeEdge(Vector<Integer> adjList[],int i, int j){
// To delete edge between (i, j), i’s adjacency list(vector list) is traversed 
///until j is found and it is removed from it
for (int k = 0; k < adjList[i].size(); k++){
if (adjList[i].get(k) == j){
adjList[i].remove(k);
break;
}
}
// the same operation is done for j , until i is found and removed from it
for (int k = 0; k < adjList[j].size(); k++){
if (adjList[j].get(k) == i){
adjList[j].remove(k);
break;
}
}
}
public static void printGraph(Vector<Integer> adjList[], int V){
for (int v = 0; v < V; v++){ // an iteration to traverse every vertex 
System.out.print("vertex " + v + " is connected to " + " ");
for (Integer i : adjList[v])//get all the elements/vertices adjacent to v in its adjacency/vector list
            System.out.print("-> " + i); // printing those vertices 
       System.out.printf("\n"); // every vertex output in a new line
    }
    System.out.printf("\n");
}
    public static void main(String[] args) {
    	int V = 5; // number of vertices
        @SuppressWarnings("unchecked")
		Vector<Integer> [] adjList = new Vector[V]; // adjacency list using java vector class
            for (int i = 0; i < V; i++) //an iteration to
            adjList[i] = new Vector<Integer>(); // create a vector for every vertex
        addEdge(adjList,0, 0);
        addEdge(adjList,0, 1);
        addEdge(adjList,1, 3);
        addEdge(adjList,2, 3);
        addEdge(adjList,3, 4);
        addEdge(adjList,4, 2);
        printGraph(adjList,V);
        System.out.println("after removing edge {i,j} = {1,3}");
        removeEdge(adjList, 1,3); // deleting edge {i,j} = {1,3}
        printGraph(adjList,V);     // printing matrix after deleting an edge
        
    }
}