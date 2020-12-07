package dictio_package;

import java.util.LinkedList;
import java.util.ListIterator;

public class LexiNode{
	/*
	 * chaque noeud a une definition, un caractere, un mot et une liste d'aurtres noeauds enfant
	 */
	private char representante;
	private String motCourant;
	private String definition = "";
	private LinkedList<LexiNode> enfants;
	/*
	 * Constructeur
	*/
	protected LexiNode(){
		this.enfants = new LinkedList<LexiNode>();
		this.motCourant = "";
	}
	private LexiNode(String mot, String mCourant){
		this.representante = mot.charAt(0);
		this.motCourant = mCourant + Character.toString(this.representante);
		this.enfants = new LinkedList<LexiNode>();
	}
	
	/*
	 * mutateurs et accesseurs
	 */
	private char getRepresentante() {
		return this.representante;
	}
	private void setDefinition(String def) {
		this.definition = def;
	}
	private String getMotCourant() {
		return this.motCourant;
	}
	
	protected String getDefinition() {
		return this.definition;
	}
	
	
	
	protected void modifier(String mot,String definition) {
		acceder(mot).setDefinition(definition);
	}

	protected LexiNode acceder(String mot) {
		if (this.motCourant.equals(""+mot)){
			return this;
		}
		else {
			LexiNode l = null;
			for(LexiNode n : this.enfants) {
				l = n.acceder(mot);
				if(l!=null) {
					break;
				}
			}
			return l;
		}
				
	}
	
	protected void ajouter(String mot, String def) {
		// TODO Auto-generated method stub
		if(mot.length()==0) {
			this.setDefinition(def);
		}
		else {
			LexiNode l = null;
			for(LexiNode n : this.enfants){
				if(n.getRepresentante()==mot.charAt(0)) {
					l = n;
				}
			}
			if(l == null) {
				l = new LexiNode(mot, this.getMotCourant());
				this.enfants.add(l);
			}
			l.ajouter(mot.substring(1), def);
		}
	}
	
	
	//C'est aussi la methode qu'on utilisera pour afficher la liste des mots qui commence de la même façon
	//Il faudra juste verifier si leur definition est null ou pas si leur definition est nulle on ne les affiche pas à l'écran 
	//@override
	public String toString() {
		String s = this.getMotCourant()+"\n";
		if(!this.enfants.isEmpty()) {
			for(LexiNode n : this.enfants){
				s += n.toString();
			}
		}
		return s;
	}


	
	

}
