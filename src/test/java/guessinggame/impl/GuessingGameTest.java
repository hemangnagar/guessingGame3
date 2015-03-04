package guessinggame.impl;

import static org.junit.Assert.assertEquals;
import gg.GuessingGame;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GuessingGameTest {

	GuessingGame gg;
	ByteArrayInputStream in;

	@Before
	public void setUp() throws Exception {
		gg = new GuessingGame(0, 1000);
		
		 in = new ByteArrayInputStream("ready".getBytes());
		System.setIn(in);
		//systemInMock.provideText("ready");
		String ready = gg.initSetup();
		in.close();
	}

	@Test
	public void test500() {
		gg = new GuessingGame(0, 1000);
		 in = new ByteArrayInputStream("yes\n".getBytes());
		System.setIn(in);
		
		//systemInMock.provideText("yes\n");
		assertEquals(1, gg.loopThrough(1, "ready"));
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test750() {
		gg = new GuessingGame(0, 1000);
	 in = new ByteArrayInputStream("higher\nyes\n".getBytes());
		System.setIn(in);
		//systemInMock.provideText("higher\nyes\n");
		assertEquals(2, gg.loopThrough(1, "ready"));
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEnd() {
		gg = new GuessingGame(0, 1000);
	 in = new ByteArrayInputStream("higher\nend\n".getBytes());
		System.setIn(in);
		//systemInMock.provideText("higher\nyes\n");
		assertEquals(-1, gg.loopThrough(1, "ready"));
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test325() {
		gg = new GuessingGame(0, 1000);
	 in = new ByteArrayInputStream("lower\nhigher\nlower\nhigher\nlower\nlower\nhigher\nhigher\nhigher\nyes\n".getBytes());
		System.setIn(in);
		//systemInMock.provideText("higher\nyes\n");
		assertEquals(10, gg.loopThrough(1, "ready"));
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
