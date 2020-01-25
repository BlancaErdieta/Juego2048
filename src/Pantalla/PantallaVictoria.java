package Pantalla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.PanelJuego;
/**
 * 
 * @author BlancaErdieta
 *
 */
public class PantallaVictoria implements Pantalla{
	
	/** PANEL DE JUEGO **/
	PanelJuego panelJuego;
	/** TEXTO INICIO **/
	Color colorLetra = Color.WHITE;
	Font fuente = new Font("", Font.BOLD, 60);
	String puntuacion;

	public PantallaVictoria(PanelJuego panelJuego,String puntuacion) {
		this.puntuacion = puntuacion;
		inicializarPantalla(panelJuego);
	}

	@Override
	public void inicializarPantalla(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
		
	}

	@Override
	public void pintarPantalla(Graphics g) {
		g.setColor(new Color(92, 140, 189));
		g.fillRect(0, 0, panelJuego.getWidth(), panelJuego.getHeight());
		BufferedImage img;
		g.setFont(new Font("", Font.BOLD, 20));
		g.setColor(colorLetra);
		g.drawString("¡¡ENHORABUENA!!", 110,150);
		try {
			img = ImageIO.read(new File("Imagenes/2048.jpg"));
			g.drawImage(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH), panelJuego.getWidth()/3, panelJuego.getHeight()/3, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setFont(new Font("", Font.BOLD, 20));
		g.setColor(colorLetra);
		g.drawString(puntuacion, 110,panelJuego.getHeight()-150);
		
	}

	@Override
	public void ejecutarFrame() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void pulsarTecla(KeyEvent e) {
		panelJuego.setPantallaEjecucion(new PantallaInicio(panelJuego));;
		
		
	}

}
