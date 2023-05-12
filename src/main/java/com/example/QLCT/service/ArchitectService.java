package com.example.QLCT.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.repository.ArchitectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArchitectService {

	private final ArchitectRepository archRepo;
	
	// get by id
	public Optional<Architect> getArchitectById(Integer id){
		return archRepo.findById(id);
	}
	
	// get all list
	public Iterable<Architect> getAllArchitects() {
		return archRepo.findAll();
	}
	
	// update and save
	public Architect saveArchitect(Architect archForm) {
		return archRepo.save(archForm);
	}
	
}
