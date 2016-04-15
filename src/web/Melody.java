package web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.Write;

@Controller
@SessionAttributes("melodies")
public class Melody {
//private HashMap<String, Phrase> phrases;
	@Autowired MelodyGenerator melodyGenerator;
	@Autowired WebApplicationContext ac;
	
	@ModelAttribute("melodies")
	public List<Phrase> phrasesMap(){
		List<Phrase> phrases = new ArrayList<>();
		return phrases;
	}
	
	@RequestMapping("setTitle.do")
	public String addTitle(@RequestParam("title") String title){
		melodyGenerator.newPhrase(title);
		return "index.jsp";
		
	}
	@RequestMapping("addNote.do")
	public String addNote(@RequestParam("duration") double duration,
									@RequestParam("pitch") String pitch,
									@RequestParam("octave") int octave) {
		char pitchChar = pitch.charAt(0);
		int pitchInt = (int)(pitchChar-65)*(octave*12);
		Note note = new Note(pitchInt, duration);
		melodyGenerator.addNoteToPhrase(note);
		return "index.jsp";	
	}

	@RequestMapping("addMelody.do")
	public String addMelody(@RequestParam("title") String title,
			@ModelAttribute("melodies") ArrayList<Phrase> phrasemap) throws IOException{
		
		//melodyGenerator.emptyPhrase();
		//phrasemap.add(melodyGenerator.getPhrase());
		//melodyGenerator.emptyPhrase();
		//String path = getServletContext().getRealPath("WebContent/midi/");
		//File file = new File(path);
		//String fullPathToYourWebappRoot = file.getCanonicalPath();
//		File f = new File(ac.getServletContext().getRealPath("/WebContent/midi")  + title);
//		Write.midi(melodyGenerator.getPhrase(), ac.getServletContext().getRealPath("/") + title);
//		System.out.println(f.getCanonicalPath());
		Note n = new Note(120, 4.0);
		//Play.midi(n);
		//Phrase phraseHolder = melodyGenerator.getPhrase();
		Play.midi(melodyGenerator.getPhrase());
		return "index.jsp";
		
	}
	
	@RequestMapping("playPhrase.do")
	public String playPhrase(@RequestParam("title") String title){
		//Play.audio(phrases.get(title), jm.constants.Instruments.PIANO);
		Write.midi();
		return "index.jsp";
}
}
