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
	
	public Optional<Architect> getArchitectById(Integer id){
		return archRepo.findById(id);
	}
	
	public Iterable<Architect> getAllArchitects() {
		return archRepo.findAll();
	}
	
	public Architect addNewArchitect(Architect archForm) {
		return archRepo.save(archForm);
	}
	
}
