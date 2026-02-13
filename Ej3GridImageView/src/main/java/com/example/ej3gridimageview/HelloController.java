package com.example.ej3gridimageview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private GridPane mainGrid;

    private int filaOrigen = -1;
    private int colOrigen = -1;

    /*@FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }

    public void click(MouseEvent mouseEvent) {
        int columna = 0;
        int fila = 0;
        for (Node node : mainGrid.getChildren()) {
            if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                columna = GridPane.getColumnIndex(node);
                fila = GridPane.getRowIndex(node);
            }
        }
        boolean encontrado=false;
        for (int i=0; i< mainGrid.getChildren().size()  && !encontrado;i++) {
            Node node = mainGrid.getChildren().get(i);
            if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
                columna = GridPane.getColumnIndex(node);
                fila = GridPane.getRowIndex(node);
                encontrado = true;
            }
        }
        System.out.println(fila+" "+columna);
        //Otra forma
        /*Node node = (Node) mouseEvent.getTarget();
        if (node != null && node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) {
            columna = GridPane.getColumnIndex(node);
            fila = GridPane.getRowIndex(node);
            System.out.println("Row : " + fila + ", Col : " + columna);
        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tablero tablero = new Tablero();
        pintarTablero(tablero);
    }

    /*public void accion(String coordenadas){
        String[] args = coordenadas.split(";");
        int fila = Integer.parseInt(args[0]);
        int columna = Integer.parseInt(args[1]);
        System.out.println(fila+"-"+columna);
    }*/
    public void accion(int x, int y) {
        System.out.println(x + "-" + y);
    }

    private void pintarTablero(Tablero tablero) {
        Pane pane;

        for (int i = 0, aux = 7; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #684714;");
                } else {
                    pane.setStyle("-fx-background-color: #ffe68e");
                }
                if (tablero.hayPieza(aux, j)) {
                    pane.getChildren().add(new ImageView(new Image("File:Ej3GridImageView/src/main/resources/com/example/ej3gridimageview/imagenes/".concat(tablero.getTablero()[aux][j].toString()))));
                }
                mainGrid.add(pane, j, i);
                String envio1 = aux + ";" + j;
                ;
                int fila = aux;
                int columna = j;

                pane.setOnMouseClicked(e -> {
                    if (filaOrigen == -1) {
                        if (tablero.hayPieza(fila, columna)) {
                            filaOrigen = fila;
                            colOrigen = columna;
//                            finalPane.setStyle("-fx-background-color: ##C0DDF7;");
                            accion(filaOrigen, colOrigen);
                        }
                    } else {
                        int filaDestino = fila;
                        int colDestino = columna;
                        Posicion posInicial = new Posicion(filaOrigen, colOrigen);
                        Posicion posFinal = new Posicion(filaDestino, colDestino);
                        Movimiento mov = new Movimiento(posInicial, posFinal);
                        accion(filaDestino, colDestino);
                        Juego juego = new Juego();
                        juego.setTurno(1);
                        juego.jugada(mov.toString(), tablero);
                        tablero.moverPieza(mov);

                        filaOrigen = -1;
                        colOrigen = -1;
                        pintarTablero(tablero);
                    }


                });
            }
            aux--;
        }
    }


    @SuppressWarnings("unused")
    public void enroque(ActionEvent actionEvent) {
        // TODO: Implementar lógica de enroque
    }
}
/*juego.setTurno(0);
Juego juego= new Juego();
String move = juego.jugada(message1, tablero);

                    if (move!=null) {
        tablero.moverPieza(juego.getMovimiento());
        }
        if (tablero.hayJaque(juego.getTurno())){
        Constantes.print(Constantes.MSG_JAQUE);
                    }

 */