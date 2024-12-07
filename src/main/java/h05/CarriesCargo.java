package h05;

public interface CarriesCargo {
    void loadContainer(int cargoWeight); //wird genutzt um einen Container mit Gewicht 'cargoWeight' zu laden in kgs
    boolean hasFreightLoaded();  //gibt nur true zurück falls mindestens ein Container geladen ist
    int unloadNextContainer(); //entlädt den nächsten Container und gibt das Gewicht dieses Containers zurück
}
