package h05;

public class WeatherBalloon implements Flying{
    protected int balloonNumber; //Identifikationsnummer

    //Konstruktor
    public WeatherBalloon(int balloonNumber){
        this.balloonNumber = balloonNumber;
    }

    @Override
    public String getIdentifier(){
        return "WeatherBalloon " + balloonNumber;
    }

    //Wetterballon anmelden
    public void start(){
        Airspace.get().register(this);
    }

    //Wetterballon abmelden
    public void pop(){
        Airspace.get().deregister(this);
    }
}
