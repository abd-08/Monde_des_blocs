

public enum tailleblock
{
 grand, moyen, petit;
 
 public static tailleblock getTaille(String taille) {
	 
	 if (taille.equals("petit")) {
		 return tailleblock.petit;
	 }
	 else if (taille.equals("moyen")) {
			 return tailleblock.moyen;
		 }
	 else return tailleblock.grand;
	
	}
	
}