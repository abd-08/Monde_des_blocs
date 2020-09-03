
import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;


public class RobotFrame extends Frame implements Observer {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Robot r;
	RobotCanvas rc;
	final static int HAUTEUR = 350;
	final static int LARGEUR = 350;
	
	public RobotFrame(Robot r){
		this.r=r;
		r.addObserver(this);
		this.setTitle("Robot");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new BorderLayout());
		this.rc = new RobotCanvas(r);
		this.add(this.rc,BorderLayout.CENTER);
		this.addWindowListener(new FermerFenetre(this));
		this.setVisible(true);
	}

	public Robot getR() {
		return r;
	}

	public void setR(Robot r) {
		this.r = r;
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		this.rc.repaint();
		 
	}
	

	public static void main(String[] args) {
		Cube c1=new Cube(tailleblock.getTaille("grand"),Couleur.getCouleur("vert"));
		Robot r = new Robot();
		r.MiseAJourRobo(c1);
		new RobotFrame(r);
	} 
}
