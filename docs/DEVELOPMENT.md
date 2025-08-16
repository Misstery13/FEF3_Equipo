# Development Guide

## Project structure

- `src/main/java/module-info.java` — Module descriptor. Exports `tarea3.fef3` and opens it to JavaFX FXML.
- `src/main/java/tarea3/fef3` — Java sources (controllers, models, app launcher)
- `src/main/resources/tarea3/fef3` — FXML views, CSS, and icons
- `pom.xml` — Maven build with JavaFX dependencies

## Module system

```java
module tarea3.fef3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires java.desktop;

    // 3rd party UI libs
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens tarea3.fef3 to javafx.fxml;
    exports tarea3.fef3;
}
```

- `opens` enables reflection-based FXML injection for controllers in `tarea3.fef3`
- `exports` allows other modules to reference public APIs

## Application boot

- `Launcher.main(...)` calls `Application.launch(main.class, args)`
- `main.start(Stage)` loads `FXMLMain.fxml` and renders the primary stage

## FXML loading pattern

- `FXMLMainController` loads child views into the `contentArea` center pane using `FXMLLoader.load(getClass().getResource("/tarea3/fef3/<View>.fxml"))`
- Each view has its own controller with `@FXML`-annotated fields and event handlers

## Data flow

- In-memory store `BD` holds `ArrayList` collections for all entity types
- Registration controllers add entities to lists and refresh tables
- `FXMLconsultaEquipos` filters by the team selected in the combo box and updates each tab
- Team selectors across controllers filter `BD.equipos` by `estado == "Activo"`

## Alerts / messaging

- `ModGeneral.fun_mensajeInformacion(String)` — Info alerts
- `ModGeneral.fun_mensajeError(String)` — Error alerts

## Running locally

- Requires Java 24 (configured via maven-compiler-plugin)
- Use Maven wrapper or local Maven

```bash
mvn -v
mvn clean javafx:run
```

## Testing

- JUnit 5 dependencies are present, but no test sources included.
- Consider adding controller-level validation tests and model tests under `src/test/java`.

## Extending the app

- Persistence: Replace `BD` with a repository interface and implementations (e.g., JPA/Hibernate or JSON storage)
- Validation: Extract common CI (cedula) validator to a utility class with unit tests
- Internationalization: Externalize UI strings to resource bundles and use `fx:resources`
- Navigation: Consider a router-like utility for swapping center content to remove duplication in `FXMLMainController`
