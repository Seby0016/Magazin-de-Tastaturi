    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Magazin {
        private boolean esteDeschis;
        private List<Tastatura> stoc;

        public Magazin() {
            this.esteDeschis = true;
            this.stoc = new ArrayList<>();
        }

        public boolean isEsteDeschis() {
            return esteDeschis;
        }

        public void setEsteDeschis(boolean esteDeschis) {
            this.esteDeschis = esteDeschis;
        }

        public void adaugaTastatura(Tastatura tastatura) {
            stoc.add(tastatura);
            System.out.println("Tastatura a fost adăugată în inventar.");
        }

        public void afisareStoc() {
            if (stoc.isEmpty()) {
                System.out.println("Nu există tastaturi în stoc.");
            } else {
                System.out.println("Inventarul magazinului:");
                for (int i = 0; i < stoc.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    stoc.get(i).descriere();
                }
            }
        }

        public void marcheazaCaVanduta(Scanner scanner) {
            if (stoc.isEmpty()) {
                System.out.println("Nu există tastaturi în stoc.");
                return;
            }

            System.out.println("Selectați numărul tastaturii pe care doriți să o marcați ca vândută:");
            afisareStoc();
            int index;
            try {
                index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index < 0 || index >= stoc.size()) {
                    System.out.println("Număr invalid. Încercați din nou.");
                    return;
                }
                Tastatura tastatura = stoc.get(index);

                System.out.print("Introduceți numele cumpărătorului: ");
                String nume = scanner.nextLine();
                System.out.print("Introduceți email-ul cumpărătorului: ");
                String email = scanner.nextLine();
                System.out.print("Introduceți metoda de plată (card/cash): ");
                String metodaPlata = scanner.nextLine();

                tastatura.setEsteVanduta(true);


                salveazaInFisier(tastatura, nume, email, metodaPlata);

                System.out.println("Tastatura a fost marcată ca vândută și datele au fost salvate.");
            } catch (NumberFormatException e) {
                System.out.println("Introduceți un număr valid.");
            }
        }

        private void salveazaInFisier(Tastatura tastatura, String nume, String email, String metodaPlata) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("vanzari.txt", true))) {
                writer.write("Tastatura vândută:\n");
                writer.write(tastatura.toString() + "\n");
                writer.write("Cumpărător: " + nume + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Metoda de plată: " + metodaPlata + "\n");
                writer.write("-----------------------------\n");
            } catch (IOException e) {
                System.out.println("Eroare la salvarea în fișier: " + e.getMessage());
            }
        }

        public void stergeTastatura(Scanner scanner) {
            if (stoc.isEmpty()) {
                System.out.println("Nu există tastaturi în stoc.");
                return;
            }

            System.out.println("Selectați numărul tastaturii pe care doriți să o ștergeți:");
            afisareStoc();
            int index;
            try {
                index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index < 0 || index >= stoc.size()) {
                    System.out.println("Număr invalid. Încercați din nou.");
                    return;
                }
                Tastatura tastatura = stoc.remove(index);
                System.out.println("Tastatura marca " + tastatura.getBrand() + " a fost eliminată din inventar.");
            } catch (NumberFormatException e) {
                System.out.println("Introduceți un număr valid.");
            }
        }
    }