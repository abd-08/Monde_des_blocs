
import java.util.Observable;

public class Cube extends Observable{
    
    public tailleblock taille;
    public Couleur couleur;
    public Cube dessus;

    
    public tailleblock getTaille() {
		return taille;
	}
    public int hauteur() {
    	Cube tmp = this.dessus;
    	if (tmp==null) return 1;
    	else {
    		int cmp = 1;
    		while (tmp != null) {
    			cmp++;
    			tmp=tmp.getDessus();
    		}
    		return cmp;
    	}
    }
    
    public Cube getPositionCube(int position) {
    	if (this==null || this.hauteur()<position) return null;
    	else { 
    		Cube tmp=this;
    		for (int i = 1 ; i<position;i++){
        		tmp=tmp.getDessus();
        	}
        	return tmp;
    	}
    }
    
    

	public Couleur getCouleur() {
		return couleur;
	}

	public Cube getDessus() {
		return dessus;
	}
	


	public Cube(tailleblock taille,Couleur couleur) {
    	this.taille=taille;
    	this.couleur=couleur;
    	this.dessus=null;
    }
	
	public Cube(tailleblock taille,Couleur couleur,Cube Dessus) {
    	this.taille=taille;
    	this.couleur=couleur;
    	this.dessus=Dessus;
    }

    public void AjoutDessus(Cube Dessus) {
		this.dessus = Dessus;
	}
	public boolean PeutSePoser(tailleblock taille) {
    	
    	switch(taille)
        {
            case grand:
            	 return true;                          
            case moyen:
                if (this.taille.equals(tailleblock.getTaille("grand"))){
                return false;
                }
                else return true;
            case petit:
            	if (this.taille.equals(tailleblock.getTaille("moyen")) ||
            			this.taille.equals(tailleblock.getTaille("grand"))){
                return false;
                }
                else return true; 
            default:
              return false;
        }
    }


    public boolean EsTu(tailleblock taille, Couleur couleur) {
    		return (this.taille.equals(taille) && this.couleur.equals(couleur));
    }

    
    public void SupprimeDessus() {
    	this.dessus=null;
    }



     public Cube Sommet() {
    	if (this.getDessus() == null) return this;
    	else {
    		Cube c = this.getDessus();
    		while(c.getDessus()!=null) {
    			c=c.getDessus();
    		}
    		return c;
    	}
	  }
	    
    
  
    
     
    public Cube SupprimeSommet() {
    	if (this.getDessus()==null) {
			return this;
		}
    	else { 
    		Cube cube=this.getPositionCube(this.hauteur()-1); // on prend l'avant dernier cube
    		Cube sommet = cube.getDessus(); // prend le dernier cube
    		cube.setDessus(null);//on supprime le lien entre l'avant dernier cube et le dernier cube
    		return sommet;
    	}
    	
		
    }
	public void setDessus(Cube dessus) {
		this.dessus = dessus;
	}
		
    
  
	
	
}