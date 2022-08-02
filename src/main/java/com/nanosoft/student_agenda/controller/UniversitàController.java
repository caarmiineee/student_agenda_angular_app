package com.nanosoft.student_agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.student_agenda.dto.requestDto.UniversitàRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.UniversitàResponseDto;
import com.nanosoft.student_agenda.service.UniversitàService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/università")
public class UniversitàController {

	@Autowired
	private UniversitàService universitàService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UniversitàResponseDto> addUniverità(@RequestBody UniversitàRequestDto universitàRequestDto) {
		UniversitàResponseDto universitàResponseDto = universitàService.aggiungiUniversità(universitàRequestDto);
		return new ResponseEntity<>(universitàResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUniversità(@PathVariable Integer id) {
		universitàService.rimuoviUniversità(id);
	}
	
}
