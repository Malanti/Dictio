package dictio_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextPane;

import dictio_package.Mot;
import javax.swing.JLabel;

public class Interface {

	private JFrame frame;
	private JTextField textField;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 539, 211);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Charger");
		btnNewButton.setBounds(144, 10, 119, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setBounds(277, 10, 119, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 129, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JList<Mot> list_1 = new JList<Mot>();
		list_1.setBounds(135, 77, -124, 86);
		frame.getContentPane().add(list_1);
		
		JList<Mot> list_2 = new JList<Mot>();
		list_2.setBounds(412, 145, 113, -94);
		frame.getContentPane().add(list_2);
		
		JButton btnNewButton_2 = new JButton("Ajouter/modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 152, 515, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(144, 41, 252, 97);
		frame.getContentPane().add(lblNewLabel);
		
		JList<Mot> list = new JList<>();
	}
}
