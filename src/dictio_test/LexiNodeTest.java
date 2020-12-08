package dictio_test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dictio_package.LexiNodeController;

class LexiNodeTest {


	@Test
	void testGetDefinition() {
		LexiNodeController controller = LexiNodeController.getInstance();
		controller.addOrModify("salut", "Mot familier pour dire bonjour");
		String actual = controller.define("salut");
		String expected = "Mot familier pour dire bonjour";
		
		assertEquals(expected, actual);
	}

	@Test
	void testModifierOuAjouter() {
		LexiNodeController controller = LexiNodeController.getInstance();
		controller.addOrModify("salut", "Mot familier pour dire bonjour");
		controller.addOrModify("salut", "Nouvelle définition");
		String actual = controller.define("salut");
		String expected = "Nouvelle définition";
		
		assertEquals(expected, actual);
	}

	@Test
	void testAcceder() {
		LexiNodeController controller = LexiNodeController.getInstance();
		controller.addOrModify("salut", "Mot familier pour dire bonjour");
		String actual = controller.getListWord("salut");
		String expected = "salut\n";
		
		assertEquals(expected, actual);
		
	}

}
