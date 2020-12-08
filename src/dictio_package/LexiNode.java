package dictio_package;

import java.util.LinkedList;


public class LexiNode{
	/**
	 * La classe LexiNode représente notre arbre lexicographique et ses noeuds.
	 * Elle a plusiseurs attributs : représentante, mot courant, définition, et une liste des noeuds enfant qui lui sont liés.
	 * Elle n'a pas de collaborateurs
	 */
	private char representante;
	private String motCourant;
	private String definition = "";
	private LinkedList<LexiNode> enfants;
	/*
	 * Constructeur
	*/
	/**
	 * Ce constructeur sert à initialiser notre arbre, créer la racine ce constructeur sera utilisé uniquement par la classe LexiNodeController
	 */
	protected LexiNode(){
		this.enfants = new LinkedList<LexiNode>();
		this.motCourant = "";
	}
	/**
	 * Ce constructeur sera utilisé pour initialiser les autres noeuds après la racine et sera appelé lors de l'ajout de nouveaux mots
	 * @param mot Le mon dont la premiere lettre sera le caractere représentante du nouveau noeud
	 * @param mCourant Le mot formé par les parents et grands parent du nouveau noeud
	 */
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
	
	
	/**
	 * Modifie la définition d'un mot qui existe dejà
	 * @param mot Le mot dont on souhaite modifier la définition
	 * @param definition La nouvelle définition
	 */
	protected void modifier(String mot,String definition) {
		acceder(mot).setDefinition(definition);
	}
	/**
	 * Cette fonction servira à se placer sur le noeud du mot recherché
	 * @param mot Le mot que l'on cherche
	 * @return Le noeud qui contient comme mot courant le mot recherché et dont le carctere correspond à la derniere lettre du mot recherché
	 * 
	 * Complexité O(k^n) où k correspond au nombre de lettre qu'il y a dans le mot
	 */
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
	/**
	 * Cette fonction va servir à ajouter de nouveaux mots à notre arbre en parcourant chaque noeud et lettre par lettre
	 * @param mot Le nouveau mot que l'on souhaite ajouter
	 * @param def La définition de ce nouveau mot
	 * 
	 * Complexité O(n*log(n))où n est le nombre de lettre qu'il y a dans le mot
	 */
	
	protected void ajouter(String mot, String def) {
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
		if(this.getDefinition().equals("")) {
			s = "";
		}
		if(!this.enfants.isEmpty()) {
			for(LexiNode n : this.enfants){
					s += n.toString();
			}
		}
		return s;

		
	}


	
	

}
