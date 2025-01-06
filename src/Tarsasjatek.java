import java.util.*;

public class Tarsasjatek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Adja meg a játékosok számát (2-4): ");
        int jatekosSzam = sc.nextInt();
        sc.nextLine();

        if (jatekosSzam < 2 || jatekosSzam > 4) {
            System.out.println("A játék legalább 2 és legfeljebb 4 játékossal játszható.");
            return;
        }

        List<Jatekos> jatekosok = new ArrayList<>();
        for (int i = 0; i < jatekosSzam; i++) {
            System.out.print("Adja meg a " + (i + 1) + ". játékos nevét: ");
            String nev = sc.nextLine();
            jatekosok.add(new Jatekos(nev));
        }

        List<Mezo> tabla = new ArrayList<>(20);

        Set<Integer> semlegesMezok = new HashSet<>();
        Set<Integer> elonyosMezok = new HashSet<>();
        Set<Integer> hatranyosMezok = new HashSet<>();
        Random rand = new Random();

        while (semlegesMezok.size() < 10) {
            int index = rand.nextInt(20);
            semlegesMezok.add(index);
        }

        while (elonyosMezok.size() < 5) {
            int index = rand.nextInt(20);
            while (semlegesMezok.contains(index) || hatranyosMezok.contains(index)) {
                index = rand.nextInt(20);
            }
            elonyosMezok.add(index);
        }

        while (hatranyosMezok.size() < 5) {
            int index = rand.nextInt(20);
            while (semlegesMezok.contains(index) || elonyosMezok.contains(index)) {
                index = rand.nextInt(20);
            }
            hatranyosMezok.add(index);
        }

        for (int i = 0; i < 20; i++) {
            if (elonyosMezok.contains(i)) {
                tabla.add(new Mezo("bónusz", "Kapsz 1 extra lépést!"));
            } else if (hatranyosMezok.contains(i)) {
                tabla.add(new Mezo("akadály", "Vissza kell lépned 1-et!"));
            } else {
                tabla.add(new Mezo("normál", "Semmi különös, tovább léphetsz!"));
            }
        }

        tabla.set(19, new Mezo("cél", "Célvonal! Nyertél!"));

        int aktualisJatekosIndex = 0;

        while (true) {
            Jatekos aktualisJatekos = jatekosok.get(aktualisJatekosIndex);
            System.out.println(aktualisJatekos.getNev() + " következik.");

            int lepesszam = new Random().nextInt(6) + 1;

            String dobottSzam;
            switch (lepesszam) {
                case 1:
                    dobottSzam = "1-et";
                    break;
                case 2:
                    dobottSzam = "2-őt";
                    break;
                case 3:
                    dobottSzam = "3-at";
                    break;
                case 4:
                    dobottSzam = "4-et";
                    break;
                case 5:
                    dobottSzam = "5-öt";
                    break;
                case 6:
                    dobottSzam = "6-ot";
                    break;
                default:
                    dobottSzam = "";
            }

            System.out.println(aktualisJatekos.getNev() + " dobott " + dobottSzam + ".");

            int ujPozicio = aktualisJatekos.getPozicio() + lepesszam;

            if (ujPozicio > 20) {
                ujPozicio = 20;
            }

            aktualisJatekos.lep(ujPozicio - aktualisJatekos.getPozicio());

            if (aktualisJatekos.getPozicio() == 20) {
                System.out.println(aktualisJatekos.getNev() + " elérte a célvonalat! Nyert!");
                break;
            }

            if (aktualisJatekos.getPozicio() < tabla.size()) {
                Mezo aktualisMezo = tabla.get(aktualisJatekos.getPozicio());
                aktualisMezo.effect(aktualisJatekos);
            }

            aktualisJatekosIndex = (aktualisJatekosIndex + 1) % jatekosok.size();
        }
    }
}
