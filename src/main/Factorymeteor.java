package main;

public class Factorymeteor {
    public static Meteor facto_met(Speed s, Position p,Meteor_type t){

        return new Meteor(p,t,s);

    }
}
