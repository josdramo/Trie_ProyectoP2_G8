package com.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        Trie abb = new Trie();

        abb.insertarPalabra("Hola");
        abb.insertarPalabra("hola");
        abb.insertarPalabra("h0la");
        abb.insertarPalabra("cono");
        
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Configuración de la ventana principal
        primaryStage.setTitle("Ejemplo JavaFX");
        
        // Creación de un nodo de contenido (en este caso, un Label)
        Label label = new Label("¡Hola, JavaFX!");
        
        // Creación de un contenedor para el nodo de contenido
        VBox root = new VBox();
        root.getChildren().add(label);
        
        // Creación de una escena que contiene el contenedor
        Scene scene = new Scene(root, 300, 200);
        
        // Asignación de la escena a la ventana principal
        primaryStage.setScene(scene);
        
        // Mostrar la ventana principal
        primaryStage.show();
    }
}
