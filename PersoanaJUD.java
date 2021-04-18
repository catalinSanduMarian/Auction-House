public class PersoanaJUD extends Client {

	private enum companie{
		SRL,
		SA
	}
	private double capitalSocial;



	void setCapital(double capital){

	capitalSocial = capital;

	}


	public double calculareComision()
	{
		int participari = this.getParticpari();
		if (participari <=25)
		{
			return 0.75;
		}
		else 
		{
			return 0.9;
		}
	} 


}
