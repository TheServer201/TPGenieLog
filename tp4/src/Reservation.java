import java.time.*;
import java.util.*;
import java.util.stream.*;

class Reservation {
	private Date date;
	private Double identifiant;
	private String etat;
	private List<Client> clients;
	private List<Passager> passagers;
	private List<Vol> vols;

	public Reservation(Date date, Double identifiant) {
		this.date = date;
		this.identifiant = identifiant;
		etat = "Attente";
		clients = new ArrayList<>();
		passagers = new ArrayList<>();
		vols = new ArrayList<>();
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void addPassager(Passager passager) {
		passagers.add(passager);
	}

	public void addVol(Vol vol) {
		vols.add(vol);
	}

	public void annuler() {
		etat = "Annuler";
	}

	public void confirmer() {
		etat = "Confirmer";
	}

	public void payer() {
		etat = "Payer";
	}

	@Override
	public String toString() {
		return "( date: " + date + ", identifiant: " + identifiant + ", etat: " + etat + ", clients: [" + clients.stream().map(Object::toString).collect(Collectors.joining(", ")) + "], passagers: [" + passagers.stream().map(Object::toString).collect(Collectors.joining(", ")) + "], vols: [" + vols.stream().map(Object::toString).collect(Collectors.joining(", ")) + "] )";
	}

	public static void main(String args[]) {
		Reservation reservation = new Reservation(new Date(2019, 10, 17), 0.0);
		System.out.println(reservation);
	}
}
