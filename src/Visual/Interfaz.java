package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Interfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titulo = new JLabel("Nonograma");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 54));
		Titulo.setBounds(82, 53, 434, 66);
		frame.getContentPane().add(Titulo);
		
		
		JComboBox cajaDeNivel = new JComboBox();
		cajaDeNivel.setToolTipText("");
		cajaDeNivel.setModel(new DefaultComboBoxModel(new String[] {"5","6","7","8","9","10"}));
		cajaDeNivel.setBounds(82, 215, 142, 32);
		frame.getContentPane().add(cajaDeNivel);
		
		JButton btnNewButton = new JButton("Jugar!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(396, 212, 109, 32);
		frame.getContentPane().add(btnNewButton);
		
	}
}
