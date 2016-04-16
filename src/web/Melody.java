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
	public String addNoteToPhrase(@RequestParam("duration") double duration,
									@RequestParam("pitch") int pitch,
									@RequestParam("octave") int octave) {
	
		int pitchInt = pitch + (octave*12);
		Note note = new Note(pitchInt, duration);
		melodyGenerator.addNoteToPhrase(note);
		return "index.jsp";	
	}

	@RequestMapping("addMelody.do")
	public String addMelody(
			@ModelAttribute("melodies") ArrayList<Phrase> phrasemap) throws IOException{
		
		//melodyGenerator.emptyPhrase();
		phrasemap.add(melodyGenerator.getPhrase());
		System.out.println(melodyGenerator.getPhrase());
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
		Phrase phraseHolder = melodyGenerator.getPhrase();
		//phraseHolder.addNote(n);
		Play.midi(phraseHolder);
	
		return "index.jsp";
		
	}
	
	@RequestMapping("playMelody.do")
	public String playPhrase(@RequestParam("title") String title,
							@ModelAttribute("melodies") ArrayList<Phrase> phrasemap){
		System.out.println("in here");
		System.out.println(title);
		for(Phrase phrase: phrasemap){
			System.out.println(phrase.getTitle());
			if(title.equals(phrase.getTitle())){
				Play.midi(phrase);
			}
		}
		return "index.jsp";
}
}
