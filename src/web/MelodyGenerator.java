package web;
import java.util.ArrayList;
import java.util.List;

import jm.music.data.Phrase;


public class MelodyGenerator {
	private List<PhraseGenerator> phraseList = new ArrayList<>();
	//private Phrase phrase;
	
	public PhraseGenerator newPhrase(double duration, String pitch, int octave, String title){
		PhraseGenerator phrase = new PhraseGenerator(duration, pitch, octave, title);
		phraseList.add(phrase);
		System.out.println("In melody.newPhrase");
		return phrase;
	}
	
	

}
