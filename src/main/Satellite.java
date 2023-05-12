package main;

import java.awt.*;

public class Satellite extends CorpsCeleste{

    private int revolution;
    private double revolution_current;
    private int distance_orbit;
    private int id_orbit;

    public Satellite(int id,String name, int size, int revolution, double revolution_current, int distance_orbit, Position position, int id_orbit) {
        super(id, name, size, position);
        this.revolution = revolution;
        this.revolution_current = revolution;
        this.distance_orbit = distance_orbit;
        this.id_orbit = id_orbit;
    }


    public double hour_to_degre(double h){
        return 360.0/this.getRevolution() * h;
    }

    public int getRevolution() {
        return revolution;
    }

    public void setRevolution(int revolution) {
        this.revolution = revolution;
    }

    public double getRevolution_current() {
        return revolution_current;
    }

    public void setRevolution_current(double revolution_current) {
        this.revolution_current = revolution_current;
    }

    public int getDistance_orbit() {
        return distance_orbit;
    }

    public void setDistance_orbit(int distance_orbit) {
        this.distance_orbit = distance_orbit;
    }

    public int getId_orbit() {
        return id_orbit;
    }

    public void setId_orbit(int id_orbit) {
        this.id_orbit = id_orbit;
    }

    public double hour_to_degre_s(double h){
        return 360.0/this.getRevolution() * h;
    }

    public void turn_s(Position p){

        //double rayon = (double)getDistance_orbit()/1000000;



        this.setRevolution_current(getRevolution_current()+hour_to_degre(24)) ;

        while(revolution_current>360){
            this.setRevolution_current(getRevolution_current()-360);
        }


        double x =(double)getDistance_orbit() * Math.cos(Math.toRadians(revolution_current));
        double y =(double)getDistance_orbit() * Math.sin(Math.toRadians(revolution_current));


        x += p.getX();
        y += p.getY();

        this.setPosition(new Position(x,y));

    }

}



