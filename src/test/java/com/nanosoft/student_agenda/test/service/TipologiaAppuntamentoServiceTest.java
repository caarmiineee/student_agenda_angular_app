package com.nanosoft.student_agenda.test.service;

//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.nanosoft.student_agenda.dto.requestDto.TipologiaAppuntamentoRequestDto;
//import com.nanosoft.student_agenda.model.Tipologia;
//import com.nanosoft.student_agenda.model.TipologiaAppuntamento;
//import com.nanosoft.student_agenda.repository.TipologiaAppuntamentoRepository;
//import com.nanosoft.student_agenda.service.TipologiaAppuntamentoService;
//
//@ExtendWith(MockitoExtension.class)
public class TipologiaAppuntamentoServiceTest {

//	@Mock
//	private TipologiaAppuntamentoService tipologiaAppuntamentoService;
//	private TipologiaAppuntamentoRepository tipologiaAppuntamentoRepository;
//
//	@BeforeEach
//	void setUp() {
//		tipologiaAppuntamentoService = new TipologiaAppuntamentoService(tipologiaAppuntamentoRepository);
//	}
//
//	@Test
//	@Disabled
//	void canAddTipologia(TipologiaAppuntamentoRequestDto tipologiaAppuntamentoRequestDto) {
//		tipologiaAppuntamentoRequestDto.setTipologia(Tipologia.CONSULENTE);
//		TipologiaAppuntamento tipologia = new TipologiaAppuntamento();
//		tipologia.setId(1);
//		tipologia.setTipologia(tipologiaAppuntamentoRequestDto.getTipologia());
//		ArgumentCaptor<TipologiaAppuntamento> tipologiaArgumentCaptor = ArgumentCaptor
//				.forClass(TipologiaAppuntamento.class);
//
//		verify(tipologiaAppuntamentoRepository).save(tipologiaArgumentCaptor.capture());
//
//		TipologiaAppuntamento capturedTipologia = tipologiaArgumentCaptor.getValue();
//
//		assertEquals(capturedTipologia, tipologia);
//	}
//
//	@Test
//	@Disabled
//	void canGetAll() {
//		tipologiaAppuntamentoService.getAllTipologia();
//		verify(tipologiaAppuntamentoRepository.findAll());
//	}
//
//	@Test
//	@Disabled
//	void canDeleteAppuntamento(Integer id) {
//		if (!tipologiaAppuntamentoRepository.existsById(id))
//			throw new IllegalArgumentException(id + " non esiste");
//		tipologiaAppuntamentoRepository.deleteById(id);
//	}

}
