package dictio_package;

public class LexiNodeController {
	/**
	 * Cette classe servira de lien entre notre arbre et les autres classes
	 * Elle initialisera la racine de l'arbre et sera ne sera instaciable qu'une seule fois, c'est pourquoi son constructeur est privé
	 * Collaborateurs : LexiNode
	 */
	private LexiNode root;
	//Ceci nous permet de nous assurer que chaque intéraction avec l'arbre est faite uniquement à partir de cette classe
	private static LexiNodeController instance = null; 
	
	private LexiNodeController() {
		root = new LexiNode();
	}
	/**
	 * @return L'unique instance de cette classe
	 */
	public static LexiNodeController getInstance(){
		if(instance == null) {
			instance = new LexiNodeController();
		}
		return instance;
	}
	/**
	 * Methode qui va ajouter un mot et sa définition à l'arbre si le mot existe déjà cela va juste modifier sa définition
	 * @param word Le mot que l'on souhaite ajouter ou modifier à l'arbre
	 * @param definition sa définition
	 */
	public void addOrModify(String word, String definition) {
		if(root.acceder(word)==null){
			root.ajouter(word, definition);
		}
		else {
			root.modifier(word, definition);
		}
	}
	/**
	 * 
	 * @return Obtient un string avec tous les mots qui commence par la meme lettre/mot passé en parametre séparé par des "\n"
	 */
	public String getListWord(String word) {
		if(root.acceder(word) != null) {
			return root.acceder(word).toString();
		}
		else {
			return "Aucun mot correspondant";
		}
	}
	
	/**
	 * Obient la definition d'un mot si il est défini
	 * @param word
	 * @return la définition du mot passé en parametre si elle est défini
	 */
	public String define(String word) {
		if(root.acceder(word) != null) {
			return root.acceder(word).getDefinition();
		}
		else {
			return "";
		}
	}
	/**
	 * 
	 * @return un string avec tous les motsd defini de notre dictionnaire
	 */
	public String getListAllWord() {
		return root.toString();
	}
}
