package de.hellowworld;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetsPlayTest {

	private int KomischerRandomGenerator;
	private int KomischerSpieler;
	private int iRandomGenerator;
	private int iSpieler;
	private int iSpieler1;
	private int iSpieler2;
	private int iSpieler3;
	private int iSpieler4;
	private int iSpieler5;

	@Test
	public void testRundeSpielen() throws Exception {
		int ergebniss = -1;
		Spieler testTmp1 = new SchereSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp1);
		sammelnvondaten(ergebniss);
		Spieler testTmp2 = new SteinSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp2);
		sammelnvondaten(ergebniss);
		Spieler testTmp3 = new PapierSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp3);
		sammelnvondaten(ergebniss);
		Spieler testTmp4 = new EchsenSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp4);
		sammelnvondaten(ergebniss);
		Spieler testTmp5 = new SpockSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp5);
		sammelnvondaten(ergebniss);
		Spieler testTmp6 = new RandomSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp6);

	}

	public void sammelnvondaten(int ergebniss) {
		KomischerSpieler += (ergebniss == 1) ? 1 : 0;
		KomischerRandomGenerator += (ergebniss == 2) ? 1 : 0;
	}

	@Test
	public void test50000() throws Exception {
		for (int i = 0; i < 50000; i++) {
			testRundeSpielen();

		}
		System.out.println(KomischerSpieler);
		System.out.println(KomischerRandomGenerator);
	}

	@Test
	public void SpielenSchere() throws Exception {
		int ergebniss = -1;
		Spieler testTmp1 = new SchereSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp1);
		sammelnFor5(ergebniss);
		
	}
	@Test
	public void SpielenStein() throws Exception {
		int ergebniss = -1;
		Spieler testTmp2 = new SteinSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp2);
		sammelnFor5(ergebniss);
	}
	@Test
	public void SpielenPapier() throws Exception {
		int ergebniss = -1;
		Spieler testTmp3 = new PapierSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp3);
		sammelnFor5(ergebniss);

	}
	@Test
	public void SpielenEchse() throws Exception {
		int ergebniss = -1;
		Spieler testTmp4 = new EchsenSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp4);
		sammelnFor5(ergebniss);

	}
	@Test
	public void SpielenSpock() throws Exception {
		int ergebniss = -1;
		Spieler testTmp5 = new SpockSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp5);
		sammelnFor5(ergebniss);

	}
	
	@Test
	public void RandomSpieler() throws Exception {
		int ergebniss = -1;
		Spieler testTmp6 = new RandomSpieler();
		ergebniss = LetsPlay.rundeSpielen(testTmp6);
		sammelnFor5(ergebniss);

	}

	public void sammelnFor5(int ergebniss) {
		iSpieler += (ergebniss == 1) ? 1 : 0;
		iRandomGenerator += (ergebniss == 2) ? 1 : 0;
	}

	@Test
	public void testFor5() throws Exception {
		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 100000; i++) {
			SpielenSchere();
		}
		System.out.println("SpielenSchere :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );

		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 10000; i++) {
			SpielenStein();
		}
		System.out.println("SpielenStein :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );

		
		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 100000; i++) {
			SpielenPapier();
		}
		System.out.println("SpielenPapier :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );

		
		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 100000; i++) {
			SpielenEchse();
		}
		System.out.println("SpielenEchse :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );

		
		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 100000; i++) {
			SpielenSpock();
		}
		System.out.println("SpielenSpock :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );
		
		iSpieler = 0;
		iRandomGenerator = 0;
		for (int i = 0; i < 100000; i++) {
			RandomSpieler();
		}
		System.out.println("RandomSpieler :" +iSpieler );
		System.out.println("iRandomGenerator  ::"+iRandomGenerator );
		
	
	}


}

	
	


