package test.javafx;

import java.text.SimpleDateFormat;
import java.util.Date;

import elements.Aircraft;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import test.javafx.view.JavaFXController;

public class JavaFXTestDrive extends Application {

	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Aircraft> aircraftObservableList = FXCollections.observableArrayList();	
	

	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ADS-b Delivery");
		initRootLayout();
	}
	private void initRootLayout() {
        try {
            // fxml 파일에서 상위 레이아웃을 가져온다.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFXTestDrive.class.getResource("view/JavaFXTestDrive.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Add Controller
            JavaFXController  contoller = loader.getController();            
            contoller.setController(this);
            
            
            
            // 상위 레이아웃을 포함하는 scene을 보여준다.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	

	public JavaFXTestDrive() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");		
		aircraftObservableList.add(new Aircraft(new Date(),"Initial","Initial",0,0,0,(short) 0));
	}
	
    public ObservableList<Aircraft> getAircraftObservableList() {
        return aircraftObservableList;
    }
	
	public static void main(String[] args) {
		launch(args);	
		
		
	}
}
