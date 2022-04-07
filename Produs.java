public class Produs {

    private int id;
    private String nume;
    private double pret_vanzare;
    private double pret_minim;


    public void setPid(int idP) {
        id = idP;
    }

    public void setPnume(String numeP) {
        nume = numeP;
    }

    public void setVanzare(double vanzare) {
        pret_vanzare = vanzare;
    }

    public double getMinim() {
        return pret_minim;
    }

    public void setMinim(double pret_minimP) {
        pret_minim = pret_minimP;
    }

    public void printeazaProd() {
        System.out.println("id=" + id + " nume=" + nume + " pret_vanzare=" + pret_vanzare + " pret_minim=" + pret_minim);
    }

    public int CheckId(int id_cautat) {
        if (id == id_cautat) {
            return 1;
        }
        return 0;
    }

}
