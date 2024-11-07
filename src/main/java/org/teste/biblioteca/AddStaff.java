package org.teste.biblioteca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStaff {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField contactTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "5882";
        return DriverManager.getConnection(url, user, password);
    }

    public void addStaff(ActionEvent event) throws IOException {
        String staffId = idTextField.getText();
        String name = nameTextField.getText();
        String contact = contactTextField.getText();

        String insertQuery = "INSERT INTO staff (staff_id, name, contact) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, staffId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, contact);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("staff added successfully");
                clearFields();
            } else {
                System.out.println("failed to add staff");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database insertion error: " + e.getMessage());
        }
    }

    public void clearFields() {
        idTextField.clear();
        nameTextField.clear();
        contactTextField.clear();
    }

    public void backButton(ActionEvent event) throws IOException {
        System.out.println("Button clicked!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        Dashboard dashboard = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
