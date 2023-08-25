/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class Notificacion {
    private static Notificacion instance = null;
    private AlertType alertType;
    private String title;
    private String headerText;
    private String contentText;
    private StageStyle stageStyle;

    private Notificacion() {}

    public static Notificacion getInstance() {
        if (instance == null) {
            instance = new Notificacion();
        }
        return instance;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public void setStageStyle(StageStyle stageStyle) {
        this.stageStyle = stageStyle;
    }

    public void show() {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        
        if (stageStyle != null) {
            alert.initStyle(stageStyle);
        }
        
        alert.showAndWait();
    }

    public static void showOperationSuccess(String message) {
        Notificacion notificacion = Notificacion.getInstance();
        notificacion.setAlertType(AlertType.INFORMATION);
        notificacion.setTitle("Éxito");
        notificacion.setHeaderText("Operación completada");
        notificacion.setContentText(message);
        notificacion.show();
    }
}
