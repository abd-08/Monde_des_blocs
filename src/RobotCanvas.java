import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class RobotCanvas extends Canvas implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Robot r;

	
	public RobotCanvas(Robot r) {
		this.r=r;
		r.addObserver(this);
	}
	
	public void paint(Graphics g) {

		
		if(r.TientCube()) {
		
			switch (r.cubetenu.couleur.name()) {
			  case "rouge":g.setColor(Color.RED); break;
			  case "jaune":g.setColor(Color.YELLOW); break;
			  case "vert":g.setColor(Color.GREEN);break;
			  case "bleu": g.setColor(Color.BLUE);break;
			  case "cyan":g.setColor(Color.CYAN); break;
			  case "gris":g.setColor(Color.LIGHT_GRAY); break;
			  case "noir":g.setColor(Color.BLACK);break;
			  default:g.setColor(Color.RED);break;
			}
			g.fillRect(22, 22 , 110, 110);
			g.setColor(Color.BLACK);
			if (r.cubetenu.couleur.equals(Couleur.getCouleur("noir"))) g.setColor(Color.WHITE);
			g.drawString( (r.cubetenu.taille).toString(), 60, 70);
			g.drawString( (r.cubetenu.couleur).toString(), 65, 85);
		}
		else {
			
			g.setColor(Color.BLACK);
			g.fillRect(22, 22 , 110, 110);
			g.setColor(Color.WHITE);
			g.drawString("vide",70,85);

		}
		
	}
	
	

	public void SetCouleur(Graphics g ,String coul) {
		switch (coul) {
		  case "rouge":
		    g.setColor(Color.RED);
		    break;
		  case "jaune":
			    g.setColor(Color.YELLOW);
			    break;
		  case "vert":
			    g.setColor(Color.GREEN);
			    break;
		  case "bleu":
			    g.setColor(Color.BLUE);
			    break;
		  case "cyan":
			    g.setColor(Color.CYAN);
			    break;
		  case "gris":
			    g.setColor(Color.LIGHT_GRAY);
			    break;
		  case "noir":
			    g.setColor(Color.BLACK);
			    break;
		  default:
		    g.setColor(Color.RED);
		    break;
		}
	}
	
	
	public void update(Observable arg0, Object arg1) {
		if (arg0.hasChanged()) {
			this.repaint();		
		}
		this.repaint();	
	}


}
