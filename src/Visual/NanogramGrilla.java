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
	private JPanel[] panelesGrupo; //Contiene los paneles de casillas y los tasks
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
		
		especificarTamañosDePaneles();
		
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1; //Ocupara 1 celda
        gbc.gridheight = 1; //Ocupara 1 celda
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        JPanel panelTasksVerticales = panelesGrupo[0];
        this.panelTasksVerticales = panelTasksVerticales;
        panelNanograma.add(panelTasksVerticales, gbc);

        
        gbc.gridx = 0; // Posicion de X = 0
        gbc.gridy = 1; // Posicion de Y = 1
        JPanel panelTasksHorizontales = panelesGrupo[1];
        this.panelTasksHorizontales = panelTasksHorizontales;
        panelNanograma.add(panelTasksHorizontales, gbc);
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        this.panelCasillas = panelesGrupo[2];
        panelNanograma.add(panelCasillas, gbc);
        generarCasillas();
        
	}
	

	private void especificarTamañosDePaneles() {
		panelesGrupo = new JPanel[3];
		if(tamanio==5) {
			panelesGrupo[0] = crearPanel(200, 50,Color.white);
			panelesGrupo[1] = crearPanel(50, 200,Color.white);
			panelesGrupo[2] = crearPanel(200, 200,Color.white);
		}
		else if(tamanio==10) {
			panelesGrupo[0] = crearPanel(280, 70,Color.white);
			panelesGrupo[1] = crearPanel(70, 280,Color.white);
			panelesGrupo[2] = crearPanel(280, 280,Color.white);
		}
		else if(tamanio==15) {
			panelesGrupo[0] = crearPanel(420, 90,Color.white);
			panelesGrupo[1] = crearPanel(90, 420,Color.white);
			panelesGrupo[2] = crearPanel(420, 420,Color.white);
		}
		else {
			panelesGrupo[0] = crearPanel(420, 130,Color.white);
			panelesGrupo[1] = crearPanel(130, 420,Color.white);
			panelesGrupo[2] = crearPanel(420, 420,Color.white);
			
		}	
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
			public void actionPerformed(ActionEvent e) { //Luego tambien voy a tratar de hacerlo con un EMUN. Para mas facha
				if(casilla.getBackground().equals(Color.white) && casilla.getText() != "X") {
					casilla.setBackground(Color.black);
					casilla.setText("");
				} else {
					if(casilla.getBackground().equals(Color.black)) {
						casilla.setBackground(Color.white);
						casilla.setText("X"); //Luego voy a hacer que la X se vea mas linda, por ahora se vera medio fea.
					} else {
						if(casilla.getText() == "X")
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