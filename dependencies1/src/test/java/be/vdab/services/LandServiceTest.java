package be.vdab.services;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import be.vdab.entities.Land;
import be.vdab.repositories.LandRepository;
//import be.vdab.repositories.LandRepositoryStub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class LandServiceTest {
	@Mock private LandRepository landRepository;	
	private LandService landService;
	@Before
	public void before() {
		when(landRepository.findOppervlakteAlleLanden()).thenReturn(20);
		when(landRepository.read("B")).thenReturn(new Land("B", 4));
		when(landRepository.read("NL")).thenReturn(new Land("NL", 5));
		//landRepository = new LandRepositoryStub();
		landService = new LandService(landRepository);

	}
	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLandenNL() {

		assertEquals(0, BigDecimal.valueOf(0.25).compareTo(
				landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("NL")));
		verify(landRepository).findOppervlakteAlleLanden();
		verify(landRepository).read("NL");
	}
	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLandenB() {

		assertEquals(0, BigDecimal.valueOf(0.2).compareTo(
				landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("B")));
		verify(landRepository).findOppervlakteAlleLanden();
		verify(landRepository).read("B");
	}
}
