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

    @Deprecated
    public void acc_btnguardar(ActionEvent actionEvent) {
    }

    @Deprecated
    public void acc_btnsalir(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void acc_regequipo(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void acc_about(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void acc_redirect(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void acc_repersonal(ActionEvent actionEvent) {
    }

    @Deprecated
    public void acc_btnequipo(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void acc_requipo(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-equipo");
    }

    @Deprecated
    public void acc_personal(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void acc_regjuga(ActionEvent actionEvent) {
        cargarContenido("FXMLregistro-jugadores");
    }

    @javafx.fxml.FXML
    public void acc_nomina(ActionEvent actionEvent) {
    }

    private void cargarContenido(String fxmlFile) {
        try {
        javafx.scene.Parent pane = javafx.fxml.FXMLLoader.load(getClass().getResource(fxmlFile + ".fxml"));
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
}
