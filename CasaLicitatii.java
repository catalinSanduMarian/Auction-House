import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class CasaLicitatii {
	private static int numarMaximPosibil = 15;
	/* este doar o constanta pt customiza usor
	intervalul sumei maxime oferite de clienti */
						

	private List<Registru> registrul;
	private	List<Client> lista_clienti;
	private List<Produs> lista_produse;
	private List<Licitatie> lista_licitatii_active;
	private static CasaLicitatii instantiereCasa = null;


	/* aici este singleton-ul */
	private CasaLicitatii(List<Client> clienti, List<Produs> produse, List<Licitatie> licitatii)
	{
		this.registrul = new ArrayList<Registru>();
		lista_clienti = clienti;
		lista_produse = produse;
		lista_licitatii_active = licitatii;


	}

	public static CasaLicitatii getInstance(List<Client> clienti, List<Produs> produse, List<Licitatie> licitatii) {

        if (instantiereCasa == null)
            instantiereCasa = new CasaLicitatii(clienti,produse,licitatii);
        return instantiereCasa;
    }


	public void setClienti(List<Client> clienti)
	{
		lista_clienti = clienti;
	}

	public void setProduse (List<Produs> produse)
	{
		lista_produse = produse;
	}

	public void setLicitatii (List<Licitatie> licitatii)
	{
		lista_licitatii_active = licitatii;
	}


	/* imi simulueaza procesul prin care clientii fac cereri pentru
	 produse random catre casa

	in for am un client random care cere un produs random
	cand se face o cerere verific cate cereri are un produs iar daca are 3(adica nr de cereri 
	 pentru a incepe licitatia) cereri incrementez j-ul in for
	ma opresc la nr si dupa am lista mea de licitatii active
	inlocuiesc lista cu cea cu licitatii care trebuiesc derulate */

	public void pregatireLicitatii(int nrLicitatii)
	{
		List<Licitatie> lista_licitatii_de_derulat =  new ArrayList<Licitatie>();
		int nrClienti = lista_clienti.size();
		int nrProduse = lista_produse.size();
		System.out.println("nr clienti="+nrClienti+" nr produse="+nrProduse);
		int j=0;
		while ( j<nrLicitatii)
			{
				int i=0;
				int randomClient = ThreadLocalRandom.current().nextInt(1, nrClienti + 1);
				for (Client client : lista_clienti)
				{
					i++;

					if (i== randomClient)
					{

						int randomPid = ThreadLocalRandom.current().nextInt(1, nrProduse + 1);
						for (Licitatie licitaie :lista_licitatii_active)
						{
							if(licitaie.CheckId(randomPid) == 1)
							{
								int idClientEEEE = client.getIdC();
								if(licitaie.verificareUnicitate(idClientEEEE) == 1)
								{
									if (licitaie.adaugareClient(client) == 1)
									{
										if (licitaie.numarAtins() == 1)
										{
											j++;	
											lista_licitatii_de_derulat.add(licitaie);
										}
									}
								}
							}
						}
						break;
					}
				}
			}
		lista_licitatii_active = lista_licitatii_de_derulat;
	}

	/* randomizez suma maxima a fiecarui client
	 assigenez fiecarui client cate un broker
	 fac un for de nrpasimaxim pentru licitatie */

	public void parcuregereLicitatie(List<Broker> lista_brokeri)
	{
		for (Licitatie licitatie : lista_licitatii_active)
		{
			List<Client> participanti = licitatie.getClient();
			/*asignez un broker random fiecarui client participant
			de altfel, citesc pretul maxim al clientului */
			for (Client unClient : participanti)
			{
				/*asignez fiecarui client un borker;
				modific / setez suma maxima oferita
				setez suma maxima random(intre valori pe care le vreau) */

				double randomDouble = ThreadLocalRandom.current().nextDouble(1, numarMaximPosibil);
				unClient.setPretMaxim(randomDouble); 
				/*asignez clientul brokerului*/
				int nrBrokeri = lista_brokeri.size();
				int stop = ThreadLocalRandom.current().nextInt(1, nrBrokeri + 1);
				int i=0;
				for (Broker brokerul : lista_brokeri)
				{
					i++;
					if (i== stop)
					{
						brokerul.adaugaClient(unClient);
					}
				}
			}
			/*un for de la 0 la nrMAxPAsi
			un for pt toti brokerii
			brokeri iau pretul de la toti clientii participanti
			si dau maximul casei
			casa face maximul licitat si il returneaza brokerilor
			se trece la urm pas */
			
			int maximPasi = licitatie.getPasi();
			double pretulMaximStabilit=0;
			for (int i =0;i<maximPasi; i++)
			{
				for (Broker brokerul : lista_brokeri)
				{					
					/*apelez o metoda care imi intoarce maximul pus dintre clientii brokerului
					brokerii dau doar val maxima inregistrata intre clientii lor
					fac maximul dintre ce imi dau brokerii
					trimit maximul inapoi brokerilor */
					double pretBroker =  brokerul.reprezentareClienti(pretulMaximStabilit);
					if ( pretBroker > pretulMaximStabilit)
					{
						pretulMaximStabilit = pretBroker;
						licitatie.setCastigator(brokerul);
					}
				}
			}		
			/*brokerul socate produsul fol pid-ul
			//trb sa gasec produsul dupa id */

			int idProdusVandut = licitatie.getPid();
			for (Produs produsVandut: lista_produse)
			{
				if (produsVandut.CheckId(idProdusVandut) == 1)
				{
					double minimVanzare = produsVandut.getMinim();
					if(minimVanzare < pretulMaximStabilit)
					{
						Broker brokerulCastigator =  licitatie.getCastigator();
						Client clientulCastigator = brokerulCastigator.GetClientCastigator();
						System.out.println("VANDUTTTTT!!!!");
						produsVandut.setVanzare(pretulMaximStabilit);
						clientulCastigator.printTOT();
						/*incrementez numarul de victorii */
						clientulCastigator.aCastigat();	

						double multiplicator;
						/*fac comisionul brokerului*/
						if (clientulCastigator instanceof PersoanaJUD)
						{
							PersoanaJUD persJud =(PersoanaJUD) clientulCastigator;
							multiplicator =  persJud.calculareComision();
						}
						else 
						{
							PersoanaFIZ persFiz = (PersoanaFIZ) clientulCastigator;
							multiplicator = persFiz.calculareComision();
						}
						/*adaug vanzarea in registru*/
						Registru registruProdus = new Registru (produsVandut, pretulMaximStabilit , pretulMaximStabilit*multiplicator);
						registrul.add(registruProdus);
						/*brokerul sterge produsul din lista de produse*/
						brokerulCastigator.StergereProduse(lista_produse, produsVandut);
						break;
					}
					else
					{
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@pretul minim nu a fost atins");
						break;
					}
				}	
			}
			/* reintializez listele brokerilor */
			for (Broker brokerul : lista_brokeri)
			{
				brokerul.resetListe();
			}
		}
	}



	public void printezaRegistrul()
	{
		for (Registru elem :registrul)
		{
			elem.printRegistru();
		}
	}


	public void printeazaCampurileCasei(){

		System.out.println("@@@@@@@@@@@@@@inceput lista clienti@@@@@@@@@@@");

		for (Client element : lista_clienti)
		{
			element.printTOT();
		}
		System.out.println("@@@@@@@@@@@@@@inceput lista produse@@@@@@@@@@");


		for (Produs element : lista_produse)
		{
			element.printeazaProd();
		}

		System.out.println("@@@@@@@@@@@@@@inceput lista licitatii active@@@@@@@@@@@@@");


		for (Licitatie element :lista_licitatii_active)
		{
			element.printeazaLic();
		}
	}
}