import java.util.*;

public class Tarsasjatek {

    public static void main(String[] args) {
        // A mezők véletlenszerű elhelyezése
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
    }
}
