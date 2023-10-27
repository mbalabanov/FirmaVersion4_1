/*
 * 
 * Firma V4.1 - Firma
 * Marin Balabanov
 * 
 */

package at.bfi.projekt.firma_v4_1.complete;

import java.util.Arrays;

public class Firma {

	Mitarbeiter[] mitarbeiter_Liste;
	Abteilung[] abteilungs_Liste;

	public Firma(Mitarbeiter[] mitarbeiter_Liste, Abteilung[] abteilungs_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
		this.abteilungs_Liste = abteilungs_Liste;
	}

	public Mitarbeiter[] getMitarbeiter_Liste() {
		return this.mitarbeiter_Liste;
	}

	/**
	 * @param mitarbeiter_Liste
	 */
	public void setMitarbeiter_Liste(Mitarbeiter[] mitarbeiter_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
	}

	/**
	 * @return
	 */
	public Abteilung[] getAbteilungs_Liste() {
		return this.abteilungs_Liste;
	}

	/**
	 * @param abteilungs_Liste
	 */
	public void setAbteilungs_Liste(Abteilung[] abteilungs_Liste) {
		this.abteilungs_Liste = abteilungs_Liste;
	}

	@Override
	public String toString() {
		return "Firma [mitarbeiter_Liste=" + Arrays.toString(this.mitarbeiter_Liste) + ", abteilungs_Liste="
				+ Arrays.toString(this.abteilungs_Liste) + "]";
	}

}
