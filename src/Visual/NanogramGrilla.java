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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
		GridBagConstraints gbcParaLosPaneles = new GridBagConstraints();
	    gbcParaLosPaneles.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
	    gbcParaLosPaneles.insets = new Insets(0, 0, 0, 0); // Sin espacio entre casillas
	    
	    gbcParaLosPaneles.gridx = 1; // Posicion de X = 1
	    gbcParaLosPaneles.gridy = 0; // Posicion de Y = 0
	    gbcParaLosPaneles.weightx = 0.8; // Espacio para las pistas verticales
	    gbcParaLosPaneles.weighty = 0.2;
        JPanel panelTasksVerticales = crearPanel(Color.white);
        panelNanograma.add(panelTasksVerticales, gbcParaLosPaneles);
        
        gbcParaLosPaneles.gridx = 0; // Posicion de X = 0
        gbcParaLosPaneles.gridy = 1; // Posicion de Y = 1
        gbcParaLosPaneles.weightx = 0.2; // Espacio para las pistas horizontales
        gbcParaLosPaneles.weighty = 0.8;
        JPanel panelTasksHorizontales = crearPanel(Color.white);
        panelNanograma.add(panelTasksHorizontales, gbcParaLosPaneles);
        
        gbcParaLosPaneles.gridx = 1; // Posicion de X = 1
        gbcParaLosPaneles.gridy = 1; // Posicion de Y = 1
        gbcParaLosPaneles.weightx = 0.9; // Espacio principal para las casillas
        gbcParaLosPaneles.weighty = 0.9;
        this.panelCasillas = crearPanel(Color.white);
        panelNanograma.add(panelCasillas, gbcParaLosPaneles);
        generarCasillas();

	}

	private void generarCasillas() {
		panelCasillas.setLayout(new GridLayout(tamanio, tamanio, 0, 0));
		panelCasillas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
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
				
				casilla.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (SwingUtilities.isRightMouseButton(e)) {
				        	if(casilla.getText() == "x") {
				        		casilla.setText("");
				        	} else {
				        		casilla.setText("x");
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
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel.setLayout(new BorderLayout());
		return panel;
	}
}