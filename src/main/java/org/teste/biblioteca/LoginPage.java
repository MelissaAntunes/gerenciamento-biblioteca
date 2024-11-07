package org.teste.biblioteca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage {
    @FXML
    private Label mainLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize() {
        loginButton.setDefaultButton(true); // Set the login button as the default button
    }

    // database connection method
    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "5882";

        return DriverManager.getConnection(url, user, password);
    }

    // method to verify credentials
    private boolean verifyCredentials(String username, String password) {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void login(ActionEvent event) throws IOException {

        String username = usernameField.getText(); // retrives the entered username
        String password = passwordField.getText(); // retrives the entered password

        if(verifyCredentials(username, password)) { // checks if credentials are valid
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            root = loader.load();
            Dashboard dashboard = loader.getController();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        } else {
            //show an alert if credentials are invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter a valid credentials");
            alert.showAndWait();
        }


    }
}