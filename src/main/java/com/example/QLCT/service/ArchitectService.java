package com.example.QLCT.service;

import java.util.Optional;

import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.repository.ArchitectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArchitectService {

	private final ArchitectRepository archRepo;
	
	// get by id
	public Architect getById(Integer id){
		Optional<Architect> result = archRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			throw new ResourceClosedException("Error");
		}
	}
	
	// get all list
	public Iterable<Architect> getAll() {
		return archRepo.findAll();
	}
	
	// save
	public Architect save(Architect archForm) {
		return archRepo.save(archForm);
	}
	
	// update
	public Architect update(Architect archForm) {
		return archRepo.save(archForm);
	}
	
	// delete
	public void delete(int id) {
		archRepo.deleteById(id);;
	}
}
