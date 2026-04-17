module org.example.primerejemplojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.primerejemplojavafx to javafx.fxml;
    exports org.example.primerejemplojavafx;
}