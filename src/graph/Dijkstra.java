package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Dijkstra {
	private ArrayList<Double> dist0 = new ArrayList<>();
	private ArrayList<Integer> prev = new ArrayList<>();
	private ArrayList<Integer> toDo = new ArrayList<>();
	private ArrayList<Node> route = new ArrayList<>();
	
	public ArrayList<Double> getDist0() {
		return dist0;
	}
	
	public Double getDist0(int i) {
		return dist0.get(i);
	}

	public ArrayList<Integer> getPrev() {
		return prev;
	}
	
	public Integer getPrev(int i) {
		return prev.get(i);
	}

	public ArrayList<Integer> getToDo() {
		return toDo;
	}
	
	public void addNodeToDo(Integer index) {
		toDo.add(index);
	}
	
	public void addDist0(Double val) {
		dist0.add(val);
	}
	
	public void setDist0(int index, Double val) {
		dist0.set(index, val);
	}
	
	public void addPrev(Integer val) {
		prev.add(val);
	}
	
	public void setPrev(int index, Integer val) {
		prev.set(index, val);
	}
	
	public void removeFromToDo(Integer index) {
		toDo.remove(index);
	}
	
	public int getMinDist0() {
		Double lower = Double.POSITIVE_INFINITY;
		for (Iterator<Integer> iter = toDo.iterator(); iter.hasNext();) {
			Double d = dist0.get(iter.next());
			if (lower.compareTo(d)>0) {
				lower = d;
			}
		}
		return dist0.indexOf(lower);
	}
	
	public void setRoute(ArrayList<Node> route) {
		this.route=route;
	}
	
	public ArrayList<Node> getRoute(){
		return route;
	}
	
}
