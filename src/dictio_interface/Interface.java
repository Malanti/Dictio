package dictio_interface;


import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import javax.swing.filechooser.FileNameExtensionFilter;

import dictio_package.*;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.EventQueue;


public class Interface {

	private JFrame frame;
	private JTextField textField;
	protected JLabel lblNewLabel_1;
	protected JButton btnNewButton;
	protected JButton btnNewButton_1;
	protected JTextPane textPane;
	protected JScrollPane scrollPane_1;
	protected JPanel panel;
	protected JScrollPane scrollPane;
	protected JPanel panel_1;
	protected JButton btnNewButton_2;
	protected JList<String> list = new JList<String>();
	protected JList<String> list2 = new JList<String>();
	
	private static LexiNodeController controller = LexiNodeController.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
		perform();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//FENETRE
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 661, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//LABEL-CONSIGNES
		lblNewLabel_1 = new JLabel("Veuillez charger votre fichier TXT pour commencer");
		lblNewLabel_1.setBounds(181, 49, 367, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		//CHARGER FICHIER
		btnNewButton = new JButton("Charger");
		btnNewButton.setBounds(181, 10, 153, 30);
		frame.getContentPane().add(btnNewButton);
		
		//ENREGISTRER FICHIER
		btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setBounds(395, 10, 153, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		//TEXTE DE LA DEFINITION
		textPane = new JTextPane();
		textPane.setBounds(144, 81, 252, 183);
		frame.getContentPane().add(textPane);
				
		//LISTE DES MOTS
		scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(406, 81, 241, 183);
	    frame.getContentPane().add(scrollPane_1); 
		
		panel = new JPanel();
	    panel.setBounds(406, 41, 119, 101);	    
  		scrollPane_1.setViewportView(panel);
	    
	    
	  //LISTE DES MOTS COURANTS
  		scrollPane = new JScrollPane();
  		scrollPane.setBounds(10, 81, 129, 183);
  		frame.getContentPane().add(scrollPane);
  		
  		panel_1 = new JPanel();
  		scrollPane.setViewportView(panel_1);
	    
	    //RECHERCHE MOT
  		textField = new JTextField();
  		textField.setBounds(10, 41, 129, 30);
  		frame.getContentPane().add(textField);
  		textField.setColumns(10);
  		

	  	//AJOUTER/MODIFIER MOT OU DEFINITION
		btnNewButton_2 = new JButton("Ajouter/modifier");
		btnNewButton_2.setBounds(0, 274, 647, 30);
		frame.getContentPane().add(btnNewButton_2);
			
	}
	
	private void perform() {
		
		//ACTION CHARGEMENT FICHIER
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile = new JFileChooser();
				jfile.setDialogTitle("Chargez votre fichier");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				jfile.setFileFilter(filter);
				int b = jfile.showSaveDialog(null);
				if(b == JFileChooser.APPROVE_OPTION) {
					File file = jfile.getSelectedFile();
					try {
						String path = file.toString();
						System.out.println(path);
						TraitementFichier tf = new TraitementFichier(path);
						tf.chargement(controller);
						System.out.println("Traitement fichier réalisé");
						System.out.println(controller.getListAllWord());
						lblNewLabel_1.setText("Votre fichier a été charger avec succès");
						
						//LISTE DES MOTS APRES CHARGEMENT DU FICHIER
						//Création de la liste
						list = new JList<String>();
						list.setSelectedIndex(0);
						list.setLayoutOrientation(JList.VERTICAL);
						list.setFixedCellWidth(panel.getWidth()); 
					    
					    //Action de la liste 
						list.addMouseListener(new MouseAdapter() {
					    	@Override
					    	public void mouseClicked(MouseEvent e) {
					    		textField.setText(list.getSelectedValue());
					    		textPane.setText(controller.define(list.getSelectedValue()));
					    	}
					    });
						
						//traitement du panel qui contient la liste
					    panel.removeAll();
						panel.add(list);
						String[] listeDesMots = controller.getListAllWord().split("\n");
						System.out.println(listeDesMots.length);
						list.setListData(listeDesMots);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});		
		
		//ENREGISTREMENT DU FICHIER
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile = new JFileChooser();
				jfile.setDialogTitle("Enregistrez votre fichier");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				jfile.setFileFilter(filter);
				int b = jfile.showSaveDialog(null);
				if(b == JFileChooser.APPROVE_OPTION) {
					File file = jfile.getSelectedFile();
					if(!jfile.getSelectedFile().getAbsolutePath().endsWith(".txt")){
						file = new File(jfile.getSelectedFile() + ".txt");
					}
					try {
						String path = file.toString();
						System.out.println(path);
						TraitementFichier tf = new TraitementFichier(path);
						tf.enregistrement(controller);
						lblNewLabel_1.setText("Le fichier a été enregistré");	
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//RECHERCHE DU MOT
		textField.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			String motCourant = textField.getText();
			System.out.println(motCourant);
			
			//Création de la liste
			list2 = new JList<String>();
			list2.setSelectedIndex(0);
		    list2.setLayoutOrientation(JList.VERTICAL);
		    list2.setFixedCellWidth(panel_1.getWidth()); 
		    
		    //Action de la liste 
  			list2.addMouseListener(new MouseAdapter() {
  		    	@Override
  		    	public void mouseClicked(MouseEvent e) {
  		    		textField.setText(list2.getSelectedValue());
  		    		textPane.setText(controller.define(list2.getSelectedValue()));
  		    	}
  		    });
  			    
  			    //traitement du panel qui contient la liste
  			    panel_1.removeAll();
  				panel_1.add(list2);
  				String[] listeDesMotsCourants = controller.getListWord(motCourant).split("\n");
  				list2.setListData(listeDesMotsCourants);
  				
  				textPane.setText(controller.define(textField.getText()));
  			}
  		});
				
		//AJOUT-MODIF MOT
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addOrModify(textField.getText(), textPane.getText());
				panel.removeAll();
				String[] listeDesMots = controller.getListAllWord().split("\n");
				list.setListData(listeDesMots);
  				panel.add(list);
  				
  				
			}
		});
	
	}
	
}
