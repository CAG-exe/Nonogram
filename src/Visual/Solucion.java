package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Solucion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Boolean[][] matriz;
	private int tamanio;
	private JPanel panelNonogramaSolucion;
	private JPanel panelDeCasillasSolucion;
	private JPanel panelTasksVerticales;
	private JPanel panelTasksHorizontales;

	
	
	public Solucion(Boolean[][] matriz, int tamanio, JPanel panelTasksVerticales, JPanel panelTasksHorizontales) {
		this.matriz = matriz;
		this.panelTasksVerticales = panelTasksVerticales;
		this.panelTasksHorizontales = panelTasksHorizontales;
		this.tamanio = tamanio;
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(137, 108, 108));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		crearPanelesSegunTamanio();
		contentPanel.add(panelNonogramaSolucion);
		colocarPanalesDelNanograma();
		generarCasillas();
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(137, 108, 108));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("OK");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	private void crearPanelesSegunTamanio() {
		panelNonogramaSolucion = new JPanel();
		panelNonogramaSolucion.setLayout(new GridBagLayout());
		switch(tamanio) {
			case(5):
				setBounds(600, 400, 550, 500);
				panelNonogramaSolucion.setBounds(140, 100, 250, 250);
				panelDeCasillasSolucion = crearPanel(200, 50,Color.white);
				break;
			case(10):
				setBounds(600, 300, 600, 600);
				panelNonogramaSolucion.setBounds(120, 100, 350, 350);
				panelDeCasillasSolucion = crearPanel(280, 70,Color.white);
				break;
			case(15):
				setBounds(500, 200, 720, 750);
				panelNonogramaSolucion.setBounds(100, 100, 500, 500);
				panelDeCasillasSolucion = crearPanel(420, 90,Color.white);
				break;
			case(20):
				setBounds(500, 200, 850, 800);
				panelNonogramaSolucion.setBounds(130, 100, 550, 550);
				panelDeCasillasSolucion = crearPanel( 420, 130,Color.white);
				break;
		}
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
	
	
	private void colocarPanalesDelNanograma() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1; //Ocupara 1 celda
        gbc.gridheight = 1; //Ocupara 1 celda
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 0; // Posicion de Y = 0
        panelNonogramaSolucion.add(panelTasksVerticales, gbc);

        
        gbc.gridx = 0; // Posicion de X = 0
        gbc.gridy = 1; // Posicion de Y = 1
        panelNonogramaSolucion.add(panelTasksHorizontales, gbc);
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 1; // Posicion de Y = 1
        gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        panelNonogramaSolucion.add(panelDeCasillasSolucion, gbc);
	}
	
	
	public void generarCasillas() {
		panelDeCasillasSolucion.setLayout(new GridLayout(tamanio, tamanio, 0, 0));
		panelDeCasillasSolucion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		JPanel[][] casillas = new JPanel[tamanio][tamanio];
		for(int fila = 0; fila<tamanio ; fila++) {
			for(int columna = 0; columna<tamanio ; columna++) {
				JPanel casilla = new JPanel();
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				if(this.matriz[fila][columna]) {
					casilla.setBackground(Color.black);
				} else {
					casilla.setBackground(Color.white);
				}
				
				casillas[fila][columna] = casilla;
				panelDeCasillasSolucion.add(casilla);
			}
		}
	};

}