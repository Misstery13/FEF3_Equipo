package tarea3.fef3;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.net.URI;

public class FXMLAbout {

    @javafx.fxml.FXML
    private Hyperlink hl_repo;

    @javafx.fxml.FXML
    public void acc_hlrepo(ActionEvent actionEvent) {
        try {
            URI uri = new URI("https://github.com/Misstery13/FEF3_Equipo");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            }else {
                System.out.println("No esta disponible");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
