import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Sabarish Raghu
 * This class has the implementation to find Minimum spanning tree by using a naive method to store edges
 *
 */
public class PrimUnsorted {
	Set<Integer> covered=new HashSet<Integer>();
	
/**
 * @param graph
 * @param adjacencyMatrix
 */
public void findMstPrim(ArrayList<Node> graph,double[][] adjacencyMatrix)
{
	for(Node node:graph)
	{
		node.setKey(10000000);
	}
	graph.get(0).setKey(0.0); //setting one starting vertex.
	//Set<Integer> covered=new HashSet<Integer>();
	//Node u=graph.get(0); //select first node
	
	Set<SortedEdges> candidateEdges=new HashSet<SortedEdges>();
	Node initNode=graph.get(0);
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
private void getRecursiveMST(Node node, Set<SortedEdges> candidateEdges, ArrayList<Node> graph, double[][] adjacencyMatrix) {
	// TODO Auto-generated method stub
	while(covered.size()<graph.size()){
	covered.add(node.getNodeId());
	ArrayList<SortedEdges> edges=node.getAdjacentEdges(graph, adjacencyMatrix,covered);
	candidateEdges.addAll(edges);
	
	SortedEdges candidateEdge=getMinEdge(candidateEdges,graph);
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
 * @param candidateEdges
 * @param graph
 * @return the minimum of the candidate edges
 */
private SortedEdges getMinEdge(Set<SortedEdges> candidateEdges,ArrayList<Node> graph) {
	Iterator<SortedEdges> minIter=candidateEdges.iterator();
	double min=0.0;
	SortedEdges minEdge=null;
	if(minIter.hasNext()){
	SortedEdges edge=minIter.next();
	minEdge=edge;	
	min=edge.getEdgeWeight();
	}
	
	for(SortedEdges edge:candidateEdges){
	if(edge.getEdgeWeight()<min)
	{
		min=edge.getEdgeWeight();
		minEdge= edge;

	}
	}
	return minEdge;	
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
