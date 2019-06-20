import XMLManager.DecodificatoreXML;
import XMLManager.StrutturaDati;
import graph.City;
import graph.Dijkstra;
import graph.Mappa;

public class Rovine {
    private static final String TAG_NAME = "id";
    private static final String TAG_TO = "to";
    private static final String TAG_LINK = "link";
    private static final String TAG_Z = "h";
    private static final String TAG_Y = "y";
    private static final String TAG_X = "x";
    private static final String TAG_CITY = "city";
    private DecodificatoreXML decoder = new DecodificatoreXML();
    private Mappa mapDist = new Mappa("luigi");
    private Mappa mapAlt = new Mappa("luca");

    public void acquisisciFile(String pathInputFile) {
        decoder.leggiFile(pathInputFile);

        StrutturaDati XMLmap = decoder.getFile();

        for (StrutturaDati s : XMLmap.getAttributi()) {
            if (s.getNome().equals(TAG_CITY)) {
                City newCity = new City(s.getTag(TAG_NAME), Double.valueOf(s.getTag(TAG_X)),
                        Double.valueOf(s.getTag(TAG_Y)), Double.valueOf(s.getTag(TAG_Z)));
                City newCity1 = new City(s.getTag(TAG_NAME), Double.valueOf(s.getTag(TAG_X)),
                        Double.valueOf(s.getTag(TAG_Y)), Double.valueOf(s.getTag(TAG_Z)));
                mapDist.addNode(newCity);
                mapAlt.addNode(newCity1);
            }
        }

        for (StrutturaDati s : XMLmap.getAttributi()) {
            if (s.getNome().equals(TAG_CITY)) {
                String cityName = s.getTag(TAG_NAME);
                for (StrutturaDati a : s.getAttributi()) {
                    if (a.getNome().equals(TAG_LINK)) {
                        City attCity = mapDist.getCitta(cityName);

                        int destIndex = Integer.valueOf(a.getTag(TAG_TO));
                        City destCity = (City) mapDist.getNodes().get(destIndex);

                        double dist = attCity.getCoordinate().distanceFrom(destCity.getCoordinate());

                        int labelC = attCity.getLabel();
                        mapDist.addEdgeOriented(labelC, destIndex, dist);

                    }
                }
            }
        }
        for (StrutturaDati s : XMLmap.getAttributi()) {
            if (s.getNome().equals(TAG_CITY)) {
                String cityName = s.getTag(TAG_NAME);
                for (StrutturaDati a : s.getAttributi()) {
                    if (a.getNome().equals(TAG_LINK)) {
                        City attCityDisl = mapAlt.getCitta(cityName);
                        int destIndex = Integer.valueOf(a.getTag(TAG_TO));
                        City destCityDisl = (City) mapDist.getNodes().get(destIndex);
                        double disLiv = attCityDisl.getCoordinate().dislivello(destCityDisl.getCoordinate());
                        int labelC = attCityDisl.getLabel();

                        mapAlt.addEdgeOriented(labelC, destIndex, disLiv);
                    }
                }
            }
        }

        Dijkstra prova = mapAlt.dijkstra(0,49);
        Dijkstra prova1 = mapDist.dijkstra(0,49);
    }
}
