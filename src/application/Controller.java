package application;

import java.net.URL;
import java.util.ResourceBundle;
import model.*;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Hippodrome relation;
	private Stage stage;
	private HBox hb;
	private VBox example;
	private Button btStart;
	private Button btAddMore;
	private TextField t1;
	private TextField t2;
	private Button rematch;
	
	public Controller(Stage s) {
		relation = new Hippodrome();
		this.stage = s;
		stage.setTitle("Indomable Spirit");
		btStart = new Button("Start");
		btAddMore = new Button("add more");
		actionbtAddMore();
		actionbtStart();
		start();
	}
	
	public void start() {
		VBox vb2 = new VBox(4);
		HBox hb2 = new HBox();		
		jockeys();
		changeExample();
		
		hb2.getChildren().addAll(btStart, btAddMore);
		vb2.getChildren().addAll(example,hb, hb2);
		Scene sc = new Scene(vb2);
		stage.setScene(sc);
		stage.show();
	}
	
	public void actionbtStart() {
		btStart.setOnAction(e->{
			StageBettor();
		});
	}
	
	public  void StageBettor() {
		stage.close();
		Stage s = new Stage();
		HBox root = new HBox();
		Text jockey = new Text(relation.namesJockey());
		
		root.getChildren().addAll(jockey);
		Scene sc = new Scene(root);
		s.setScene(sc);
		s.show();
		
	}
	
	public void actionbtAddMore() {
		btAddMore.setOnAction(e->{
			String nameH = t1.getText();
			String nameJ =t2.getText();
			relation.addJockey(nameJ, nameH);
			t1.clear();
			t2.clear();
		});
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
