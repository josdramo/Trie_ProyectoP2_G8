/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.main.AppState;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
