package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.models.*;
import com.example.demo.repositories.*;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	public List<Lookify> allSongs(){
		return lookifyRepository.findAll();
	}
	public Lookify createSong(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}
	public Lookify findSong(Long id) {
		Optional<Lookify> song = lookifyRepository.findById(id);
		if (song.isPresent()) {
			return song.get();
		}else {
			return null;
		}
	}
//	public void deleteSong(Long id) {
//		Optional<Lookify> lookify = lookifyRepository.findById(id);
//		if (lookify.isPresent()) {
//			lookifyRepository.deleteById(id);
//		}
//	}
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	public List<Lookify> songsContainingArtist(String artist) {
		return lookifyRepository.findByArtist(artist);
	}
	
	public List<Lookify> topTenSongs(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
}
