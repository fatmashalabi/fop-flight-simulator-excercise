package h05;

public class Tank implements Refuelling{
    private final FuelType fuelType;


    //Konstruktor
    public Tank(FuelType fuelType){
        this.fuelType = fuelType;
    }

    /**
     * Falls der eigene FuelType identisch mit dem FuelType des übergegebnen Parameters, soll es um den fehlenden Wert getankt werden!
     * Sonst wird eine Fehlermeldung ausgegeben
     * @param plane
     */
    @Override
    public void refuelPlane(Plane plane){
        if(plane.getFuelType().equals(fuelType)) {
            plane.refuel(plane.getFuelCapacity() - plane.getCurrentFuelLevel());
        }

        else {
            System.out.println("Tanken ist nicht möglich!");
        }
    }
}
