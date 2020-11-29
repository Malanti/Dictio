package dictio_package;

import java.awt.List;
import java.util.ArrayList;

public class Node {
	
	private char c;
	private Node precedent;
	private ArrayList<Node> listeEnfants;
	
	//racine
	public Node(){
		this.precedent = null;
		this.c = (Character) null;
		listeEnfants = new ArrayList<Node>();
	}
	
	public Node(char c){
		this.precedent = null;
		this.c = c;
		listeEnfants = new ArrayList<Node>();
	}
	
	/*
	 * Accesseurs et mutateurs
	 */
	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public Node getPrecedent() {
		return precedent;
	}

	public void setPrecedent(Node precedent) {
		this.precedent = precedent;
	}

	public ArrayList<Node> getListeEnfants() {
		return listeEnfants;
	}

	public void setListeEnfants(ArrayList<Node> listeEnfants) {
		this.listeEnfants = listeEnfants;
	}
	
	
	
	
	

}
