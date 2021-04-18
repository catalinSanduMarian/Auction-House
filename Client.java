import java.util.concurrent.ThreadLocalRandom;



public class Client {

	private int id;
	private String nume;
	private String adresa;
	private int numarParticipari;
	private int nr_licitatii_castigate;
	private double pretMaximOferit =0;

	void setPretMaxim(double pret)
	{
		pretMaximOferit = pret;
	}

	public Client()
	{
		id =  0;
		nume = "gol";
		adresa = "gol";
		numarParticipari = 0;
		nr_licitatii_castigate = 0; 	
	}

	void setId(int idC)
	{
		id =  idC;
	}
	void setNume (String numeC)
	{
		nume = numeC;
	}

	void setAdresa(String adresaC)
	{
		adresa = adresaC;
	}
	void setParticipari(int numarParticipariC)
	{
		numarParticipari = numarParticipariC;
	}
	void setWins(int nr_licitatii_castigateC)
	{
		nr_licitatii_castigate = nr_licitatii_castigateC;
	}


	void printTOT()
	{
		System.out.println("id="+id+" nume="+nume+" adresa="+adresa+ " numarParticipari="+numarParticipari+
			" nr_licitatii_castigate="+nr_licitatii_castigate +"suma max lic="+pretMaximOferit);

	}



	public void aCastigat()
	{
		nr_licitatii_castigate = nr_licitatii_castigate +1;
	}

	public void aParticipat()
	{
		numarParticipari = numarParticipari+1;
	}


	public int getParticpari()
	{
		return numarParticipari;
	}

	public int getWins()
	{
		return nr_licitatii_castigate;
	}
	public int getIdC()
	{
		return id;
	}

	public double liciteaza(double minim)
	{
		if (minim > pretMaximOferit)
		{
			return pretMaximOferit;
		}
		double randomDouble = ThreadLocalRandom.current().nextDouble(minim, pretMaximOferit);
		return randomDouble;
	}




}