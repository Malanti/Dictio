package dictio_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import dictio_package.*;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Interface {

	private JFrame frame;
	private JTextField textField;
	protected AbstractButton lblNewLabel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Dictionnaire d = new Dictionnaire();
		
		Mot m1 = new Mot("Nom1", "Def1");
		Mot m2 = new Mot("Nom2", "Def2");
		Mot m3 = new Mot("Nom3", "Def3");
		
		d.add(m1);
		d.add(m2);
		d.add(m3);
		
		System.out.println(d.toString());
		System.out.println(d.getDictNom().toString());
		
		
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 547, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//CHARGER FICHIER
		JButton btnNewButton = new JButton("Charger");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//action
				System.out.println("ACTION CHARGER FICHIER");
			}
		});
		btnNewButton.setBounds(144, 10, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		//ENREGISTRER FICHIER
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ACTION ENREGISTRER");	
			}
		});
		btnNewButton_1.setBounds(277, 10, 119, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		//DEFINITION
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(144, 41, 252, 63);
		frame.getContentPane().add(lblNewLabel);
		
		
		//RECHERCHE MOT
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("RECHERCHE MOT");
				lblNewLabel.setText("T");
			}
		});
		textField.setBounds(10, 44, 129, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		//AJOUTER/MODIFIER MOT OU DEFINITION
				JButton btnNewButton_2 = new JButton("Ajouter/modifier");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("ACTION AJOUTER/MODIFER");
					}
				});
				btnNewButton_2.setBounds(10, 152, 515, 21);
				frame.getContentPane().add(btnNewButton_2);
				
		//LISTE DES MOTS		
		int n = Dictionnaire.getDictNom().size();
		String[] listeMot = new String[n];
		for(int i = 0; i<n;i++) {
			listeMot[i]=Dictionnaire.getDictNom().get(i);
			System.out.println(listeMot[i]);
		}
		JList<String> list = new JList<String>(listeMot);
		list.setBounds(397, 140, 128, -99);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(list);
		frame.getContentPane().add(scrollPane);
		
	}
}
