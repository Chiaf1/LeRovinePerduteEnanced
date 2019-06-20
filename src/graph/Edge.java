package graph;

public class Edge implements Comparable<Edge> {

	private City startNode;
	private City endNode;
	private double weight;
	
	public Edge(City _startNode, City _endNode, double _weight) {
		startNode = _startNode;
		endNode = _endNode;
		weight = _weight;
	}
	
	@Override
	public String toString() {
		return String.format(startNode.getLabel() + " - " + endNode.getLabel() + " = " + weight);
	}
	

	public Node getStartNode() {
		return startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public double getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Edge e1) {
			return Double.compare(this.getWeight(), e1.getWeight());
	}
	
	public boolean equals(Edge edge) {
		boolean flag = false;
		if (this.startNode.equals(edge.getStartNode()) && this.endNode.equals(edge.getEndNode())
				&& (this.weight == edge.getWeight())) {
			flag = true;
		}
		if (this.startNode.equals(edge.getEndNode()) && this.endNode.equals(edge.getStartNode())
				&& (this.weight == edge.getWeight())) {
			flag = true;
		}
		return flag;
	}

}

