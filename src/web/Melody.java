package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Melody {

	@RequestMapping("addMelody.do")
	public ModelAndView processData(@RequestParam("duration") String duration,
									@RequestParam("pitch") String pitch,
									@RequestParam("octave") int octave) {
//		int duration1 = duration;
		System.out.println(duration);
		System.out.println(pitch);
		System.out.println(octave);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("duration", duration);
		mv.addObject("pitch", pitch);
		mv.addObject("octave", octave);
		return mv;
		
	}
}
