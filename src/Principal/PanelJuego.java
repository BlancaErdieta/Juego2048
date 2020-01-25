package Principal;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import Pantalla.Pantalla;
import Pantalla.PantallaInicio;


/**
 * Panel de juego.
 * @author Blanca Erdieta
 */
public class PanelJuego extends JPanel implements Runnable ,KeyListener {
	private static final long serialVersionUID = 1L;
	
	/** PANTALLAS **/
	Pantalla pantallaEjecucion;

	// El contructor
	public PanelJuego() {
		this.setFocusable(true);
		pantallaEjecucion = new PantallaInicio(this);
		// HILO
		new Thread(this).start();
		this.addKeyListener(this);
	}

	// Metodo que se llama automaticamente
	@Override
	public void paintComponent(Graphics g) {
		pantallaEjecucion.pintarPantalla(g);
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			Toolkit.getDefaultToolkit().sync();
			pantallaEjecucion.ejecutarFrame();

		}

	}

	public Pantalla getPantallaEjecucion() {
		return pantallaEjecucion;
	}

	public void setPantallaEjecucion(Pantalla pantallaEjecucion) {
		this.pantallaEjecucion = pantallaEjecucion;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		pantallaEjecucion.pulsarTecla(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
