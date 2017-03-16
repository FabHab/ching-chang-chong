package de.hellowworld;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LetsPlayFIOTest {

	@Test
	public void test() throws IOException {
		LetsPlay l = new LetsPlay();
		String expected = null; 
		//assertEquals(expected, );
		l.persistString("AAAA");
		assertEquals("AAAA", l.persistString("AAAA"));
		assertEquals("AAAA", l.persistString(null));
		assertEquals("AAAA", l.persistString(null));
		assertEquals("AAAA", l.persistString("AAAA"));
		assertEquals("AAAA", l.persistString("BBBB"));
		assertEquals("BBBB", l.persistString("CCCCC"));
		assertEquals("CCCCC", l.persistString("12345"));
	}

}
