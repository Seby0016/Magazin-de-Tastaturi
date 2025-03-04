public class TastaturaMecanica extends Tastatura {
    private boolean areLED;

    public TastaturaMecanica(String brand, String culoare, double pret, boolean areLED) {
        super(brand, culoare, pret);
        this.areLED = areLED;
    }

    public boolean isAreLED() {
        return areLED;
    }

    @Override
    public void descriere() {
        String statusLED = areLED ? "are LED-uri" : "nu are LED-uri";
        String statusVandut = isEsteVanduta() ? "vândută" : "disponibilă";
        System.out.println("Tastatura mecanică marca " + getBrand() + ", de culoare " + getCuloare() +
                ", " + statusLED + ", este " + statusVandut + " și costă " + getPret() + " RON.");
    }
}