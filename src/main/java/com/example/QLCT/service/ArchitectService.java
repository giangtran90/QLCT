package com.example.QLCT.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
	
	// create
	public Architect create(Architect architect) {
		return archRepo.save(architect);
	}
	
	// update
	public Architect update(int id, Architect architectRequest) {
		Architect architect = archRepo.findById(id).orElseThrow(()->new EntityNotFoundException());
		architect.setName(architectRequest.getName());
		architect.setBirthday(architectRequest.getBirthday());
		architect.setSex(architectRequest.getSex());
		architect.setPlace(architectRequest.getPlace());
		architect.setAddress(architectRequest.getAddress());
		return archRepo.save(architect);
	}
	
	// delete
	public void delete(int id) {
		archRepo.deleteById(id);;
	}
}
