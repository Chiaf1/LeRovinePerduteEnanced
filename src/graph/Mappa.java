package graph;

public class Mappa extends Graph {

	private String name;
	
	public Mappa(String _name) {
		super();
		name = _name;
	}

	public City getCitta(String _nome) {
		for (int i = 0;i<super.getNodes().size(); i++) {
			City myCity = (City) super.getNodes().get(i);
			if (myCity.equals(_nome)){
				return myCity;
			}
		}
		return null;
	}
	
	
}
