public class Tablou extends Produs {

	private String numePictor;
	private enum Culori {
		ulei,
		tempera,
		acrilic,
	}

	void setPictor(String numele)
	{
		numePictor = numele;
	}
}