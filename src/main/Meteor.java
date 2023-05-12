package main;

import java.io.FileNotFoundException;

public class Meteor{
    int id;
    int cid = 1;
    Meteor_type type;
    Speed speed;
    Position mposition;

    public Meteor(Position mposition, Meteor_type type, Speed speed) {
        this.id = cid;
        cid++;
        this.mposition = mposition;
        this.type = type;
        this.speed = speed;
    }

    public Meteor_type getType() {
        return type;
    }

    public void setType(Meteor_type type) {
        this.type = type;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Position getMposition() {
        return mposition;
    }

    public void setMposition(Position mposition) {
        this.mposition = mposition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void travel(){
        this.mposition.setX(this.mposition.getX()+(this.getSpeed().Xspeed));
        this.mposition.setY(this.mposition.getY()+(this.getSpeed().Yspeed));
    }

    public boolean checkcollision(CorpsCeleste c) throws FileNotFoundException {
        double x1 = this.mposition.getX();
        double y1 = this.mposition.getY();
        double x2 = c.getPosition().getX();
        double y2 = c.getPosition().getY();
        double size = c.getSize();

        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        if(distance<=size){
            Singleton.getInstance().printcollision(c,this);
            return true;
        }

        return false;
    }

    public String toJSON(){
        return "{'x':"+this.getMposition().getX()+", 'y':"+this.getMposition().getY()+"}";
    }



}
