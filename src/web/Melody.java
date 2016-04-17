package web;

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
import org.springframework.web.servlet.ModelAndView;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;
import jm.util.Play;

@Controller
@SessionAttributes("melodies")
public class Melody {
	
	@Autowired MelodyGenerator melodyGenerator;
	@Autowired WebApplicationContext ac;
	
	@ModelAttribute("melodies")
	public List<Phrase> phrasesMap(){
		List<Phrase> phrases = new ArrayList<>();
		return phrases;
	}
	

	/*
	 * The @PostConstruct method is called by Spring after 
	 * object creation and dependency injection
	 */

	@RequestMapping("loadMelodies.do")
	public String loadMelodies(@ModelAttribute("melodies") ArrayList<Phrase> phrasemap){
		ArrayList<Phrase> phrasesHolder = melodyGenerator.getMelodies();
		for(Phrase phrase: phrasesHolder){
			phrasemap.add(phrase);
		}
		return "index.jsp";
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
		//Note n = new Note(120, 4.0);
		//Play.midi(n);
		//Phrase phraseHolder = melodyGenerator.getPhrase();
		Phrase phraseHolder = melodyGenerator.getPhrase();
		//phraseHolder.addNote(n);
		Play.midi(phraseHolder);
	
		return "index.jsp";
		
	}
	
	@RequestMapping("deleteMelody.do")
	public String deleteMelody(@RequestParam("index") int index,
			@ModelAttribute("melodies") ArrayList<Phrase> phrasemap){
		phrasemap.remove(index);
		return "index.jsp";
		
	}
	@RequestMapping("editMelody.do")
	public String editMelody(@RequestParam("index") int index,
							@RequestParam("pitch") int pitch,
							@RequestParam("octave") int octave,
							@RequestParam("rhythm") double rhythm,
							@RequestParam("noteIndex") int noteIndex,
							@ModelAttribute("melodies") ArrayList<Phrase> phrasemap) throws Exception{
		try{
		Phrase phraseHolder = phrasemap.get(index);
		//int pitchInt = (int)(pitch.charAt(0));
		int convertedPitch = pitch + (octave*12);
		Note newNote = new Note(convertedPitch, rhythm);
		phraseHolder.setNote(newNote, noteIndex);
//		Note newNote = new Note(pitch, rhythm);
//		Phrase phraseToEdit = phrasemap.get(index);
//		phraseToEdit.setNote(newNote, );
		return "index.jsp";
		}catch (Exception e){
			return "edit.jsp";
		}
		
	}
	@RequestMapping("playMelody.do")
	public ModelAndView playPhrase(@RequestParam("title") String title,
							@RequestParam("submit") String submit,
							@ModelAttribute("melodies") ArrayList<Phrase> phrasemap){
		
		ModelAndView mv = new ModelAndView();
		switch(submit){
		case "Play Melody":
			for(Phrase phrase: phrasemap){
				if(title.equals(phrase.getTitle())){
					Play.midi(phrase);
					
				}
				mv.setViewName("index.jsp");
			}
			break;
		case "Phase Melody":
			for(Phrase phrase: phrasemap){
				if(title.equals(phrase.getTitle())){
					Phrase phraseCopy = phrase.copy();
					phaseMelody(phraseCopy);
				}
				mv.setViewName("index.jsp");
			}
			break;
		case "Polyphony Melody":
			for(Phrase phrase: phrasemap){
				if(title.equals(phrase.getTitle())){
					Phrase phraseCopy = phrase.copy();
					polyMelody(phraseCopy);
				}
				mv.setViewName("index.jsp");
			}
			break;
		case "Stop Playback":
			Play.stopMidi();
			mv.setViewName("index.jsp");
			break;
		case "Edit":
			for(Phrase phrase: phrasemap){
				if(title.equals(phrase.getTitle())){
					mv.addObject("notes", phrase.getNoteList());
					mv.addObject("index", phrasemap.indexOf(phrase));
					mv.addObject("phrase", phrase);
					mv.addObject("noteIndex", 0);
					
				}
			}
			mv.setViewName("edit.jsp");
		}
		
			
		return mv;
		//return "index.jsp";
		
}
	private void polyMelody(Phrase phrase){
		Score score = new Score("Poly");
		Part part1 = new Part("part1", jm.constants.Instruments.PIANO, 0);
		Part part2 = new Part("part2", jm.constants.Instruments.PIANO, 1);
		Part part3 = new Part("part3", jm.constants.Instruments.ACOUSTIC_BASS, 2);
		Phrase normalPhrase = phrase;
		Phrase bassPhrase = normalPhrase.copy();
		Mod.elongate(bassPhrase, 2.0);
		normalPhrase.setStartTime(8.0);
		Phrase highPhrase = normalPhrase.copy();
		Mod.transpose(highPhrase, 7);
		Mod.repeat(normalPhrase, 10);
		Mod.repeat(bassPhrase, 5);
		Mod.transpose(bassPhrase, -12);
		Mod.repeat(highPhrase, 8);
		highPhrase.setStartTime(12.0);
		part1.add(normalPhrase);
		part2.add(highPhrase);
		part3.add(bassPhrase);
		score.add(part1);
		score.add(part2);
		score.add(part3);
		score.setTempo(150.0);
		Play.midi(score);
	}
	private void phaseMelody(Phrase phrase){
		Score score = new Score("Phase");
		Part part1 = new Part("part1", jm.constants.Instruments.PIANO, 0);
		Part part2 = new Part("part2", jm.constants.Instruments.PIANO, 1);
		part1.add(phrase);
		part2.add(phrase);
		Mod.repeat(part1, 10);
		Mod.repeat(part2, 10);
		part1.setTempo(150.0);
		part2.setTempo(150.5);
		score.add(part1);
		score.add(part2);
		Play.midi(score);
		
		
	}
}
