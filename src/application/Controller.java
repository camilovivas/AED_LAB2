package application;

import java.net.URL;
import java.util.ResourceBundle;
import model.*;
import threads.ClockThread;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Hippodrome relation;
	private Stage stage;
	private Stage s;
	private Stage sa;
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
	private TextField tconsult;
	private Text result;
	private Button rematch;
	private Button addB;
	private Button readyB;
	private Button consult;
	private Button tryAgain;
	private Text time;
	private ClockThread ct;

	public Controller(Stage s) {
		relation = new Hippodrome();
		this.stage = s;
		stage.setTitle("Indomable Spirit");
		btStart = new Button("Start");
		btStart.setDisable(true);
		btAddMore = new Button("add");
		addB = new Button("Add");
		readyB = new Button("play");
		consult = new Button("consultar");
		tryAgain = new Button("play again");
		rematch = new Button("Revancha");
		time = new Text();
		ct = new ClockThread(this, relation);
		actionbtAddMore();
		actionbtStart();
		actionAddBettor();
		actionPlay();
		actionConsult();
		actionRematch();
		actionTryAgain();
		start();
	}

	public void start() {
		VBox vb2 = new VBox(4);
		HBox hb2 = new HBox();
		jockeys();
		chargeExample();
		hb2.getChildren().addAll(btStart, btAddMore);
		vb2.getChildren().addAll(example, hb, hb2);
		Scene sc = new Scene(vb2);
		stage.setScene(sc);
		stage.show();
	}

	public void actionbtStart() {
		btStart.setOnAction(e -> {
			StageBettor();
		});
	}

	public void StageBettor() {
		stage.close();
		exampleB();
		s = new Stage();
		HBox root = new HBox();
		System.out.println(relation.namesJockey());
		Text jockey = new Text(relation.namesJockey());
		VBox bettor = new VBox();
		HBox textB = new HBox();
		B1 = new TextField();
		B2 = new TextField();
		B3 = new TextField();
		B4 = new TextField();
		HBox butt = new HBox();
		butt.getChildren().addAll(addB, readyB, time);
		textB.getChildren().addAll(B1, B2, B3, B4);
		bettor.getChildren().addAll(example2, textB, butt);
		root.getChildren().addAll(jockey, bettor);
		ct.start();
		Scene sc = new Scene(root);
		s.setScene(sc);
		s.show();
	}

	public void actionPlay() {
		readyB.setOnAction(e -> {
			play();
		});
	}

	public void play() {
		s.close();
		sa = new Stage();
		HBox root = new HBox();
		Text jockey = new Text(relation.play());
		VBox b = new VBox();
		Text t = new Text("Escriba su numero de identificacion para ver si gano");
		tconsult = new TextField();
		result = new Text();
		HBox h = new HBox();
		h.getChildren().addAll(rematch, tryAgain);
		b.getChildren().addAll(t, tconsult, result, consult, h);
		root.getChildren().addAll(jockey, b);
		Scene sc = new Scene(root);
		sa.setScene(sc);
		sa.show();
	}

	public void actionConsult() {
		consult.setOnAction(e -> {
			String id = tconsult.getText();
			String tresult;
			try {
				tresult = relation.checkBettor(id);
				result.setText(tresult);
			} catch (Exception e1) {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("Letter input");
				info.setContentText("Please do not enter letters, enter only numbers is an ID!");
				info.showAndWait();
			}
			tconsult.clear();
		});
	}

	public void actionRematch() {
		rematch.setOnAction(e -> {
			sa.close();
			relation.invertQueue();
			StageBettor();
		});
	}

	public void actionTryAgain() {
		tryAgain.setOnAction(e -> {
			sa.close();
			btStart.setDisable(true);
			relation.newGame();
			start();
		});
	}

	public void actionAddBettor() {
		addB.setOnAction(e -> {
			String cc = B1.getText();
			String name = B2.getText();
			int money = Integer.parseInt(B3.getText());
			String horse = B4.getText();
			if (relation.search(B4.getText()) == null) {
				Alert info = new Alert(AlertType.ERROR);
				info.setTitle("Nonexistent horse");
				info.setContentText("The horse you want to add does not exist");
				info.showAndWait();
			}else {
			relation.addBettor(cc, name, money, horse);
			B1.clear();
			B2.clear();
			B3.clear();
			B4.clear();
			}
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
		c.getChildren().addAll(t1, t2, t3, t4);
		example2.getChildren().addAll(tc, c);
	}

	public void actionbtAddMore() {
		btAddMore.setOnAction(e -> {
			String nameH = t1.getText();
			String nameJ = t2.getText();
			relation.addJockey(nameJ, nameH);
			t1.clear();
			t2.clear();
			if (relation.getJockeys().size() > 6) {
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
		hb.getChildren().addAll(t1, t2);
		example.getChildren().addAll(tc, hb);

	}

	public void jockeys() {
		hb = new HBox();
		t1 = new TextField();
		t2 = new TextField();
		hb.getChildren().addAll(t1, t2);
	}
	
	public void moveTime() {
		time.setText(Integer.toString(relation.getClock().getSeconds()));
	}
	
	public void finishTime() {
		addB.setVisible(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
