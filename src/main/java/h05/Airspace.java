package h05;

import java.util.HashSet;
import java.util.Set;


public class Airspace {

    private static Airspace INSTANCE = null;


    //Statische Methoden werden häufig für Hilfsmethoden verwendet, die unabhängig von einer Instanz der Klasse sind
    //um den Zugriff von äußeren Klassen zu erlauben!
    public static Airspace get() {
        if (INSTANCE == null) {
            INSTANCE = new Airspace();
        }
        return INSTANCE;
    }

    // TODO: H5.1.1 - Uncomment the following lines
    private final Set<Flying> flyingInAirspace = new HashSet<>();

    private Airspace(){

    }

    void register(Flying flying){
        flyingInAirspace.add(flying);
    }

    void deregister(Flying flying){
        flyingInAirspace.remove(flying);
    }

    void scanAirspace() {
        // TODO: H5.5
        System.out.println("Scanning...");
        if(flyingInAirspace.isEmpty()){
            System.out.println("Airspace is empty");
        }

        else{
            for(Flying f: flyingInAirspace){
                if(f.getClass().equals(PassengerPlane.class)){
                    System.out.println(f.getIdentifier() + " is flying in airspace (" + ((PassengerPlane) f).getPassengerCount() + " PAX)");
                }
               else {System.out.println(f.getIdentifier() + " is flying in airspace." );}
            }
        }


    }
}
