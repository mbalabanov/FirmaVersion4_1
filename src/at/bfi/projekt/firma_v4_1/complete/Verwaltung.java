/*
 * 
 * Firma V4.1 - Verwaltung
 * 
 */

package at.bfi.projekt.firma_v4_1.complete;

public class Verwaltung implements Utility {

	private Firma firma;
	private static Mitarbeiter[] mitarbeiter_Liste;
	private static Abteilung[] abteilungs_Liste;

	public Verwaltung() {
		init();
	}

	public static void main(String[] args) {
		Verwaltung verwaltung = new Verwaltung();

	}

	public void init() {

		// Mitarbeiter und Mitarbeiterliste werden erstellt.
		mitarbeiter_Liste = new Mitarbeiter[SIZE_MITARBEITER];
		mitarbeiter_Liste[0] = new Arbeiter(1, "Anneken", 29.1, 109, 94.4);
		mitarbeiter_Liste[1] = new Arbeiter(2, "Poldi", 31.7, 97, 101.3);
		mitarbeiter_Liste[2] = new Arbeiter(3, "Ottila", 17.2, 83, 44.9);
		mitarbeiter_Liste[3] = new Arbeiter(4, "Eckehard", 27.8, 134, 104.7);
		mitarbeiter_Liste[4] = new Arbeiter(5, "Juliane", 23.7, 124, 114.1);
		mitarbeiter_Liste[5] = new Arbeiter(6, "Erna", 22.5, 123, 111.8);
		mitarbeiter_Liste[6] = new Angestellter(7, "Mathis", 2400.00, 1211.30, 18.8);
		mitarbeiter_Liste[7] = new Angestellter(8, "Hardwin", 2800.00, 1309.80, 19.9);
		mitarbeiter_Liste[8] = new Angestellter(9, "Barthold", 1812.23, 992.20, 20.0);
		mitarbeiter_Liste[9] = new Angestellter(10, "Ortrun", 1903.67, 1489.10, 21.1);
		mitarbeiter_Liste[10] = new Angestellter(11, "Loreley", 1407.95, 1298.21, 22.2);
		mitarbeiter_Liste[11] = new Angestellter(12, "Wilmar", 1703.67, 1496.21, 23.3);

		// Abteilungen und Abteilungsliste werden erstellt
		abteilungs_Liste = new Abteilung[SIZE_ABTEILUNG];
		abteilungs_Liste[0] = new Abteilung(1, ABTEILUNG_PR, new Mitarbeiter[] { mitarbeiter_Liste[0],
				mitarbeiter_Liste[5], mitarbeiter_Liste[6], mitarbeiter_Liste[7] });
		abteilungs_Liste[1] = new Abteilung(2, ABTEILUNG_SALES, new Mitarbeiter[] { mitarbeiter_Liste[1],
				mitarbeiter_Liste[2], mitarbeiter_Liste[8], mitarbeiter_Liste[9], mitarbeiter_Liste[10] });
		abteilungs_Liste[2] = new Abteilung(3, ABTEILUNG_IT,
				new Mitarbeiter[] { mitarbeiter_Liste[4], mitarbeiter_Liste[5], mitarbeiter_Liste[11] });
		abteilungs_Liste[3] = new Abteilung(4, ABTEILUNG_HR, new Mitarbeiter[] { mitarbeiter_Liste[3] });

		// Firma wird erstellt
		Firma firma = new Firma(mitarbeiter_Liste, abteilungs_Liste);
		this.firma = firma;
	}

	/**
	 * @return
	 */
	public double berechneSummeAlleGehaelter() {
		double summeGehaelter = 0.0;
		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			summeGehaelter = summeGehaelter + dieserMitarbeiter.berechneBrutto();
		}
		return summeGehaelter;
	};

	/**
	 * @param dieserMitarbeiter
	 * @return
	 */
	public double berechneNettoGehalt(Mitarbeiter dieserMitarbeiter) {
		double bruttoBetrag = dieserMitarbeiter.berechneBrutto();
		double steuerBetrag = 0;

		if (dieserMitarbeiter instanceof Arbeiter) {
			steuerBetrag = bruttoBetrag * TAX_ARB;
		}
		if (dieserMitarbeiter instanceof Angestellter) {
			steuerBetrag = bruttoBetrag * TAX_ANG;
		}

		return bruttoBetrag - steuerBetrag;
	};

	public String ausgabe_AlleAbteilungen() {
		String tempAusgabe = "";
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			tempAusgabe += dieseAbteilung.ausgabe();
		}

		return tempAusgabe;
	}

	/**
	 * @param abt_id
	 * @return
	 */
	public Mitarbeiter[] getMitarbeiterListeVonAbteilung(int abt_id) {
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			if (dieseAbteilung.getId() == abt_id) {
				return dieseAbteilung.getMitarb_liste();
			}
		}
		return null;
	}

	/**
	 * @param mitarbeiter_id
	 * @return
	 */
	public Mitarbeiter searchMitarbeiterAusFirma(int mitarbeiter_id) {
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			for (Mitarbeiter dieserMitarbeiter : dieseAbteilung.getMitarb_liste()) {
				if (dieserMitarbeiter.getId() == mitarbeiter_id)
					return dieserMitarbeiter;
			}
		}

		return null;
	}

	public boolean searchAbteilung(int id) {
		for (Abteilung abteilung : firma.getAbteilungs_Liste()) {
			if (abteilung.getId() == id) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param dieserMitarbeiter
	 */
	public void ausgabe(Mitarbeiter dieserMitarbeiter) {
		System.out.println(dieserMitarbeiter.ausgabe());
		System.out.print("Netto: ");
		System.out.printf("%.2f%n", berechneNettoGehalt(dieserMitarbeiter));
	}

	/**
	 * Diese
	 * 
	 * @param mitarbeiterListe
	 */
	public String ausgabeMitarbeiterListe(Mitarbeiter[] dieseMitarbeiterListe) {
		String tempAusgabe = "";
		if (dieseMitarbeiterListe != null) {
			for (Mitarbeiter dieserMitarbeiter : dieseMitarbeiterListe) {
				tempAusgabe += dieserMitarbeiter.ausgabe();
			}
		}

		return tempAusgabe;
	}

	/**
	 * @return
	 */
	public int getAnzAngestellterGesamt() {
		int anzahlAngestellte = 0;

		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			if (dieserMitarbeiter instanceof Angestellter) {
				anzahlAngestellte++;
			}
		}

		return anzahlAngestellte;
	};

	/**
	 * @return
	 */
	public int getAnzArbeiterGesamt() {
		int anzahlArbeiter = 0;

		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			if (dieserMitarbeiter instanceof Arbeiter) {
				anzahlArbeiter++;
			}
		}

		return anzahlArbeiter;
	}

	public Abteilung[] getAbteilungs_Liste() {
		return abteilungs_Liste;
	}

	public void setAbteilungs_Liste(Abteilung[] abteilungs_Liste) {
		this.abteilungs_Liste = abteilungs_Liste;
	}

	public Mitarbeiter[] getMitarbeiter_Liste() {
		return mitarbeiter_Liste;
	}

	public void setMitarbeiter_Liste(Mitarbeiter[] mitarbeiter_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
	};

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}
}
