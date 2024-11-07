package org.teste.biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class EditAdmin {
    @FXML
    private TextField admTextField;
    @FXML
    private ComboBox<String> admComboBox;
    @FXML
    private Button backButton;
    @FXML
    private Button updateButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        populateComboBox();
    }

    public void populateComboBox() {
        ObservableList<String> admColumns = FXCollections.observableArrayList("user_id", "username", "password", "contact");
        admComboBox.setItems(admColumns);
    }

    @FXML
    public void handleUpdateButton(){
        String selectedItem = admComboBox.getValue();
        String newValue = admTextField.getText();

        if(selectedItem != null && !newValue.isEmpty()) {
            updateButton(selectedItem, newValue);
        }
        else {
            System.out.println("Please select a option");
        }
    }


    private void updateButton(String item, String newValue) {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "5882";

        String query = "UPDATE admin SET " + item + " = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1, newValue);

                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected > 0) {
                    System.out.println("Successfully updated");
                    clearField();
                }
                else {
                    System.out.println("Failed to update");
                }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearField() {
        admTextField.clear();
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
