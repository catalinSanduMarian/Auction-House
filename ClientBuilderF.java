public class ClientBuilderF {

	public final  PersoanaFIZ client = new PersoanaFIZ();
	
	public ClientBuilderF withId (int id)
	{
		client.setId(id);
		return this;
	}

	public ClientBuilderF withNume (String nume)
	{
		client.setNume(nume);
		return this;
	}

	public ClientBuilderF withAdresa (String adresa)
	{
		client.setAdresa(adresa);
		return this;
	}
	public ClientBuilderF withParticip (int numarP)
	{
		client.setParticipari(numarP);
		return this;
	}
	public ClientBuilderF withWins (int numarW)
	{
		client.setWins(numarW);

		return this;
	}
	public ClientBuilderF withData (String data)
	{
		client.setNastere(data);

		return this;
	}

	public PersoanaFIZ build()
	{
		return client;
	}

}
