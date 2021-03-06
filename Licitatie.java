import java.util.ArrayList;
import java.util.List;


public class Licitatie {

    private int id;
    private int numarParticipanti;
    private int idProdus;
    private int nrPasiMaxim;
    private List<Client> clientiParticipanti;
    private int nrActualClienti;
    private Broker brokerCastigator = null;

    public void setBrokerCastigator(Broker brokerCastigator) {
        this.brokerCastigator = brokerCastigator;
    }

    public int numarAtins() {
        if (nrActualClienti == numarParticipanti) {
            return 1;
        }
        return 0;
    }


    public Broker getCastigator() {
        return brokerCastigator;
    }


    public void setActual(int actual) {
        nrActualClienti = actual;
    }

    public void setNrPArt(int nrPart) {


        numarParticipanti = nrPart;
    }

    public void setMaxim(int maxim) {

        nrPasiMaxim = maxim;
    }

    public void newParticipanti() {
        clientiParticipanti = new ArrayList<>();
    }

    public void printeazaLic() {
        System.out.println("id=" + id + " nrPart=" + numarParticipanti + " id proodus=" + idProdus
                + " nrpasi=" + nrPasiMaxim + " Clientiactual=" + nrActualClienti);

        for (Client element : clientiParticipanti) {
            element.printTOT();
        }
        if (brokerCastigator != null) {
            System.out.println("broker Castigator este:");
            brokerCastigator.printBroker();
        }

    }

    public List<Client> getClient() {
        return clientiParticipanti;
    }

    public int verificareUnicitate(int idClient) {
        for (Client element : clientiParticipanti) {
            int verific = element.getIdC();
            if (idClient == verific) {

                return 0;
            }
        }

        return 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int lid) {
        id = lid;
    }

    public int getNrPart() {
        return numarParticipanti;
    }

    public int getPid() {
        return idProdus;
    }

    public void setPid(int pid) {

        idProdus = pid;
    }

    public int getPasi() {
        return nrPasiMaxim;
    }


    public int adaugareClient(Client client) {
        if (nrActualClienti == numarParticipanti) {
            return 0;
        }

        clientiParticipanti.add(client);
        nrActualClienti = nrActualClienti + 1;
        return 1;

    }

    public int CheckId(int id_cautat) {
        if (idProdus == id_cautat) {
            return 1;
        }
        return 0;
    }
}