package com.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.Serializator;

public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        restaurar();
        
        ViewManager manager = new ViewManager();
        
        manager.setStage(primaryStage);
        manager.loadViews();
        manager.showMainView();
        
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> guardar());
    }
    
    private void restaurar() {
        AppState appState = Serializator.deserialize(Constantes.APP_STATE_FILE_PATH);
        AppState.setInstanceIfNotDefined(appState);
    }
    
    private void guardar() {
        Serializator.serialize(AppState.getInstance(), Constantes.APP_STATE_FILE_PATH);
    }
}
