public class Registru {


    private Produs produsulVandut;
    private double pretVanzareProdus;
    private double venitCasa;


    public Registru(Produs produsulVandut, double pretVanzareProdus, double venitCasa) {
        this.produsulVandut = produsulVandut;
        this.pretVanzareProdus = pretVanzareProdus;
        this.venitCasa = venitCasa;
    }

    public void setProdus(Produs produs) {
        produsulVandut = produs;
    }

    public void setVanzare(double pret) {
        pretVanzareProdus = pret;
    }

    public void setVenit(double venit) {
        venitCasa = venit;
    }

    void printRegistru() {
        System.out.println("@@@@@printare elem registru");

        System.out.println("pretVanzare=" + pretVanzareProdus + " venit=" + venitCasa + " produsul este:");
        produsulVandut.printeazaProd();
    }

}
