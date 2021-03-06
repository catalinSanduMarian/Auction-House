public class ClientiFactory {


    public Client initializareClient(String[] persoana, int idClient) {
        if (persoana == null) {
            System.out.println("Eroare factory");
            return null;
        }

        if (persoana[5].equals("F")) {
            return new ClientBuilderF()
                    .withId(idClient)
                    .withNume(persoana[1])
                    .withAdresa(persoana[2])
                    .withParticip(Integer.parseInt(persoana[3]))
                    .withWins(Integer.parseInt(persoana[4]))
                    .withData(persoana[6])
                    .build();
        } else if (persoana[5].equals("J")) {
            return new ClientBuilderJ()
                    .withId(idClient)
                    .withNume(persoana[1])
                    .withAdresa(persoana[2])
                    .withParticip(Integer.parseInt(persoana[3]))
                    .withWins(Integer.parseInt(persoana[4]))
                    .withCapital(Double.parseDouble(persoana[6]))
                    .build();

        }
        return null;
    }
}
