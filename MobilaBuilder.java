public class MobilaBuilder {

	public final  Mobila mobila = new Mobila();

	public MobilaBuilder withId (int id)
	{
		mobila.setPid(id);
		return this;
	}




	public MobilaBuilder withNume (String nume)
	{
		mobila.setPnume(nume);
		return this;
	}
	public MobilaBuilder withVanzare (double vanzare)
	{
		mobila.setVanzare(vanzare);
		return this;
	}
	public MobilaBuilder withMinim (double minim)
	{
		mobila.setMinim(minim);
		return this;
	}

	public MobilaBuilder withTip (String tip)
	{
		mobila.setTip(tip);
		return this;
	}
	public MobilaBuilder withMaterial (String material)
	{
		mobila.setMaterial(material);
		return this;
	}

	public Mobila build()
	{
		return mobila;
	}

}


