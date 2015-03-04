package ggpack;

public interface IGuessingGame {

	public int guess (int lower, int higher);
	public String initSetup();
	public int loopThrough(int tries,  String response);
}
