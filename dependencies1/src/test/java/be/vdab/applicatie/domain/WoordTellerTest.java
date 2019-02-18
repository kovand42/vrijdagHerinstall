package be.vdab.applicatie.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class WoordTellerTest {
	private WoordTeller woordTeller;
	@Before
	public void before() {
		woordTeller = new WoordTeller();
	}
	@Test(expected = NullPointerException.class)
	public void eenNullWaarde() {
		woordTeller.telWoorden(null);
	}
	@Test
	public void eenLegeString() {
		assertEquals(0, woordTeller.telWoorden(""));
	}
	@Test
	public void enkelEenSpatie() {
		assertEquals(0, woordTeller.telWoorden(" "));
	}
	@Test
	public void enkelSpaties() {
		assertEquals(0, woordTeller.telWoorden("   "));
	}
	@Test
	public void enkelEenWoord() {
		assertEquals(1, woordTeller.telWoorden("woord"));
	}
	@Test
	public void eenWoordMetEenVoorafgaandeSpatie() {
		assertEquals(1, woordTeller.telWoorden(" woord"));
	}
	@Test
	public void eenWoordMetDaaropvolgendeSpatie() {
		assertEquals(1, woordTeller.telWoorden("woord "));
	}
	@Test
	public void tweeWoorden() {
		assertEquals(2, woordTeller.telWoorden("Ik ook"));
	}
	@Test
	public void tweeWoordenMetDaartussenMeerdereSpaties() {
		assertEquals(2, woordTeller.telWoorden("ik   ook"));
	}
	@Test
	public void tweeWoordenMetEenKommaErTussen() {
		assertEquals(2, woordTeller.telWoorden("Ik,ook"));
	}
	@Test
	public void enkelEenKomma() {
		assertEquals(0, woordTeller.telWoorden(","));
	}
	@Test
	public void enkelKommas() {
		assertEquals(0, woordTeller.telWoorden(",,,"));
	}
	@Test
	public void enkelKommasEnSpaties() {
		assertEquals(0, woordTeller.telWoorden(" , ,, "));
	}
	@Test
	public void tweeWoordenMetEenKommaEnEenSpatieErTussen(){
		assertEquals(2, woordTeller.telWoorden("ik, ook"));
	}
	@Test
	public void tweeWoordenMetEenSpatieEnEenKommaErTUssen() {
		assertEquals(2, woordTeller.telWoorden("ik ,ook"));
	}

}
