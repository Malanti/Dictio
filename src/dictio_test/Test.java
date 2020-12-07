package dictio_test;

import dictio_package.*;

public class Test {
	
	public static void main(String[] args)
	{
		LexiNodeController controller = LexiNodeController.getInstance();
		controller.AddOrModify("salut", "Mot familier pour dire bonjour");
		controller.AddOrModify("wsh", "Mot tres tres familier pour dire bonjour");
		controller.AddOrModify("sale", "pas propre");
		controller.AddOrModify("salle", "une piece pour étudier");
		System.out.println(controller.getListAllWord());
		System.out.println();
		System.out.println(controller.getListWord("sa"));
		System.out.println();
		System.out.println();
		System.out.println(controller.define("salut"));
		System.out.println(controller.define("salle"));
		controller.AddOrModify("salut", "Nouvelle definition");
		System.out.println();
		System.out.println(controller.define("salut"));
	}

}
