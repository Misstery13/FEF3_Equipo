//Autor: Diana Melena Santander
//Fecha: 2025-08-13

package tarea3.fef3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("/tarea3/fef3/FXMLMain.fxml"));
            Pane ventana = fxmlLoader.load();
            Scene scene = new Scene(ventana);
//        stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
