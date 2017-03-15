package de.hellowworld;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author Fabio Haug
 *
 */
public class LetsPlay {

	/**
	 * 
	 */
	public LetsPlay() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		int program = 0;
		int mensch = 0;

		for(;;){
			System.out.println("Punktestand:"+mensch+" : "+program);
			int ergebniss = rundeSpielen();

			if (ergebniss==1) {
				mensch++;
			}
			if (ergebniss==2) {
				program++;
			}	
					
			
		}
		
		
	}

	private static int rundeSpielen() throws Exception {
		System.out.println("Hallo, was wähst du? ");
		System.out.println("1= Schere");
		System.out.println("2=Stein");
		System.out.println("3=Papier");
		int antwortVonMensch = getInput();
		System.out.println("Antwort1:"+ZahlZuText (antwortVonMensch));
		int antwortVonProgramm = getRandom();
		System.out.println("Antwort2:"+ZahlZuText(antwortVonProgramm));
		int Ergebnis = rufRichter(antwortVonMensch,antwortVonProgramm);
		
		System.out.println("Ergebnis:"+ZahlenVonRichterUmwandeln(Ergebnis));
		return Ergebnis;
	}

	private static String ZahlenVonRichterUmwandeln(int ergebnis) {
		String [] richterAntwort = new String []{"Unentschieden","MenschGewonnen","ProgrammGewonnen"};
		String wert = richterAntwort [ergebnis];
		return wert;
	}

	private static String ZahlZuText(int antwortVonMensch) {
		String [] Handzechen = new String []{"Hallo","Schere","Stein","Papier"};
		String wert = Handzechen [antwortVonMensch];
		return wert;
	}

	/**
	 * Diese Metode nimmt zwei parameter Mensch und Maschine und entscheidet wer gewonnen hat.
	 * Wen Mensch und Programm das gleiche gewählt haben schickt das Programm eine 0 für unentschieden.
	 * Wen der Mensch gewinnt schick das Programm eine 1 zurück.
	 * Wen Programm gewinnt schickt dies 2 zurück.
	 * @param antwortVonMensch
	 * @param antwortVonProgramm
	 * @return
	 */
	private static int rufRichter(int antwortVonMensch, int antwortVonProgramm) {
		int entscheidung = 0;
		Map<String, String> results = new HashMap<String, String>();
		results .put("11", "0");
		results .put("12", "2");
		results .put("13", "1");
		results .put("21", "1");
		results .put("22", "0");
		results .put("23", "2");
		results .put("31", "2");
		results .put("32", "1");
		results .put("33", "0");
		String key = ""+antwortVonMensch+antwortVonProgramm;
		String result = results.get(key);
		int allowedAnswers []= new int []{ 0, 1, 2};
		int indexInResults = Integer.parseInt(result);
		entscheidung = allowedAnswers[indexInResults];
		return entscheidung;
		
	}

	private static int getRandom() {
		int allowedAnswers []= new int []{ 1, 2, 3};
		return allowedAnswers[(int) (Math.random()*3)]; 
	}

	/**
	 * @throws IOException
	 */
	private static int getInput() throws Exception {
		byte[] arg0 = new byte[15];
		System.in.read(arg0);
		String string = new String(arg0);
		System.out.println(""+string	);
		int allowedAnswers []= new int []{ 1, 2, 3}; 
		int retval = Integer.parseInt(string.trim());
		return allowedAnswers[retval-1] ;
	}

}
