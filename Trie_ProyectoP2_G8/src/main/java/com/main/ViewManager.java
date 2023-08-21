/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import controllers.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
    
    private Stage stage;
    
    private Scene mainScene;
    
    public void loadViews() {
        try {
            mainScene = loadScene(Constantes.VIEW_MAIN_FILE_PATH);
        } catch (IOException ex) {
            Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Scene loadScene(String filePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(filePath));
        
        Parent parent = loader.load();
        
        Controller controller = loader.getController();
        
        // TODO: decidir si pasar app o state
        controller.setViewManager(this);
        
        return new Scene(parent);
    }
    
    public void showMainView() {
        this.stage.setTitle(Constantes.VIEW_MAIN_TITLE);
        this.stage.setScene(mainScene);
        this.stage.show();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
