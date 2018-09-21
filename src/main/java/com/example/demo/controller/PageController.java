package com.example.demo.controller;



import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model) {
//		model.addAttribute("name",name);
//		return "challenge";
//	}
	@RequestMapping(value= {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping(value= {"/generator", "generator/{a,b}"})
	public String generator(
		@RequestParam(value = "a", defaultValue= "0") int a,
		@RequestParam(value = "b", defaultValue= "0") int b,
		Model model)	
			{
				String tempM= "";
				String tempH= "";
				String result="";
				int x = a;
				int y = b; 
				
				if(a==0) {
					x=1;
				}if(b==0){
					y=1;
				}
				for(int j=0 ; j < x ; j++) {
					tempM+= "m";
				}
				for(int i=0 ; i < y ; i++) {
					tempH+= " h"+tempM;
				}				
				result = tempH;
				model.addAttribute("a", a);
				model.addAttribute("b", b);
				model.addAttribute("result",result);
				
				return "generator";
			}
}
