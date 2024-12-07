package h05;

import java.util.Arrays;

public class TankerPlane extends Plane implements Refuelling{
    //Tankerplane
    private final double[] availableAmount = new double[FuelType.values().length];

    //Konstruktor
    public TankerPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity){
        super(aircraftRegistration, baseWeight, fuelType, fuelCapacity);
    }

    /**
     * Treibstoffe auffüllen
     * @param fuelType
     * @param amount
     */
    //Bei Aufruf der Methode wird availableAmount an der entsprechenden Stelle im Array um die übergegebene Menge amount erhöht!
    public void loadFuel(FuelType fuelType, double amount){
        availableAmount[fuelType.ordinal()] += amount;
    }

    /**
     * return die Masse des TankerPlane(baseWeight, summierte Menge aller Treibstoffarten)
     */
    @Override
    public double mass(){
        double sumFuel = 0.0;
        //sumFuel = Arrays.stream(availableAmount).sum(); funktioniert auch!
        for(double fuel : availableAmount){
            sumFuel += fuel;
        }
        return baseWeight + sumFuel;
    }

    /**
     * Flugzeug auftanken
     * @param plane
     */
    @Override
    public  void refuelPlane(Plane plane){
      double neededFuel =  plane.getFuelCapacity() - plane.getCurrentFuelLevel();
      double availableFuel = availableAmount[plane.getFuelType().ordinal()]; //gibt den Wert von Treibstff des entsprechenden FuelTypes im Tankerplane
      double fuelAmount = Math.min(neededFuel, availableFuel);
      availableAmount[plane.getFuelType().ordinal()] -= fuelAmount;
      plane.refuel(fuelAmount);

    }

}
