import java.util.*;
//implements Vizualizare, Adaugare	

public class Broker extends Angajat implements Stergere{

	private String numeB;
	private List<Client> listaClienti;
	private Client clientCastigator= null;

	@Override
	public void StergereProduse(List<Produs> listaProduse, Produs produs)
	{
		listaProduse.remove(produs);

	}


	void newClienti()
	{
		listaClienti =  new ArrayList<Client>();
	}

	void adaugaClient (Client client)
	{
		listaClienti.add(client);
	}

	List<Client> getClienti()
	{
		return listaClienti;
	}

	public void setBnume(String nume)
	{
		numeB = nume;
	}

	public void newClientCastigator()
	{
		clientCastigator = null;
	}

	public void resetListe()
	{
		clientCastigator = null;
		listaClienti =  new ArrayList<Client>();
	}

	public Client GetClientCastigator()
	{
		return clientCastigator;
	}

	public void printBroker()
	{
		System.out.println("numeBroaker=" +numeB);
	    for (Client element : listaClienti)
	    {
	    	element.printTOT();
	    }
	    if (clientCastigator != null)
	    {
	    	System.out.println("CLIENT CASTIGATOR");
	    	clientCastigator.printTOT();
	    }

	}
	/* brokerul ia suma licitata a fiecarui 
	client pe care ii reprezinta si face maximul
	transmite maximul mai departe, retinand clientul
	care a licitat cel mai mult*/
	public double reprezentareClienti(double minim)
	{
		double maxim=minim;

		for (Client client : listaClienti)
		{
			double pret = client.liciteaza(minim);
			if (maxim < pret)
			{
				maxim =pret;
				clientCastigator = client;
			}
		}

		return maxim;
	}


}