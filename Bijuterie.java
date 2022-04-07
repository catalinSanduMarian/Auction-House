public class Bijuterie extends Produs {

    private String material;
    private Boolean piatraPretioasa;

    public Boolean getPiatraPretioasa() {
        return piatraPretioasa;
    }

    public String getMaterial() {
        return material;
    }

    void setMaterial(String material) {
        this.material = material;
    }

    void setPP(Boolean piatraPretioasa) {
        this.piatraPretioasa = piatraPretioasa;
    }

}