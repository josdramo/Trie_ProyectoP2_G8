/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import controllers.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewManager {
    
    private Scene mainScene;
    
    public void loadViews() throws IOException {
        mainScene = loadScene("views/main.fxml");
    }
    
    private Scene loadScene(String filePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(filePath));
        
        Parent parent = loader.load();
        
        Controller controller = loader.getController();
        
        // TODO: decidir si pasar app o state
        controller.setViewManager(this);
        
        return new Scene(parent);
    }
}
