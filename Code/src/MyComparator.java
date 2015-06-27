import java.util.Comparator;

/**
 * @author Sabarish Raghu
 *
 * This method is used to compare the edge weights
 */
public class MyComparator implements Comparator<SortedEdges>{
@Override
public int compare(SortedEdges e1,SortedEdges e2)
{
	if(e1.getEdgeWeight()>e2.getEdgeWeight())
	{
		return 1;
	}
	else {
		return -1;
	}
	
	
	
}
}
