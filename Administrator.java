import java.util.List;


public class Administrator extends Angajat implements Adaugare {


    @Override
    public void AdaugareProduse(List<Produs> listaProduse, Produs produs) {
        listaProduse.add(produs);
    }

}
