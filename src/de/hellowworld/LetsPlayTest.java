package de.hellowworld;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetsPlayTest {

	@Test
	public void testRundeSpielen() throws Exception {
		int ergebniss = -1;
		Spieler testTmp1 = new SchereSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp1 );
		System.out.println(ergebniss);
		Spieler testTmp2 = new SteinSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp2 );
		System.out.println(ergebniss);
		Spieler testTmp3 = new PapierSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp3 );
		System.out.println(ergebniss);
		Spieler testTmp4 = new EchsenSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp4 );
		System.out.println(ergebniss);
		Spieler testTmp5= new SpockSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp5 );
		System.out.println(ergebniss);
		
	}

}
