/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author infrative
 */
public class BuscarArchivo {
    private static BuscarArchivo instance = null;
    private Stage parentStage;

    private BuscarArchivo() {}

    public static BuscarArchivo getInstance() {
        if (instance == null) {
            instance = new BuscarArchivo();
        }
        return instance;
    }

    public void setParentStage(Stage stage) {
        this.parentStage = stage;
    }

    public String show() {
        if (parentStage == null) {
            throw new IllegalStateException("Parent stage not set. Use setParentStage() before calling show().");
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo");
        File selectedFile = fileChooser.showOpenDialog(parentStage);

        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }
    }
}
