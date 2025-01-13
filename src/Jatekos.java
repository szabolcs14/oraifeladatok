public class Jatekos {
    private String nev;
    private int pozicio;

    public Jatekos(String nev) {
        this.nev = nev;
        this.pozicio = 0;
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

    public void lep(int lepesszam) {
        this.pozicio += lepesszam;
    }
}