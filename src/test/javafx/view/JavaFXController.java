package test.javafx.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import elements.Aircraft;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import test.javafx.JavaFXTestDrive;

public class JavaFXController{
	
	@FXML
	private TableView<Aircraft> aircraftTable;
	@FXML
	private TableColumn<Aircraft, String> column1;
	@FXML
	private TableColumn<Aircraft, String> column2;
	@FXML
	private TableColumn<Aircraft, String> column3;
	@FXML
	private TableColumn<Aircraft, String> column4;
	@FXML
	private TableColumn<Aircraft, String> column5;
	@FXML
	private TableColumn<Aircraft, String> column6;
	@FXML
	private TableColumn<Aircraft, String> column7;
	
	private JavaFXTestDrive theMainFX;
	
	
	public JavaFXController() {
	
	}
	
	@FXML
	private void initialize(){
		
		/**
		 * Connect column with Aircraft Table
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		column1.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getDat())));
		column2.setCellValueFactory(cellData -> cellData.getValue().getHexProperty());
		column3.setCellValueFactory(cellData -> cellData.getValue().getFliProperty());		
		column4.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLat())));
		column5.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLon())));
		column6.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAlt())));
		column7.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSpd())));

	}
	
	@FXML
	private void clickReceiveButton() {
		System.out.println("WW");
	}
	
	public void setController(JavaFXTestDrive aApp) {
		theMainFX = aApp;
		aircraftTable.setItems(theMainFX.getAircraftObservableList());
	}

}
