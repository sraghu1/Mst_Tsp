import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Sabarish Raghu
 * 
 * This is the main runnable file of the class
 *
 */
public class myMain {
	 
	public static void main(String args[])
	{
		ArrayList<Node> graph;
		ReadInput reader=new ReadInput();
		graph=reader.readInputToObj(args[0],args[1]);
		double[][] adjacencyMatrix=calculateAdjacencyMatrix(graph);
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter the algorithm that you wish to implement");
		System.out.println("1. Naive Kruskal \n 2.Kruskal Union \n 3.Kruskal Union with path compression \n 4. Prim's Unsorted \n 5. Prim's Sorted 6.Prim's Heap \n 7. Travelling sales man Approximation");
		int choice=s.nextInt();
		switch(choice){
		case 1:
		{
		NaiveKruskal nk=new NaiveKruskal();
		nk.findMSTKruskal(graph, adjacencyMatrix);
		}
		case 2:
		{
		KruskalUnion ku=new KruskalUnion();
		ku.findMSTKruskalUnion(graph, adjacencyMatrix);
		}
		case 3:
		{
		KruskalUnionPath kup=new KruskalUnionPath();
		kup.findMSTKruskalUnion(graph, adjacencyMatrix);
		}
		case 4:
		{
		PrimUnsorted pu=new PrimUnsorted();
		pu.findMstPrim(graph, adjacencyMatrix);
		}
		case 5:
		{
		PrimSorted ps=new PrimSorted();
		ps.getMSTSorted(graph, adjacencyMatrix);
		}
		case 6:
		{
		PrimsHeap ph=new PrimsHeap();
		ph.getMSTSorted(graph, adjacencyMatrix);
		}
		case 7:
		{
		TSPApprox tsp=new TSPApprox();
		
		tsp.findTSPApprox(graph, adjacencyMatrix);
		}
		}
	} 

	/**
	 * This method calculates the adjacency matrix of the graph.
	 * @param graph
	 * @return adjacency matrix
	 */
	private static double[][] calculateAdjacencyMatrix(ArrayList<Node> graph) {
		// TODO Auto-generated method stub
		double[][] adjMatrix=new double[graph.size()][graph.size()];
		for(int i=0;i<graph.size();i++)
		{
			for(int j=0;j<graph.size();j++)
			{
			Node n1=graph.get(i);
			Node n2=graph.get(j);
			double x1=n1.getX();
			double y1=n1.getY();
			double x2=n2.getX();
			double y2=n2.getY();
			double dist=calcDistance(x1,y1,x2,y2);
			adjMatrix[i][j]=dist;
			}
		}
		return adjMatrix;
	}

	/**
	 * This method calculates the distance between 2 nodes
	 * @param x1 x coordinate of first node
	 * @param y1 y coordinate of first node
	 * @param x2 x coordinate of second node
	 * @param y2 y coordinate of second node
	 * @return the distance between the nodes
	 */
	private static double calcDistance(double x1, double y1, double x2, double y2) {
		
		double coeff=((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
		double dist=Math.sqrt(coeff);
		return dist;
		// TODO Auto-generated method stub
		
	}
}
