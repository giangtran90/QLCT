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
	
//	public Architect updateArchitect(Integer id, Architect form) {
//		Architect architect = archRepo.findById(id).get();
//		architect.setName(form.getName());
//		architect.setAddress(form.getAddress());
//	    return archRepo.save(architect);
//	}
	
//	public void updateCustomerContacts(long id, String phone) {
//	    Customer myCustomer = repo.findById(id);
//	    myCustomer.phone = phone;
//	    repo.save(myCustomer);
//	}
}
