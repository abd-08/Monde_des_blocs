import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class TableCanvas extends Canvas implements Observer{
	
	private static final long serialVersionUID = 1L;
	private int TAILLE =100;
	private int dx=0;
	private int dy=800;
	
	private Table t;

	public TableCanvas(Table t) {
		this.t = t;
		t.addObserver(this);
	}
	
	public void paint(Graphics g) {
		int hauteur;
		Cube cube; 
		
		for(int i=0 ; i<Table.TAILLE ; i++) {
			
			cube=t.Cubi(i);//on recupere le cube en position i de la liste
			g.setColor(Color.DARK_GRAY);			
			
			if (cube != null) {
				hauteur= cube.hauteur();
				
				for (int j=0 ; j < hauteur ;j++ ) {
					
					switch (cube.couleur.name()) {
					  case "rouge":g.setColor(Color.RED); break;
					  case "jaune":g.setColor(Color.YELLOW); break;
					  case "vert":g.setColor(Color.GREEN);break;
					  case "bleu": g.setColor(Color.BLUE);break;
					  case "cyan":g.setColor(Color.CYAN); break;
					  case "gris":g.setColor(Color.LIGHT_GRAY); break;
					  case "noir":g.setColor(Color.BLACK);break;
					  default:g.setColor(Color.RED);break;
					}
					g.fillRect(dx+(TAILLE*i)+2, dy-((j+1)*TAILLE) , TAILLE-4, TAILLE-4);
					
					g.setColor(Color.BLACK);
					if (cube.couleur.equals(Couleur.getCouleur("noir"))) g.setColor(Color.WHITE);
					g.drawString( (cube.taille).toString(), dx+(TAILLE*i)+40, dy-((j+1)*TAILLE)+50);
					g.drawString( (cube.couleur).toString(), dx+(TAILLE*i)+40, dy-((j+1)*TAILLE)+70);
					cube=cube.getDessus();
				}
			}
			else g.fillRect(dx+(TAILLE*i)+2, dy , TAILLE-4,5 );
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
		this.repaint();		
	}
}