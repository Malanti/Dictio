package dictio_package;

public class DictionnaireException extends Exception {
	
	public DictionnaireException(int nb) {
		super();
		System.out.println("La ligne "+nb+" ne contient pas le caractere '&'");
	}
}
