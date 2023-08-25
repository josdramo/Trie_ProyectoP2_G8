/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.main.AppState;
import com.main.Constantes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import util.FileParser;
import util.Serializator;
import views.BuscarArchivo;
import views.BuscarRuta;
import views.Notificacion;

/**
 *
 * @author infrative
 */
public class MainController extends Controller {
    
    @FXML
    private Label sizeLabel;

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
        String palabra = delimitadoresTextField.getText().trim();
        if (!palabra.isEmpty()) {
            if (!delimitadoresListView.getItems().contains(palabra)) {
                delimitadoresListView.getItems().add(palabra);
                delimitadoresTextField.clear();
            } else {
                Notificacion.showWarning("Duplicación de delimitador", "El delimitador ya está en la lista.");
            }
        }
    }

    public void onEliminarDelimitador() {
        int indiceSeleccionado = delimitadoresListView.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            String palabraEliminada = (String) delimitadoresListView.getItems().get(indiceSeleccionado);
            delimitadoresListView.getItems().remove(indiceSeleccionado);
            
            Notificacion.showOperationSuccess("La palabra '" + palabraEliminada + "' ha sido eliminada.");
        } else {
            String textoDelTextField = delimitadoresTextField.getText().trim();
            if (textoDelTextField.isEmpty()) {
                Notificacion.showWarning("Nada seleccionado", "Por favor, selecciona una palabra de la lista de delimitadores para eliminar.");
            }
        }
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
        String palabra = (String) buscadorListView.getSelectionModel().getSelectedItem();
        if (palabra != null && !palabra.isEmpty()) {
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

        Notificacion.showOperationSuccess("Archivo cargado correctamente");
    }

    public void onBuscar() {
        clearBuscadorListView();

        List<String> sugerencias = AppState.getInstance().getDiccionario().search(buscadorTextField.getText());

        buscadorListView.getItems().addAll(sugerencias);
    }

    public void onBuscarDelimitador() {
        String delimitador = (String) delimitadoresListView.getSelectionModel().getSelectedItem();
        if (busquedaInversaCheckBox.isSelected()) {
            List<String> palabrasEncontradas = AppState.getInstance().getDiccionario().busquedaInversa(delimitador);
            buscadorListView.getItems().clear();
            buscadorListView.getItems().addAll(palabrasEncontradas);
        } else {
            clearBuscadorListView();
            List<String> sugerencias = AppState.getInstance().getDiccionario().search(delimitador);
            buscadorListView.getItems().addAll(sugerencias);
        }
    }

    public void clearBuscadorListView() {
        buscadorListView.getItems().clear();
    }
    
    public void onMenuGuardar() {
        Serializator.serialize(AppState.getInstance(), Constantes.APP_STATE_FILE_PATH);
        
        Notificacion.showOperationSuccess("Guardado completado yada yada.");
    }
    
    public void onExportar() {
        String ruta = BuscarRuta.getInstance().show();
        
        try (FileWriter escritor = new FileWriter(ruta + File.separator + "diccionario.txt")) {
            for (String palabra : AppState.getInstance().getDiccionario().search("")) {
                escritor.write(palabra + System.lineSeparator());
            }
            
            Notificacion.showOperationSuccess("Exportación completada.");
        } catch (IOException e) {
            Notificacion.showWarning("Error", "Ha ocurrido un problema inesperado exportando.");
        }
        
    }
    
    public void actualizarContadorDePalabras() {
        sizeLabel.setText(Integer.toString(AppState.getInstance().getDiccionario().search("").size()));
    }
}
