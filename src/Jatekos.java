public class Jatekos {
    private String nev;
    private int pozicio;
    private int penz;

    public Jatekos(String nev) {
        this.nev = nev;
        this.pozicio = 0;
        this.penz = 100;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getPozicio() {
        return pozicio;
    }

    public void setPozicio(int pozicio) {
        this.pozicio = pozicio;
    }

    public int getPenz() {
        return penz;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public void lep(int lepesszam) {
        this.pozicio += lepesszam;
        System.out.println(nev + " lépett " + lepesszam + " mezőt, most a " + pozicio + ". mezőn áll.");
    }

    public void modositPenz(int osszeg) {
        this.penz += osszeg;
        System.out.println(nev + " új pénzösszege: " + penz);
    }
}
