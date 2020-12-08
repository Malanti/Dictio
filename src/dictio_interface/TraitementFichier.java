package dictio_interface;

import java.io.*;
import java.nio.charset.*;


import dictio_package.LexiNodeController;

/**
 * 
 * @author Faycal & Malanto
 * Classe qui va parser le fichier + cr�er les mots avec leurs d�finitions et les ajouter dans le dictionnaire
 * Ajout du mot comme un arbre (en r�cursif)
 * 
 * Inspir� de la vid�o suivante : https://www.youtube.com/watch?v=waXvGUEjTTs
 */

public class TraitementFichier{
	
	private String path;
	
	public TraitementFichier(String pathname) {
		this.path = pathname;
	}
	
	/*
	 * Accesseurs et mutateurs
	 */
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	/*
	 * M�thodes
	 */
	
	public void chargement(LexiNodeController controller) {
		try {
			String ligne;
			int nb = 1;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			
		    
			while((ligne = br.readLine()) != null) {
				String[] arrS = new String[255];
				if(ligne.contains("&")) {
					arrS = ligne.split(" & ",2);
					String mot = arrS[0].replaceAll("\\s", "");
					String definition = arrS[1];
					controller.addOrModify(mot.toLowerCase(), definition.toLowerCase());
				}else {
					System.out.println("La ligne "+nb+" n'a pas correctement �t� ajout�e. Il manque le caract�re &");
				}
				nb+=1;				
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enregistrement(LexiNodeController controller) throws IOException {
		File file = new File(path);
		String[] liste = controller.getListAllWord().split("\n");
		
		try (FileOutputStream fileOutput = new FileOutputStream(file)) {
			for(String s : liste) {
				String def = controller.define(s);
				String ligne = s+" & "+def+"\n";
				System.out.println(ligne);
	            byte[] ligneBytes = ligne.getBytes();
	            fileOutput.write(ligneBytes);
			}
			fileOutput.flush();
			fileOutput.close();
		}
		
		
	}

		
		
		
}

