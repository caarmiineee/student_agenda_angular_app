package com.nanosoft.student_agenda.test.service;

//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.nanosoft.student_agenda.dto.requestDto.AppuntamentoRequestDto;
//import com.nanosoft.student_agenda.model.Appuntamento;
//import com.nanosoft.student_agenda.repository.AppuntamentoRepository;
//import com.nanosoft.student_agenda.service.AppuntamentoService;
//
//@ExtendWith(MockitoExtension.class)
public class AppuntamentoServiceTest {

//	@Mock
//	private AppuntamentoService appuntamentoService;
//	private AppuntamentoRepository appuntamentoRepository;
//
//	@BeforeEach
//	void setUp() {
//		appuntamentoService = new AppuntamentoService(appuntamentoRepository);
//	}
//
//	@Test
//	@Disabled
//	void canAggiungiAppuntamento(AppuntamentoRequestDto appuntamento) {
//		Date date = null;
//		String str = "01/02/2022";
//		try {
//			date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		appuntamento.setOra(8);
//		appuntamento.setDescrizione("iscrizione");
//		appuntamento.setData(str);
//		appuntamento.setAgendaId(1);
//		appuntamento.setUfficioId(2);
//		appuntamento.setTipologiaId(3);
//
//		appuntamentoService.aggiungiAppuntamento(appuntamento);
//
//		Appuntamento appuntamentos = new Appuntamento();
//		appuntamentos.setOra(appuntamento.getOra());
//		appuntamentos.setDescrizione(appuntamento.getDescrizione());
//		appuntamentos.setData(date);
//
//		ArgumentCaptor<Appuntamento> appuntamentoArgumentCaptor = ArgumentCaptor.forClass(Appuntamento.class);
//
//		verify(appuntamentoRepository).save(appuntamentoArgumentCaptor.capture());
//
//		Appuntamento capturedAppuntamento = appuntamentoArgumentCaptor.getValue();
//
//		assertEquals(capturedAppuntamento, appuntamentos);
//	}
//
//	@Test
//	@Disabled
//	void canRimuoviAppuntamento(Integer id) {
//		if (!appuntamentoRepository.existsById(id))
//			throw new IllegalArgumentException(id + " non esiste");
//		appuntamentoRepository.deleteById(id);
//	}
//
//	@Test
//	@Disabled
//	void canGetAppuntamentoById(Integer id) {
//		appuntamentoRepository.existsById(id);
//	}
//
//	@Test
//	@Disabled
//	void canUpdateAppuntamento(AppuntamentoRequestDto appuntamentoRequestDto) {
//		Date date = null;
//		String str = "01/02/2022";
//		try {
//			date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		appuntamentoRequestDto.setOra(11);
//		appuntamentoRequestDto.setDescrizione("colloquio");
//		appuntamentoRequestDto.setData(str);
//		appuntamentoRequestDto.setAgendaId(1);
//		appuntamentoRequestDto.setUfficioId(2);
//		appuntamentoRequestDto.setTipologiaId(3);
//		Appuntamento appuntamento = new Appuntamento();
//		appuntamento.setOra(13);
//		appuntamento.setDescrizione("colloquio");
//		appuntamento.setData(date);
//		appuntamentoService.aggiungiAppuntamento(appuntamentoRequestDto);
//
//		ArgumentCaptor<Appuntamento> appuntamentoArgumentCaptor = ArgumentCaptor.forClass(Appuntamento.class);
//
//		verify(appuntamentoRepository).save(appuntamentoArgumentCaptor.capture());
//
//		Appuntamento capturedAppuntamento = appuntamentoArgumentCaptor.getValue();
//
//		assertEquals(capturedAppuntamento, appuntamento);
//	}
//	
//	@Test
//	@Disabled
//	void canGetAll() {
//		appuntamentoService.getAppuntamenti();
//		verify(appuntamentoRepository).findAll();
//	}
}
