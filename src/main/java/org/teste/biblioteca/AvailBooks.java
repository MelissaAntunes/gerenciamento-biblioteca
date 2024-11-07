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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AvailBooks {

    @FXML
    private Button backButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TableView<Book> myTableView;

    @FXML
    private TableColumn<Book, Integer> bookIdColumn;
    @FXML
    private TableColumn<Book, String> categoryColumn;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> copiesColumn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        // Ensure the columns display the correct data from Book
        bookIdColumn.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        copiesColumn.setCellValueFactory(cellData -> cellData.getValue().copiesProperty().asObject());
    }


    public void refreshButton(ActionEvent actionEvent) throws IOException {
        ObservableList<Book> books = FXCollections.observableArrayList();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "5882")){
            System.out.println("Connected to the database successfully.");
            String query = "SELECT book_id, category, name, author, copies FROM books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String category = resultSet.getString("category");
                String name= resultSet.getString("name");
                String author = resultSet.getString("author");
                int copies = resultSet.getInt("copies");

                books.add(new Book(bookId, category, name, author, copies));

            }
            myTableView.setItems(books);
            System.out.println("Data fetched and TableView updated.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
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
