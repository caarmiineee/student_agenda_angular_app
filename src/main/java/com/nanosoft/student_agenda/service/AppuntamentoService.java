package com.nanosoft.student_agenda.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.student_agenda.dto.Mapper;
import com.nanosoft.student_agenda.dto.requestDto.AppuntamentoRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.AppuntamentoResponseDto;
import com.nanosoft.student_agenda.model.Agenda;
import com.nanosoft.student_agenda.model.Appuntamento;
import com.nanosoft.student_agenda.model.Tipologia;
import com.nanosoft.student_agenda.model.TipologiaAppuntamento;
import com.nanosoft.student_agenda.model.Ufficio;
import com.nanosoft.student_agenda.repository.AppuntamentoRepository;

@Service
public class AppuntamentoService {

	private AppuntamentoRepository appuntamentoRepository;
	private AgendaService agendaService;
	private UfficioService ufficioService;
	private TipologiaAppuntamentoService tipologiaAppuntamentoService;

	public AppuntamentoService(AppuntamentoRepository appuntamentoRepository) {
		this.appuntamentoRepository = appuntamentoRepository;
	}

	@Autowired
	public AppuntamentoService(AppuntamentoRepository appuntamentoRepository, AgendaService agendaService,
			UfficioService ufficioService, TipologiaAppuntamentoService tipologiaAppuntamentoService) {
		this.appuntamentoRepository = appuntamentoRepository;
		this.agendaService = agendaService;
		this.ufficioService = ufficioService;
		this.tipologiaAppuntamentoService = tipologiaAppuntamentoService;
	}

