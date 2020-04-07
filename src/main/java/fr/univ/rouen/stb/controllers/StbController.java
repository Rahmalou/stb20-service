package fr.univ.rouen.stb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.stb.models.Stb;
import fr.univ.rouen.stb.services.StbService;

@RestController
public class StbController {
	
	@Autowired
	private StbService stbService;
	
	
	@GetMapping("/help")
	@ResponseBody
	public String help() {
		return stbService.getHelp();
	}
	
	@GetMapping(value= {"", "/"})
	@ResponseBody
	public String home() {
		return stbService.getHome();
	}
	
	@RequestMapping( value="/resume", method = {RequestMethod.GET, RequestMethod.POST}, 
			produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String resume() {
		return stbService.getAllStbs();
	}
	
	@GetMapping(value="/stb", produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String stb(@RequestParam int id) {
		return stbService.findById(id);
	}
	
	@GetMapping(value="/htmlstb")
	@ResponseBody
	public String htmlstb(@RequestParam int id) {
		return stbService.findByIdHTML(id);		
	}
	
	@PutMapping(value="/insert", produces=MediaType.APPLICATION_XML_VALUE)
	public String insert(@RequestBody Stb stb) {
		return stbService.insert(stb);
	}
	
	@DeleteMapping(value="/delete", produces=MediaType.APPLICATION_XML_VALUE)
	public String delete(@RequestParam int id) {
		return stbService.delete(id);		
	}
	
	
	
}
