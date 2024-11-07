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
import java.sql.*;

public class AddBooks {
    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField catTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField copiesTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "5882";
        return DriverManager.getConnection(url, user, password);
    }

    public void addBook(ActionEvent event) throws IOException {
        String bookID = idTextField.getText();
        String category = catTextField.getText();
        String name = nameTextField.getText();
        String author = authorTextField.getText();
        String copies = copiesTextField.getText();

        String insertQuery = "INSERT INTO books (book_id, category, name, author, copies) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, bookID);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, author);
            preparedStatement.setInt(5, Integer.parseInt(copies));

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("book added successfully");
                clearFields();
            } else {
                System.out.println("failed to add book");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database insertion error: " + e.getMessage());
        }
    }

    public void clearFields() {
        idTextField.clear();
        catTextField.clear();
        nameTextField.clear();
        authorTextField.clear();
        copiesTextField.clear();
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

