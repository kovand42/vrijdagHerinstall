package be.vdab.applicatie.services;
import java.math.BigDecimal;
import be.vdab.applicatie.repositories.*;
public class WinstService {
	private final KostRepository kostRepository;
	private final OpbrengstRepository opbrengstRepository;
	public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository) {
		this.opbrengstRepository = opbrengstRepository;
		this.kostRepository = kostRepository;
	}
	public BigDecimal getWinst() {
		return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
	}
}
