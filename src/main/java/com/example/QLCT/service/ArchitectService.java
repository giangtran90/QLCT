package com.example.QLCT.service;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.entityDto.ArchitectDto;
import com.example.QLCT.exception.ArchitectNotFoundException;
import com.example.QLCT.mapper.ArchitectMapper;
import com.example.QLCT.repository.ArchitectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArchitectService {

	private final ArchitectRepository archRepo;

	// get by id
	public ArchitectDto getById(Integer id) {
		Optional<Architect> result = archRepo.findById(id);
		ArchitectMapper mapper = new ArchitectMapper();
		if (result.isPresent()) {
			return mapper.toArchitectDto(result.get());
		} else {
			throw new ArchitectNotFoundException(id);
		}
	}

	// get all list
	public Iterable<ArchitectDto> getAll() {
		Iterable<Architect> architects = archRepo.findAll();
		ArchitectMapper mapper = new ArchitectMapper();
		return StreamSupport.stream(architects.spliterator(), false).map(mapper::toArchitectDto).toList();
	}

	// create
	public ArchitectDto create(ArchitectDto architectDto) {
		ArchitectMapper mapper = new ArchitectMapper();
		// convert entity from DTO
		Architect architect = mapper.toArchitect(architectDto);
		// convert DTO from entity
		ArchitectDto archResponse = mapper.toArchitectDto(archRepo.save(architect));
		return archResponse;
	}

	// update
	public ArchitectDto update(int id, ArchitectDto architectDto) {
		ArchitectMapper mapper = new ArchitectMapper();
		// convert entity from DTO 
		Architect architectRequest = mapper.toArchitect(architectDto);
		Architect architect = archRepo.findById(id).orElseThrow(() -> new ArchitectNotFoundException(id));
		architect.setName(architectRequest.getName());
		architect.setBirthday(architectRequest.getBirthday());
		architect.setSex(architectRequest.getSex());
		architect.setPlace(architectRequest.getPlace());
		architect.setAddress(architectRequest.getAddress());

		return mapper.toArchitectDto(archRepo.save(architect));
	}

	// delete
	public void delete(int id) {
		if (!archRepo.existsById(id)) {
			throw new ArchitectNotFoundException(id);
		}
		archRepo.deleteById(id);
	}
}
