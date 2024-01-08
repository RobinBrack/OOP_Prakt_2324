package business;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import factory.ConcreteCsvCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import guiBuergeraemter.BuergeraemterControl;
import guiBuergeraemter.BuergeraemterView;
import javafx.scene.Node;
import observer.Observable;
import observer.Observer;

public class BuergeraemterModel implements Observable{
 		
	// private Buergeramt buergeramt;
	
	private ArrayList<Buergeramt> buergeraemter = new
			ArrayList<Buergeramt>();
	
	
	private BuergeraemterControl buergeraemterControl;
	private BuergeraemterView buergeraemterView;
	
	
	
	//Singleton
	
	private static BuergeraemterModel buerger;
	
	private BuergeraemterModel() {
		
	}
	
	public static BuergeraemterModel getInstance() {
		if(buerger == null) {
			buerger = new BuergeraemterModel();
		}
		
		return buerger;
	}
	
	Vector<Observer> observers = new Vector<Observer>();
	
	
	// BuergeramtListe
	
	public void addBuergeramt(Buergeramt buergeramt) {
		buergeraemter.add(buergeramt);
		notifyObservers();
	}
	
	

	
	public Object getBuergeramt() {
		return buergeraemter.get(buergeraemter.size()-1).gibBuergeramtZurueck(';');
	}
	
	

 		
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator writerCreator = new ConcreteCsvCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.buerger.buergeraemter);
		writer.schliesseDatei();
 	}
	
	public void schreibeBuergeraemterInTxtDatei()
		throws IOException{
		Creator writerCreator = new ConcreteTxtCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.buerger.buergeraemter);
		writer.schliesseDatei();
	}

	// Observable - Methoden:
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}

	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.observers.size(); i++){
			this.observers.elementAt(i).update();
			}

	}

	public ArrayList<Buergeramt> getBuergeraemter() {
		// TODO Auto-generated method stub
		return buergeraemter;
	}
	

}