public class Registru {


	private Produs produsulVandut;
	private double pretVanzareProdus;
	private double venitCasa;


	public void setProdus(Produs produs)
	{
		produsulVandut = produs;
	}


	public void setVanzare(double pret)
	{
		pretVanzareProdus = pret;
	}

	public void setVenit(double venit)
	{
		venitCasa = venit;
	}


	public Registru(Produs produs, double pret, double venit)
	{
		produsulVandut = produs;
		pretVanzareProdus = pret;
		venitCasa = venit;
	}


	void printRegistru()
	{
		System.out.println("@@@@@printare elem registru");

		System.out.println("pretVanzare=" + pretVanzareProdus+ " venit=" +venitCasa+" produsul este:");
		produsulVandut.printeazaProd();
	}

}
