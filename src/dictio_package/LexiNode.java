package dictio_package;

import java.awt.List;

public class LexiNode{

	private Node racine;
	
	public LexiNode() {
		this.racine = new Node();
	}
	
	public Node getRacine() {
		return racine;
	}

	public void setRacine(Node racine) {
		this.racine = racine;
	}
	/*
	 * Méthodes
	 */
	public void getMot(Mot m) {
		
	}
	
	public void ajoutMot(Mot m) {
		//verification du noeuf precedent 
		if(!racine.getListeEnfants().contains(m.getMot_nom().toUpperCase().charAt(0))) {
			Node n = new Node(m.getMot_nom().toUpperCase().charAt(0));
			racine.getListeEnfants().add(n);
		}else {
			for(Node n : racine.getListeEnfants())
				if(m.getMot_nom().toUpperCase().charAt(0)==n.getC()) {
					char c = n.getC();
				}
			/*
			if() {
				
			}else {
				
			}*/
		} 
		
	}
	
	public void modifierMot(Mot m) {
		
	}
	

	
	

}
