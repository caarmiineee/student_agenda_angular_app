package com.nanosoft.student_agenda.test.service;

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
//import com.nanosoft.student_agenda.dto.requestDto.UniversitàRequestDto;
//import com.nanosoft.student_agenda.model.Università;
//import com.nanosoft.student_agenda.repository.UniversitàRepository;
//import com.nanosoft.student_agenda.service.UniversitàService;

//@ExtendWith(MockitoExtension.class)
public class UniversitaServiceTest {
//
//	@Mock
//	private UniversitàService universitàService;
//	private UniversitàRepository universitàRepository;
//
//	@BeforeEach
//	void setUp() {
//		universitàService = new UniversitàService(universitàRepository);
//	}
//
//	@Test
//	@Disabled
//	void canAddUni(UniversitàRequestDto universitàRequestDto) {
//		universitàRequestDto.setNome("unical");
//		Università università = new Università();
//		università.setId(1);
//		università.setNome(universitàRequestDto.getNome());
//		ArgumentCaptor<Università> univerArgumentCaptor = ArgumentCaptor.forClass(Università.class);
//		verify(universitàRepository).save(univerArgumentCaptor.getValue());
//		Università capturedUniversità = univerArgumentCaptor.getValue();
//		assertEquals(capturedUniversità, università);
//	}
//
//	@Test
//	@Disabled
//	void canDeleteUni(Integer id) {
//		if (!universitàRepository.existsById(id))
//			throw new IllegalArgumentException(id + " non esiste");
//		universitàRepository.deleteById(id);
//	}
}
