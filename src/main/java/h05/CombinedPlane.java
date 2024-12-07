package h05;

public class CombinedPlane extends PassengerPlane implements CarriesCargo{
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


    //Konstruktor
    public CombinedPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity, int crewCount){
        super(aircraftRegistration, baseWeight, fuelType, fuelCapacity, crewCount);
    }

    /**
     *
     * @return gibt die Gesamtmasse des Frachtflugzeugs; entsprechts der Summe des Gewichts aller Container + Eigengewicht, Gewicht aller Personen, Gesamtgewichts des Gepäcks
     */
    @Override
    protected double mass(){
        return super.mass() + containers.getSum() + baseWeight;
    }

}
