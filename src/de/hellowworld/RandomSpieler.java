package de.hellowworld;

import java.io.IOException;

public class RandomSpieler extends WegStreicher {

	@Override
	public int getInput() throws IOException {
		return LetsPlay.getRandom();
	}

	

		

	

}
