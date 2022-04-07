import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitireInput {

    private final List<Client> clientela = new ArrayList<>();
    private final List<Produs> Lproduse = new ArrayList<>();
    private final Administrator admin = new Administrator();
    private final List<Licitatie> listaLicitatii = new ArrayList<>();
    private final List<Broker> lBrokeri = new ArrayList<>();
    private final ClientiFactory fabricaC = new ClientiFactory();
    private final ProdusFactory fabricaP = new ProdusFactory();
    private int numarLicitatii = 0;

    public void citeste(File test) {
        try {
            Scanner citire = new Scanner(test);
            int idClient = 0, idProdus = 0;

            while (citire.hasNextLine()) {
                String linie = citire.nextLine();
                String[] comenzi = linie.split(" ");

                /*fac listele de clienti, brokeri si produse */

                /*adaug un nou client in lista de clienti */
                /*adaug un nou broker in lista de brokeri */
                /*adaug un nou produs in lista de produse */
                /* pornesc executia licitatiilor*/
                switch (comenzi[0]) {
                    case "Client" -> {
                        idClient = idClient + 1;
                        clientela.add(fabricaC.initializareClient(comenzi, idClient));
                    }
                    case "Broker" -> {
                        Broker toti_brokerii = new BrokerBuilder()
                                .withNume(comenzi[1])
                                .withClienti()
                                .build();
                        lBrokeri.add(toti_brokerii);
                    }
                    case "Produs" -> {
                        idProdus = idProdus + 1;
                        Produs insertnume = fabricaP.initializareProdus(comenzi, idProdus);
                        admin.AdaugareProduse(Lproduse, insertnume);
                    }
                    case "Start" -> {
                        numarLicitatii = Integer.parseInt(comenzi[1]);
                        int licId = 0;
                        for (int i = 1; i <= idProdus; i++) {
                            licId = licId + 1;
                            Licitatie scosVanzare = new LicitatieBuilder()
                                    .withId(licId)
                                    .withNrPArt(3)
                                    .withPid(i)
                                    .withMaxim(5)
                                    .withParticipanti()
                                    .withActual(0)
                                    .build();
                            listaLicitatii.add(scosVanzare);
                        }
                    }
                }

            }
            citire.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public List<Client> getClienti() {
        return clientela;
    }

    public int getNrClienti() {
        return clientela.size();
    }

    public List<Produs> getProduse() {
        return Lproduse;
    }

    public List<Licitatie> getLicitatii() {
        return listaLicitatii;
    }

    public int getNrLicitatii() {
        return numarLicitatii;
    }

    public List<Broker> getBrokeri() {
        return lBrokeri;
    }
}
