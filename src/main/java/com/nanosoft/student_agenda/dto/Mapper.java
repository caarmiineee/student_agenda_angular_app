package com.nanosoft.student_agenda.dto;

import java.util.ArrayList;
import java.util.List;

import com.nanosoft.student_agenda.dto.responseDto.AgendaResponseDto;
import com.nanosoft.student_agenda.dto.responseDto.AppuntamentoResponseDto;
import com.nanosoft.student_agenda.dto.responseDto.TipologiaAppuntamentoResponseDto;
import com.nanosoft.student_agenda.dto.responseDto.UfficioResponseDto;
import com.nanosoft.student_agenda.dto.responseDto.UniversitàResponseDto;
import com.nanosoft.student_agenda.model.Agenda;
import com.nanosoft.student_agenda.model.Appuntamento;
import com.nanosoft.student_agenda.model.TipologiaAppuntamento;
import com.nanosoft.student_agenda.model.Ufficio;
import com.nanosoft.student_agenda.model.Università;

public class Mapper {

	public static AppuntamentoResponseDto appuntamentoToAppuntamentoResponseDto(Appuntamento appuntamento) {

		AppuntamentoResponseDto appuntamentoResponseDto = new AppuntamentoResponseDto();

		appuntamentoResponseDto.setId(appuntamento.getId());
		appuntamentoResponseDto.setOra(appuntamento.getOra());
		appuntamentoResponseDto.setDescrizione(appuntamento.getDescrizione());
		appuntamentoResponseDto.setData(appuntamento.getData());
		appuntamentoResponseDto.setAgendaNome(appuntamento.getAgenda().getNome());
		appuntamentoResponseDto.setUfficioNome(appuntamento.getUfficio().getNome());
		appuntamentoResponseDto.setTipologiaNome(appuntamento.getTipologia().getTipologia());

		return appuntamentoResponseDto;

	}

	public static List<AppuntamentoResponseDto> appuntamentiToAppuntamentiResponseDtos(
			List<Appuntamento> appuntamenti) {
		List<AppuntamentoResponseDto> appuntamentoResponseDtos = new ArrayList<AppuntamentoResponseDto>();
		for (Appuntamento appuntamento : appuntamenti)
			appuntamentoResponseDtos.add(appuntamentoToAppuntamentoResponseDto(appuntamento));
		return appuntamentoResponseDtos;
	}

	public static AgendaResponseDto agendaToAgendaResponseDto(Agenda agenda) {

		AgendaResponseDto agendaResponseDto = new AgendaResponseDto();

		agendaResponseDto.setId(agenda.getId());
		agendaResponseDto.setNome(agenda.getNome());

		return agendaResponseDto;
	}

	public static List<AgendaResponseDto> agendeToAgendeResponseDtos(List<Agenda> agende) {
		List<AgendaResponseDto> agendaResponseDtos = new ArrayList<AgendaResponseDto>();
		for (Agenda agenda : agende)
			agendaResponseDtos.add(agendaToAgendaResponseDto(agenda));
		return agendaResponseDtos;
	}

	public static TipologiaAppuntamentoResponseDto tipologiaToTipologiaResponseDto(TipologiaAppuntamento tipologia) {

		TipologiaAppuntamentoResponseDto tipologiaAppuntamentoResponseDto = new TipologiaAppuntamentoResponseDto();

		tipologiaAppuntamentoResponseDto.setId(tipologia.getId());
		tipologiaAppuntamentoResponseDto.setTipologia(tipologia.getTipologia());

		return tipologiaAppuntamentoResponseDto;
	}

	public static List<TipologiaAppuntamentoResponseDto> tipologieToTipologieResponseDtos(
			List<TipologiaAppuntamento> tipologiaAppuntamenti) {
		List<TipologiaAppuntamentoResponseDto> tipologiaAppuntamentoResponseDtos = new ArrayList<TipologiaAppuntamentoResponseDto>();
		for (TipologiaAppuntamento tipologia : tipologiaAppuntamenti)
			tipologiaAppuntamentoResponseDtos.add(tipologiaToTipologiaResponseDto(tipologia));
		return tipologiaAppuntamentoResponseDtos;
	}

	public static UfficioResponseDto ufficioToUfficioResponseDto(Ufficio ufficio) {

		UfficioResponseDto ufficioResponseDto = new UfficioResponseDto();

		ufficioResponseDto.setId(ufficio.getId());
		ufficioResponseDto.setNome(ufficio.getNome());


		ufficioResponseDto.setUniversitaNome(ufficio.getUniversità().getNome());

		return ufficioResponseDto;
	}

	public static List<UfficioResponseDto> ufficiToUfficiResponseDto(List<Ufficio> uffici) {

		List<UfficioResponseDto> ufficioResponseDtos = new ArrayList<UfficioResponseDto>();
		for (Ufficio ufficio : uffici)
			ufficioResponseDtos.add(ufficioToUfficioResponseDto(ufficio));
		return ufficioResponseDtos;
	}

	public static UniversitàResponseDto universitaToUniversitaResponseDto(Università università) {

		UniversitàResponseDto universitàResponseDto = new UniversitàResponseDto();

		universitàResponseDto.setId(università.getId());
		universitàResponseDto.setNome(università.getNome());

		return universitàResponseDto;
	}
}
