import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.*;

public class CitireInput {

	private List<Client> clientela = new ArrayList<Client>();
	private List<Produs> Lproduse = new ArrayList<Produs>();
	private Administrator admin = new Administrator();
	private List<Licitatie> listaLicitatii = new ArrayList<Licitatie>();
	private List<Broker> lBrokeri = new ArrayList<Broker>();
	private ClientiFactory fabricaC = new ClientiFactory();
	private ProdusFactory fabricaP = new ProdusFactory();
	private int numarLicitatii =0;
 	public 	void citeste(File test) {
	    try 
	    {
	    	Scanner citire = new Scanner(test);
	    	int idClient=0, idProdus=0;

	    	while (citire.hasNextLine()) {
		        String linie = citire.nextLine();
	    	    String[] comenzi = linie.split (" ");

	        	/*fac listele de clienti, brokeri si produse */

	        	if (comenzi[0].equals("Client"))
	        	{	
	       			idClient = idClient+1;
 	        		/*adaug un nou client in lista de clienti */
					clientela.add(fabricaC.initializareClient(comenzi,idClient));
		        }

	  	    	else if (comenzi[0].equals("Broker"))
	        	{
	        		/*adaug un nou broker in lista de brokeri */

	        		Broker toti_brokerii = new BrokerBuilder()
	        		.withNume(comenzi[1])
	        		.withClienti()
	        		.build();
	        		lBrokeri.add(toti_brokerii);

	        	}
	      		else if (comenzi[0].equals("Produs"))
	        	{
	        		/*adaug un nou produs in lista de produse */

	        		idProdus = idProdus+1;
	        		Produs insertnume = fabricaP.initializareProdus(comenzi,idProdus);
	        		admin.AdaugareProduse(Lproduse,insertnume);
	        	}



				else if (comenzi[0].equals("Start"))
				{
	       		 	
	       		 	/* pornesc executia licitatiilor*/
	       		 	numarLicitatii = Integer.parseInt(comenzi[1]);

	       		 	int licId = 0;
	       		 	for (int i = 1; i<= idProdus; i++)
	       		 	{
	       		 		licId = licId+1;
	        			Licitatie scosVanzare = new LicitatieBuilder()
	        			.withId(licId)
	        			.withNrPArt(3)
	        			.withPid(i)
	        			.withMaxim(5)
	        			.withParticipanti()
	        			.withActual(0)
	        			.build();
	        			listaLicitatii.add(scosVanzare);
	        		}
	        		break;
				}
	    
	    	}
	      citire.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

	  }

	public List<Client> getClienti()
	{
		return clientela;
	}
	public int getNrClienti()
	{
		return clientela.size();
	}

	public List<Produs> getProduse()
	{
		return Lproduse;
	}
	public List<Licitatie> getLicitatii()
	{
		return listaLicitatii;
	}
	public int getNrLicitatii()
	{
		return numarLicitatii;
	}
	public List<Broker> getBrokeri()
	{
		return lBrokeri;
	}
}
