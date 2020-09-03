import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class MondeFrame extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6108889555562873076L;
	String taille="grand";
	String couleur="rouge";
	Table t ;
	Robot r;
	RobotFrame robof ;
	TableFrame tablef  ;
	
	final static int HAUTEUR = 900;
	final static int LARGEUR = 300;

	
	public MondeFrame(Table t , Robot r , RobotFrame robof ,TableFrame tablef  ){
		this.r=r;
		this.t=t;
		this.robof=robof ;
		this.tablef=tablef ;
		
		this.setSize(LARGEUR, HAUTEUR);
		this.setLayout(new GridLayout(8,1));
		
		
		// Choice Panel
		Panel chPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Label choice = new Label("Choisir la Couleur");
		chPanel.add(choice);
		Choice choix = new Choice();
			choix.addItem("rouge");
			choix.addItem("vert");
			choix.addItem("jaune");
			choix.addItem("bleu");
			choix.addItem("cyan");
			choix.addItem("gris");
			choix.addItem("noir");
		chPanel.add(choix);
		this.add(chPanel);
		
		// selectButton Panel
		Panel rbPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		Label selecttaille = new Label("selectionner la Taille");
		rbPanel.add(selecttaille);
		List lst = new List(3, false);
			lst.add("grand");
			lst.add("moyen");
			lst.add("petit");
		rbPanel.add(lst);
		this.add(rbPanel);
			
		//--------bouton
		Panel cr = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button creer = new Button("Créer un cube");
		cr.add(creer);
		this.add(cr);
		
		Panel dt = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button detruire = new Button("Détruire le cube");
		dt.add(detruire);
		this.add(dt);
		
		Panel pr = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button prendre = new Button("Prendre un cube");
		pr.add(prendre);
		this.add(pr);
		
		Panel pt = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button posertable = new Button("Poser le cube sur la table");
		pt.add(posertable);
		this.add(pt);
		
		Panel pc = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button posercube = new Button("Poser le cube sur un cube");
		pc.add(posercube);
		this.add(pc);			
		
		this.setBackground(Color.GRAY);
		this.setVisible(true);
		
		
		this.taille=lst.getSelectedItem();
		this.couleur=choix.getSelectedItem();
		
		
		
		choix.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	couleur = choix.getSelectedItem();
		        System.out.println("Couleur : " + choix.getSelectedItem());
		       
		      }
		    });
				
		lst.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	taille = lst.getSelectedItem();
		        System.out.println("taille : " + lst.getSelectedItem()+" "+taille);
		      }
		    });
		
		this.addWindowListener(new FermerFenetre(this));
		
		creer.addActionListener(new ActionListener() {  

			public void actionPerformed(ActionEvent e) {       
				taille= lst.getSelectedItem();
            	couleur=choix.getSelectedItem();
            	r.CreerCube(tailleblock.getTaille(taille), Couleur.getCouleur(couleur));
            }  
        });		
		
		detruire.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	r.DetruireCube(); 
            }
		});	
		
		posertable.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	r.PoserCubeSurTable(t); 
            }
		});
		
		posercube.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	taille= lst.getSelectedItem();
            	couleur=choix.getSelectedItem();
            	r.PoserCubeSurCube(tailleblock.getTaille(taille),Couleur.getCouleur(couleur), t); 
            }
		}); 
		
		prendre.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	taille= lst.getSelectedItem();
            	couleur=choix.getSelectedItem();
            	r.PrendreCube(tailleblock.getTaille(taille),Couleur.getCouleur(couleur), t); 
            }
		});
			
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r = new Robot();
		Table t = new Table(); 
		RobotFrame robof = new RobotFrame(r);
		TableFrame tablef = new TableFrame(t); 
		new MondeFrame( t,r,robof,tablef);

	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


