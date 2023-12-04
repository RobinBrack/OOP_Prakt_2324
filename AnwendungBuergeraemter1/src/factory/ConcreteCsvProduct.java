package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteCsvProduct extends Product {
	
	BufferedWriter aus;
	
	
	public ConcreteCsvProduct() {
		try {
			aus = new BufferedWriter(new FileWriter("./Buergeraemter.csv",true));
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void fuegeInDateiHinzu(Object o) throws IOException {
		// TODO Auto-generated method stub
		Buergeramt buergeramt = (Buergeramt) o;
		aus.write(buergeramt.gibBuergeramtZurueck(';'));
		aus.flush();
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
