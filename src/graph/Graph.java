package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private List<City> nodes = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	private int numNodes = 0;
	
	
	/*
	public Graph(int nodes) {
		numNodes = nodes;
		for (int i = 0; i < nodes; i++) {
			this.nodes.add(new Node(i));
		}
	}
	*/
	public Graph() {
		
	}
	
	public List<City> getNodes() {
		return nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public int getNumNodes() {
		return numNodes;
	}
	
	public void addNode(City _myNode) {
		_myNode.setLabel(numNodes);
		numNodes++;
		nodes.add(_myNode);
	}
	/*
	public void addEdgeUnoriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	public void addEdgeUnoriented(int from, int to, double weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);

		if (!edges.contains(edge)) {
			//edge.getStartNode().setLinkedNodes(edge.getEndNode());
			//edge.getEndNode().setLinkedNodes(edge.getStartNode());
			edge.getStartNode().addEdge(edge);
			edge.getEndNode().addEdge(edge);
			edges.add(edge);
			nodes.get(from).addEdge(edge);
			//nodes.get(from).setLinkedNodes(nodes.get(to));
			nodes.get(to).addEdge(edge);
			//nodes.get(to).setLinkedNodes(nodes.get(from));
		}
	}

	public void addEdgeOriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}
	*/
	public void addEdgeOriented(int from, int to, double weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);

			//edge.getStartNode().setLinkedNodes(edge.getEndNode());
			edge.getStartNode().addEdge(edge);
			edges.add(edge);
			//nodes.get(from).addEdge(edge);
			//nodes.get(from).setLinkedNodes(nodes.get(to));

	}

	public Dijkstra dijkstra(int from, int to) {
		Dijkstra dk = new Dijkstra();
		if (!(from != to && (from < nodes.size() && from >= 0) && (to < nodes.size() && to >= 0))) {
			return null;
		}
		// riempio l'insieme toDo con tutti i nodi del grafo ed
		// inizializzo la distanza dall'origine ad infinito e
		// il nodo precendente a null
		for (int i = 0; i < this.nodes.size(); i++) {
			dk.addDist0(Double.POSITIVE_INFINITY);
			dk.addPrev(null);
			dk.addNodeToDo(i);
		}
		// setUp primo nodo
		dk.setDist0(from, 0.0);
		dk.setPrev(from, from);

		// continuo a scorrere la lista toDo finch� non la finisco
		while (dk.getToDo().size() != 0) {
			// dichiaro indAttNode con l'indice del nodo con distanza minima da 0 presente
			// nella lista toDo
			int indAttNode = dk.getMinDist0();
			Node attNode = nodes.get(indAttNode);
			// per ogni nodo adiacente al nodo sotto studio calcolo la distanza minima
			// passando dal nodo sotto esame se � inferiore alla distanza gi� presente la
			// sostituisco
			for (Iterator<Edge> iter = attNode.getLinks().iterator(); iter.hasNext();) {
				Edge e = iter.next();
				double calcDist = dk.getDist0(indAttNode) + e.getWeight();
				int indexE = e.getEndNode().getLabel();
				if (calcDist < dk.getDist0(indexE)) {
					dk.setDist0(indexE, calcDist);
					dk.setPrev(indexE, indAttNode);
				}
			}
			// rimuovo dalla lista toDo l'indice del nodo appena studiato
			dk.removeFromToDo(indAttNode);
		}

		// calcolo strada partendo dal nodo d'arrivo andando a ritroso seguendo i nodi
		// precedenti appena calcolati
		ArrayList<Node> app = new ArrayList<>();
		ArrayList<Node> route = new ArrayList<>();
		app.add(nodes.get(to));
		int indAttNode = nodes.get(to).getLabel();
		//finch� il nodo precedente non � uguale al nodo attuale continuo a ciclare
		while (dk.getPrev(indAttNode) != indAttNode) {
			app.add(nodes.get(dk.getPrev(indAttNode)));
			indAttNode = dk.getPrev(indAttNode);
		}
		//inverto la strada in modo da averla ordinata da from a to
		for (int i = 0; i < app.size(); i++) {
			route.add(app.get(i));
		}
		dk.setRoute(route);

		return dk;
	}

	/*
	public void aStar() {

	}
	*/

	public void print() {
		for (Node n : nodes) {
			System.out.println(n);
		}
		System.out.print("\n\n");
		for (Edge e : edges) {
			System.out.println(e + " ");
		}
	}
}
