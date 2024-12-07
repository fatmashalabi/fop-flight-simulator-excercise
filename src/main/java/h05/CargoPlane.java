package h05;

public class CargoPlane extends Plane implements CarriesCargo{
     private final CargoStack containers = new CargoStack();
     /**
      * wird genutzt um einen Container mit Gewicht 'cargoWeight' zu laden in kgs
      */
     @Override
     public void loadContainer(int cargoWeight) {
     containers.push(cargoWeight);
     }

    /**
     *
     * @return gibt nur true zurück falls mindestens ein Container geladen ist
     */
     @Override
    public boolean hasFreightLoaded(){
     if(!containers.empty()) {
         return true;
     }
     return false;
     }

    /**
     *
     * @return entlädt den nächsten Container und gibt das Gewicht dieses Containers zurück
     */
     @Override
    public  int unloadNextContainer(){
         return containers.pop();
     }


    /**
     *
     * @return gibt die Gesamtmasse des Frachtflugzeugs; entsprechts der Summe des Gewichts aller Container Plus dem Eigengewicht
     */
     @Override
    protected double mass(){
         return containers.getSum() + baseWeight;
    }

    //Konstruktor
    public CargoPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity){
         super(aircraftRegistration, baseWeight, fuelType, fuelCapacity);
    }



}
