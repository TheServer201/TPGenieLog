public class Client {
	private String nom;
	private String paiement;
	private String contact;
	private String reference;

	public Client(String nom, String paiement, String contact, String reference) {
		this.nom = nom;
		this.paiement = paiement;
		this.contact = contact;
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "( nom: " + nom + ", paiement: " + paiement + ", contact: " + contact + ", reference: " + reference + " )";
	}
}
