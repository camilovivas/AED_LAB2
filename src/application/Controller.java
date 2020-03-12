package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Stage stage;
	private Pane pane;
	private HBox hb;
	private VBox example;
	private Button btAddJockeys;
	private Button btAddMore;
	private TextField t1;
	private TextField t2;
	
	public Controller(Stage s) {
		this.stage = s;
		stage.setTitle("Indomable spirit");
		start();
	}
	
	public void start() {
		VBox vb2 = new VBox(4);
		btAddJockeys = new Button("Start");
		jockeys();
		changeExample();
		
		vb2.getChildren().addAll(example,hb, btAddJockeys);
		Scene sc = new Scene(vb2);
		stage.setScene(sc);
		stage.show();
	}
	
	public void changeExample() {
		example = new VBox();
		HBox hb = new HBox();
		Text tc = new Text("llene las casillas  asi:");
		TextField t1 = new TextField("Name horse");
		t1.setDisable(true);
		TextField t2 = new TextField("Name jockey");
		t2.setDisable(true);
		hb.getChildren().addAll(t1,t2);
		example.getChildren().addAll(tc, hb);
		
	}
	
//	crea los cuadros pa los jinetes
	public void jockeys() {
			hb = new HBox();
			t1 = new TextField();
			t2 = new TextField();
			hb.getChildren().addAll(t1,t2);
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
