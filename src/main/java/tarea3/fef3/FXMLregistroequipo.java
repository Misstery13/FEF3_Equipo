package tarea3.fef3;

import javafx.event.Event;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class FXMLregistroequipo {
    @javafx.fxml.FXML
    private TextField txt_equipo;
    @javafx.fxml.FXML
    private TextField txt_estado;
    @javafx.fxml.FXML
    private TextField txt_ciudad;
    @javafx.fxml.FXML
    private ImageView btn_guardar;

    @javafx.fxml.FXML
    public void initialize() {
        Tooltip tooltipGuardar = new Tooltip("Guardar");
        Tooltip.install(btn_guardar, tooltipGuardar);
//        Tooltip tooltipEliminar = new Tooltip("Eliminar");
//        Tooltip.install(btn_eliminar, tooltipEliminar);
    }

    @javafx.fxml.FXML
    public void acc_guardar(Event event) {
        try {
            if (fun_validar()) {
                String equipo = this.txt_equipo.getText();
                String ciudad = this.txt_ciudad.getText();
                String estado = this.txt_estado.getText();
                Equipo objEquipo = new Equipo(equipo, ciudad, estado);
                BD.equipos.add(objEquipo);
//                System.out.println("Se registro con exito");
                ModGeneral.fun_mensajeInformacion("Se registro con exito");

            } else {
                fun_validar();
            }
        } catch (Exception e) {
            ModGeneral.fun_mensajeInformacion(e.getMessage());
        }
    }

    private boolean fun_validar() {

        try {
            if (this.txt_equipo.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Esto no puede estar vacio");
                this.txt_equipo.requestFocus();
                return false;
            }
            if (this.txt_ciudad.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Esto no puede estar vacio");
                this.txt_ciudad.requestFocus();
                return false;
            }
            if (this.txt_estado.getText().isEmpty()) {
                ModGeneral.fun_mensajeInformacion("Esto no puede estar vacio");
                this.txt_estado.requestFocus();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
