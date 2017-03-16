package de.hellowworld;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LetsPlay implements Spieler {

	public static void main(String[] args) throws Exception {
		int program = 0;
		int mensch = 0;

		LetsPlay menschInputGrabber = new LetsPlay();
		
		for (;;) {
			menschInputGrabber.println("Punktestand:" + mensch + " : " + program);
			int ergebniss = rundeSpielen(menschInputGrabber);

			mensch += (ergebniss == 1) ? 1 : 0;
			program += (ergebniss == 2) ? 1 : 0;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static int rundeSpielen(Spieler actor) throws Exception {
		actor.println("Hallo, was wähst du? ");
		actor.println("1 = Schere");
		actor.println("2 = Stein");
		actor.println("3 = Papier");
		actor.println("4 = Echse");
		actor.println("5 = Spock");
		int antwortVonMensch = actor.getInput();
		int antwortVonProgramm = getRandom();
		actor.println(ZahlZuText(antwortVonMensch) +"--- gegen ---" + ZahlZuText(antwortVonProgramm));
		int Ergebnis = rufRichter(antwortVonMensch, antwortVonProgramm);

		actor.println("Ergebnis:" + ZahlenVonRichterUmwandeln(Ergebnis));
		return Ergebnis;
	}

	public void println(String string) {
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
	 * Wandelt die Ziffern 1, 2, 3, 4, 5 in Schere, Stein, Papier usw. um
	 * 
	 * @param antwort
	 * @return
	 */
	private static String ZahlZuText(int antwort) {
		String[] Handzechen = new String[] { "Hallo", "Schere", "Stein", "Papier", "Echse", "Spock"};
		String wert = Handzechen[antwort];
		return wert;
	}

	/**
	 * Diese Metode nimmt zwei parameter Mensch und Maschine und entscheidet wer
	 * gewonnen hat. Wen Mensch und Programm das gleiche gewählt haben schickt
	 * das Programm eine 0 für unentschieden. Wenn der Mensch gewinnt schick das
	 * Programm eine 1 zurück. Wenn das Programm gewinnt schickt dies 2 zurück.
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
		results.put("15", "2");
		results.put("21", "1");
		results.put("22", "0");
		results.put("23", "2");
		results.put("24", "2");
		results.put("25", "1");
		results.put("31", "2");
		results.put("32", "1");
		results.put("33", "0");
		results.put("34", "1");
		results.put("35", "2");
		results.put("41", "1");
		results.put("42", "1");
		results.put("43", "2");
		results.put("44", "0");
		results.put("45", "1");
		results.put("51", "1");
		results.put("52", "2");
		results.put("53", "1");
		results.put("54", "2");
		results.put("55", "0");
		String key = "" + antwortVonMensch + antwortVonProgramm;
		String result = results.get(key);
		int allowedAnswers[] = new int[] { 0, 1, 2 };
		int indexInResults = Integer.parseInt(result);
		entscheidung = allowedAnswers[indexInResults];
		return entscheidung;
	}

	/**
	 * Die Maschine Produziert Zufällige ziffern zwischen 1 und 3.
	 * 
	 * @return
	 */
	private static int getRandom() {
		int allowedAnswers[] = new int[] { 1, 2, 3, 4, 5};
		return allowedAnswers[(int) (Math.random() * 5)];
	}

	/**
	 * Diese Metode liest die angabe vom benützer und schaut noch ob die erlaubten
	 * werten vorhanden sind.
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	 public int getInput() throws IOException {
		byte[] arg0 = new byte[15];
		System.in.read(arg0);
		String string = new String(arg0);
		println("" + string);
		int i = -1;
		int allowedAnswers[] = new int[] { 1, 2, 3, 4, 5 };
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