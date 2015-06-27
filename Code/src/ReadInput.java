import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/**
 * @author Sabarish Raghu
 *
 */
public class ReadInput {
/**
 * @param path
 * @return The graph
 */
public ArrayList<Node> readInputToObj(String path,String sep)
{
	ArrayList<Node> graph=new ArrayList<Node>();
	try
	{
	BufferedReader inputReader=new BufferedReader(new FileReader(new File(path)));
	//Read number of nodes
	inputReader.readLine();
	String line;
	while((line=inputReader.readLine())!=null)
	{
		Node node=new Node();
		String parts[]=line.split(sep);
		int nodeId=Integer.parseInt(parts[0]);
		double x=Double.parseDouble(parts[1]);
		double y=Double.parseDouble(parts[2]);
		node.setNodeId(nodeId);
		node.setX(x);
		node.setY(y);
		graph.add(node);
	}
	inputReader.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return graph;
}
}