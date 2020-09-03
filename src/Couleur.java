


public enum Couleur
{
 rouge, vert, jaune, bleu, cyan, gris, noir;

	
 public static Couleur getCouleur(String coulSaisie) {
	 switch(coulSaisie) {
	 
	 	case "rouge":return Couleur.rouge;
	 	case "vert":return Couleur.vert;
	 	case "jaune":return Couleur.jaune;
	 	case "bleu":return Couleur.bleu;
	 	case "cyan":return Couleur.cyan;
	 	case "gris":return Couleur.gris;
	 	case "noir":return Couleur.noir;
	 	default : return Couleur.rouge;
	 
	 }
 }


}
