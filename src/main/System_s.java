package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class System_s {
    private String nom;
    private List<CorpsCeleste> corps = new ArrayList<>();
    private List<CorpsCeleste> ptrash = new ArrayList<>();

    public System_s(String nom) {
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<main.CorpsCeleste> getCorps() {
        return corps;
    }

    public void setCorps(List<main.CorpsCeleste> corps) {
        this.corps = corps;
    }
    public void addCorp(CorpsCeleste cc){
        corps.add(cc);
    }

    public void ptrash(Planet p){
        this.ptrash.add(p);
    }
    public CorpsCeleste findById(int id){
        for(CorpsCeleste cc : this.corps){
            if(cc.getId() == id){
                return cc;
            }
        }
        return null;
    }

    public void turnall(int j) throws FileNotFoundException {

        Logmachine l = new Logmachine();

        Launcher launch = new Launcher();

        List<Planet> planets = new ArrayList<>();
        Random random = new Random();

        int rcrash = 0 ;

        for (CorpsCeleste p : this.corps) {
            if (p.getClass() == Planet.class) {
                planets.add((Planet)p);
            }
        }



        for (int i = 0; i < j; i++) {

            launch.meteortavel();

            for (CorpsCeleste p : this.corps) {
                if (p.getClass() == Planet.class) {
                    ((Planet) p).turn();
                }
            }
            for (CorpsCeleste c: this.corps){
                launch.wcheckcollision(c,this);
                Singleton.getInstance().addjson(c.toJSON());
            }

            for (CorpsCeleste c : ptrash) {
                if (c.getClass() == Planet.class) {
                    for (Satellite s : ((Planet) c).satellites){
                        this.corps.remove(s);
                    }
                    this.corps.remove(c);
                } else {
                    ptrash.clear();
                }
            }


            if(rcrash %33 == 0) {
               int r = random.nextInt(planets.size());
               launch.planetcrash(planets.get(r),random.nextInt(300)+100);
            }
            rcrash++;


            launch.printmeteor();

            Singleton.getInstance().wcycle();

        }
        Singleton.getInstance().printlog();
    }
}
