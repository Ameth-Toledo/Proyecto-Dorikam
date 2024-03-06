module com.toledo.proyectodorikam {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;

    opens com.toledo.proyectodorikam to javafx.fxml;
    exports com.toledo.proyectodorikam;
    exports com.toledo.proyectodorikam.controllers;
    opens com.toledo.proyectodorikam.controllers to javafx.fxml;
}