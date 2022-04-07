public class ClientBuilderJ {

    public final PersoanaJUD client = new PersoanaJUD();

    public ClientBuilderJ withId(int id) {
        client.setId(id);
        return this;
    }

    public ClientBuilderJ withNume(String nume) {
        client.setNume(nume);
        return this;
    }

    public ClientBuilderJ withAdresa(String adresa) {
        client.setAdresa(adresa);
        return this;
    }

    public ClientBuilderJ withParticip(int numarP) {
        client.setNumarParticipari(numarP);
        return this;
    }

    public ClientBuilderJ withWins(int numarW) {
        client.setWins(numarW);

        return this;
    }

    public ClientBuilderJ withCapital(double capital) {
        client.setCapital(capital);

        return this;
    }

    public PersoanaJUD build() {
        return client;
    }

}
