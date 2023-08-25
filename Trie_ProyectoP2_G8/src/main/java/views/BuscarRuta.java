/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.io.File;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author infrative
 */
public class BuscarRuta {
    private static BuscarRuta instance = null;
    
    private Stage stage;
    
    private BuscarRuta() {}
    
    public static BuscarRuta getInstance() {
        if (instance == null) {
            instance = new BuscarRuta();
        }
        return instance;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public String show() {
        if (stage == null) {
            throw new IllegalStateException("Parent stage not set. Use setParentStage() before calling show().");
        }

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Selecciona la ubicación de guardado");
        
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        
        File selectedDirectory = directoryChooser.showDialog(stage);
        
        return selectedDirectory.getAbsolutePath();
    }
}
