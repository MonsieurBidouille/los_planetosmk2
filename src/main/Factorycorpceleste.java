package main;
import org.json.JSONObject ;

public class Factorycorpceleste {

        public static CorpsCeleste facto_cc(Facto_enum en, JSONObject cc){

            int id = cc.getInt("id");
            String name = cc.getString("name");
            int size = cc.getInt("size");
            JSONObject positionjson = cc.getJSONObject("position");
            Position position = new Position(positionjson.getDouble("x"), positionjson.getDouble("y"));


            switch (en){
                case PLANET -> {
                    return new Planet(id,name,size,cc.getInt("revolution"),cc.getDouble("revolution_current"),cc.getInt("distance_orbit"),position, cc.getInt("id_orbit"));
                }
                case SATELLITE -> {
                    return new Satellite(id,name,size,cc.getInt("revolution"), cc.getDouble("revolution_current"),cc.getInt("distance_orbit"),position, cc.getInt("id_orbit"));
                }
                case ETOILE -> {
                    return new Etoile(id,name,size,position);
                }


                default -> {
                    return null;
                }

            }

        }




}
