package web;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Convert;
import jm.util.Play;
import jm.util.Write;

public class PhraseMaker {

	public static void main(String[] args) {
	    Score stochScore = new Score("JMDemo - Stochastic");
        Part inst = new Part("Piano", jm.constants.Instruments.PIANO, 0);
        Phrase phr = new Phrase(0.0); 
        
        // create a phrase of randomly pitched quavers over the full MIDI range.
        for(int i=0; i<24; i++){
            Note note = new Note((int)(Math.random()*127), jm.constants.Durations.QUAVER);
            phr.addNote(note);
        }
        
        // add the phrase to an instrument and that to a score
        inst.addPhrase(phr);
        stochScore.addPart(inst);
    	String converted = Convert.phraseToPitchAndRhythmString(phr);
		System.out.println(converted);
        // create a MIDI file of the score
        //Play.midi(stochScore);
		// Phrase phrase = new Phrase(0.0);
//		for(int i=0; i<12; i++){
//			phrase.add(new Note(34+(i*2), jm.constants.Durations.QN));
//		}
	
//		
		Phrase phraseIn = Convert.pitchAndRhythmStringToPhrase("50,0.5,101,0.5,55,0.5,40,0.5,19,0.5,26,0.5,106,0.5,101,0.5,19,0.5,84,0.5,116,0.5,57,0.5,34,0.5,42,0.5,58,0.5,89,0.5,66,0.5,64,0.5,61,0.5,17,0.5,21,0.5,66,0.5,81,0.5,53,0.5");
		Play.midi(phraseIn);
	}

}
