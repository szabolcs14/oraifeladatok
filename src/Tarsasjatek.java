import java.util.*;

public class Tarsasjatek {

    public static void main(String[] args) throws InterruptedException {
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
        Set<Integer> visszadoboMezok = new HashSet<>();
        Random rand = new Random();

        while (semlegesMezok.size() < 10) {
            int index = rand.nextInt(20);
            semlegesMezok.add(index);
        }

        while (elonyosMezok.size() < 5) {
            int index = rand.nextInt(20);
            while (semlegesMezok.contains(index) || hatranyosMezok.contains(index) || visszadoboMezok.contains(index)) {
                index = rand.nextInt(20);
            }
            elonyosMezok.add(index);
        }

        while (hatranyosMezok.size() < 4) {
            int index = rand.nextInt(20);
            while (semlegesMezok.contains(index) || elonyosMezok.contains(index) || visszadoboMezok.contains(index)) {
                index = rand.nextInt(20);
            }
            hatranyosMezok.add(index);
        }

        while (visszadoboMezok.size() < 1) {
            int index = rand.nextInt(20);
            while (semlegesMezok.contains(index) || elonyosMezok.contains(index) || hatranyosMezok.contains(index)) {
                index = rand.nextInt(20);
            }
            visszadoboMezok.add(index);
        }

        for (int i = 0; i < 20; i++) {
            if (elonyosMezok.contains(i)) {
                tabla.add(new Mezo("bónusz", "Kapsz 1 vagy 2 extra lépést!"));
            } else if (hatranyosMezok.contains(i)) {
                tabla.add(new Mezo("akadály", "Vissza kell lépned 1 vagy 2 mezőt!"));
            } else if (visszadoboMezok.contains(i)) {
                tabla.add(new Mezo("visszadob", "Visszadob az elejére!"));
            } else {
                tabla.add(new Mezo("normál", "Semmi különös, tovább léphetsz!"));
            }
        }

        tabla.set(19, new Mezo("cél", "Célvonal! Nyertél!"));

        int aktualisJatekosIndex = 0;

        while (true) {
            Jatekos aktualisJatekos = jatekosok.get(aktualisJatekosIndex);
            System.out.println(aktualisJatekos.getNev() + " következik. Nyomj Entert a dobáshoz!");

            sc.nextLine();

            int lepesszam = porgoDobas();

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

                if (aktualisMezo.getTipus().equals("bónusz")) {
                    int extraLepes = rand.nextInt(2) + 1;
                    System.out.println(aktualisJatekos.getNev() + " bónusz mezőre lépett! Kapsz " + extraLepes + " bónusz lépést.");
                    aktualisJatekos.lep(extraLepes);
                    System.out.println(aktualisJatekos.getNev() + " előrelépett " + extraLepes + " mezőt, most a " + aktualisJatekos.getPozicio() + ". mezőn áll.");
                } else if (aktualisMezo.getTipus().equals("akadály")) {
                    int minuszLepes = rand.nextInt(2) + 1;
                    System.out.println(aktualisJatekos.getNev() + " akadály mezőre lépett! Vissza kell lépned " + minuszLepes + " mezőt.");
                    aktualisJatekos.lep(-minuszLepes);
                    System.out.println(aktualisJatekos.getNev() + " visszalépett " + minuszLepes + " mezőt, most a " + aktualisJatekos.getPozicio() + ". mezőn áll.");
                } else if (aktualisMezo.getTipus().equals("visszadob")) {
                    System.out.println(aktualisJatekos.getNev() + " akadály mezőre lépett! Visszadob az elejére!");
                    aktualisJatekos.setPozicio(0);
                    System.out.println(aktualisJatekos.getNev() + " most az " + aktualisJatekos.getPozicio() + ". mezőn áll.");
                } else {
                    System.out.println(aktualisJatekos.getNev() + " normál mezőre lépett! Semmi különös, tovább léphetsz!");
                    System.out.println(aktualisJatekos.getNev() + " a/z " + aktualisJatekos.getPozicio() + ". mezőn áll.");
                }
            }

            aktualisJatekosIndex = (aktualisJatekosIndex + 1) % jatekosok.size();
        }
    }

    public static int porgoDobas() throws InterruptedException {
        Random rand = new Random();
        int szam = 0;
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 3000) {
            szam = rand.nextInt(6) + 1;
            System.out.print("\rDobás: " + szam);
            Thread.sleep(100);
        }
        System.out.println();
        return szam;
    }
}