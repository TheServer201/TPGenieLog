public class Passager {
   	private String nom;
   	private String contact;

   	public Passager(String nom, String contact) {
		this.nom = nom;
		this.contact = contact;
 	}

	@Override
	public String toString() {
		return "( nom: " + nom + ", contact: " + contact + " )";
	}
}
