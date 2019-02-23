package test.javafx.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import elements.Aircraft;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import network.http.ADSBReceiverHttpJson;
import test.javafx.JavaFXTestDrive;

public class JavaFXController{
	
	@FXML
	private TableView<Aircraft> aircraftTableView;
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
	@FXML
	private TableColumn<Aircraft, String> column8;
	
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
		column2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHex()));
		column3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFli()));		
		column4.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLat())));
		column5.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLon())));
		column6.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAlt())));
		column7.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSpd())));
		column8.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIsNew())));
		column8.setCellFactory(column ->{
	        return new TableCell<Aircraft, String>() {
	            @Override
	            protected void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                System.out.println(item);
	                setText(empty ? "" : getItem().toString());
	                setGraphic(null);
	                TableRow<Aircraft> currentRow = getTableRow();	                	                
	                if (!isEmpty()) {
	                	
	                    if(item.equals("1")) {
	                    	currentRow.setStyle("-fx-background-color:lightcoral");
	                    }else {
	                    	currentRow.setStyle("");
	                    }	                    
	                }
	            }
	        };
	    });

	}
	
	@FXML
	private void clickReceiveButton() {
		
		if(ADSBReceiverHttpJson.isProcessRun()) {			
			ADSBReceiverHttpJson.setProcessRun(false);
		}else {			
			ADSBReceiverHttpJson.setProcessRun(true);
			ADSBReceiverHttpJson.getInstance().receiveADSBJson(aircraftTableView);			
		}
	}
	
	public void setController(JavaFXTestDrive aApp) {
		theMainFX = aApp;
		aircraftTableView.setItems(theMainFX.getAircraftObservableList());
	}

}