	public Appuntamento getAppuntamento(Integer id) {
		return appuntamentoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(id + " non trovato"));
	}

	public List<AppuntamentoResponseDto> getAppuntamenti() {
		List<Appuntamento> appuntamenti = StreamSupport.stream(appuntamentoRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.appuntamentiToAppuntamentiResponseDtos(appuntamenti);
	}
	
	public List<AppuntamentoResponseDto> getAppuntamentiSortForDay() {
		List<AppuntamentoResponseDto> appuntamenti = getAppuntamenti();
		Collections.sort(appuntamenti, new Comparator<AppuntamentoResponseDto>() {

			@Override
			public int compare(AppuntamentoResponseDto o1, AppuntamentoResponseDto o2) {
				return o1.getData().compareTo(o2.getData());
			}
		});
		return appuntamenti;
	}

	@Transactional
	public AppuntamentoResponseDto aggiungiAppuntamento(AppuntamentoRequestDto appuntamentoRequestDto) {

		LocalDate data = convertStringToLocalDate(appuntamentoRequestDto.getData());
		
		boolean result = false;
		for(int i = 0; i < getAppuntamenti().size(); i++)
			if(getAppuntamenti().get(i).getOra().equals(appuntamentoRequestDto.getOra()) && getAppuntamenti().get(i).getData().equals(data))
				result = true;
		
		if (result)
			throw new IllegalStateException("Ora o id non disponibile, prova con un altra ora");
		
		Agenda agenda = agendaService.getAgenda(appuntamentoRequestDto.getAgendaId());
		Ufficio ufficio = ufficioService.getUfficio(appuntamentoRequestDto.getUfficioId());
		TipologiaAppuntamento tipologiaAppuntamento = tipologiaAppuntamentoService
				.getTipologiaAppuntamento(appuntamentoRequestDto.getTipologiaId());

		Appuntamento appuntamento = new Appuntamento();
		appuntamento.setOra(appuntamentoRequestDto.getOra());
		appuntamento.setDescrizione(appuntamentoRequestDto.getDescrizione());
		appuntamento.setData(data);
		appuntamento.setAgenda(agenda);
		appuntamento.setUfficio(ufficio);
		appuntamento.setTipologia(tipologiaAppuntamento);

		appuntamentoRepository.save(appuntamento);

		return Mapper.appuntamentoToAppuntamentoResponseDto(appuntamento);
	}

	public void rimuoviAppuntamento(Integer id) {
		
		appuntamentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("L'appuntamento non esiste"));
		appuntamentoRepository.deleteById(id);
		
	}

	public AppuntamentoResponseDto appuntamentoById(Integer id) {

		Appuntamento appuntamento = getAppuntamento(id);

		return Mapper.appuntamentoToAppuntamentoResponseDto(appuntamento);
	}

	@Transactional
	public AppuntamentoResponseDto modificaAppuntamento(AppuntamentoRequestDto appuntamentoRequestDto, Integer id) {

		LocalDate data = convertStringToLocalDate(appuntamentoRequestDto.getData());
		boolean result = false;
		for(int i = 0; i < getAppuntamenti().size(); i++)
			if(getAppuntamenti().get(i).getOra().equals(appuntamentoRequestDto.getOra()) && getAppuntamenti().get(i).getData().equals(data))
				result = true;
		
		if (result)
			throw new IllegalStateException("Ora o data non disponibile oppure gia prenotato da voi, prova con un altra ora o data");
		
		Agenda agenda = agendaService.getAgenda(appuntamentoRequestDto.getAgendaId());

		Ufficio ufficio = ufficioService.getUfficio(appuntamentoRequestDto.getUfficioId());

		TipologiaAppuntamento tipologia = tipologiaAppuntamentoService
				.getTipologiaAppuntamento(appuntamentoRequestDto.getTipologiaId());

		Appuntamento appuntamento = getAppuntamento(id);

		appuntamento.setOra(appuntamentoRequestDto.getOra());
		appuntamento.setDescrizione(appuntamentoRequestDto.getDescrizione());
		appuntamento.setData(data);
		appuntamento.setAgenda(agenda);
		appuntamento.setUfficio(ufficio);
		appuntamento.setTipologia(tipologia);

		return Mapper.appuntamentoToAppuntamentoResponseDto(appuntamento);
	}

	public List<AppuntamentoResponseDto> listaAppuntamentiPerData(String data) {
		
		LocalDate date = convertStringToLocalDate(data);
		
		return getAppuntamenti().stream().filter(appuntamenti -> appuntamenti.getData().equals(date)).collect(Collectors.toList());
	}

	private static LocalDate convertStringToLocalDate(String data) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
		return LocalDate.parse(data, formatter);

	}
	public List<AppuntamentoResponseDto> listaAppuntamentiPerUfficio(Integer id) {

		List<Appuntamento> list = new ArrayList<>();

		List<Appuntamento> appuntamenti = appuntamentoRepository.findAll();

		for (int i = 0; i < appuntamenti.size(); i++)
			if (appuntamenti.get(i).getUfficio().getId().equals(id))
				list.add(appuntamenti.get(i));

		return Mapper.appuntamentiToAppuntamentiResponseDtos(list);
	}

	public List<AppuntamentoResponseDto> listaAppuntamentiPerTipologia(String tip) {

		Tipologia tipologia = Tipologia.valueOf(tip);

		List<Appuntamento> list = new ArrayList<>();
		List<Appuntamento> appuntamenti = appuntamentoRepository.findAll();

		for (int i = 0; i < appuntamenti.size(); i++)
			if(appuntamenti.get(i).getTipologia().getTipologia().equals(tipologia))
				list.add(appuntamenti.get(i));
		
		return Mapper.appuntamentiToAppuntamentiResponseDtos(list);

	}

	public List<AppuntamentoResponseDto> listaAppuntamentiPerDescrizione(String descrizione) {

		return getAppuntamenti().stream().filter(appuntamenti -> appuntamenti.getDescrizione().equals(descrizione)).collect(Collectors.toList());

	}
	
	public List<AppuntamentoResponseDto> getAppuntamentiByOra(Integer ora) {

		return getAppuntamenti().stream().filter(appuntamenti -> Objects.equals(appuntamenti.getOra(), ora))
		.collect(Collectors.toList());
	
	}
	
	public Map<LocalDate, Long> appuntamentiInUnGiorno() {
		List<Appuntamento> appuntamenti = appuntamentoRepository.findAll();
		Map<LocalDate, Long> occorrenze = new HashMap<LocalDate, Long>();
		for(int i = 0; i < appuntamenti.size(); i++) {
			if(occorrenze.containsKey(appuntamenti.get(i).getData())) {
				occorrenze.put(appuntamenti.get(i).getData(), occorrenze.get(appuntamenti.get(i).getData()) + 1);
			}
			else 
				occorrenze.put(appuntamenti.get(i).getData(), (long) 1);
		}
		return occorrenze;
	}

}