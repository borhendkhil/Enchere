package enchere;

public class offres {
	
	private double prix ;
	private membres m; 
	private enchères e;
	public offres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public offres(double prix, membres m, enchères e) {
		super();
		this.prix = prix;
		this.m = m;
		this.e = e;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public membres getM() {
		return m;
	}
	public void setM(membres m) {
		this.m = m;
	}
	public enchères getE() {
		return e;
	}
	public void setE(enchères e) {
		this.e = e;
	}
	public String i() {
		return prix+"##"+m.getNom()+"##"+e.getIdE()+"##";
	}
	
}
