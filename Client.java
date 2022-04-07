import java.util.concurrent.ThreadLocalRandom;


public class Client {

    private int id;
    private String nume;
    private String adresa;
    private int numarParticipari;
    private int nr_licitatii_castigate;
    private double pretMaximOferit = 0;
    private double capital;

    public Client() {
        id = 0;
        nume = "gol";
        adresa = "gol";
        numarParticipari = 0;
        nr_licitatii_castigate = 0;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public String getAdresa() {
        return adresa;
    }

    void setAdresa(String adresaC) {
        adresa = adresaC;
    }

    public int getNr_licitatii_castigate() {
        return nr_licitatii_castigate;
    }

    public void setNr_licitatii_castigate(int nr_licitatii_castigate) {
        this.nr_licitatii_castigate = nr_licitatii_castigate;
    }

    public String getNume() {
        return nume;
    }

    void setNume(String numeC) {
        nume = numeC;
    }

    public int getId() {
        return id;
    }

    void setId(int idC) {
        id = idC;
    }

    void setPretMaxim(double pret) {
        pretMaximOferit = pret;
    }

    void setWins(int nr_licitatii_castigate) {
        this.nr_licitatii_castigate = nr_licitatii_castigate;
    }

    int getNumarParticipari() {
        return this.numarParticipari;
    }

    void setNumarParticipari(int numarParticipari) {
        this.numarParticipari = numarParticipari;
    }

    void printTOT() {
        System.out.println("id=" + id + " nume=" + nume + " adresa=" + adresa + " numarParticipari=" + numarParticipari +
                " nr_licitatii_castigate=" + nr_licitatii_castigate + "suma max lic=" + pretMaximOferit);

    }


    public void aCastigat() {
        nr_licitatii_castigate = nr_licitatii_castigate + 1;
    }


    public int getIdC() {
        return id;
    }

    public double liciteaza(double minim) {
        if (minim > pretMaximOferit) {
            return pretMaximOferit;
        }
        return ThreadLocalRandom.current().nextDouble(minim, pretMaximOferit);

    }


}