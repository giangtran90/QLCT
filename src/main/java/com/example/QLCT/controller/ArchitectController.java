package com.example.QLCT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.QLCT.entityDto.ArchitectDto;
import com.example.QLCT.service.ArchitectService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/architects")
@RequiredArgsConstructor
@CrossOrigin
public class ArchitectController {

	private final ArchitectService architectService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<ArchitectDto> getAll() {
		// This returns a JSON or XML with the architects
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		return architectService.getAll();
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody ArchitectDto getById(@PathVariable("id") int id) {
		return architectService.getById(id);
	}

	@PostMapping()
	public @ResponseBody ArchitectDto create(@RequestBody @NonNull ArchitectDto architectDto) {

		return architectService.create(architectDto);
	}

	@PutMapping(path = "/{id}")
	public @ResponseBody ArchitectDto update(@PathVariable("id") int id, @RequestBody @NonNull ArchitectDto architectDto) {
		return architectService.update(id, architectDto);
	}

	@DeleteMapping(path = "/{id}")
	public @ResponseBody void delete(@PathVariable("id") int id) {
		architectService.delete(id);
	}
}
