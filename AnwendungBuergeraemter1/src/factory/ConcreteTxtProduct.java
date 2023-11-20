package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product {
	
	BufferedWriter aus;
	
	public ConcreteTxtProduct() {
		try {
			aus = new BufferedWriter(new FileWriter("./Buergeraemter.txt",true));
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void fuegeInDateiHinzu(Object o) throws IOException {
		// TODO Auto-generated method stub
		Buergeramt ba = (Buergeramt) o;
		aus.write("Daten des Buergeramtes\n" 
		+ "Name des Buergeramtes:\t\t\t\t" + ba.getName() + "\n" 
		+ "Oeffnungszeiten des Buergera,tes:\t\t" + ba.getGeoeffnetVon() + " - " + ba.getGeoeffnetBis() + "\n"
		+ "Strassenhausnummer des Buergeramtes:\t\t" + ba.getStrasseHNr() + "\n"
		+ "Dienstleistungen des Buergeramtes:\t" + ba.getDienstleistungenAlsString(';') + "\n\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
