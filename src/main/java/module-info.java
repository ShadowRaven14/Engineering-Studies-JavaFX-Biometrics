module com.example.biometriajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.biometriajavafx to javafx.fxml;
    exports com.example.biometriajavafx;
}