package test.javafx.view;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.sun.glass.events.MouseEvent;

import elements.Aircraft;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import network.http.ADSBReceiveAndDeliverHttpJson;
import network.http.AircraftReceiverServer;
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
	
	@FXML
	private ToggleButton DeliverySendingButton;
	@FXML
	private TextField	JsonReceiverPort;
	@FXML
	private TextField   JsonSourceAddr;
	@FXML
	private TextField   JsonDestinationIP;
	@FXML
	private TextField   JsonDestinationPort;
	
	private JavaFXTestDrive theMainFX;
	
	private AircraftReceiverServer JsonRecieverServer = AircraftReceiverServer.getInstance();
	private Thread JsonserverThread = null; 
	private Socket	DeliveryclinetSocket;
	
	public JavaFXController() {
	
	}
	
	@FXML
	private void initialize(){
		
		/**
		 * Connect column with Aircraft Table
		 */		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		try {
		column1.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getDat())));
		}catch(NullPointerException e) {
			System.out.println("No Data");
		}
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
	                setText(empty ? "" : getItem().toString());
	                setGraphic(null);
	                TableRow<Aircraft> currentRow = getTableRow();	                	                
	                if (!isEmpty()) {
	                    if(item.equals("1")) {
	                    	currentRow.setStyle("-fx-background-color:lightcyan ");
	                    }else {
	                    	currentRow.setStyle("");
	                    }	                    
	                }
	            }
	        };
	    });

	}
	
	@FXML
	private void clickDeliveryReceiveButton() {
		if(ADSBReceiveAndDeliverHttpJson.isProcessRun()) {			
			ADSBReceiveAndDeliverHttpJson.setProcessRun(false);
		}else {			
			ADSBReceiveAndDeliverHttpJson.setProcessRun(true);
			ADSBReceiveAndDeliverHttpJson.getInstance().receiveADSBJson(aircraftTableView,DeliverySendingButton,JsonSourceAddr.getText());			
		}
		
	}
	
	@FXML
	public void clickDeliverySendingButton() {
		
		if(ADSBReceiveAndDeliverHttpJson.isJsonSending()) {			
			ADSBReceiveAndDeliverHttpJson.setJsonSending(false);
			try {
				DeliverySendingButton.setStyle(null);
				ADSBReceiveAndDeliverHttpJson.getfJsonSendingStream().close();
				DeliveryclinetSocket.close();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Delivery Socket Closed");
			} catch(java.lang.NullPointerException e) {
				System.out.println("Stream is not generated..");
			} 
		}else {			
			ADSBReceiveAndDeliverHttpJson.setJsonSending(true);
			// Connect to server
			try {
				SocketAddress l_socketAddress = new InetSocketAddress(JsonDestinationIP.getText(), Integer.parseInt(JsonDestinationPort.getText()));
				DeliveryclinetSocket = new Socket();
				DeliveryclinetSocket.connect(l_socketAddress,100);
//				l_ClinetSocket.getOutputStream()''
				ObjectOutputStream l_objectOutputStream = new ObjectOutputStream(DeliveryclinetSocket.getOutputStream());
				ADSBReceiveAndDeliverHttpJson.setfJsonSendingStream(l_objectOutputStream);
				DeliverySendingButton.setStyle("-fx-background-color: #3355ff;-fx-text-fill: #ffffff;");
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				DeliverySendingButton.setStyle("-fx-background-color: #ff0000;-fx-text-fill: #ffffff;");
			}
			
		}
		
	}
	
	@FXML
	private void clickReceiverReceiveButton() {
		
		if(!AircraftReceiverServer.isRunning()) {
			JsonRecieverServer.setPort(Integer.parseInt(JsonReceiverPort.getText()));
			JsonRecieverServer.setTableView(aircraftTableView);
			JsonserverThread = new Thread(JsonRecieverServer);
			AircraftReceiverServer.setRunning(true);
			JsonserverThread.start();
			
		}else {
			AircraftReceiverServer.setRunning(false);
			AircraftReceiverServer.closeServerSocket();
		}
		
		
		
	}
	public void setController(JavaFXTestDrive aApp) {
		theMainFX = aApp;
		aircraftTableView.setItems(theMainFX.getAircraftObservableList());
	}

}
