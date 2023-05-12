package main;

public class Droitep {
    Position p1;
    Position p2;

    public Droitep(Position p1, Position p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Position getP1() {
        return p1;
    }

    public void setP1(Position p1) {
        this.p1 = p1;
    }

    public Position getP2() {
        return p2;
    }

    public void setP2(Position p2) {
        this.p2 = p2;
    }
    double longueur(){
        return p1.distance(p2);
    }
}
