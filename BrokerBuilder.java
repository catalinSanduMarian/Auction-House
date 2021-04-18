public class BrokerBuilder{



	public final  Broker broker = new Broker();

	public BrokerBuilder withNume (String nume)
	{
		broker.setBnume(nume);
		return this;
	}


	public BrokerBuilder withClienti ()
	{
		broker.newClienti();
		return this;
	}

	public Broker build()
	{
		return broker;
	}

}