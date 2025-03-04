import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        Scanner scanner = new Scanner(System.in);
        String optiune;

        do {
            System.out.println("\n1. Adaugă tastatură");
            System.out.println("2. Afișează inventarul");
            System.out.println("3. Marchează tastatură ca vândută");
            System.out.println("4. Șterge tastatură");
            System.out.println("5. Schimbă statusul magazinului (Deschis/Închis)");
            System.out.println("6. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextLine();

            switch (optiune) {
                case "1":
                    if (!magazin.isEsteDeschis()) {
                        System.out.println("Magazinul este închis.");
                        break;
                    }
                    System.out.println("Tip tastatură: ");
                    System.out.println("1. Simplă");
                    System.out.println("2. Mecanică");
                    System.out.print("Alegeți tipul de tastatură: ");
                    String tip = scanner.nextLine();

                    System.out.print("Introduceți brandul: ");
                    String brand = scanner.nextLine();
                    System.out.print("Introduceți culoarea: ");
                    String culoare = scanner.nextLine();
                    System.out.print("Introduceți prețul: ");
                    double pret;
                    try {
                        pret = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Prețul trebuie să fie un număr.");
                        break;
                    }

                    if (tip.equals("1")) {
                        magazin.adaugaTastatura(new Tastatura(brand, culoare, pret));
                    } else if (tip.equals("2")) {
                        System.out.print("Are LED-uri? (da/nu1): ");
                        boolean areLED = scanner.nextLine().trim().equalsIgnoreCase("yes");
                        magazin.adaugaTastatura(new TastaturaMecanica(brand, culoare, pret, areLED));
                    } else {
                        System.out.println("Opțiune invalidă!");
                    }
                    break;

                case "2":
                    if (!magazin.isEsteDeschis()) {
                        System.out.println("Magazinul este închis. ");
                        break;
                    }
                    magazin.afisareStoc();
                    break;

                case "3":
                    if (!magazin.isEsteDeschis()) {
                        System.out.println("Magazinul este închis. ");
                        break;
                    }
                    magazin.marcheazaCaVanduta(scanner);
                    break;

                case "4":
                    if (!magazin.isEsteDeschis()) {
                        System.out.println("Magazinul este închis.");
                        break;
                    }
                    magazin.stergeTastatura(scanner);
                    break;

                case "5":
                    magazin.setEsteDeschis(!magazin.isEsteDeschis());
                    System.out.println("Magazinul este acum " + (magazin.isEsteDeschis() ? "deschis" : "închis") + ".");
                    break;

                case "6":
                    System.out.println("La revedere!");
                    break;

                default:
                    System.out.println("Opțiune invalidă. Încercați din nou.");
            }
        } while (!optiune.equals("6"));

        scanner.close();
    }
}
