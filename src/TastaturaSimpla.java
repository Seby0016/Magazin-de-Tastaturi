public class TastaturaSimpla extends Tastatura {

    public TastaturaSimpla(String brand, String culoare, double pret) {
        super(brand, culoare, pret);
    }

    @Override
    public void descriere() {
        String statusVandut = isEsteVanduta() ? "vândută" : "disponibilă";
        System.out.println("Tastatura simplă marca " + getBrand() + ", de culoare " + getCuloare() +
                ", este " + statusVandut + " și costă " + getPret() + " RON.");
    }
}