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

public class StaffDetails {
    @FXML
    private Button backButton;
    @FXML
    private Button refreshButton;

    @FXML
    private TableView<Staff> myTableView;
    @FXML
    private TableColumn<Staff, Integer> idColumn;
    @FXML
    private TableColumn<Staff, String> nameColumn;
    @FXML
    private TableColumn<Staff, String> contactColumn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        // Ensure the columns display the correct data from Staff
        idColumn.setCellValueFactory(cellData -> cellData.getValue().staffIdProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
        
    }


    public void refreshButton(ActionEvent actionEvent) throws IOException {
        ObservableList<Staff> staff = FXCollections.observableArrayList();

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "5882")){
            System.out.println("Connected to the database successfully.");
            String query = "SELECT staff_id, name, contact FROM staff";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int staffId = resultSet.getInt("staff_id");
                String name = resultSet.getString("name");
                String contact= resultSet.getString("contact");

                staff.add(new Staff(staffId, name, contact));


            }
            myTableView.setItems(staff);
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
