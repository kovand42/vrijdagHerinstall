package be.vdab.entities;
import java.math.BigDecimal;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Rekening1Test {
	private Rekening1 rekening1, rekening2;
	@Before
	public void before() {
		Rekeningnummer rekeningnummer1 = new Rekeningnummer("123-4567890-02");
		rekening1 = new Rekening1(rekeningnummer1);
		Rekeningnummer rekeningnummer2 = new Rekeningnummer("123-4567891-03");
		rekening2 = new Rekening1(rekeningnummer2);
	}
	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		assertEquals(0, BigDecimal.ZERO.compareTo(rekening1.getSaldo()));;
	}
	@Test
	public void hetSaldoNaEenEersteStortingIsHetBedragVanDieStorting() {
		rekening1.storten(BigDecimal.valueOf(2.5));
		assertEquals(0, BigDecimal.valueOf(2.5).compareTo(rekening1.getSaldo()));
	}
	@Test
	public void hetSaldoNaTweeStortingenIsDeSomVanDeBedragenVanDieStortingen() {
		rekening1.storten(BigDecimal.valueOf(2.5));
		rekening1.storten(BigDecimal.valueOf(1.2));
		assertEquals(0, BigDecimal.valueOf(3.7).compareTo(rekening1.getSaldo()));
	}
	@Test
	public void equalsOpTweeDezelfdeRekeningenMoetTrueZijn() {		
		assertEquals(rekening1, new Rekening1(new Rekeningnummer("123-4567890-02")));
	}
	@Test
	public void equalsOpTweeVerschillendeRekeningenMoetFalseZijn() {
		assertNotEquals(rekening1, rekening2);
	}
	@Test
	public void hashCodeOpTweeDezelfdeRekeningenMoetGelijkZijn() {
		assertEquals(rekening1.hashCode(), new Rekening1(new Rekeningnummer("123-4567890-02")).hashCode());
	}
	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNulZijn() {
		rekening1.storten(BigDecimal.ZERO);
	}
	@Test(expected = IllegalArgumentException.class)
	public void hetbedragVanEenStortingMagNietNegatiefZijn() {
		rekening1.storten(BigDecimal.valueOf(-1));
	}
	@Test(expected = NullPointerException.class)
	public void hetBedragVanEenStortingMagNietNullZijn() {
		rekening1.storten(null);
	}
}

