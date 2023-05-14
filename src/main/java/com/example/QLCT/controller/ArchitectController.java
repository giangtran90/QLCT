package com.example.QLCT.controller;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.entityDto.ArchitectDto;
import com.example.QLCT.service.ArchitectService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/architects")
@RequiredArgsConstructor
public class ArchitectController {

	private final ModelMapper modelMapper;

	private final ArchitectService architectService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ArchitectDto> getAll() {
		// This returns a JSON or XML with the architects
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Iterable<Architect> architects = architectService.getAll();
		return StreamSupport.stream(architects.spliterator(), false)
				.map(art -> modelMapper.map(art, ArchitectDto.class)).collect(Collectors.toList());
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody ArchitectDto getById(@PathVariable("id") int id) {
		Architect architect 		= architectService.getById(id);
		ArchitectDto archReponse 	= modelMapper.map(architect, ArchitectDto.class);
		return archReponse;
	}

	@PostMapping()
	public @ResponseBody ArchitectDto create(@RequestBody @NonNull ArchitectDto architectDto) {

		// convert DTO to entity
		Architect architectRequest 	= modelMapper.map(architectDto, Architect.class);
		Architect architect 		= architectService.create(architectRequest);

		// convert entity to DTO
		ArchitectDto architectResponse = modelMapper.map(architect, ArchitectDto.class);

		return architectResponse;
	}

	@PutMapping(path = "/{id}")
	public @ResponseBody ArchitectDto update(@PathVariable("id") int id,
			@RequestBody @NonNull ArchitectDto architectDto) {

		// convert DTO to entity
		Architect architectRequest 	= modelMapper.map(architectDto, Architect.class);
		Architect architect 		= architectService.update(id, architectRequest);

		// convert entity to DTO
		ArchitectDto architectResponse = modelMapper.map(architect, ArchitectDto.class);
		
		return architectResponse;
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody void delete(@PathVariable("id") int id) {
		architectService.delete(id);
	}
}
