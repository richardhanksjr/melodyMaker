package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Melody {

	@Autowired MelodyGenerator melodyGenerator;
	
	@RequestMapping("addMelody.do")
	public ModelAndView processData(@RequestParam("duration") double duration,
									@RequestParam("pitch") String pitch,
									@RequestParam("octave") int octave,
									@RequestParam("title") String title) {
//		int duration1 = duration;
		System.out.println(duration);
		System.out.println(pitch);
		System.out.println(octave);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("duration", duration);
		mv.addObject("pitch", pitch);
		mv.addObject("octave", octave);
		mv.addObject("title", title);
		mv.addObject("phrase", melodyGenerator.newPhrase(duration, pitch, octave, title));
		return mv;
		
	}
}
