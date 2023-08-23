/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.main.AppState;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.FileParser;
import views.BuscarArchivo;
import views.Notificacion;

/**
 *
 * @author infrative
 */
public class MainController extends Controller {

    @FXML
    private TextField delimitadoresTextField;

    @FXML
    private ListView delimitadoresListView;

    @FXML
    private CheckBox busquedaInversaCheckBox;

    @FXML
    private TextField buscadorTextField;

    @FXML
    private ListView buscadorListView;

    public void onAgregarDelimitador() {

    }

    public void onEliminarDelimitador() {

    }

    public void onBusquedaInversa() {

    }

    public void onAgregarPalabra() {
        String palabra = buscadorTextField.getText();
        if (!palabra.isEmpty()) {
            AppState.getInstance().getDiccionario().insert(palabra);
            buscadorTextField.clear();
            clearBuscadorListView();

            System.out.println("Agregado");
        }
    }

    public void onRemoverPalabra() {
        String palabra = buscadorTextField.getText();
        if (!palabra.isEmpty()) {
            boolean eliminada = AppState.getInstance().getDiccionario().eliminarPalabra(palabra);
            if (eliminada) {
                buscadorTextField.clear();
                clearBuscadorListView();
            } else {
                clearBuscadorListView();
            }
        }
    }

    public void onCargar() {
        BuscarArchivo buscarArchivo = BuscarArchivo.getInstance();
        String filePath = buscarArchivo.show();

        FileParser fileParser = new FileParser(filePath);
        AppState.getInstance().getDiccionario().insertarPalabras(fileParser.parse());

        Notificacion notificacion = Notificacion.getInstance();
        notificacion.setAlertType(AlertType.INFORMATION);
        notificacion.setTitle("Éxito");
        notificacion.setHeaderText("Operación completada");
        notificacion.setContentText("Archivo cargado correctamente");
        notificacion.show();
    }

    public void onBuscar() {
        clearBuscadorListView();

        List<String> sugerencias = AppState.getInstance().getDiccionario().search(buscadorTextField.getText());

        buscadorListView.getItems().addAll(sugerencias);
    }

    public void clearBuscadorListView() {
        buscadorListView.getItems().clear();
    }
}
