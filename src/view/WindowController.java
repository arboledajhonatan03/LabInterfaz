package view;
import javax.swing.JOptionPane;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
				b1.setText(i+", "+j);
				root1.add(b1, i, j);
				b1.setOnAction(e ->{
					b1.setText(valor);
					if(b1.getText().equals('*')) {
						b.setPerdio(true);
					}
					try {
						if(b.darPerdio()) {
						JOptionPane.showMessageDialog(null, "Perdiste!");
						stage.close();
						}
					} catch (PerdioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
			}
		}
		Scene s1 = new Scene(root);
		stage.setScene(s1);
		stage.show();
		b4.setOnAction(e -> {
			stage.close();
		});
	}
	
	public void resolver() {
		for (int i = 0; i < array.length; i++) {
			
		}
	}
	
}
