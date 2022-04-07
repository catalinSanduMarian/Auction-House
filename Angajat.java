import java.util.List;


interface Adaugare {
    void AdaugareProduse(List<Produs> listaProduse, Produs produs);
}

interface StergereDeProduse {

    void StergereProduse(List<Produs> listaProduse, Produs produs);
}


public class Angajat {

    private String nume;
    private String adresa;
    private int varsta;

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNume() {
        return nume;
    }
}