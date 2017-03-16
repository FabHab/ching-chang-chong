package de.hellowworld;

import java.io.IOException;

public interface Spieler {

	int getInput() throws IOException;

	void println(String string);

	void ergebnissMitteilen(int ergebniss);

}
