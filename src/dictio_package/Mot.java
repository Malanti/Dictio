package dictio_package;

/**
 * 
 * @author Fayçal et Malanto
 * Classe qui va permettre d'utiliser les mots et récuperer leurs défintions
 */

public class Mot {
	
	private String mot_nom;
	private String mot_definition;
	
	public Mot(String mot, String definition) {
		this.mot_nom = mot;
		this.mot_definition = definition;
	}

	public String getMot_nom() {
		return mot_nom;
	}

	public void setMot_nom(String mot_nom) {
		this.mot_nom = mot_nom;
	}

	public String getMot_definition() {
		return mot_definition;
	}

	public void setMot_definition(String mot_definition) {
		this.mot_definition = mot_definition;
	}

	@Override
	public String toString() {
		return mot_nom + " & "+ mot_definition;
	}
	
}
