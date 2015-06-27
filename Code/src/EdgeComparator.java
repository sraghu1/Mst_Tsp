import java.util.Comparator;


/**
 * @author Sabarish Raghu
 *
 * THis method is used to compare the edge weights
 */
public class EdgeComparator implements Comparator<SortedEdges>{
@Override
public int compare(SortedEdges e1,SortedEdges e2)
{
	if(e1.getEdgeWeight()>e2.getEdgeWeight())
	{
		return 1;
	}
	else if(e1.getEdgeWeight()<e2.getEdgeWeight())
	{
		return -1;
	}
	else
	{
		return 0;
	}
	
	
}
}
