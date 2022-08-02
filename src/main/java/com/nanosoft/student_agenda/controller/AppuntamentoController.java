package com.nanosoft.student_agenda.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.student_agenda.dto.requestDto.AppuntamentoRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.AppuntamentoResponseDto;
import com.nanosoft.student_agenda.service.AppuntamentoService;

import net.bytebuddy.asm.Advice.Local;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/appuntamento")
public class AppuntamentoController {

	@Autowired
	private AppuntamentoService appuntamentoService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<AppuntamentoResponseDto> addAppuntamento(@RequestBody final AppuntamentoRequestDto appuntamentoRequestDto) {
		
		AppuntamentoResponseDto appuntamentoResponseDto = appuntamentoService.aggiungiAppuntamento(appuntamentoRequestDto);
		
		return new ResponseEntity<>(appuntamentoResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Map<String, Boolean>> rimuoviAppuntamento(@PathVariable("id") final Integer id) {

		appuntamentoService.rimuoviAppuntamento(id);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAll() {
		
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = appuntamentoService.getAppuntamentiSortForDay();
		
		return new ResponseEntity<>(appuntamentoResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<AppuntamentoResponseDto> getAppuntamentoById(@PathVariable("id") final Integer id) {
		
		AppuntamentoResponseDto appuntamentoResponseDto = appuntamentoService.appuntamentoById(id);
		
		return new ResponseEntity<>(appuntamentoResponseDto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<AppuntamentoResponseDto> modificaAppuntamento(@PathVariable("id") final Integer id, @RequestBody final AppuntamentoRequestDto appuntamentoRequestDto) {	
		
		AppuntamentoResponseDto appuntamentoResponseDto = appuntamentoService.modificaAppuntamento(appuntamentoRequestDto, id);
		
		return new ResponseEntity<>(appuntamentoResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/data/{data}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAppuntamentiPerData(@PathVariable("data") String data) {
		
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = appuntamentoService.listaAppuntamentiPerData(data);
		
		return new ResponseEntity<>(appuntamentoResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/ufficio/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAppuntamentiByUfficio(@PathVariable("id") Integer id) {
		
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = appuntamentoService.listaAppuntamentiPerUfficio(id);
		
		return new ResponseEntity<>(appuntamentoResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/tipologia/{tipologia}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAppuntamentoByTipologia(@PathVariable("tipologia") String tipologia) {
		
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = appuntamentoService.listaAppuntamentiPerTipologia(tipologia);
	
		return new ResponseEntity<>(appuntamentoResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/descrizione/{descrizione}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAppuntamentoByDescrizione(@PathVariable("descrizione") String descrizione) {
	
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = appuntamentoService.listaAppuntamentiPerDescrizione(descrizione);
		
		return new ResponseEntity<>(appuntamentoResponseDtos, HttpStatus.OK);
	}
	
	@GetMapping("/ora/{ora}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<AppuntamentoResponseDto>> getAppuntamentiByOra(@PathVariable("ora") Integer ora) {
	
		List<AppuntamentoResponseDto> appuntamentoResponseDto = appuntamentoService.getAppuntamentiByOra(ora);
		
		return new ResponseEntity<>(appuntamentoResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/appforday")
	public ResponseEntity<Map<LocalDate, Long>> appuntamentiForDay() {
		Map<LocalDate, Long> map = appuntamentoService.appuntamentiInUnGiorno();
		return ResponseEntity.ok(map);
	}
	
}