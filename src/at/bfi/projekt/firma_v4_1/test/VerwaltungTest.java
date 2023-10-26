package at.bfi.projekt.firma_v4_1.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.bfi.projekt.firma_v4_1.complete.Angestellter;
import at.bfi.projekt.firma_v4_1.complete.Arbeiter;
import at.bfi.projekt.firma_v4_1.complete.Mitarbeiter;
import at.bfi.projekt.firma_v4_1.complete.Verwaltung;

class VerwaltungTest {

	@Test
	void testGetAnzahlDerArbeiterGesamt() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		Mitarbeiter[] dieseMitarbeiterListe = verwaltung.getMitarbeiter_Liste();

		// Act
		int actualAnzArbeiter = verwaltung.getAnzArbeiterGesamt(dieseMitarbeiterListe);
		int expectedAnzArbeiter = 6;

		// Assert
		assertEquals(expectedAnzArbeiter, actualAnzArbeiter);
	}

	@Test
	void testGetAnzahlDerAngestelltenGesamt() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		Mitarbeiter[] dieseMitarbeiterListe = verwaltung.getMitarbeiter_Liste();

		// Act
		int actualAnzAngestellte = verwaltung.getAnzAngestellterGesamt(dieseMitarbeiterListe);
		int expectedAnzAngestellte = 6;

		// Assert
		assertEquals(expectedAnzAngestellte, actualAnzAngestellte);
	}

	@Test
	void testBerechneSummeAllerGehaelter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		double actualSummeGehaelter = verwaltung.berechneSummeAlleGehaelter();
		double expectedAnzAngestellte = 37626.74;

		// Assert
		assertEquals(expectedAnzAngestellte, actualSummeGehaelter);
	}

	@Test
	void testBerechneNettoArbeiter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		final double ASSERTION_TAX_ARB = 0.15;

		// Act
		Arbeiter arbeiter_0 = new Arbeiter(1, "Klemens", 10, 10, 10);
		Arbeiter arbeiter_1 = new Arbeiter(2, "Karoline", 20, 20, 20);

		double nettoArbeiter_0 = verwaltung.berechneNettoGehalt(arbeiter_0);
		double nettoArbeiter_1 = verwaltung.berechneNettoGehalt(arbeiter_1);

		double assertionBruttoTemp = arbeiter_0.berechneBrutto() + arbeiter_1.berechneBrutto();
		double expectedNetto = assertionBruttoTemp - (assertionBruttoTemp * ASSERTION_TAX_ARB);

		// Assert
		assertEquals(expectedNetto, (nettoArbeiter_0 + nettoArbeiter_1));

	}

	@Test
	void testAusgabeMitarbeiterListe() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		Mitarbeiter[] dieseAbteilungsMitarbeiter = verwaltung.getMitarbeiterListeVonAbteilung(4);

		// Act
		String actualOutput = verwaltung.ausgabeMitarbeiterListe(dieseAbteilungsMitarbeiter);
		String expectedOutput = "\nArbeiter\n========\nId: 4\nName: Eckehard\nStundenlohn: 27.80\nAnzahl der Stunden: 134\nSchichtzulage: 104.70\nBrutto: 3829.9";

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testAusgabeAlleAbteilungen() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		String actualOutput = verwaltung.ausgabe_AlleAbteilungen();
		String expectedOutput = "Abteilung mit ID 1\nName: PR\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 1\nName: Anneken\nStundenlohn: 29.10\nAnzahl der Stunden: 109\nSchichtzulage: 94.40\nBrutto: 3266.3\n\n\nArbeiter\n========\nId: 6\nName: Erna\nStundenlohn: 22.50\nAnzahl der Stunden: 123\nSchichtzulage: 111.80\nBrutto: 2879.3\n\n\nAngestellter\n============\nId: 7\nName: Mathis\nGrundgehalt: 2400.00\nZulage: 1211.30\nOrtszuschlag: 18.80\nBrutto: 3630.10\n\n\nAngestellter\n============\nId: 8\nName: Hardwin\nGrundgehalt: 2800.00\nZulage: 1309.80\nOrtszuschlag: 19.90\nBrutto: 4129.70\n\nAbteilung mit ID 2\nName: Sales\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 2\nName: Poldi\nStundenlohn: 31.70\nAnzahl der Stunden: 97\nSchichtzulage: 101.30\nBrutto: 3176.2000000000003\n\n\nArbeiter\n========\nId: 3\nName: Ottila\nStundenlohn: 17.20\nAnzahl der Stunden: 83\nSchichtzulage: 44.90\nBrutto: 1472.5\n\n\nAngestellter\n============\nId: 9\nName: Barthold\nGrundgehalt: 1812.23\nZulage: 992.20\nOrtszuschlag: 20.00\nBrutto: 2824.43\n\n\nAngestellter\n============\nId: 10\nName: Ortrun\nGrundgehalt: 1903.67\nZulage: 1489.10\nOrtszuschlag: 21.10\nBrutto: 3413.87\n\n\nAngestellter\n============\nId: 11\nName: Loreley\nGrundgehalt: 1407.95\nZulage: 1298.21\nOrtszuschlag: 22.20\nBrutto: 2728.36\n\nAbteilung mit ID 3\nName: IT\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 5\nName: Juliane\nStundenlohn: 23.70\nAnzahl der Stunden: 124\nSchichtzulage: 114.10\nBrutto: 3052.8999999999996\n\n\nArbeiter\n========\nId: 6\nName: Erna\nStundenlohn: 22.50\nAnzahl der Stunden: 123\nSchichtzulage: 111.80\nBrutto: 2879.3\n\n\nAngestellter\n============\nId: 12\nName: Wilmar\nGrundgehalt: 1703.67\nZulage: 1496.21\nOrtszuschlag: 23.30\nBrutto: 3223.18\n\nAbteilung mit ID 4\nName: HR\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 4\nName: Eckehard\nStundenlohn: 27.80\nAnzahl der Stunden: 134\nSchichtzulage: 104.70\nBrutto: 3829.9\n\n";

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSearchAbteilungSuccess() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		boolean actualSearchResult = verwaltung.searchAbteilung(1);
		boolean expectedSearchResult = true;

		// Assert
		assertEquals(expectedSearchResult, actualSearchResult);
	}

	@Test
	void testSearchAbteilungFail() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		boolean actualSearchResult = verwaltung.searchAbteilung(0);
		boolean expectedSearchResult = false;

		// Assert
		assertEquals(expectedSearchResult, actualSearchResult);
	}

	@Test
	void testGetMitarbeiterListeVonAbteilung() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter[] actualMitarbeiterListeVonAbteilung = verwaltung.getMitarbeiterListeVonAbteilung(4);
		Mitarbeiter[] expectedMitarbeiterListeVonAbteilung = { verwaltung.getMitarbeiter_Liste()[3] };

		// Assert
		assertArrayEquals(expectedMitarbeiterListeVonAbteilung, actualMitarbeiterListeVonAbteilung);
	}

	@Test
	void testBerechneNettoAngestellter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		double ASSERTION_TAX_ANG = 0.20;

		// Act
		Angestellter angestellter_1 = new Angestellter(1, "Warinot", 100.0, 10.00, 1.0);

		double actualNetto = verwaltung.berechneNettoGehalt(angestellter_1);
		double expectedNetto = angestellter_1.berechneBrutto() - (angestellter_1.berechneBrutto() * ASSERTION_TAX_ANG);

		// Assert
		assertEquals(expectedNetto, actualNetto);

	}

	@Test
	void testSucheAbteilungsmitarbeiterNachID() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter gefundenerMitarbeiter = verwaltung.searchMitarbeiterAusFirma(4);
		String expectedName = "Eckehard";

		// Assert
		assertEquals(expectedName, gefundenerMitarbeiter.getName());
	}

}
