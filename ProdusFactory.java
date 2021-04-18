public class ProdusFactory {


	public Produs initializareProdus(String[] comenzi, int idProdus )

	{
		if (comenzi[1].equals ("mobila"))
	    {


	    	Mobila mobila = new MobilaBuilder()
	     	.withId(idProdus)
	        .withNume(comenzi[2])
	      	.withVanzare(0)
	      	.withMinim(Double.parseDouble(comenzi[3]))
	       	.withTip(comenzi[4])
	       	.withMaterial(comenzi[5])	
	       	.build();
	       	return mobila;
	    }
	    else if (comenzi[1].equals ("tablou"))
	    {
	        Tablou tablou = new TablouBuilder()
	       	.withId(idProdus)
	        .withNume(comenzi[2])
	      	.withVanzare(0)
	      	.withMinim(Double.parseDouble(comenzi[3]))
	      	.withPictor(comenzi[4])
	      	.build();
	      	return tablou;
	    }

	    else if (comenzi[1].equals ("bijuterie"))
	    {
	        Bijuterie bijut = new BijuterieBuilder()
	     	.withId(idProdus)
	        .withNume(comenzi[2])
	      	.withVanzare(0)
	      	.withMinim(Double.parseDouble(comenzi[3]))
	      	.withMaterial(comenzi[4])
	      	.withPP(Boolean.valueOf(comenzi[5]))
	      	.build();
	      	return bijut;
		}
	    
	    return null;
	}

}