
public class DijkPair implements Comparable<DijkPair>{
	
	int destination;
	int weight;
	
	DijkPair(int destination,int weight)
	{
		this.destination = destination;
		this.weight = weight;
	}
	
	public int compareTo(DijkPair o)
	{
		return (this.weight - o.weight);
	}
}
