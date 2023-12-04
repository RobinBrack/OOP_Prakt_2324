package guiBuergeraemter;

import java.io.IOException;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import observer.Observer;

public class BuergeraemterControl implements Observer{
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

	public BuergeraemterControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.buergeraemterView = new BuergeraemterView(this, primaryStage, 
				buergeraemterModel);
		buergeraemterModel.addObserver(this);
	}
	
	void schreibeBuergeraemterInDatei(String typ){
	   	try{
	   		if("csv".equals(typ)){
	   			buergeraemterModel.schreibeBuergeraemterInCsvDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
	   				"Die Bürgerämter wurden gespeichert!");
	   		} else if("txt".equals(typ)) {
	   			buergeraemterModel.schreibeBuergeraemterInTxtDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
	   					"Die Buergeraemter wurden gespeichert!");
	   		}

	    } 
		catch(IOException exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }

	public void update() {
		// TODO Auto-generated method stub
		buergeraemterView.zeigeBuergeraemterAn();
	}

}
