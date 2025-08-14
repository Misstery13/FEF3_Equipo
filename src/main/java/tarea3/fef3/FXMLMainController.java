package tarea3.fef3;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FXMLMainController {

    @javafx.fxml.FXML
    private MenuItem btn_repersonal;
    @javafx.fxml.FXML
    private MenuItem btn_about;
    @javafx.fxml.FXML
    private MenuItem btn_requipo;
    @javafx.fxml.FXML
    private MenuItem btn_nomina;
    @javafx.fxml.FXML
    private MenuItem btn_regequipo;
    @javafx.fxml.FXML
    private MenuItem btn_redirect;
    @javafx.fxml.FXML
    private MenuBar bar_menu;
    @javafx.fxml.FXML
    private MenuItem btn_regjuga;
    @javafx.fxml.FXML
    private AnchorPane contentArea;
    @javafx.fxml.FXML
    private MenuItem btn_vaciar;


    @javafx.fxml.FXML
    public void acc_regequipo(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-equipotec");

    }

    @javafx.fxml.FXML
    public void acc_about(ActionEvent actionEvent) {
        cargarContenido("FXMLAbout");
    }

    @javafx.fxml.FXML
    public void acc_redirect(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-directivo");
    }

    @javafx.fxml.FXML
    public void acc_repersonal(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-personal");
    }


    @javafx.fxml.FXML
    public void acc_requipo(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-equipo");
    }


    @javafx.fxml.FXML
    public void acc_regjuga(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-jugadores");
    }

    @javafx.fxml.FXML
    public void acc_nomina(ActionEvent actionEvent) {
        cargarContenido("FXMLNomina");
    }

    private void cargarContenido(String fxmlFile) {
        try {
            javafx.scene.layout.BorderPane pane = javafx.fxml.FXMLLoader.load(getClass().getResource("/tarea3/fef3/" + fxmlFile + ".fxml"));
            contentArea.getChildren().setAll(pane);
        // Anclar a todos los bordes
        javafx.scene.layout.AnchorPane.setTopAnchor(pane, 0.0);
        javafx.scene.layout.AnchorPane.setBottomAnchor(pane, 0.0);
        javafx.scene.layout.AnchorPane.setLeftAnchor(pane, 0.0);
        javafx.scene.layout.AnchorPane.setRightAnchor(pane, 0.0);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @javafx.fxml.FXML
    public void acc_btnvaciar(ActionEvent actionEvent) {
        try {
            BD.equipos.clear();
            BD.personal.clear();
            BD.directivos.clear();
            BD.jugadores.clear();
            ModGeneral.fun_mensajeInformacion("Datos vaciados con éxito");
        } catch (Exception e) {
            ModGeneral.fun_mensajeInformacion("Error al vaciar los datos: " + e.getMessage());
        }
    }
}
