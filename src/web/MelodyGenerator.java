package web;
import java.util.ArrayList;
import java.util.List;

import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;


public class MelodyGenerator {
	private List<PhraseGenerator> phraseList = new ArrayList<>();
	private Phrase phrase;
	//private Phrase phrase;
	
//	public PhraseGenerator newPhrase(double duration, String pitch, int octave, String title){
//		PhraseGenerator phrase = new PhraseGenerator(duration, pitch, octave, title);
//		phraseList.add(phrase);
//		System.out.println("In melody.newPhrase");
//		return phrase;
//	}
	
	
	public void newPhrase(String title){
		phrase = new Phrase(title, 0.0);
	}
	public List<PhraseGenerator> getPhraseList(){
		return phraseList;
	}
	
	public void addNoteToPhrase(Note note){
		
		this.phrase.add(note);
		Phrase phraseHolder = new Phrase(0.0);
		phraseHolder.addNote(note);
		System.out.println("phrase length" + phrase.length());
		Play.midi(note);
	}
	
	public Phrase getPhrase(){
		Phrase newPhrase = this.phrase.copy();
		this.phrase.empty();
		return newPhrase;
	}
	
	public void emptyPhrase(){
		this.phrase.empty();
	}

}
