package de.hellowworld;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LetsPlay {

	public static void main(String[] args) throws Exception {
		int program = 0;
		int mensch = 0;

		for (;;) {
			println("Punktestand:" + mensch + " : " + program);
			int ergebniss = rundeSpielen();

			mensch += (ergebniss == 1) ? 1 : 0;
			program += (ergebniss == 2) ? 1 : 0;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private static int rundeSpielen() throws Exception {
		println("Hallo, was wähst du? ");
		println("1 = Schere");
		println("2 = Stein");
		println("3 = Papier");
		println("4 = Brunnen");
		int antwortVonMensch = getInput();
		int antwortVonProgramm = getRandom();
		println(ZahlZuText(antwortVonMensch) +"--- gegen ---" + ZahlZuText(antwortVonProgramm));
		int Ergebnis = rufRichter(antwortVonMensch, antwortVonProgramm);

		println("Ergebnis:" + ZahlenVonRichterUmwandeln(Ergebnis));
		return Ergebnis;
	}

	private static void println(String string) {
		System.out.println(string);
	}

	/**
	 * Wandelt die Ziffern für Ergebnis in klartext Form um.
	 * 
	 * @param ergebnis
	 * @return
	 */
	private static String ZahlenVonRichterUmwandeln(int ergebnis) {
		String[] richterAntwort = new String[] { "Unentschieden:/", "Du Hast Gewonnen:(!", "Du Hast Verloren:)" };
		String wert = richterAntwort[ergebnis];
		return wert;
	}

	/**
	 * Wandelt die Ziffern 1, 2, 3 in Schere, Stein, Papier um.
	 * 
	 * @param antwort
	 * @return
	 */
	private static String ZahlZuText(int antwort) {
		String[] Handzechen = new String[] { "Hallo", "Schere", "Stein", "Papier", "Brunnen"};
		String wert = Handzechen[antwort];
		return wert;
	}

	/**
	 * Diese Metode nimmt zwei parameter Mensch und Maschine und entscheidet wer
	 * gewonnen hat. Wen Mensch und Programm das gleiche gewählt haben schickt
	 * das Programm eine 0 für unentschieden. Wen der Mensch gewinnt schick das
	 * Programm eine 1 zurück. Wen Programm gewinnt schickt dies 2 zurück.
	 * 
	 * @param antwortVonMensch
	 * @param antwortVonProgramm
	 * @return
	 */
	private static int rufRichter(int antwortVonMensch, int antwortVonProgramm) {
		int entscheidung = 0;
		Map<String, String> results = new HashMap<String, String>();
		results.put("11", "0");
		results.put("12", "2");
		results.put("13", "1");
		results.put("14", "2");
		results.put("21", "1");
		results.put("22", "0");
		results.put("23", "2");
		results.put("24", "2");
		results.put("31", "2");
		results.put("32", "1");
		results.put("33", "0");
		results.put("34", "1");
		results.put("41", "1");
		results.put("42", "1");
		results.put("43", "2");
		results.put("44", "0");
		String key = "" + antwortVonMensch + antwortVonProgramm;
		String result = results.get(key);
		int allowedAnswers[] = new int[] { 0, 1, 2 };
		int indexInResults = Integer.parseInt(result);
		entscheidung = allowedAnswers[indexInResults];
		return entscheidung;
	}

	/**
	 * Produziert Zufällige ziffern zwischen 1 und 3 von Maschine.
	 * 
	 * @return
	 */
	private static int getRandom() {
		int allowedAnswers[] = new int[] { 1, 2, 3, 4 };
		return allowedAnswers[(int) (Math.random() * 4)];
	}

	/**
	 * Diese Metode liest angabe von benützer und übereinstimmt mit erlaubten
	 * werten.
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	private static int getInput() throws IOException {
		byte[] arg0 = new byte[15];
		System.in.read(arg0);
		String string = new String(arg0);
		println("" + string);
		int i = -1;
		int allowedAnswers[] = new int[] { 1, 2, 3, 4 };
		try {
			int retval = Integer.parseInt(string.trim());
			
			i = allowedAnswers[retval - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			println("try again!");
			i = getInput();
		} catch (NumberFormatException e) {
			println("try again!");
			i = getInput();
		}
		return i;
	}
}