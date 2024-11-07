module org.teste.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.teste.biblioteca to javafx.fxml;
    exports org.teste.biblioteca;
}