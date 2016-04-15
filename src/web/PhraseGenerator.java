package web;
import jm.constants.Pitches;
import jm.music.data.Phrase;
import jm.util.Play;
public class PhraseGenerator {
	private double duration;
	private String pitch;
	private int octave;
	private String title;
	private Phrase phrase = new Phrase(0.0);
	
	
	public PhraseGenerator(){
		
	}

	public PhraseGenerator(double duration, String pitch, int octave, String title) {
		super();
		this.duration = duration;
		this.pitch = pitch;
		this.octave = octave;
		this.title = title;
		//String pitchString = pitch+""+octave;
		char pitchChar = pitch.charAt(0);
		int pitchInt = (pitchChar-65)*octave;
		this.phrase.addNote(pitchInt, duration);
		phrase.setTempo(200.0);
		phrase.addNote(pitchInt+4, duration);
		Play.midi(phrase);
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPitch() {
		return pitch;
	}

	public void setPitch(String pitch) {
		this.pitch = pitch;
	}

	public int getOctave() {
		return octave;
	}

	public void setOctave(int octave) {
		this.octave = octave;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
