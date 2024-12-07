package h05;

abstract public class Plane implements Flying {
    //klassenkonstante Treibstoffverbrauch in Liter je Kilometer je Kilogramm
    public static final double CONSUMPTION_PER_KM_KG = 1.1494e-4;
    //ICH MUSS NOCH ÜBERLEGEN BEI WELCHEM ATTRIBUT ALS FINAL DEKLARIEREN!
    String aircraftRegistration;  //Luftfahrzeugkennzeichen
    int baseWeight; //Leergewicht des Fahrzeugs ohne Ladung
    FuelType fuelType;  //Treibstoffart
    final double fuelCapacity; //maximale Menge des Treibstoffs
    double currentFuelLevel; //aktuelle Menge des Treibstoffs

    //Konstruktor
    public Plane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity) {
        this.aircraftRegistration = aircraftRegistration;
        this.baseWeight = baseWeight;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = 0.0;
    }


    @Override
    public String getIdentifier() {
        return aircraftRegistration;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getFuelCapacity(){
        return fuelCapacity;
    }

    public double getCurrentFuelLevel(){
        return currentFuelLevel;
    }

    public void refuel(double amount) {
       currentFuelLevel+= amount;
       if(currentFuelLevel > fuelCapacity) {
           System.out.println("The Tank of Plane " + aircraftRegistration + " has overflowed!");
           currentFuelLevel = fuelCapacity;
       }
    }

    // gibt die Geamstmasse eines Flugzeuges zurück
    abstract protected double mass();


    /**
     * gibt den Treibstoffverbrauch je geflogenen Kilometer zurück(Beschränkung auf den Effekt durch das Gewicht)
     * @return
     */
    protected double getFuelConsumptionPerKilometer(){
        //NICHT SICHER VON DIESER IMPLEMENTIERUNG
        return CONSUMPTION_PER_KM_KG * mass() * fuelType.getConsumptionMultiplicator();
    }


    /**
     * Berechnet die Menge an Teibstoff, die für das Zurücklegen der Strcke distance benötigt
     * @param distance gibt an, wie Weit das Flugzeug in Kilometern fliegen soll
     */
    public void fly(double distance){
        double neededFuel = getFuelConsumptionPerKilometer() * distance;
        if(neededFuel > currentFuelLevel) {
            System.out.println("Plane " + aircraftRegistration + " does not have enough fuel to fly " + distance + " km.");
        }

        if(neededFuel <= currentFuelLevel) {
        currentFuelLevel -= neededFuel;
        System.out.println("Plane " + aircraftRegistration + " flew " + distance + " km and has " + currentFuelLevel + " liters of fuel left.");
        }
    }

    /**
     *Hebt das FLugzeug ab, muss diese Methode aufgerufen werden
     */
    public void takeOff(){
        Airspace.get().register(this);
    }

    /**
     * Landet das FLugzeug, muss diese Methode aufgerufen werden
     */
    public void land(){
        Airspace.get().deregister(this);
    }






}

