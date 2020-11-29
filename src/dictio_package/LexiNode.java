package dictio_package;

import java.util.LinkedList;
import java.util.ListIterator;

public class LexiNode{

	private Node racine;
	private LinkedList<Node> lexic;
	
	public LexiNode() {
		this.racine = new Node();
		lexic = new LinkedList<Node>();
		lexic.add(racine);
	}
	
	public Node getRacine() {
		return racine;
	}

	public void setRacine(Node racine) {
		this.racine = racine;
	}
	
	public LinkedList<Node> getLexic() {
		return lexic;
	}

	public void setLexic(LinkedList<Node> lexic) {
		this.lexic = lexic;
	}
	/*
	 * Méthodes
	 */
	public void getMot(Mot m) {
		
	}
	
	public void ajoutMot(Mot m, Node n) {
		
		
		
	}
	
	public void modifierMot(Mot m) {
		
	}

	
	

	
	

}
