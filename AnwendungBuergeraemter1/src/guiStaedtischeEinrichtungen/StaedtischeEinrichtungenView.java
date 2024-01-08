package guiStaedtischeEinrichtungen;
   
import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.*;

public class StaedtischeEinrichtungenView implements Observer {
	
	// Hier ergaenzen
	private Buergeramt buergeramt;
	private StaedtischeEinrichtungenControl staedtischeEinrichtungenControl;
	private BuergeraemterModel buergeraemterModel;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraeamter     
 		= new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraeamter  = new TextArea();
    	private Button btnAnzeigeBuergeraeamter = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl staedtischeEinrichtungenControl, 
    	    	Stage primaryStage, BuergeraemterModel buergeraemterModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		// Hier ergaenzen
 			this.buergeraemterModel = buergeraemterModel;

		this.initKomponenten();
		this.initListener();
    	}

    	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
 		lblAnzeigeBuergeraeamter.setLayoutX(310);
 		lblAnzeigeBuergeraeamter.setLayoutY(40);
 		lblAnzeigeBuergeraeamter.setFont(font);
 		lblAnzeigeBuergeraeamter.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBuergeraeamter);    
        	


// Textbereich	
       	txtAnzeigeBuergeraeamter.setEditable(false);
       	txtAnzeigeBuergeraeamter.setLayoutX(310);
       	txtAnzeigeBuergeraeamter.setLayoutY(90);
       	txtAnzeigeBuergeraeamter.setPrefWidth(220);
       	txtAnzeigeBuergeraeamter.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBuergeraeamter);        	
        	// Button
       	btnAnzeigeBuergeraeamter.setLayoutX(310);
       	btnAnzeigeBuergeraeamter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBuergeraeamter); 
   }
   
   private void initListener() {
	   btnAnzeigeBuergeraeamter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
    }
   
    void zeigeBuergeraemterAn(){
    	if(buergeraemterModel.getBuergeraemter().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Buergeramt bg : buergeraemterModel.getBuergeraemter()) {
				text.append(bg.gibBuergeramtZurueck(' ')+"\n");			
			}
			this.txtAnzeigeBuergeraeamter.setText(text.toString());
		}
		else{
			zeigeInformationsfensterAn( 
				"Bisher wurde kein B�rgeramt aufgenommen!");
		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	public void update() {
		// TODO Auto-generated method stub
		this.zeigeBuergeraemterAn();
	}	
    
}

