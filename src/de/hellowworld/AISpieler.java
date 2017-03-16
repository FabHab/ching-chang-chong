package de.hellowworld;

import java.io.IOException;

public class AISpieler extends WegStreicher {

	
	
	@Override
	public int getInput() throws IOException {
		return callAI();
	}

	private int callAI() throws IOException {
	
		LetsPlay l = new LetsPlay();
		String antworten = null; 
		antworten  = l.persistString(antworten);
		int retval = Integer.parseInt(antworten.substring(0,1));
		return retval;
	}

	@Override
	public void ergebnissMitteilen(int ergebniss) {

		LetsPlay l = new LetsPlay();
		if (ergebniss == 2)
		try {
			String antworten = l.persistString(null);
			antworten = antworten.substring(2)+antworten.substring(0,2) ;
			System.out.println(">>>>>>>>>>>>>>>>"+antworten+"<<<<<<<<<<"+ergebniss);
			l.persistString(antworten);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ergebniss == 1)
		try {
			String antworten = l.persistString(null);
			antworten = antworten.substring(1)+antworten.substring(0,1) ;
			System.out.println(">>>>>>>>>>>>>>>>"+antworten+"<<<<<<<<<<"+ergebniss);
			l.persistString(antworten);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
