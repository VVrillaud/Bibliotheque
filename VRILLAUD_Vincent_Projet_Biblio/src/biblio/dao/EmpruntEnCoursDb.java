//package biblio.dao;
//
//import java.util.Date;
//
//import biblio.metier.Exemplaire;
//import biblio.metier.Utilisateur;
//import metier.EmpruntEnCours;
//
//public class EmpruntEnCoursDb extends EmpruntEnCours {
//	
//	public int idEx;
//	public int idUt;
//
//	public EmpruntEnCoursDb(Utilisateur emprunteur, Exemplaire exemplaire, Date dateEmprunt) {
//		super(emprunteur, exemplaire, dateEmprunt);
//		// TODO Auto-generated constructor stub
//	}
//
//	public EmpruntEnCoursDb(Utilisateur emprunteur, Exemplaire exemplaire) {
//		
//		// TODO Auto-generated constructor stub
//	}
//
//	public EmpruntEnCoursDb(int idut, int idex) {
//		this(new Utilisateur(), new Exemplaire(), new Date());
//		this.setIdExemplaire = idex;
//		this.setIdUtilisateur = idut;
//		// TODO Auto-generated constructor stub
//	}
//
//	public EmpruntEnCoursDb() {
//		// TODO Auto-generated constructor stub
//	}
//
//}
