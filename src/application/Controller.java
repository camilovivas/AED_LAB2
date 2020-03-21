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
	private VBox example2;
	private Button btStart;
	private Button btAddMore;
	private TextField t1;
	private TextField t2;
	private TextField B1;
	private TextField B2;
	private TextField B3;
	private TextField B4;
	private Button rematch;
	private Button addB;
	private Button readyB;
	
	public Controller(Stage s) {
		relation = new Hippodrome();
		this.stage = s;
		stage.setTitle("Indomable Spirit");
		btStart = new Button("Start");
		btStart.setDisable(true);
		btAddMore = new Button("add");
		addB = new Button("Add");
		readyB = new Button("play");
		actionbtAddMore();
		actionbtStart();
		actionAddBettor();
		start();
	}
	
	public void start() {
		VBox vb2 = new VBox(4);
		HBox hb2 = new HBox();		
		jockeys();
		chargeExample();
		
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
		exampleB();
		Stage s = new Stage();
		HBox root = new HBox();
		Text jockey = new Text(relation.namesJockey());
		
		VBox bettor = new VBox();
		HBox textB = new HBox();
		B1 = new TextField();
		B2 = new TextField();
		B3 = new TextField();
		B4 = new TextField();
		
		HBox butt = new HBox();
		butt.getChildren().addAll(addB, readyB);
		textB.getChildren().addAll(B1,B2,B3,B4);
		bettor.getChildren().addAll(example2,textB, butt);
		root.getChildren().addAll(jockey,bettor);
		Scene sc = new Scene(root);
		s.setScene(sc);
		s.show();
		
	}
	
	public void actionPlay() {
		
	}
	
	public void actionAddBettor() {
		addB.setOnAction(e->{
			String cc = B1.getText();
			String name = B2.getText();
			int money = Integer.parseInt(B3.getText());
			String horse = B4.getText();
			relation.addBettor(cc, name, money, horse);
			B1.clear();
			B2.clear();
			B3.clear();
			B4.clear();
		});
	}
	
	public void exampleB() {
		example2 = new VBox();
		Text tc = new Text("llene las casillas  asi:");
		HBox c = new HBox();
		TextField t1 = new TextField("cedula");
		t1.setDisable(true);
		TextField t2 = new TextField("nombre");
		t2.setDisable(true);
		TextField t3 = new TextField("monto apostado");
		t3.setDisable(true);
		TextField t4 = new TextField("caballo a apostar");
		t4.setDisable(true);
		c.getChildren().addAll(t1,t2,t3,t4);
		example2.getChildren().addAll(tc,c);
	}
	
	public void actionbtAddMore() {
		btAddMore.setOnAction(e->{
			String nameH = t1.getText();
			String nameJ =t2.getText();
			relation.addJockey(nameJ, nameH);
			t1.clear();
			t2.clear();
			if(relation.getJockeys().size() > 6) {
				btStart.setDisable(false);
			}
		});
	}
	
	public void chargeExample() {
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
