import java.io.File;   
import java.io.FileNotFoundException;   
import java.util.Scanner;  
import java.util.*;

public class Main {


	public static void main(String[] args) {
		File test = new File("test.in");
		CitireInput prelucrare = new CitireInput();
		prelucrare.citeste(test);
		List<Client> toti_clientii = prelucrare.getClienti();
		List<Produs> toate_produsele = prelucrare.getProduse();
		List<Licitatie> toate_licitatiile = prelucrare.getLicitatii();
		List<Broker> toti_brokerii = prelucrare.getBrokeri();
		int numarLicitatii = prelucrare.getNrLicitatii();





		CasaLicitatii casaL = CasaLicitatii.getInstance(toti_clientii, toate_produsele,toate_licitatiile);
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ campurile casei inainte de licitatii @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		casaL.printeazaCampurileCasei();    	/*
														<----- inainte de adaugarea licitatiilor
												*/


		casaL.pregatireLicitatii(numarLicitatii);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ campurile casei dupa ce licitatiile au fost intializate @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


		casaL.printeazaCampurileCasei();		/*<---- dupa ce licitatiile au fost intializate*/

		

		casaL.parcuregereLicitatie(toti_brokerii);

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ campurile casei dupa terminarea licitatiilor @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


		casaL.printeazaCampurileCasei();		/*<----- dupa terminarea licitatiilor*/
		

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ registrul @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	
		casaL.printezaRegistrul();			/* <----- printeaza registrul vanzarilor */

	}
}