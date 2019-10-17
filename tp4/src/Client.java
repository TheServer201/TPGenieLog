public class Client {
	private String nom;
	private String paiement;
	private String contact;
	private String reference;
	
	public Client (String unNom, String unPaiement, String unContact, String uneReference) {
		nom = unNom;
		paiement = unPaiement;
		contact = unContact;
		reference = uneReference;
	}
	
	@Override
	public String toString() {
		return nom + " " + paiement + " " + contact + " " + reference;
	}
}
