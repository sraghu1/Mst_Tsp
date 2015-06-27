import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.BinaryHeap;

/**
 * @author Sabarish Raghu
 * This class has the implementation to find Minimum spanning tree using heap to store edges
 *
 */
@SuppressWarnings("deprecation")
public class PrimsHeap {
	Set<Integer> covered=new HashSet<Integer>();
	ArrayList<SortedEdges> alledges=new ArrayList<SortedEdges>();
	
/**
 * @param graph
 * @param adjacencyMatrix
 * @return the edges in the MST
 */
public ArrayList<SortedEdges> getMSTSorted(ArrayList<Node> graph, double[][] adjacencyMatrix)
{
	BinaryHeap candidateEdges=new BinaryHeap(new EdgeComparator());
	Node initNode=graph.get(0);
	System.out.println("------Prim's Heap Implementation");
	long t1=System.currentTimeMillis();
	getRecursiveMST(initNode,candidateEdges,graph,adjacencyMatrix);
	long t2=System.currentTimeMillis();
	long run=t2-t1;
	System.out.println(run);
	return alledges;
}

/**
 * @param node
 * @param candidateEdges
 * @param graph
 * @param adjacencyMatrix
 */
private void getRecursiveMST(Node node, BinaryHeap candidateEdges,
		ArrayList<Node> graph, double[][] adjacencyMatrix) {
	// TODO Auto-generated method stub
	while(covered.size()<graph.size()){
		covered.add(node.getNodeId());
		ArrayList<SortedEdges> edges=node.getAdjacentEdges(graph, adjacencyMatrix,covered);
		candidateEdges.addAll(edges);
		SortedEdges candidateEdge=(SortedEdges) candidateEdges.peek();
		Node minNode=getNode(candidateEdge.getToId(),graph);
		if(!(covered.contains(candidateEdge.getFromId())&&covered.contains(candidateEdge.getToId())))
		{
			System.out.println(candidateEdge.getFromId()+"---->"+candidateEdge.getToId()+":  "+candidateEdge.getEdgeWeight());
			alledges.add(candidateEdge);
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
 * @return Node of corresponding node Id
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
