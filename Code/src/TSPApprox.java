import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;


/**
 * @author Sabarish Raghu
 *
 */
public class TSPApprox {
		LinkedHashSet<Integer> visit=new LinkedHashSet<Integer>();
		ArrayList<Node> graph;
		ArrayList<Integer> tempList=new ArrayList<Integer>();
	    /**
	     * @param g
	     * @param adjacencyMatrix
	     */
	    public void findTSPApprox(ArrayList<Node> g, double[][] adjacencyMatrix)
	    {
	    	long t1=System.currentTimeMillis();
	    	graph=g;
	    	PrimsHeap ph=new PrimsHeap();
	    	
	    	ArrayList<SortedEdges> edges=ph.getMSTSorted(g, adjacencyMatrix);
	    	visitPreOrder(edges.get(0).getFromId(),edges);
	    	long t2=System.currentTimeMillis();
	    	long run=t2-t1;
	    	System.out.println("TSP runtime"+run);
	    	ArrayList<Integer> finalvisit=new ArrayList<Integer>(visit);
	    	finalvisit.add(edges.get(0).getFromId());
	    	for(int i:finalvisit)
	    	{
	    		System.out.println(i);
	    	}
	    	double tot=0.0;
	    	for(int i=0;i<finalvisit.size()-1;i++)
	    	{
	    		
	    		tot+=adjacencyMatrix[finalvisit.get(i)-1][finalvisit.get(i+1)-1];
	    	}
	    	System.out.println(tot);
	    }
	    
	    /**
	     * @param id
	     * @param edges
	     * @return the pre-order traversal of the given graph
	     */
	    public HashSet<Integer> visitPreOrder(int id,ArrayList<SortedEdges> edges)
	    {
	    	visit.add(id);
	    	if(!tempList.contains(id)){tempList.add(id);}
	    	for(SortedEdges edge:edges)
	    	{
	    		if(edge.fromId==id&&!(visit.contains(edge.fromId)&&visit.contains(edge.toId)))
	    		{
	    			visitPreOrder(edge.toId, edges);
	    		
	    		}
	    		}
	    	if(visit.size()<graph.size())
	    	{
	    		tempList.remove(tempList.size()-1);
	    		visitPreOrder(tempList.get(tempList.size()-1),edges);
	    	}
	    return visit;
	    }
	    
}
	