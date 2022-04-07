import java.util.ArrayList;
import java.util.List;
//implements Vizualizare, Adaugare	

public class Broker extends Angajat implements StergereDeProduse {

    private String BrokerName;
    private List<Client> listaClienti;
    private Client clientCastigator = null;


    @Override
    public void StergereProduse(List<Produs> listaProduse, Produs produs) {
        listaProduse.remove(produs);
    }

    void newClienti() {
        listaClienti = new ArrayList<>();
    }

    void adaugaClient(Client client) {
        listaClienti.add(client);
    }

    public void setBrokerName(String nume) {
        BrokerName = nume;
    }

    public void resetListe() {
        clientCastigator = null;
        listaClienti = new ArrayList<>();
    }

    public Client GetClientCastigator() {
        return clientCastigator;
    }

    public void printBroker() {
        System.out.println("numeBroker=" + BrokerName);
        for (Client element : listaClienti) {
            element.printTOT();
        }
        if (clientCastigator != null) {
            System.out.println("CLIENT CASTIGATOR");
            clientCastigator.printTOT();
        }

    }

    public double reprezentareClienti(double minim) {
        double maxim = minim;

        for (Client client : listaClienti) {
            double pret = client.liciteaza(minim);
            if (maxim < pret) {
                maxim = pret;
                clientCastigator = client;
            }
        }

        return maxim;
    }


}