import java.util.ArrayList;
import java.util.Observable;


public class Table extends Observable{
	public static final int TAILLE = 10;
	public static final int HAUTEUR_MAX = 8;
    public ArrayList<Cube> List  = new ArrayList<Cube> ();

   public Table() {
	   for (int i=0;i<TAILLE;i++) {
		   this.List.add(null);
	   }
   }
   public Cube Cubi(int i) {
	   return this.List.get(i);
   }
    

  
   public int PlaceDispo() {
	   //fonction qui renvoie le nombre de place disponible d'une table
	   int i = 0;
	   while (i<=TAILLE-1 && List.get(i)!=null) {   		
			i++;
	   }
	   if (i==TAILLE && List.get(i)!=null ) i=-1; 
	   return i;
   }
   
   
   public Cube chercheCube(tailleblock taille, Couleur couleur) {
   	//fonction qui vérifie si un cube d'une taille et d'une couleur est present en haut de file 
   	//renvoie la racine du cube
   	Cube cube; 	
   	for (Cube c: List) {
   		if (c!=null) {
	    		cube=c.Sommet();
	    		if ( cube.EsTu(taille, couleur)) {
	    			System.out.println("present");
	    			return c;
	    		}
   		}
   		else System.out.println("colonne vide");
   	}
   	System.out.println("absent");
		return null;
   }
   

    
    public void PoserCubeSurTable(Cube cube) {
    	int place = this.PlaceDispo();
    	if (place<Table.TAILLE) {
	    	this.List.set(place, cube);
	    	this.setChanged();
			this.notifyObservers();
	    	System.out.println("cube ajouter a la table");
    	}
    	else System.out.println("echec de l'ajout");
    }
  
    public void PoserCubeSurCube(Cube cubetenu, tailleblock taille, Couleur couleur) {
    	Cube poser = this.chercheCube(taille , couleur);
    	if (poser!=null) {
    		int i = this.List.indexOf(poser);
    		
    		if (this.List.get(i).hauteur()<Table.HAUTEUR_MAX) {
	    		this.List.get(i).Sommet().AjoutDessus(cubetenu);
	    		this.setChanged();
				this.notifyObservers();
	    		System.out.println("cube poser");
    		}
    		else System.out.println(" colonne plein ");
    	}
    	else System.out.println("destination non existant");
    	
    }

    public Cube EnleverCubeDeTable(tailleblock taille, Couleur couleur) {
    	Cube enlever = this.chercheCube(taille, couleur);
    	if (enlever!=null) {
    		boolean estbase = enlever.getDessus()==null; //variable qui sert si on a un seul cube sur une colonne
    		int i = this.List.indexOf(enlever);
    		enlever =this.List.get(i).SupprimeSommet();
    		if (estbase) this.List.set(i, null);//on supprime la base de la table
    		this.setChanged();
			this.notifyObservers();
    		System.out.println("suppression reussi");
    		return enlever ;
    		
    	}
    	else {
    		System.out.println("suppression impossible");
    		return null;
    	}
    }

 
	
}