import java.time.*;
import java.util.stream.*;

public class Vol {
	private String identifiant[];
	private ZonedDateTime depart;
	private ZonedDateTime arrivee;
	private boolean estOuvert;

	public Vol(String identifiant[], ZonedDateTime depart, ZonedDateTime arrivee) {
		this.identifiant = identifiant;
		this.depart = depart;
		this.arrivee = arrivee;
		ouvrir();
	}

	public Duration duree() {
		return Duration.between(depart, arrivee);
	}

	public void ouvrir() {
		estOuvert = true;
	}

	public void fermee() {
		estOuvert = false;
	}

	@Override
	public String toString() {
		return "( identifiant: [" + Stream.of(identifiant).collect(Collectors.joining(", ")) + "], depart: " + depart + ", arrivee: " + arrivee + " )";
	}
}
