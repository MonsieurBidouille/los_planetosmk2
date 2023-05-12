package main;

import com.sun.source.util.SourcePositions;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static main.Facto_enum.METEOR;

public class Launcher {
    private Position position;

    private List<Meteor> meteorlist = new ArrayList<>();

    public Launcher() {
        this.position = new Position(280000000,280000000);;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Meteor> getMeteorlist() {
        return meteorlist;
    }

    public void setMeteorlist(List<Meteor> meteorlist) {
        this.meteorlist = meteorlist;
    }

    public void planetcrash(Planet p){

        double x1 = this.position.getX();
        double y1 = this.position.getY();

        double x2 = p.turnsim(100).getX();
        double y2 = p.turnsim(100).getY();

        double vx = (x2 - x1)/100;
        double vy = (y2 - y1)/100;

        thrownormal(vx,vy);
    }


    public void thrownormal(double x, double y){
        Speed s = new Speed(x,y);
        Position p = this.getPosition();
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.NORMAL);
        meteorlist.add(m);
    }

    public void throwkiller(double x, double y){
        Speed s = new Speed(x,y);
        Position p = this.getPosition();
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.TUEUR);
        meteorlist.add(m);
    }

    public void printmeteor() throws FileNotFoundException {
        for (Meteor m : this.meteorlist) {
            Singleton.getInstance().addjson(m.toJSON());
        }
    }
    public void turnmeteor(){
        for (Meteor m : this.meteorlist){
            m.travel();
        }
    }

    public void wcheckcollision(CorpsCeleste c) throws FileNotFoundException {
        for (Meteor m : this.meteorlist){
            if(m.checkcollision(c)){
                System.out.println("ouuui");
              // meteorlist.remove(m);
            }
        }
    }

}
