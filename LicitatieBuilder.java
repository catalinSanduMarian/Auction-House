public class LicitatieBuilder {

    public final Licitatie licitatia = new Licitatie();


    public LicitatieBuilder withId(int id) {
        licitatia.setId(id);
        return this;
    }


    public LicitatieBuilder withNrPArt(int nr) {
        licitatia.setNrPArt(nr);
        return this;
    }


    public LicitatieBuilder withPid(int pid) {
        licitatia.setPid(pid);
        return this;
    }

    public LicitatieBuilder withMaxim(int max) {
        licitatia.setMaxim(max);
        return this;
    }

    public LicitatieBuilder withParticipanti() {
        licitatia.newParticipanti();
        return this;
    }

    public LicitatieBuilder withActual(int actual) {
        licitatia.setActual(actual);
        return this;
    }

    public Licitatie build() {
        return licitatia;
    }


}