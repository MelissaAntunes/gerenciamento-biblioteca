package org.teste.biblioteca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveStaff {
    @FXML
    private TextField staffTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button remButton;
    @FXML
    private Label successFail;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "5882";
        return DriverManager.getConnection(url, user, password);
    }

    public void remStaff(ActionEvent event) throws IOException {
        String staff = staffTextField.getText();
        int staff2 = Integer.parseInt(staffTextField.getText());

        String deleteQuery = "DELETE FROM staff WHERE staff_id=? OR name=?";

        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, staff2);
            preparedStatement.setString(2, staff);


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                successFail.setText("Staff removido com sucesso");
                clearFields();
            } else {
                successFail.setText("Nome ou ID incorreto");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database insertion error: " + e.getMessage());
        }
    }

    public void clearFields() {
        staffTextField.clear();
    }

    public void backButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        Dashboard dashboard = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
