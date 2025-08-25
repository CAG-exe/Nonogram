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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NanogramGrilla{
	private JButton[][] casillas;
	private int tamanio;
	private JPanel panelNanograma;
	private JPanel panelCasillas;
	
	public NanogramGrilla(int tamanio, JPanel panelNanograma) {
		this.tamanio = tamanio;
		this.panelNanograma = panelNanograma;
		this.panelNanograma.setLayout(new GridBagLayout());
		iniciar();
	}
	
	private void iniciar() {
		panelNanograma.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
	    gbc.insets = new Insets(0, 0, 0, 0); // Sin espacio entre casillas
		
        gbc.gridx = 0; // Posicion de X = 0
        gbc.gridy = 0; // Posicion de Y = 0
        gbc.weightx = 0.2; // Espacio para las pistas horizontales
        gbc.weighty = 0.2;
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 0; // Posicion de Y = 0
        gbc.weightx = 0.8; // Espacio para las pistas verticales
        gbc.weighty = 0.2;
        JPanel panelTasksVerticales = crearPanel(Color.white);
        panelNanograma.add(panelTasksVerticales, gbc);
        
        gbc.gridx = 0; // Posicion de X = 0
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.weightx = 0.2; // Espacio para las pistas horizontales
        gbc.weighty = 0.8;
        JPanel panelTasksHorizontales = crearPanel(Color.white);
        panelNanograma.add(panelTasksHorizontales, gbc);
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.weightx = 0.9; // Espacio principal para las casillas
        gbc.weighty = 0.9;
        this.panelCasillas = crearPanel(Color.white);
        panelNanograma.add(panelCasillas, gbc);
        generarCasillas();

	}

	private void generarCasillas() {
		this.casillas = new JButton[tamanio][tamanio];
		for(int i = 0; i<tamanio ; i++) {
			for(int j = 0; j<tamanio ; j++) {
				JButton casilla = new JButton();
				casilla.setBackground(Color.white);
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				
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
				
				casillas[i][j] = casilla;
				panelCasillas.add(casilla);
			}
		}
		
		
		  panelCasillas.revalidate();
		  panelCasillas.repaint();
	}
	
	
	private JPanel crearPanel(Color color) {
		JPanel panel = new JPanel();
		panel.setBackground(color);
		panel.setLayout(new BorderLayout());
		return panel;
	}
}
     	  panelCasillas.setLayout(new GridLayout(tamanio, tamanio, 0, 0));
    	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
