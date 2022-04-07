public class BijuterieBuilder {

    public final Bijuterie jewelry = new Bijuterie();

    public BijuterieBuilder withId(int id) {
        jewelry.setPid(id);
        return this;
    }

    public BijuterieBuilder withNume(String nume) {
        jewelry.setPnume(nume);
        return this;
    }

    public BijuterieBuilder withVanzare(double vanzare) {
        jewelry.setVanzare(vanzare);
        return this;
    }

    public BijuterieBuilder withMinim(double minim) {
        jewelry.setMinim(minim);
        return this;
    }

    public BijuterieBuilder withMaterial(String material) {
        jewelry.setMaterial(material);
        return this;
    }

    public BijuterieBuilder withPP(Boolean peps) {
        jewelry.setPP(peps);
        return this;
    }

    public Bijuterie build() {
        return jewelry;
    }
}

