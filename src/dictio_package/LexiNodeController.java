package dictio_package;

public class LexiNodeController {
	
	private LexiNode root;
	//Ceci nous permet de nous assurer que chaque int�raction avec l'arbre est faite uniquement � partir de cette classe
	private static LexiNodeController instance = null; 
	
	private LexiNodeController() {
		root = new LexiNode();
	}
	public static LexiNodeController getInstance(){
		if(instance == null) {
			instance = new LexiNodeController();
		}
		return instance;
	}
	
	public void AddOrModify(String word, String definition) {
		if(root.acceder(word)==null){
			root.ajouter(word, definition);
		}
		else {
			root.modifier(word, definition);
		}
	}
	/**
	 * 
	 * Obtiens un string avec tous les mots qui commence par la meme lettre/mot pass� en parametre s�parer par des "\n"
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
	 * Obient la definition d'un mot si il est d�fini
	 * @param word
	 * @return la d�finition du mot pass� en parametre si elle est d�fini
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
