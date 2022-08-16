package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Lookify;
import com.example.demo.services.*;


@Controller

public class LookifyController {
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index() {
		return "welcome.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashBoard(Model model, @ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> song = lookifyService.allSongs();
		model.addAttribute("song", song);
		return "dashboard.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong( @ModelAttribute("song") Lookify song) {
		return "new.jsp";
	}
	@RequestMapping(value = "/songs/new", method=RequestMethod.POST)
	public String create(
			@Valid @ModelAttribute("song")Lookify song, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "new.jsp";
		}else {
			lookifyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
	public String showSong(@PathVariable("id") Long id, Model model) {
		Lookify songs = lookifyService.findSong(id);
		model.addAttribute("songs", songs);
		return "show.jsp";
		
	}
	@RequestMapping(value = "/songs/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("artist") String artist, Model model) {
		List<Lookify> songs = lookifyService.songsContainingArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@RequestMapping(value="/search/topTen", method=RequestMethod.GET)
	public String topTen(Model model) {
		List<Lookify> songs = lookifyService.topTenSongs();
		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
}
