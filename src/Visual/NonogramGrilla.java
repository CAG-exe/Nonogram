package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPrincipal;
import Negocio.Nonograma;

public class NonogramGrilla{
	private int tamanio;
	private Nonograma modelo;
	private JPanel panelNanograma;
	private JPanel[] panelesGrupo; //Contiene los paneles de casillas y los tasks
	private JPanel panelCasillas;
	private JPanel panelTasksVerticales;
	private JPanel panelTasksHorizontales;
	private TablaBotones tablaBotones;
	private ControladorPrincipal controladorPrincipal;
	private int cantidadDePaneles;
	
	public NonogramGrilla(Nonograma modelo, JPanel panelNanograma, ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.modelo = modelo;
		this.tamanio = modelo.obtenerTamanio();
		this.panelNanograma = panelNanograma;
		this.panelNanograma.setLayout(new GridBagLayout());
		this.panelNanograma.setBackground(Color.decode("#896c6c"));
		this.cantidadDePaneles = 3;
		iniciar();
	}
	
	private void iniciar() {
		especificarTamañosDePaneles();
		crearPanelesDelNanograma();
        generarCasillas();
        colocarTasks();
        
	}
	

	private void colocarTasks() {
		colocarTasksHorizontales();
		colocarTasksVerticales();
	}

	private void colocarTasksHorizontales() {
		panelTasksHorizontales.setLayout(new GridLayout(tamanio, 1, 0, 0));
		ArrayList<String> tasks = (ArrayList<String>) modelo.obtenerTasksHorizontales();
		for(String task : tasks) {
			JLabel textoParaTask = new JLabel();
			textoParaTask.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			textoParaTask.setHorizontalAlignment(SwingConstants.CENTER);
	        textoParaTask.setVerticalAlignment(SwingConstants.CENTER);
			textoParaTask.setText(task);
			textoParaTask.setBackground(Color.WHITE);
			panelTasksHorizontales.add(textoParaTask);
		}
	}

	private void colocarTasksVerticales() {
	    panelTasksVerticales.setLayout(new GridLayout(1, tamanio, 0, 0));
	    ArrayList<String> tasks = (ArrayList<String>) modelo.obtenerTasksVerticales();

	    for (String task : tasks) {
	        JPanel columna = new JPanel(new GridLayout(0, 1));
	        columna.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	        columna.setBackground(Color.WHITE);

	        String[] numeros = task.split(" ");
	        for (String numero : numeros) {
	            JLabel lbl = new JLabel(numero, SwingConstants.CENTER);
	            columna.add(lbl);
	        }

	        panelTasksVerticales.add(columna);
	    }
	}
	private void crearPanelesDelNanograma() {
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH; // Que ocupen todo el espacio disponible
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 1; //Ocupara 1 celda
        gbc.gridheight = 1; //Ocupara 1 celda
        
        gbc.gridx = 1; // Posicion de X = 1
        gbc.gridy = 0; // Posicion de Y = 0
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
	}

	private void especificarTamañosDePaneles() {
		Dimension[] dimensionesPaneles = controladorPrincipal.obtenerTamaniosDeLosPanelesDeLaGrilla();  
		panelesGrupo = new JPanel[cantidadDePaneles];
		for(int i = 0 ; i < panelesGrupo.length; i++) {
			panelesGrupo[i] = crearPanel(dimensionesPaneles[i], Color.white);
		}
	}

	private void generarCasillas() {
		panelCasillas.setLayout(new GridLayout(tamanio, tamanio, 0, 0));
		panelCasillas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		this.tablaBotones= new TablaBotones(panelCasillas,tamanio, controladorPrincipal);
		NonogramWindow.darCasillas(TablaBotones.casillas);
		panelCasillas = tablaBotones.generarCasillas();
		panelCasillas.revalidate();
		panelCasillas.repaint();
	}
	

	private JPanel crearPanel(Dimension dimension,Color color) {
		JPanel panel = new JPanel();
        panel.setPreferredSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);
        panel.setBackground(color);
		panel.setLayout(new BorderLayout());
		return panel;
	}
	
	public JPanel obtenerPanelTasksVerticales() {
		return panelTasksVerticales;
	}
	
	public JPanel obtenerPanelTasksHorizontales() {
		return panelTasksHorizontales;
	}
}