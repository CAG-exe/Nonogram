package Visual;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NanogramWindow extends JPanel {

	private JButton[][] casillas;
	private int tamanio = 5;
	private JPanel panelPrincipal;
	private JPanel panelNanograma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame juegoNonograma = new JFrame("Nonograma");
					NanogramWindow window = new NanogramWindow(5);
					juegoNonograma.add(window);
					juegoNonograma.setBounds(100, 100, 626, 600);
					juegoNonograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					juegoNonograma.setLocationRelativeTo(null);
					juegoNonograma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NanogramWindow(int tamanio) {
		this.tamanio = tamanio;
		initialize();
		NanogramGrilla nanogramaGrilla = new NanogramGrilla(tamanio, panelNanograma);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(new Color(137, 108, 108));
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		this.panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JPanel panelNanograma = new JPanel(new GridBagLayout());
		this.panelNanograma = panelNanograma;
		panelNanograma.setBounds(180, 100, 250, 250);
		panel.add(panelNanograma);
		panelNanograma.setLayout(new GridLayout(5, 5, 0, 0));
		panelNanograma.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		JButton comprobarButton = new JButton("Comprobar");
		comprobarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comprobarButton.setBounds(254, 410, 106, 39);
		panel.add(comprobarButton);
		
		JButton volverButton = new JButton("Volver al Menú");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz.volverAlMenu();
			}
		});
		volverButton.setBounds(50, 410, 150, 39);
		panel.add(volverButton);
	}
}
