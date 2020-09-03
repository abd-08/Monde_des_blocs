
import java.awt.BorderLayout;
import java.awt.Frame;


public class TableFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3439804460291478781L;
	private Table t;
	final static int HAUTEUR = 1000;
	final static int LARGEUR = 1200;
	TableCanvas tc;

	
	public TableFrame(Table t ) {
		this.setT(t);
		setTitle("table ");
		setSize(LARGEUR, HAUTEUR);
		this.setLayout(new BorderLayout());
		this.add(new TableCanvas(t),BorderLayout.CENTER);
		this.addWindowListener(new FermerFenetre(this));
	    this.setVisible(true);	    
	}
	

	public static void main(String[] args) {
		Table t = new Table();
		Cube c1=new Cube(tailleblock.getTaille("grand"),Couleur.getCouleur("vert"));
		Cube c2=new Cube(tailleblock.getTaille("grand"),Couleur.getCouleur("rouge"));
		Cube c3=new Cube(tailleblock.getTaille("moyen"),Couleur.getCouleur("jaune"));
		Cube c4=new Cube(tailleblock.getTaille("petit"),Couleur.getCouleur("bleu"));

		t.PoserCubeSurTable(c1);
		t.PoserCubeSurTable(c2);

		t.PoserCubeSurCube(c4,c1.getTaille(),c1.getCouleur());
		t.PoserCubeSurCube(c3,c4.getTaille(),c4.getCouleur());
		
		new TableFrame(t);
	}
	
	


	public Table getT() {
		return t;
	}


	public void setT(Table t) {
		this.t = t;
	}


	
}