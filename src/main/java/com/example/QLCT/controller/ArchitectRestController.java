package com.example.QLCT.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.QLCT.entity.Architect;
import com.example.QLCT.service.ArchitectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/rest")
@RequiredArgsConstructor
public class ArchitectRestController {

	private final ArchitectService architectService;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Architect> getAllArchitects() {
		// This returns a JSON or XML with the architects
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		return architectService.getAllArchitects();
	}

	@GetMapping(path = "/all/{id}")
	public @ResponseBody Optional<Architect> getArchitectById(@PathVariable("id") Integer id){
		return architectService.getArchitectById(id);
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewArchitect(@RequestBody Architect architect) {
		architectService.addNewArchitect(architect);
		return "success";
	}
	
//	@PutMapping(path = "/edit/{param}")
//	public @ResponseBody String updateArchitect(@RequestBody Architect architect) {
//		architectService.;
//		return "success";
//	}
}
