import java.util.Observable;

public class Robot extends Observable {

    public Cube cubetenu;

    public Robot() {
    	super();
		this.cubetenu = null;
	}

	public void CreerCube(tailleblock taille, Couleur couleur) {
		if (!TientCube()) {
			this.cubetenu = new Cube(taille,couleur);
			this.NotoficationChangement(); //Notification pour le graphiique
			System.out.println("le "+ taille.toString() +" cube "+ couleur.toString()+ " a été créer ");
		}
		else System.out.println("le robot n'est pas vide");
    }

    public void PrendreCube(tailleblock taille, Couleur couleur,Table t) {
    	if (!TientCube()) {
    		Cube present=t.EnleverCubeDeTable(taille,couleur);
	    	if (present!=null) {
	    		this.MiseAJourRobo(present.Sommet());
	    		this.NotoficationChangement();
	    	}
	    	else System.out.println("ce cube n'est pas sur la table ");
    	}
    	else System.out.println(" le robot tient un cube !" );
    }

    public void DetruireCube() {
    	if (TientCube()) {
    		System.out.println("le "+ this.cubetenu.getTaille().toString()+" cube " +this.cubetenu.getCouleur().toString() + " a été détruit");
    		this.LacherCube();
    		this.NotoficationChangement();

    	}
    	else System.out.println("aucun cube à détruire");
    }

    public void PoserCubeSurTable(Table t) {
    	if (TientCube()) {
    			t.PoserCubeSurTable(this.cubetenu);
    			this.LacherCube();
    			this.NotoficationChangement();
    	}
    	else System.out.println("aucun cube dans le robot");
    }

    public void PoserCubeSurCube(tailleblock taille, Couleur couleur,Table t) {
    	if (TientCube()) {
	    		if (this.cubetenu.PeutSePoser(taille)) {
	    			t.PoserCubeSurCube(this.cubetenu, taille,couleur);
	    			this.LacherCube();
	    			this.NotoficationChangement();
    			}
	    		else System.out.println("le cube est trop grand ");
    		
    	}
    	else System.out.println("aucun cube dans le robot");
    }

    public boolean TientCube() {
		return this.cubetenu!=null; 
    }

    public void MiseAJourRobo(Cube cube) {
    	this.cubetenu=cube;
    }
    
    public void NotoficationChangement() {
    	this.setChanged();
		this.notifyObservers();
    }

    public void LacherCube() {
    	this.cubetenu=null;
    }



}