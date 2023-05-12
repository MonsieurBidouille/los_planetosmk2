package main;

import java.awt.*;
import java.math.BigDecimal;

public class CorpsCeleste {
    private int id;
    private String name;
    private int size;
    private Position position;


    public CorpsCeleste(int id, String name, int size, Position position) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.position = position;

    }

    public CorpsCeleste() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public  String doubleToString(Double d) {
        if (d == null)
            return null;
        if (d.isNaN() || d.isInfinite())
            return d.toString();

        return new BigDecimal(d.toString()).stripTrailingZeros().toPlainString();
    }

    public double distance(CorpsCeleste a){

       return Math.sqrt((Math.pow((this.getPosition().getX() + a.getPosition().getX()), 2)) + (Math.pow((this.getPosition().getY() + a.getPosition().getY()), 2)));
    }

    public double distancesun(){

        return Math.sqrt((Math.pow((this.getPosition().getX() + 0), 2)) + (Math.pow((this.getPosition().getY() + 0), 2)));
    }

    public String pos_to_string(){
        return "X : "+this.position.getX()+" Y : "+doubleToString(this.position.getY());
    }


    public String toJSON(){
        return "{'x':"+this.getPosition().getX()+", 'y':"+this.getPosition().getY()+"}";
    }


}
