package enchere;

public class offres {
	
	private double prix ;
	private membres m; 
	private ench�res e;
	public offres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public offres(double prix, membres m, ench�res e) {
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
	public ench�res getE() {
		return e;
	}
	public void setE(ench�res e) {
		this.e = e;
	}
	public String i() {
		return prix+"##"+m.getNom()+"##"+e.getIdE()+"##";
	}
	
}
