package dictio_package;

import java.util.LinkedList;


public class LexiNode{
	/**
	 * La classe LexiNode repr�sente notre arbre lexicographique et ses noeuds.
	 * Elle a plusiseurs attributs : repr�sentante, mot courant, d�finition, et une liste des noeuds enfant qui lui sont li�s.
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
	 * Ce constructeur sert � initialiser notre arbre, cr�er la racine ce constructeur sera utilis� uniquement par la classe LexiNodeController
	 */
	protected LexiNode(){
		this.enfants = new LinkedList<LexiNode>();
		this.motCourant = "";
	}
	/**
	 * Ce constructeur sera utilis� pour initialiser les autres noeuds apr�s la racine et sera appel� lors de l'ajout de nouveaux mots
	 * @param mot Le mon dont la premiere lettre sera le caractere repr�sentante du nouveau noeud
	 * @param mCourant Le mot form� par les parents et grands parent du nouveau noeud
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
	 * Modifie la d�finition d'un mot qui existe dej�
	 * @param mot Le mot dont on souhaite modifier la d�finition
	 * @param definition La nouvelle d�finition
	 */
	protected void modifier(String mot,String definition) {
		acceder(mot).setDefinition(definition);
	}
	/**
	 * Cette fonction servira � se placer sur le noeud du mot recherch�
	 * @param mot Le mot que l'on cherche
	 * @return Le noeud qui contient comme mot courant le mot recherch� et dont le carctere correspond � la derniere lettre du mot recherch�
	 * 
	 * Complexit� O(k^n) o� k correspond au nombre de lettre qu'il y a dans le mot
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
	 * Cette fonction va servir � ajouter de nouveaux mots � notre arbre en parcourant chaque noeud et lettre par lettre
	 * @param mot Le nouveau mot que l'on souhaite ajouter
	 * @param def La d�finition de ce nouveau mot
	 * 
	 * Complexit� O(n*log(n))o� n est le nombre de lettre qu'il y a dans le mot
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
	
	
	//C'est aussi la methode qu'on utilisera pour afficher la liste des mots qui commence de la m�me fa�on
	//Il faudra juste verifier si leur definition est null ou pas si leur definition est nulle on ne les affiche pas � l'�cran 
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
