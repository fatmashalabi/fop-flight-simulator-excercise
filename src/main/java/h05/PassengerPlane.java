package h05;

public class PassengerPlane extends Plane implements CarriesPassengers{
    private int passengerCount = 0;  //speichert die aktuelle Anzahl an Passagieren
    private final int crewCount; //Objektkonstante: damit sicherstellen, dass wichtige Attribute einer Instanz unverändert bleiben, nachdem sie initialisiert wurden.
    //Klassenkonstanten
    protected static final char AVERAGE_PEOPLE_WEIGHT = 100;
    protected static final char AVERAGE_LUGGAGE_WEIGHT = 15;


    /**
     * lädt alle Passagiere ein
     * @param peopleCount
     */
   @Override
    public void board(int peopleCount){
        passengerCount+= peopleCount;
    }

    /**
     * entlädt alle Passagiere
     */
    @Override
    public void disembark(){
       passengerCount = 0;
    }

    /**
     *
     * @return die aktuelle Anzahl an Passagieren
     */
    @Override
    public int getPassengerCount(){
        return passengerCount;
    }


    /**
     * Constructor
     * @param aircraftRegistration
     * @param baseWeight
     * @param fuelType
     * @param fuelCapacity
     * @param crewCount: gibt an aus wie vielen Personen die Crew des Passagierflugzeugs besteht
     */
    public PassengerPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity, int crewCount){
        super(aircraftRegistration, baseWeight, fuelType, fuelCapacity); //Verrebung
        this.crewCount = crewCount;
    }

    /**
     *
     * @return Gesamtgewicht des Flugzeugs(Eigengewicht, Gewicht aller Personen, Gesamtgewichts des Gepäcks)
     */
    @Override
    protected double mass(){
        return baseWeight + (passengerCount + crewCount) * AVERAGE_PEOPLE_WEIGHT + passengerCount * AVERAGE_LUGGAGE_WEIGHT;
    }




}
