package business;

import java.io.*;

import factory.ConcreteCsvCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;

public class BuergeraemterModel {
 		
	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
	}
 		
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator writerCreator = new ConcreteCsvCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
 	}
	
	public void schreibeBuergeraemterInTxtDatei()
		throws IOException{
		Creator writerCreator = new ConcreteTxtCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
	}
	

}