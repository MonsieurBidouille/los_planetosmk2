package main;

import com.sun.source.util.SourcePositions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Planet extends CorpsCeleste{
    List<Satellite> satellites = new ArrayList<>();
    private int revolution;
    private double revolution_current;
    private int distance_orbit;
    private int id_orbit;


    public Planet() {
        super();
    }

    public Planet(int id,String name, int size, int revolution, double revolution_current, int distance_orbit, Position position, int id_orbit) {
        super(id,name, size,  position);
        this.distance_orbit = distance_orbit;
        this.revolution = revolution;
        this.revolution_current = revolution_current;
        this.id_orbit = id_orbit;
    }
    
    public void add_satellite(Satellite s){
        satellites.add(s);
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
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

    public void addSatellite(Satellite s){
        satellites.add(s);
    }


    public double hour_to_degre(double h){
        return 360.0/this.getRevolution() * h;
    }

    public Position turnsim(int t){

        double cr = this.getRevolution_current();

        double x = 0;
        double y = 0;

        for(int i = 0; i < t; i++) {

            //double rayon = (double)getDistance_orbit()/1000000;

            this.setRevolution_current(getRevolution_current() + hour_to_degre(24));

            while (revolution_current > 360) {
                this.setRevolution_current(getRevolution_current() - 360);
            }

            x = (double) getDistance_orbit() * Math.cos(Math.toRadians(revolution_current));
            y = (double) getDistance_orbit() * Math.sin(Math.toRadians(revolution_current));

        }
        this.setRevolution_current(cr);


        return new Position(x,y);
    }

    public void turn(){


        //double rayon = (double)getDistance_orbit()/1000000;

        this.setRevolution_current(getRevolution_current()+hour_to_degre(24))  ;

        while(revolution_current>360){
            this.setRevolution_current(getRevolution_current()-360);
        }

        double x = (double)getDistance_orbit() * Math.cos(Math.toRadians(revolution_current));
        double y = (double)getDistance_orbit() * Math.sin(Math.toRadians(revolution_current));

        this.setPosition(new Position(x,y));

        for(Satellite s:satellites){
            s.turn_s(this.getPosition());
        }
    }

}
