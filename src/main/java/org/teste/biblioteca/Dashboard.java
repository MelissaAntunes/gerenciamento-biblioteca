package org.teste.biblioteca;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    private Label mainLabel2;

    @FXML
    private Button dashButton1;

    @FXML
    private Button dashButton2;

    @FXML
    private Button dashButton3;

    @FXML
    private Button dashButton4;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void checkBooks(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("availableBooks.fxml"));
        root = loader.load();
        AvailBooks availBooks = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void addRemBook(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addBook.fxml"));
        root = loader.load();
        AddBooks addBooks = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void remBooks(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("remBook.fxml"));
        root = loader.load();
        RemoveBook removeBook = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void staffDet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("staffDetails.fxml"));
        root = loader.load();
        StaffDetails staffDetails = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void addStaff(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addStaff.fxml"));
        root = loader.load();
        AddStaff addStaff = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void remStaff(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("remStaff.fxml"));
        root = loader.load();
        RemoveStaff removeStaff = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void editAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editAdmin.fxml"));
        root = loader.load();
        EditAdmin editAdmin = loader.getController();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }


}
