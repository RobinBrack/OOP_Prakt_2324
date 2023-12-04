package guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.BuergeraemterModel;
import guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import observer.Observer;

public class StaedtischeEinrichtungenControl implements Observer {
	private BuergeraemterModel buergerarmtModel;
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage) {
		this.buergerarmtModel = BuergeraemterModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(
				this,primaryStage, buergerarmtModel);
		this.buergerarmtModel.addObserver(this);
	}
	
	public void update() {
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();
	}
}
