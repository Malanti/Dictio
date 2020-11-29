package dictio_package;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

/**
 * 
 * @author Faycal & Malanto
 * Classe qui va parser le fichier + créer les mots avec leurs définitions et les ajouter dans le dictionnaire
 * Ajout du mot comme un arbre (en récursif)
 * 
 * Inspiré de la vidéo suivante : https://www.youtube.com/watch?v=waXvGUEjTTs
 */

public class TraitementFichier{
	
	public TraitementFichier(String pathname, Dictionnaire d) throws DictionnaireException {
		creationDictionnaire(pathname, d);
	}

	
	/*
	 * Méthodes
	 */
	
	private void creationDictionnaire(String nomPath, Dictionnaire dictionnaire) throws DictionnaireException {
		try {
			String ligne;
			int nb = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomPath), StandardCharsets.UTF_8));
		    
			while((ligne = br.readLine()) != null) {
				String[] arrS = new String[255];
				if(ligne.contains("&")) {
					arrS = ligne.split(" & ",2);
					dictionnaire.add(new Mot(arrS[0].replaceAll("\\s", ""),arrS[1]));
				}else {
					throw new DictionnaireException(nb);
				}
				nb+=1;				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifierFichier() {
		
	}

	

}
