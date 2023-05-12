package main;

import com.sun.source.util.SourcePositions;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static main.Facto_enum.METEOR;

public class Launcher {
    private Position position;

    private List<Meteor> meteorlist = new ArrayList<>();

    private List<Meteor> trash = new ArrayList<>();
    private Random rng = new Random();
    public Launcher() {
        this.position = new Position(280000000,280000000);
    }

    public Position getPosition() {
        return position;
    }


    public List<Meteor> getMeteorlist() {
        return meteorlist;
    }

    public void setMeteorlist(List<Meteor> meteorlist) {
        this.meteorlist = meteorlist;
    }

    public void planetcrash(Planet p,int speed){

        double x1 = this.position.getX();
        double y1 = this.position.getY();

        double x2 = p.turnsim(speed).getX();
        double y2 = p.turnsim(speed).getY();

        double vx = (x2 - x1)/speed;
        double vy = (y2 - y1)/speed;

        int r = rng.nextInt(100);
        if(r>10){
        thrownormal(vx,vy);}
        else {
            throwkiller(vx,vy);
        }
    }


    public void thrownormal(double x, double y){
        Speed s = new Speed(x,y);
        Position p = new Position(this.getPosition().getX(), this.getPosition().getY());
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.NORMAL);
        meteorlist.add(m);
    }

    public void throwkiller(double x, double y){
        Speed s = new Speed(x,y);
        Position p = new Position(this.getPosition().getX(), this.getPosition().getY());
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.TUEUR);
        meteorlist.add(m);
    }

    public void printmeteor() throws FileNotFoundException {
        for (Meteor m : this.meteorlist) {
            Singleton.getInstance().addjson(m.toJSON());
        }
    }
    public void meteortavel(){
        for (Meteor m : this.meteorlist){
            m.travel();
        }
    }

    public void wcheckcollision(CorpsCeleste c,System_s s) throws FileNotFoundException {
        for (Meteor m : meteorlist) {
            if (m.checkcollision(c)) {
                System.out.println("Collision !!");
                trash.add(m);
            }
        }
        for (Meteor me : trash){
            if (me.getType() == Meteor_type.TUEUR){
            meteorlist.remove(me);
            s.ptrash((Planet) (c));
            }else {
                meteorlist.remove(me);
            }
        }
        trash.clear();
    }

}
