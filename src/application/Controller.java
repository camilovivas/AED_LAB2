package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Stage stage;
	private Pane pane;
	
	public Controller(Stage s) {
		this.stage = s;
		stage.setTitle("indomable spirit");
		start();
	}
	
	public void start() {
		VBox vb2 = new VBox(4);
		
		
		Scene sc = new Scene(vb2);
		stage.setScene(sc);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
