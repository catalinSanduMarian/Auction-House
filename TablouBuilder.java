public class TablouBuilder {

public final  Tablou tablou = new Tablou();



	public TablouBuilder withId (int id)
	{
		tablou.setPid(id);
		return this;
	}

	public TablouBuilder withNume (String nume)
	{
		tablou.setPnume(nume);
		return this;
	}
	public TablouBuilder withVanzare (double vanzare)
	{
		tablou.setVanzare(vanzare);
		return this;
	}
	public TablouBuilder withMinim (double minim)
	{
		tablou.setMinim(minim);
		return this;
	}


	public TablouBuilder withPictor(String pictor)
	{
		tablou.setPictor(pictor);
		return this;
	}

	public Tablou build()
	{
		return tablou;
	}


}