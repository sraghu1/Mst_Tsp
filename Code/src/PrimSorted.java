import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Sabarish Raghu
 *
 */
public class PrimSorted {
	Set<Integer> covered=new HashSet<Integer>();
/**
 * @param graph
 * @param adjacencyMatrix
 */
public void getMSTSorted(ArrayList<Node> graph, double[][] adjacencyMatrix)
{
	TreeSet<SortedEdges> candidateEdges=new TreeSet<SortedEdges>(new EdgeComparator());
	Node initNode=graph.get(0);
	System.out.println("------Prim's Sorted Implementation");
	long t1=System.currentTimeMillis();
	getRecursiveMST(initNode,candidateEdges,graph,adjacencyMatrix);
	long t2=System.currentTimeMillis();
	long run=t2-t1;
	System.out.println(run);
}

/**
 * @param node
 * @param candidateEdges
 * @param graph
 * @param adjacencyMatrix
 */
private void getRecursiveMST(Node node, TreeSet<SortedEdges> candidateEdges,
		ArrayList<Node> graph, double[][] adjacencyMatrix) {
	// TODO Auto-generated method stub
	while(covered.size()<graph.size()){
		covered.add(node.getNodeId());
		ArrayList<SortedEdges> edges=node.getAdjacentEdges(graph, adjacencyMatrix,covered);
		candidateEdges.addAll(edges);
		SortedEdges candidateEdge=candidateEdges.first();
		Node minNode=getNode(candidateEdge.getToId(),graph);
		if(!(covered.contains(candidateEdge.getFromId())&&covered.contains(candidateEdge.getToId())))
		{
			System.out.println(candidateEdge.getFromId()+"---->"+candidateEdge.getToId()+":  "+candidateEdge.getEdgeWeight());
			candidateEdges.remove(candidateEdge);
			
			getRecursiveMST(minNode,candidateEdges,graph,adjacencyMatrix);
	
		}
		else
		{
			candidateEdges.remove(candidateEdge);
		}
	
	
	
	
	
	}
}

/**
 * @param i
 * @param graph
 * @return the node corresponding to the NodeId
 */
private Node getNode(int i, ArrayList<Node> graph) {
	// TODO Auto-generated method stub
	for(Node node:graph)
	{
		if(node.getNodeId()==i)
		{
			return node;
		}
	}
	return new Node();
}
}
