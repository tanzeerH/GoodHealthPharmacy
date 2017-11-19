/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy;

import goodhealthpharmacy.database.DataHelper;
import goodhealthpharmacy.model.Doctor;
import goodhealthpharmacy.model.Sell;
import goodhealthpharmacy.utils.CommonUtils;
import goodhealthpharmacy.utils.Constants;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Tanzeer
 */
public class FXMLSellManagementController implements Initializable {

    @FXML
    TextField txtSsn;
    @FXML
    TextField txtName;
    @FXML
    TextField txtSpeciality;
    @FXML
    TextField txtExp;
    @FXML
    Button btnAdd;
    
    @FXML
    Button btnSell;
    
    @FXML
    Button btnDocManage;
    
    @FXML
    Button btnPharmacy;
    
    @FXML
    Button btnCompany;
    
    @FXML
    Button btnDrug;


    @FXML
    TableView tableSell;

    private  ObservableList<Sell> data;

    @FXML
    private void handleButtonAction(ActionEvent event) {
       System.out.println(event.getSource()+"  patient clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnSell.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDoctorManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    @FXML
    private void onDocManage(ActionEvent event) {
     System.out.println(event.getSource()+"  doctor clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnSell.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDoctorManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
             
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    @FXML
    private void onPharmManage(ActionEvent event) {
     System.out.println(event.getSource()+"  doctor clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnSell.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLPharmacyManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Pharmacy Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onCompanyManage(ActionEvent event) {
     System.out.println(event.getSource()+"  company clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLCompanyManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Company Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  @FXML
    private void onDrugManage(ActionEvent event) {
     System.out.println(event.getSource()+"  drugs clicked");
        Stage stage;
        Parent root;
        stage = (Stage) btnCompany.getScene().getWindow();
        //load up OTHER FXML document
        try {
             root = FXMLLoader.load(getClass().getResource("FXMLDrugsManagement.fxml"));
             Scene scene = new Scene(root,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

            stage.setTitle("Company Management");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddButton(ActionEvent event) {
        System.out.println(event.getSource() + "  add clicked");
        if(txtSsn.getText().length() == 0 || txtName.getText().length() == 0 ||
                txtSpeciality.getText().length() == 0 || txtExp.getText().length() == 0)
        {
            CommonUtils.showWarningDialog();
        }
        else
        {
           boolean res= DataHelper.insertDoctor(txtSsn.getText(), txtName.getText(), txtSpeciality.getText(), txtExp.getText());
           if(res)
           {
                JOptionPane.showMessageDialog(null, "Successfully Inserted.");
                txtSsn.setText("");
                txtName.setText("");
                txtSpeciality.setText("");
                txtExp.setText("");
                initSellTable();
           }
           else
           {
                JOptionPane.showMessageDialog(null, "Insertion Failed.");
               
           }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initSellTable();
    }
    private void loadData()
    {
        ArrayList<Sell> patientList= DataHelper.getSellList();
        data= FXCollections.observableArrayList(patientList);
    }

    private void initSellTable() {
        loadData();
        int column_maxWidth = Constants.TABLE_WIDTH / 5;
        tableSell.setEditable(true);
        TableColumn price = new TableColumn("Price");
        TableColumn pharm_id = new TableColumn("Pharmacy Id");
        TableColumn trade_name = new TableColumn("Trade Name");
        TableColumn pharm_co_name = new TableColumn("Company");
        

        TableColumn remove = new TableColumn("Remove");

        price.setPrefWidth(column_maxWidth);
        price.setCellValueFactory(
                new PropertyValueFactory<Doctor, String>("price"));
        // firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
       price.setCellFactory(TextFieldTableCell.forTableColumn());
       price.setOnEditCommit(
            new EventHandler<CellEditEvent<Sell, String>>() {
                @Override
                public void handle(CellEditEvent<Sell, String> t) {
                    System.out.println(t.getNewValue()+"  "+ t.getOldValue());
                    if( t.getNewValue().length() == 0)
                    {
                        initSellTable();
                      //  CommonUtils.showWarningDialog();
                  
                    }
                    else
                    {
                    ((Sell) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPrice(t.getNewValue());
                    }
                }
            }
        );

        pharm_id.setPrefWidth(column_maxWidth);
        pharm_id.setCellValueFactory(
                new PropertyValueFactory<Sell, String>("pharm_id"));
        pharm_id.setCellFactory(TextFieldTableCell.forTableColumn());
        pharm_id.setOnEditCommit(
            new EventHandler<CellEditEvent<Sell, String>>() {
                @Override
                public void handle(CellEditEvent<Sell, String> t) {
                    ((Sell) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_id(t.getNewValue());
                }
            }
        );

        trade_name.setPrefWidth(column_maxWidth);
        trade_name.setCellValueFactory(
                new PropertyValueFactory<Sell, String>("trade_name"));
        trade_name.setCellFactory(TextFieldTableCell.forTableColumn());
        trade_name.setOnEditCommit(
            new EventHandler<CellEditEvent<Sell, String>>() {
                @Override
                public void handle(CellEditEvent<Sell, String> t) {
                    ((Sell) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTrade_name(t.getNewValue());
                }
            }
        );
        pharm_co_name.setCellValueFactory(
                new PropertyValueFactory<Sell, Integer>("pharm_co_name"));
        pharm_co_name.setPrefWidth(column_maxWidth);
        pharm_co_name.setCellFactory(TextFieldTableCell.forTableColumn());
        pharm_co_name.setOnEditCommit(
            new EventHandler<CellEditEvent<Sell, String>>() {
                @Override
                public void handle(CellEditEvent<Sell, String> t) {
                    ((Sell) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setPharm_co_name(t.getNewValue());
                }
            }
        );
       
        
        remove.setCellValueFactory(new PropertyValueFactory<Sell, String>("remove"));
        remove.setPrefWidth(column_maxWidth);
        tableSell.setItems(data);

        tableSell.getColumns().addAll(price, pharm_id, trade_name, pharm_co_name,remove);

        tableSell.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableSell.getSelectionModel().getSelectedCells();

        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                int i = tableSell.getSelectionModel().getSelectedIndex();
                // System.out.println("Selected Value" + val + "ssn "+ tableSell.getSelectionModel().getSelectedIndex());
                if (val.toString().equals("Remove")) {
                   // String s = ((Sell) tableSell.getItems().get(i)).getSsn();
                   // System.out.println(s);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialog_result = JOptionPane.showConfirmDialog(null, "Are you sure?");
                    if (dialog_result == 0) {
                        System.out.println("Yes option");
                    } else {
                        System.out.println("No Option");
                    }
                }

            }
        });
    }

}
