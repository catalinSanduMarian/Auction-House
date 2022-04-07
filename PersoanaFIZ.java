public class PersoanaFIZ extends Client {

	private String dataNastere;

	void setNastere(String data) {
		dataNastere = data;
	}

	public String getDataNastere() {
		return dataNastere;
	}

	public double calculareComision() {
		int participari;
		participari = getNumarParticipari();
		if (participari <= 5) {
			return 0.8;
		} else {
			return 0.85;
		}
	}


}
