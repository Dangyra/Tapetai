package lt.ku.tapetai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TapetaiController {

		@GetMapping("/")
		public String forma(){
			return "forma";
		}

		@PostMapping("/")
		public String pvm(
				@RequestParam("swidth") double sienu_aukstis, 
				@RequestParam("sheight") double sienu_ilgis,
				@RequestParam("dwidth") double duru_aukstis, 
				@RequestParam("dheight") double duru_ilgis,
				@RequestParam("lwidth") double lango_aukstis, 
				@RequestParam("lheight") double lango_ilgis,
				Model model) {
				
			double kiekis=(sienu_aukstis*sienu_ilgis*4)-(duru_aukstis*duru_ilgis)-(lango_aukstis*lango_ilgis);
			kiekis=Math.round(kiekis*100)/100.0;
			
			model.addAttribute("kiekis", kiekis);
			return "rezultatas";
		}
}

