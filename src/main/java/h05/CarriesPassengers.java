package h05;

public interface CarriesPassengers {
    void board(int peopleCount); //Passagiere steigen in das Flugzeug ein
    void disembark(); //Alle Passagiere verlassen das Flugzeug
    int getPassengerCount(); //liefert die aktuelle Anzahl an Passagieren zurück

}
