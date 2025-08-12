package tarea3.fef3;

import javafx.scene.control.Alert;

public class ModGeneral {
    public static void fun_mensajeInformacion(String mensaje) {
        Alert alertinfo=new Alert(Alert.AlertType.INFORMATION);
        alertinfo.setTitle("Mensaje del Sistema");
        alertinfo.setContentText(mensaje);
        alertinfo.showAndWait();
    }

    public static void fun_mensajeError(String message) {
        Alert alerterror=new Alert(Alert.AlertType.ERROR);
        alerterror.setTitle("Mensaje de error");
        alerterror.setContentText(message);
        alerterror.showAndWait();
    }
}
