package Bibikov;

import controllers.Controller;
import dao.HibernateNoteDaoImpl;
import dao.NoteDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends javafx.application.Application {

    public static NoteDao noteDao = new HibernateNoteDaoImpl();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.mainStage = primaryStage;
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Ведение заметок");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
