package com.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import util.Serializator;
import views.BuscarArchivo;
import views.BuscarRuta;

public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BuscarArchivo.getInstance().setParentStage(primaryStage);
        BuscarRuta.getInstance().setStage(primaryStage);
        
        ViewManager manager = new ViewManager();
        
        manager.setStage(primaryStage);
        manager.loadViews();
        
        manager.showPreloadView();
        
        Task<Void> restorationTask = new RestorationTask(manager);

        Thread restorationThread = new Thread(restorationTask);
        restorationThread.start();
    }
}

class RestorationTask extends Task<Void> {
    private final ViewManager manager;

    public RestorationTask(ViewManager manager) {
        this.manager = manager;
    }

    @Override
    protected Void call() throws Exception {
        restaurarAppState();
        return null;
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        Platform.runLater(() -> {
            manager.closePreloadView();
            
            manager.showMainView();
        });
    }
        
    private void restaurarAppState() {
        AppState appState = Serializator.deserialize(Constantes.APP_STATE_FILE_PATH);
        AppState.setInstanceIfNotDefined(appState);
    }

}