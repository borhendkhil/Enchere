package enchere;
import java.util.*;





public class enchères {
	private int idE;
	private String des;
	private double prix ;
	private int hf;
	private List<Integer> etat = Arrays.asList(0,1,2);
	public List<membres> lim =new ArrayList<>();
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public  double getPrix() {
		return prix;
	}
	public void setPrix(double doub) {
		this.prix = doub;
	}
	public int getHf() {
		return hf;
	}
	public void setHf(int hf) {
		this.hf = hf;
	}
	public List<Integer> getEtat() {
		return etat;
	}
	public void setEtat(List<Integer> etat) {
		this.etat = etat;
	}
	public List<membres> getListeM() {
		return lim;
	}
	public void setListeM( List<membres> lim) {
		this.lim= lim;
	}
	public enchères(int idE, String des, double prix, int hf, List<Integer> etat, List<membres> lim) {
		super();
		this.idE = idE;
		this.des = des;
		this.prix = prix;
		this.hf = hf;
		this.etat = etat;
		this.lim = lim;
	}
	public enchères() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String i() {
		return idE+des+"##"+prix+"##"+hf+"##"+etat+"##";
	}
	
}
