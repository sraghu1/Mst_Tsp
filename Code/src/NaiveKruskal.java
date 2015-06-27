import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.Stack;
import java.util.TreeSet;


public class NaiveKruskal {
/**
 * This method finds the minimum spanning tree by a naive method of checking cycles using DFS
 * @param g Graph g which is an arraylist of nodes
 * @param adjacencyMatrix 
 */
public void findMSTKruskal(ArrayList<Node> g,double[][] adjacencyMatrix)
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
		mstadj[i-1][j-1]=candidateEdge.getEdgeWeight();
		mstadj[j-1][i-1]=candidateEdge.getEdgeWeight();
		if(checkDfsCycle(candidateEdge.getFromId()-1,mstadj,new ArrayList<Integer>(),candidateEdge.getFromId()-1)==0)
		{
			mstadj[i-1][j-1]=0.0;
			mstadj[j-1][i-1]=0.0;
		}
		else
		{
			covered.add(i);
			covered.add(j);
		}
	
	}
	if(edgeIterator.hasNext()){
	edgeIterator.next();}
}
long t2=System.currentTimeMillis();
long run=t2-t1;
System.out.println("*******Runtime*******"+run);
//out print
for(int i=0;i<g.size();i++)
{
	for(int j=0;j<g.size();j++)
	{
		int x=i+1;
		int y=j+1;
		System.out.print(+x+","+y+":  "+mstadj[i][j]+"  ");
	}
	System.out.println("\n");
}

}

/**
 * 
 * This method checks cylcle by DFS for all entries in mstadj, 
 * check the values 'j' > 0 and visit it. 
 * and check if both root and j are already in visited. 
 * If it has been already visited, cycle, Else call recursively and
 * pass root as j and j as prev root.
 * 
 * @param root
 * @param adjacencyMatrix
 * @param visited
 * @param callee
 * @return 0 if cycle, 1 if it doesnot have a cycle
 */
public int checkDfsCycle(int root,double[][] adjacencyMatrix,ArrayList<Integer> visited, int callee)
{
	for(int j=0;j<adjacencyMatrix[root].length;j++)
	{
		if(adjacencyMatrix[root][j]>0.0)
		{
			visited.add(root);
			//to exclude duplicate edges
			if(j!=callee){
			if(visited.contains(root)&&visited.contains(j))
			{
				//System.out.println("Cycle"+visited+"-----"+root+","+j);
				return 0;
				
			}
			else
			{
				//System.out.println(visited+"-----"+root+","+j);
				
				checkDfsCycle(j,adjacencyMatrix,visited,root);
			}}
		}
	}
	
	return 1;
}
}
