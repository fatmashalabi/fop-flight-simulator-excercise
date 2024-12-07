package h05;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // TODO: H5.6
        //1
        Airspace.get().scanAirspace();
        //2
        Runway runway1 = new Runway(2000);
        Runway runway2 = new Runway(4000);
        //3
        WeatherBalloon balloon = new WeatherBalloon(99);
        balloon.start();
        //4
        Tank tank1 = new Tank(FuelType.JetA);
        Tank tank2 = new Tank(FuelType.JetB);
        //5
        TankerPlane tankerPlane = new TankerPlane("D-ABCD", 10000, FuelType.JetA, 1000);
        tankerPlane.loadFuel(FuelType.AvGas, 100000);
        tankerPlane.loadFuel(FuelType.Biokerosin, 100000);
        //6
        PassengerPlane passengerPlane = new PassengerPlane("GAG-67", 10000, FuelType.JetA, 1700, 5);
        tank1.refuelPlane(passengerPlane);
        passengerPlane.board(100);
        passengerPlane.takeOff();
        //7
        Airspace.get().scanAirspace();
        //8
        CargoPlane cargoPlane = new CargoPlane("D-AFFF", 8000, FuelType.JetB, 1500);
        cargoPlane.loadContainer(1000);
        tank2.refuelPlane(cargoPlane);
        //9
        passengerPlane.disembark();
        //10
        Airspace.get().scanAirspace();
        //11
        cargoPlane.takeOff();
        cargoPlane.fly(1000);
        //12
        Airspace.get().scanAirspace();
        //13
        CombinedPlane combinedPlane = new CombinedPlane("D-ABBB", 9000, FuelType.AvGas, 10700, 5);
        tankerPlane.refuelPlane(combinedPlane);
        //14
        combinedPlane.board(30);
        combinedPlane.loadContainer(400);
        combinedPlane.takeOff();
        combinedPlane.fly(3000);
        //15
        Airspace.get().scanAirspace();
        //16
        runway1.land(combinedPlane);
        runway2.land(cargoPlane);
        //17
        Airspace.get().scanAirspace();
        //18
        balloon.pop();
        Airspace.get().scanAirspace();
        Airspace.get().scanAirspace();
    }
}
