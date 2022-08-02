package com.nanosoft.student_agenda.test.service;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.nanosoft.student_agenda.dto.requestDto.AgendaRequestDto;
//import com.nanosoft.student_agenda.model.Agenda;
//import com.nanosoft.student_agenda.repository.AgendaRepository;
//import com.nanosoft.student_agenda.service.AgendaService;
//
//@ExtendWith(MockitoExtension.class)
public class AgendaServiceTest {

//	@Mock
//	private AgendaService agendaService;
//	private AgendaRepository agendaRepository;
//	
//	@BeforeEach
//	void setUp() {
//		agendaService = new AgendaService(agendaRepository);
//	}
//	
//	@Test
//	@Disabled
//	void canAddAgenda(AgendaRequestDto agendaRequestDto) {
//		
//		agendaRequestDto.setNome("lista");
//		
//		Agenda agenda = new Agenda();
//		agenda.setId(1);
//		agenda.setNome(agendaRequestDto.getNome());
//		
//		agendaService.aggiungiAgenda(agendaRequestDto);
//		
//		ArgumentCaptor<Agenda> agendaArgumentCaptor = ArgumentCaptor.forClass(Agenda.class);
//		
//		verify(agendaRepository).save(agendaArgumentCaptor.getValue());
//		
//		Agenda capturedAgenda = agendaArgumentCaptor.getValue();
//		
//		assertEquals(capturedAgenda, agenda);
//	}
//	
//	@Test
//	@Disabled
//	void canGetAll() {
//		
//		agendaService.getAllAgenda();
//		
//		verify(agendaRepository.findAll());
//	}
//	
//	@Test
//	@Disabled
//	void canDeleteAppuntamento(Integer id) {
//		if(!agendaRepository.existsById(id))
//			throw new IllegalArgumentException(id + " non esiste");
//		agendaRepository.deleteById(id);
//	}
}
