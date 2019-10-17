import java.time.*;
import java.util.stream.*;

public class Vol {
	private String[] identifiant;
	private ZonedDateTime depart;
	private ZonedDateTime arrivee;
	private boolean estOuvert;
	
	public Vol(String[] unIdentifiant, ZonedDateTime unDepart, ZonedDateTime uneArrivee) {
		identifiant = unIdentifiant;
		depart = unDepart;
		arrivee = uneArrivee;
		ouvrir();
	}
	
	public Duration duree() {
		return Duration(depart, arrivee);
	}
	
	public void ouvrir() {
		estOuvert = true;
	}
	
	public void fermee() {
		estOuvert = false;
	}
	
	@Override
	public String toString() {
		return Stream.of(identifiant).collect(Collectors.joining(", ")) + " " + depart + " " + arrivee;
	}
}
