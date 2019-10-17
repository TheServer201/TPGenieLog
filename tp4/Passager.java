public class Passager {
    private String nom;
    private String contact;


    public Passager(String unNom, String unContact) {
        nom = unNom;
        contact = unContact;
    }
	
	@Override
    public String toString() {
        return nom + " " + contact;
    }
}
