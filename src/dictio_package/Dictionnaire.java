package dictio_package;

import java.util.ArrayList;

/**
 * 
 * @author Fayçal & Malanto
 * Classe qui va contenir l'information du fichier parser avec une liste de mots associés à leurs définitions
 * 
 */

public class Dictionnaire {
	
	private ArrayList<Mot> dict;
	
	public Dictionnaire() {
		this.dict = new ArrayList<Mot>();
	}
	
	/*
	 * Accesseurs et mutateurs
	 */

	public ArrayList<Mot> getDict() {
		return dict;
	}

	public void setDict(ArrayList<Mot> dict) {
		this.dict = dict;
	}
	
	/*
	 * Méthodes
	 */
	public ArrayList<String> recherche(String s){
		ArrayList<String> liste_mot = new ArrayList<String>();
		
		//parcours dans la liste si la chaine s est dans un mot 
		for(Mot mot : dict) {
			if(mot.getMot_nom().toLowerCase().contains(s.toLowerCase())) {
				liste_mot.add(mot.getMot_nom());
			}
		}
		
		//trier la liste et la retourner 
		
		return liste_mot;
		
	}

	public void add(Mot m) {
		// TODO Auto-generated method stub
		this.dict.add(m);
	}
	
	@Override
	public String toString(){
		String s = "";
		for(Mot mot : dict) {
			s+="{"+mot.toString()+"}\n";
		}
		return s;
	}
}
