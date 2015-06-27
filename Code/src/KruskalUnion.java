import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Sabarish Raghu
 * This class has the kruskal's algorithm implementation with Union Find data structure without
 * Path compression. 
 *
 */
public class KruskalUnion {
	Hashtable<Integer,Integer> unionTable=new Hashtable<Integer,Integer>();
	
	/**
	 * This method finds the Minimum spanning tree with union find data structure to find cycles
	 * @param g The graph which is modeled to be an arraylist of nodes.
	 * @param adjacencyMatrix
	 */
	public void findMSTKruskalUnion(ArrayList<Node> g,double[][] adjacencyMatrix)
	{
	
	long t1=System.currentTimeMillis();
	TreeSet<SortedEdges> edgeList=new TreeSet<SortedEdges>(new MyComparator());
	for(int i=0;i<g.size();i++)
	{
		for(int j=0;j<g.size();j++)
		{
			if(i<j)
			{
				SortedEdges edge=new SortedEdges();
				edge.setEdgeWeight(adjacencyMatrix[i][j]);
				edge.setFromId(i+1);
				edge.setToId(j+1);
				edgeList.add(edge);
			}
		}
	}
	
	makeSet(g);
	Iterator<SortedEdges> edgeIterator=edgeList.iterator();
	double[][] mstadj=new double[g.size()][g.size()];
	Set<Integer> covered=new HashSet<Integer>();
	while(edgeIterator.hasNext()) //if all nodes are covered
	{
		while(covered.size()<g.size()&&edgeIterator.hasNext())
		{
			SortedEdges candidateEdge=edgeIterator.next();
			int i=candidateEdge.getFromId();
			int j=candidateEdge.getToId();
			if(find(i)!=find(j))
			{
				union(i,j);
				mstadj[i-1][j-1]=candidateEdge.getEdgeWeight();
				mstadj[j-1][i-1]=candidateEdge.getEdgeWeight();
				covered.add(i);
				covered.add(j);
			}
			else
				
			{
				System.out.println("Cycle");
			}
		}
		if(edgeIterator.hasNext()){
			edgeIterator.next();}
	}
	for(int i=0;i<g.size();i++)
	{
		for(int j=0;j<g.size();j++)
		{
			int x=i+1;
			int y=j+1;
			if(mstadj[i][j]>0)
			System.out.print(+x+","+y+":  "+mstadj[i][j]+"  ");
		}
		System.out.println("\n");
	}
	long t2=System.currentTimeMillis();
	long run=t2-t1;
	System.out.println("***** Runtime *****"+run);
	}
	
	/**
	 * This method is used to find the representative of the node in the union find data structure
	 * @param i NodeId of the Node
	 * @return the representative of the set
	 */
	private int find(int i) {
		// TODO Auto-generated method stub
		int x = i;
		
		if(unionTable.get(i)!=i)
		{
		x= find(unionTable.get(i));
		}
		else
		{
			
		
		}
		return x;
	}
	
	/**
	 * This method creates and adds to the table its nodeid as the set name and parent as its nodeid
	 * @param g Graph which is the array list of nodes
	 */
	private void makeSet(ArrayList<Node> g)
	{
		for(Node node:g)
		{
			unionTable.put(node.getNodeId(), node.getNodeId());
		}
	}
	
	/**
	 * This method is used to union 2 nodes
	 * @param x NodeId of node 1
	 * @param y NodeId of node 2
	 */
	private void union(int x,int y)
	{
		unionTable.put(y, x);
	}

}
