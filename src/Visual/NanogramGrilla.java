package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class NanogramGrilla{
	private JButton[][] casillas;
	private int tamanio;
	private JPanel panelNanograma;
	private JPanel panelCasillas;
	private JPanel panelTasksVerticales;
	private JPanel panelTasksHorizontales;
	
	public NanogramGrilla(int tamanio, JPanel panelNanograma) {
		this.tamanio = tamanio;
		this.panelNanograma = panelNanograma;
		this.panelNanograma.setLayout(new GridBagLayout());
		iniciar();
	}
	
	private void iniciar() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JPanel panelTasksVerticales = crearPanel(250, 50,Color.white);
        this.panelTasksVerticales = panelTasksVerticales;
        panelNanograma.add(panelTasksVerticales, gbc);

        
        gbc.gridx = 0; // Posicion de X = 0
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JPanel panelTasksHorizontales = crearPanel(50,250,Color.white);
        this.panelTasksHorizontales = panelTasksHorizontales;
        panelNanograma.add(panelTasksHorizontales, gbc);
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.panelCasillas = crearPanel(250,250,Color.white);
        panelNanograma.add(panelCasillas, gbc);
        generarCasillas();
        
	}
	

	private void generarCasillas() {
		panelCasillas.setLayout(new GridLayout(tamanio, tamanio, 0, 0));
		panelCasillas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		this.casillas = new JButton[tamanio][tamanio];
		for(int i = 0; i<tamanio ; i++) {
			for(int j = 0; j<tamanio ; j++) {
				JButton casilla = new JButton();
				casilla.setBackground(Color.white);
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				
				accionesDeClicACasillas(casilla);
				
				casillas[i][j] = casilla;
				panelCasillas.add(casilla);
			}
		}
		panelCasillas.revalidate();
		panelCasillas.repaint();
	}
	
	
	private void accionesDeClicACasillas(JButton casilla) {
		casilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(casilla.getBackground().equals(Color.white)) {
					casilla.setBackground(Color.black);
					casilla.setText("");
				} else {
					if(casilla.getBackground().equals(Color.black)) {
						casilla.setBackground(Color.white);
						casilla.setText("");
					}
				}
			}
		});
		
	}

	private JPanel crearPanel(int ancho, int alto,Color color) {
		JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(ancho, alto));
        panel.setMinimumSize(new Dimension(ancho, alto));
        panel.setMaximumSize(new Dimension(ancho, alto));
		panel.setBackground(color);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel.setLayout(new BorderLayout());
		return panel;
	}
}