package Visual;

import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		
		frame = new JFrame();
		frame.setBackground(new Color(229, 190, 181));
		frame.getContentPane().setBackground(new Color(137, 108, 108));
		frame.setBounds(100, 100, 800, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton JugarButton = new JButton("Jugar!");
		JugarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JugarButton.setBackground(new Color(245, 250, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				JugarButton.setBackground(new Color(238, 230, 202));
			}
			
		});
		
		
		JugarButton.setBackground(new Color(238, 230, 202));
		JugarButton.setBounds(501, 268, 150, 77);
		JugarButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(JugarButton);
		
		JButton ComoJugarButton = new JButton("!!Como Jugar!!");
		ComoJugarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ComoJugarButton.setBackground(new Color(245, 250, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ComoJugarButton.setBackground(new Color(238, 230, 202));
			}
			
		});
		
		ComoJugarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tutorial = new Tutorial();
				tutorial.setVisible(true);
			}});

		
		ComoJugarButton.setBackground(new Color(238, 230, 202));
		ComoJugarButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ComoJugarButton.setBounds(501, 388, 150, 77);
		frame.getContentPane().add(ComoJugarButton);

		
		JLabel LogoLabel = new JLabel("");
		LogoLabel.setIcon(new ImageIcon("/Nonograma/src/nonograms-logo.png"));
		LogoLabel.setBounds(39, 85, 700, 116);
		frame.getContentPane().add(LogoLabel);
		
		JRadioButton cincoXcincoRadioButton = new JRadioButton("5x5");
		cincoXcincoRadioButton.setBackground(new Color(229, 190, 181));
		cincoXcincoRadioButton.setToolTipText("");
		cincoXcincoRadioButton.setBounds(117, 261, 150, 37);
		frame.getContentPane().add(cincoXcincoRadioButton);
		
		JRadioButton diezXdiezRadioButton = new JRadioButton("10x10");
		diezXdiezRadioButton.setBackground(new Color(229, 190, 181));
		diezXdiezRadioButton.setBounds(117, 318, 150, 37);
		frame.getContentPane().add(diezXdiezRadioButton);
		
		JRadioButton quinceXquinceRadioButton = new JRadioButton("15x15");
		quinceXquinceRadioButton.setBackground(new Color(229, 190, 181));
		quinceXquinceRadioButton.setBounds(117, 374, 150, 37);
		frame.getContentPane().add(quinceXquinceRadioButton);
		
		JRadioButton veinteXveinteRadioButton = new JRadioButton("20x20");
		veinteXveinteRadioButton.setBackground(new Color(229, 190, 181));
		veinteXveinteRadioButton.setBounds(117, 428, 150, 37);
		frame.getContentPane().add(veinteXveinteRadioButton);
		
		//frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalPolicy(new Component[]{JugarButton, LogoLabel, cincoXcincoRadioButton, diezXdiezRadioButton, quinceXquinceRadioButton, veinteXveinteRadioButton, ComoJugarButton}));
		
        // Crea el ButtonGroup
        ButtonGroup grupoOpciones = new ButtonGroup();

        // Agrega los JRadioButton al ButtonGroup
        grupoOpciones.add(cincoXcincoRadioButton);
        grupoOpciones.add(diezXdiezRadioButton);
        grupoOpciones.add(quinceXquinceRadioButton);
        grupoOpciones.add(veinteXveinteRadioButton);
        
        cincoXcincoRadioButton.setSelected(true);
		
	}
		

	}
