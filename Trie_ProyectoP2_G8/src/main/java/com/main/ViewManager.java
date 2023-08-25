/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import controllers.Controller;
import controllers.MainController;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

enum ControllerType {
    MAIN
}

public class ViewManager {  
    private HashMap<ControllerType, Controller> controllers;
    
    private Stage stage;
    
    private Stage provisionalStage;
    
    private Scene mainScene;
    
    private Scene preloadScene;
    
    public ViewManager() {
        controllers = new HashMap();
    }
    
    public void loadViews() {
        try {
            mainScene = loadScene(Constantes.VIEW_MAIN_FILE_PATH, ControllerType.MAIN);
            preloadScene = loadScene(Constantes.VIEW_PRELOAD_FILE_PATH, null);
        } catch (IOException ex) {
            Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Scene loadScene(String filePath, ControllerType type) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(filePath));
        
        Parent parent = loader.load();
        
        Controller controller = loader.getController();
        
        // TODO: decidir si pasar app o state
        if (controller != null) {
            controller.setViewManager(this);
            controllers.put(type, controller);
        }
        
        return new Scene(parent);
    }
    
    public void showPreloadView() {
        provisionalStage = new Stage(StageStyle.UNDECORATED);
        
        provisionalStage.setScene(preloadScene);
        
        provisionalStage.show();
    }
    
    public void closePreloadView() {
        provisionalStage.close();
    }
    
    public void showMainView() {
        this.stage.setTitle(Constantes.VIEW_MAIN_TITLE);
        this.stage.setScene(mainScene);
        
        MainController mainController = (MainController) controllers.get(ControllerType.MAIN);
        mainController.onBuscar();
        mainController.actualizarContadorDePalabras();
        
        this.stage.show();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
