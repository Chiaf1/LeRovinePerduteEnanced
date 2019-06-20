package graph;

public class City extends Node {
    private String nome;
    private Coordinate cord;

    public City(String _nome, double _x, double _y, double _z) {
        cord = new Coordinate(_x, _y, _z);

        nome = _nome;
    }

    public boolean equals(String _name) {
        return nome.equals(_name);
    }

    public String getNome() {
        return nome;
    }

    public Coordinate getCoordinate() {
        return cord;
    }

    public class Coordinate {
        private double x;
        private double y;
        private double z;

        public Coordinate(double _x, double _y, double _z) {
            x = _x;
            y = _y;
            z = _z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public double distanceFrom(Coordinate _partenza) {
            return Math.hypot((x - _partenza.getX()), (y - _partenza.getY()));
        }

        public double dislivello(Coordinate _partenza) {
            return Math.abs(z - _partenza.getZ());
        }
    }

}
