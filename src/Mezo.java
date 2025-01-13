import java.util.Random;

public class Mezo {
    private String tipus;
    private String leiras;

    public Mezo(String tipus, String leiras) {
        this.tipus = tipus;
        this.leiras = leiras;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public void effect(Jatekos jatekos) {
        switch (tipus) {
            case "normál":
                System.out.println(leiras);
                break;
            case "bónusz":
                int extraLepes = new Random().nextInt(3) + 1;
                System.out.println(jatekos.getNev() + " bónusz mezőre lépett! Kapsz " + extraLepes + " extra lépést!");
                jatekos.lep(extraLepes);
                break;
            case "akadály":
                int minuszLepes = new Random().nextInt(2) + 1;
                System.out.println(jatekos.getNev() + " akadály mezőre lépett! Vissza kell lépnie " + minuszLepes + " lépést!");
                jatekos.lep(-minuszLepes);
                break;
            case "visszadob":
                System.out.println(jatekos.getNev() + " visszadobás mezőre lépett! Visszakerült az első mezőre!");
                jatekos.setPozicio(0);
                break;
            case "cél":
                break;
            default:
                System.out.println("Ismeretlen mező típus.");
        }
    }
}
