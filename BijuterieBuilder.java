public class BijuterieBuilder {

	public final  Bijuterie bijut = new Bijuterie();

	public BijuterieBuilder withId (int id)
	{
		bijut.setPid(id);
		return this;
	}


	


	public BijuterieBuilder withNume (String nume)
	{
		bijut.setPnume(nume);
		return this;
	}
	public BijuterieBuilder withVanzare (double vanzare)
	{
		bijut.setVanzare(vanzare);
		return this;
	}
	public BijuterieBuilder withMinim (double minim)
	{
		bijut.setMinim(minim);
		return this;
	}
	public BijuterieBuilder withMaterial (String material)
	{
		bijut.setMaterial(material);
		return this;
	}
	public BijuterieBuilder withPP (Boolean peps)
	{
		bijut.setPP(peps);
		return this;
	}

	public Bijuterie build()
	{
		return bijut;
	}
}

