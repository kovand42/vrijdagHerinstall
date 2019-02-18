package be.vdab.applicatie.domain;

public class WoordTeller {
	public int telWoorden(String zin) {
		int aantalWoorden = 0;
		int index = 0;
		while(index != zin.length()) {
	    	while(index != zin.length() &&
		    	(zin.charAt(index) == ' ' || zin.charAt(index) == ',')){
			    index++;
		    }
		    if(index != zin.length()) {
			    aantalWoorden++;
			    while(index != zin.length() && zin.charAt(index) != ' ' &&
				    	zin.charAt(index) != ',') {
				    index++;
			    }
		    }
	    }
		return aantalWoorden;
	}		
}
