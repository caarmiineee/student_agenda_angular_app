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
//import com.nanosoft.student_agenda.dto.requestDto.UfficioRequestDto;
//import com.nanosoft.student_agenda.model.Ufficio;
//import com.nanosoft.student_agenda.model.Università;
//import com.nanosoft.student_agenda.repository.UfficioRepository;
//import com.nanosoft.student_agenda.service.UfficioService;
//
//@ExtendWith(MockitoExtension.class)
public class UfficioServiceTest {

//	@Mock
//	private UfficioService ufficioService;
//	private UfficioRepository ufficioRepository;
//
//	@BeforeEach
//	void setUp() {
//		ufficioService = new UfficioService(ufficioRepository);
//	}
//
//	@Test
//	@Disabled
//	void canAddUfficio(UfficioRequestDto ufficioRequestDto) {
//		ufficioRequestDto.setNome("segreteria");
//		Ufficio ufficio = new Ufficio();
//		ufficio.setId(1);
//		ufficio.setNome(ufficioRequestDto.getNome());
//		ufficio.setUniversità(new Università(1, "unical"));
//
//		ArgumentCaptor<Ufficio> ufficioArgumentCaptor = ArgumentCaptor.forClass(Ufficio.class);
//
//		verify(ufficioRepository).save(ufficioArgumentCaptor.capture());
//
//		Ufficio capturedUfficio = ufficioArgumentCaptor.getValue();
//
//		assertEquals(capturedUfficio, ufficio);
//	}
//
//	@Test
//	@Disabled
//	void getAll() {
//		ufficioService.getAllUfficio();
//		verify(ufficioRepository.findAll());
//	}
//
//	@Test
//	@Disabled
//	void canDeleteUfficio(Integer id) {
//		if (!ufficioRepository.existsById(id))
//			throw new IllegalArgumentException(id + " non esiste");
//		ufficioRepository.deleteById(id);
//	}
}