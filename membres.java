package enchere;



public class membres {

	private String nom;
	private int id;
	static int c;

	public membres(String nom) {
		this.nom = nom;
		this.id = c++;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getC() {
		return c;
	}

	public static void setC(int c) {
		membres.c = c;
	}

	public membres (String nom, int id) {
		super();
		this.nom = nom;
		this.id = id;
	}

}
