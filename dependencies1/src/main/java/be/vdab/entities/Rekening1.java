package be.vdab.entities;
import java.math.BigDecimal;
public class Rekening1 {
	private BigDecimal saldo = BigDecimal.ZERO;
	private Rekeningnummer rekeningnummer;
	public Rekening1(Rekeningnummer rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}
	public void storten(BigDecimal bedrag) {
		if(bedrag.compareTo(BigDecimal.ZERO)<= 0) {
			throw new IllegalArgumentException("Bedrag moet positief zijn");
		}
		saldo = saldo.add(bedrag);
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Rekening1)) {
			return false;
		}
		Rekening1 anderRekening = (Rekening1) object;
		return rekeningnummer.toString().equals(anderRekening.rekeningnummer.toString());
	}
	@Override
	public int hashCode() {
		String rek = rekeningnummer.toString();
		return rek.hashCode() ;
	}
}
