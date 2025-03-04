public class Tastatura {
    private String brand;
    private String culoare;
    private double pret;
    private boolean esteVanduta;

    public Tastatura(String brand, String culoare, double pret) {
        this.brand = brand;
        this.culoare = culoare;
        this.pret = pret;
        this.esteVanduta = false;
    }

    public String getBrand() {
        return brand;
    }

    public String getCuloare() {
        return culoare;
    }

    public double getPret() {
        return pret;
    }

    public boolean isEsteVanduta() {
        return esteVanduta;
    }

    public void setEsteVanduta(boolean esteVanduta) {
        this.esteVanduta = esteVanduta;
    }

    @Override
    public String toString() {
        return "Marca: " + brand + ", Culoare: " + culoare + ", Preț: " + pret + " RON, Disponibilitate: " +
                (esteVanduta ? "vândută" : "în stoc");
    }

    public void descriere() {
        System.out.println(toString());
    }
}