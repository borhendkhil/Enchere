package enchere;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class Traitement extends Thread {
	private static final String[] String = null;
	private Socket s;
	private membres m = null;
	private enchères e = null;

	public Traitement(Socket s) {
		this.s = s;
	}
	
	
	public void run() {

		try

		{
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader in_sc = new BufferedReader(in);

			OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
			PrintWriter out_sc = new PrintWriter(new BufferedWriter(out), true);
			while (true) {
				String msg = in_sc.readLine();
				if (msg.startsWith("ENCHERES")) {
					String s = "";
					for (enchères e : serveur.listeEn) {
						s += e.i() + "///";
					}
					if (s.length() > 0) {
						out_sc.println(s);
					} else {
						out_sc.println("Aucun Enchere dispo");
					}
				} else if (msg.startsWith("JOIN ")) {
					String cd = msg.substring(5);
					int res = Integer.parseInt(cd);
					boolean test = false;
					for (enchères e : serveur.listeEn) {
						if (e.getDes().equals(msg.substring(5))) {
							e.lim.add(this.m);
							test = true;
						}
					}
					if (test == false) {
						out_sc.println("Enchere introuvable");
					}

				} else if (msg.startsWith("OFFRE ")) {
					String cd = msg.substring(6);
					String[] t = cd.split("##");
					int res = Integer.parseInt(t[0]);
					enchères en = null;

					boolean test = false;
					for (enchères e : serveur.listeEn) {
						if (e.getIdE() == res) {
							en = e;
							test = true;
						}
					}
					double doub = Double.parseDouble(t[0]);
					if (test == false) {
						out_sc.println("Enchere introuvable");
					} else {
						if (en.getPrix() < doub) {
							en.setPrix(doub);
							offres o = new offres (doub, this.m, en);
							serveur.listeOff.add(o);
							out_sc.println("Offre Accepte ;)");
						} else {
							System.out.println("-Offre non valide :( ");
						}
					}
				} else if (msg.startsWith("LIST ")) {
					String cd = msg.substring(5);
					String s = "";
					int res = Integer.parseInt(cd);
					enchères en = null;
					boolean test = false;
					for (enchères e : serveur.listeEn) {
						if (e.getIdE() == res) {
							en = e;
							test = true;
						}
					}
					if (test == false) {
						out_sc.println("Enchere introuvable");
					} else {
						for (offres o : serveur.listeOff) {
							if (o.getE() == en) {
								s += o.i();
							}
						}

						if (s.length() > 0) {
							out_sc.println(s);
						} else {
							out_sc.println("Aucun offre dispo pour cette enchere");
						}
					}

				} else if (msg.startsWith("LOGIN ")) {
					String nom = msg.substring(6);
					this.m = new membres(nom);
				}
				
				
				else {
					out_sc.println("Syntaxe Invalide !!");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
