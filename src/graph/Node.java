package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Edge> links = new ArrayList<>();
	//private List<Node> linkedNodes = new ArrayList<>();
	private int label;

	/*
	 * public Node(int label) { this.label = label; }
	 */
	protected void setLabel(int _myLabel) {
		label = _myLabel;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("\nNodo: " + " " + label + " ");
		for (Edge e : links) {
			str.append("\n" + e);
		}
		/*str.append("\nConnesso a:");
		for (Node n : linkedNodes) {
			str.append("\n" + n.label);
		}
		*/
		return str.toString();
	}

	public int getLabel() {
		return label;
	}
	
	/*
	public List<Node> getLinkedNodes() {
		return linkedNodes;
	}
	*/

	public List<Edge> getLinks() {
		return links;
	}
	
	/*
	public void setLinkedNodes(Node _linkedNode) {
		this.linkedNodes.add(_linkedNode);
	}
	*/

	public void addEdge(Edge newEdge) {
		links.add(newEdge);
	}

}
