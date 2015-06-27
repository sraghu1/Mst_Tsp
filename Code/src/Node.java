import java.util.ArrayList;
import java.util.Set;


/**
 * @author Sabarish Raghu
 * THis is a model class for Nodes
 *
 */
public class Node {
int nodeId;
public int getNodeId() {
	return nodeId;
}
public void setNodeId(int nodeId) {
	this.nodeId = nodeId;
}
public double getX() {
	return x;
}
public void setX(double x2) {
	this.x = x2;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
double x;
double y;
double key;//used for prim's algorithm
public double getKey() {
	return key;
}
public void setKey(double key) {
	this.key = key;
}
/**
 * @param graph
 * @param adjacencyMatrix
 * @param covered
 * @return adjacent edges
 */
public ArrayList<SortedEdges> getAdjacentEdges(ArrayList<Node> graph,double[][] adjacencyMatrix,Set<Integer> covered) {
	// TODO Auto-generated method stub
	ArrayList<SortedEdges> edges=new ArrayList<SortedEdges>();
	for(int i=0;i<adjacencyMatrix[this.getNodeId()-1].length;i++)
	{
		if(adjacencyMatrix[this.getNodeId()-1][i]>0.0 &&!(covered.contains(this.getNodeId())&&covered.contains(i+1)))
		{
			SortedEdges edge=new SortedEdges();
			edge.setFromId(this.getNodeId());
			edge.setToId(i+1);
			edge.setEdgeWeight(adjacencyMatrix[this.getNodeId()-1][i]);
			edges.add(edge);
		}
			
		
	}
	
	return edges;
}

}
