package h05;

public class Runway {
    //Objektkonstante: Länge der Landebahn in Meter
    private final int runwayLength;

    //Konsturktor
    public Runway(int runwayLength){
        this.runwayLength = runwayLength;
    }

    //Nützlich für Vererbung, weil runwayLength ist vom Typ private
    public int getRunwayLength(){
        return runwayLength;
    }

    //static weil es sowas wie eine Klassenkonstante!
    public static double calculateLandingDistance(double mass){
        double bremsweg = mass / 40;
        return bremsweg;
    }


    /**
     *
     * @param plane
     * @return true nur wenn der Bremsweg kleiner gleich den 'runwayLength', sonst false
     */
    public boolean canLand(Plane plane){
        if(calculateLandingDistance(plane.mass()) <= getRunwayLength()){
            return true;
        }
        else {
            return false;
        }
    }


    public void land(Plane plane){
        if(canLand(plane)){
            plane.land();
            System.out.println("Plane " + plane.getIdentifier() + " has landed successfully.");
        }
        else{
            System.out.println("Plane "+ plane.getIdentifier() + " could not ladn. The runway is too short.");
        }
    }



}
