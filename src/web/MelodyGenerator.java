
package web;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Convert;


public class MelodyGenerator {
	
	private ArrayList<Phrase> phraseList = new ArrayList<>();
	private Phrase phrase;
	private static final String FILE_NAME = "phrases.txt";

	
	@Autowired WebApplicationContext ac;
	//private Phrase phrase;
	
//	public PhraseGenerator newPhrase(double duration, String pitch, int octave, String title){
//		PhraseGenerator phrase = new PhraseGenerator(duration, pitch, octave, title);
//		phraseList.add(phrase);
//		System.out.println("In melody.newPhrase");
//		return phrase;
//	}
	@PostConstruct
	public void init() {
		int titleNumber = 1;
		// Retrieve an input stream from the application context
		// rather than directly from the file system
		try (
				InputStream is =  ac.getResource(FILE_NAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			) {
			
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				Phrase newPhrase = Convert.pitchAndRhythmStringToPhrase(line);
				newPhrase.setTitle(""+titleNumber);
				phraseList.add(newPhrase);
				titleNumber += 1;
				
				
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	
	public ArrayList<Phrase> getMelodies(){
		return phraseList;
	}
	public void newPhrase(String title){
		phrase = new Phrase(title, 0.0);
	}
//	public List<Phrase> getPhraseList(){
//		return phraseList;
//	}
	
	public void addNoteToPhrase(Note note){
		
		this.phrase.add(note);
//		Phrase phraseHolder = new Phrase(0.0);
//		phraseHolder.addNote(note);
//		System.out.println("phrase length" + phrase.length());
//		Play.midi(note);
	}
	
	public Phrase getPhrase(){
//		Play.midi(this.phrase);
		//Phrase newPhrase = this.phrase.copy();
		//this.phrase.empty();
		return this.phrase;
	}
	
	public void emptyPhrase(){
		this.phrase.empty();
	}

}