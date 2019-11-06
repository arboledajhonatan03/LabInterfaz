package controller;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;
public class WindowController {
	private Buscaminas b;
	private Stage stage;
	private Button b2;
	private Button b3;
	private Button b4;
	
	
	public WindowController() {
		b2 = new Button();
		b3 = new Button();
		b4 = new Button();
		stage = new Stage();
	}
	
	public void nivel1() {
		b = new Buscaminas(1);
		inicializar(8,8);
	}
	public void nivel2() {
		b = new Buscaminas(2);
		inicializar(16,16);
		
	}
	public void nivel3() {
		b = new Buscaminas(3);
		inicializar(16,30);
		
	}
	
	public void inicializar(int fila, int columna) {
		BorderPane root = new BorderPane();
		GridPane root1 = new GridPane();
		BorderPane root2 = new BorderPane();
		root.setCenter(root1);
		b2.setText("Dar pista");
		b3.setText("Ver solucion");
		b4.setText("Salir");
		VBox v = new VBox();
		root.setLeft(v);
		v.getChildren().add(b2);
		v.getChildren().add(b3);
		root2.setCenter(b4);
		root.setBottom(root2);
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				Button b1 = new Button();
				String valor = ""+b.darCasillas()[i][j].mostrarValorCasilla();
				boolean es = b.darCasillas()[i][j].esMina();
				b1.setText(i+","+j);
				b1.setId(i+","+j);
				root1.add(b1, i, j);
				boolean selec = b.darCasillas()[i][j].darSeleccionada();
				b2.setOnAction(event -> {
					if(!selec) {
						if(b1.getText().equals(darPista())) {
							b1.setText(valor);
						}
					}
				});
				b1.setOnAction(e ->{
					b1.setText(valor);
					if(es) {
						BorderPane r = new BorderPane();
						Label t = new Label("Perdiste!");
						r.setCenter(t);
						Button b = new Button("Salir");
						r.setBottom(b);
						Scene s2 = new Scene(r,200,200);
						stage.setScene(s2);
						b.setOnAction(event -> {
							stage.close();
						});
					}
				});
			}
		}
		
		
		b3.setOnAction(e ->{
			root.setCenter(resolver());
		});
		
		Scene s1 = new Scene(root);
		stage.setScene(s1);
		stage.show();
		b4.setOnAction(e -> {
			stage.close();
		});
	}
	
	public GridPane resolver() {
		GridPane root3 = new GridPane();
		for (int i = 0; i < b.darCasillas().length; i++) {
			for (int j = 0; j < b.darCasillas()[i].length; j++) {
					Button boton = new Button();
					boton.setText(""+b.darCasillas()[i][j].mostrarValorCasilla());
					root3.add(boton, i, j);
			}
		}
		return root3;
	}
	
	public void salir(ActionEvent e) {
		stage.close();
	} 
	
	public String darPista() {
		return b.darPista();
	}
}
