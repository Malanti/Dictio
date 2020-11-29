package dictio_package;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
	
	private char c;
	private Node precedent;
	private LinkedList<Character> listeSuivants;
	
	//racine
	public Node(){
		this.precedent = null;
		this.c = 0;
		listeSuivants = new LinkedList<Character>();
	}
	
	public Node(char c, Node precedent){
		this.precedent = precedent;
		this.c = c;
		listeSuivants = new LinkedList<Character>();
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

	public LinkedList<Character> getListeSuivants() {
		return listeSuivants;
	}

	public void setListeSuivants(LinkedList<Character> listeEnfants) {
		this.listeSuivants= listeEnfants;
	}
	
	public void addNodeToSuivants(Character c) {
		listeSuivants.add(c);
	}
	
	public String toString() {
		String s = "";
		for(Character c : this.listeSuivants) {
			s+= Character.toString(c)+", ";
		}
		return s;
	}
	
	
	

}
